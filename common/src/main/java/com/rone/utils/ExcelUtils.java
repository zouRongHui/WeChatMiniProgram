package com.rone.utils;

import com.rone.exception.RoneException;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataValidationHelper;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.usermodel.XSSFDataValidationHelper;
import org.apache.poi.xssf.usermodel.XSSFSheet;

/**
 * excel文件解析的相关工具
 *
 * @author rone
 */
public class ExcelUtils {

    /**
     * 工具类无需实例化
     */
    private ExcelUtils() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * 获取excel单元格的值，目前仅处理了文本和数字类型
     *
     * @param cell
     * @return
     */
    public static String getCellValue(Cell cell) {
        if (cell == null) {
            return null;
        }
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                return cell.getRichStringCellValue().getString().trim();
            case Cell.CELL_TYPE_NUMERIC:
                if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell)) {
                    return null;
                } else {
                    return NumberToTextConverter.toText(cell.getNumericCellValue());
                }
            default:
                return null;
        }
    }

    /**
     * 生成数字单元格
     *
     * @param row
     * @param cellIndex
     * @param value
     * @param style
     */
    public static void writeNumberCell(Row row, Integer cellIndex, Double value, CellStyle style) {
        Cell cell = row.createCell(cellIndex);
        cell.setCellType(Cell.CELL_TYPE_NUMERIC);
        cell.setCellValue(value);
        cell.setCellStyle(style);
    }

    /**
     * 生成文本的单元格
     *
     * @param row
     * @param cellIndex
     * @param value
     * @param style
     */
    public static void writeTextCell(Row row, Integer cellIndex, String value, CellStyle style) {
        Cell cell = row.createCell(cellIndex);
        cell.setCellType(SXSSFCell.CELL_TYPE_STRING);
        cell.setCellValue(value);
        cell.setCellStyle(style);
    }

    /**
     * 获取文本类型的单元格样式
     *
     * @param workbook
     * @return
     */
    public static CellStyle getTextFormatStyle(Workbook workbook) {
        return getFormatStyle(workbook, "@");
    }

    /**
     * 获取文本类型的单元格样式
     *
     * @param workbook
     * @return
     */
    public static CellStyle getDoubleFormatStyle(Workbook workbook) {
        return getFormatStyle(workbook, "0.00");
    }

    /**
     * 获取文本类型的单元格样式
     *
     * @param workbook
     * @return
     */
    public static CellStyle getIntegerFormatStyle(Workbook workbook) {
        return getFormatStyle(workbook, "0");
    }

    /**
     * 按照格式获取单元格样式
     *
     * @param workbook
     * @param format
     * @return
     */
    public static CellStyle getFormatStyle(Workbook workbook, String format) {
        CellStyle contextStyle = workbook.createCellStyle();
        DataFormat df = workbook.createDataFormat();
        contextStyle.setDataFormat(df.getFormat(format));
        contextStyle.setBorderTop(CellStyle.BORDER_THIN);
        contextStyle.setBorderBottom(CellStyle.BORDER_THIN);
        contextStyle.setBorderLeft(CellStyle.BORDER_THIN);
        contextStyle.setBorderRight(CellStyle.BORDER_THIN);
        contextStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        contextStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        return contextStyle;
    }

    /**
     * excel配置数据有效性
     *
     * @param sheet
     * @param dataValidationConstraintType
     * @param validationData
     * @param firstRow
     * @param lastRow
     * @param firstCol
     * @param lastCol
     * @throws RoneException
     */
    public static void addValidationData(Sheet sheet, DataValidationConstraintType dataValidationConstraintType, String validationData, int firstRow, int lastRow, int firstCol, int lastCol) throws RoneException {
        DataValidationHelper dataValidationHelper;
        if (sheet instanceof XSSFSheet) {
            dataValidationHelper = new XSSFDataValidationHelper((XSSFSheet) sheet);
        } else if (sheet instanceof HSSFSheet) {
            dataValidationHelper = new HSSFDataValidationHelper((HSSFSheet) sheet);
        } else {
            return;
        }
        DataValidationConstraint dataValidationConstraint;
        switch (dataValidationConstraintType) {
            case FORMULA_LIST:
                dataValidationConstraint = dataValidationHelper.createFormulaListConstraint(validationData);
                break;
            case EXPLICIT_LIST:
                if (validationData.length() > 256) {
                    throw new RoneException("通过直接数据配置数据有效性，可选数据总长度不能超过256个字符(包含逗号)");
                }
                dataValidationConstraint = dataValidationHelper.createExplicitListConstraint(validationData.split(","));
                break;
            default:
                return;
        }
        CellRangeAddressList cellRangeAddressList = new CellRangeAddressList(firstRow, lastRow, firstCol, lastCol);
        DataValidation dataValidation = dataValidationHelper.createValidation(dataValidationConstraint, cellRangeAddressList);
        dataValidation.setSuppressDropDownArrow(true);
        dataValidation.setShowErrorBox(true);
        sheet.addValidationData(dataValidation);
    }

    /**
     * excel配置数据有效性的方式
     */
    public enum DataValidationConstraintType {
        // 根据引用公式来配置数据有效性
        FORMULA_LIST,
        // 直接根据数据数组配置数据有效性
        EXPLICIT_LIST
    }

    /**
     * 将列数转换成excel中字母表达式
     * 小于27的列数，直接转换
     * 大于27的列数，可将算法理解成将10进制转换成26进制(A：1,...Z:0)
     *
     * @param columnNumber
     * @return
     */
    public static String int2Column(int columnNumber) {
        if (columnNumber <= 26) {
            return String.valueOf((char) (columnNumber % 27 + 64));
        } else {
            return int2ColumnRecursion(columnNumber);
        }
    }

    /**
     * 大于27的列数，通过类26进制的转换算法转换
     *
     * @param columnNumber
     * @return
     */
    private static String int2ColumnRecursion(int columnNumber) {
        StringBuilder result = new StringBuilder();
        int quotient = columnNumber / 26;
        int remainder = columnNumber % 26;
        if (remainder == 0) {
            quotient--;
            remainder = 26;
        }
        if (quotient > 0) {
            result.append(int2ColumnRecursion(quotient));
        }
        remainder += 64;
        result.append((char) remainder);
        return result.toString();
    }
}
