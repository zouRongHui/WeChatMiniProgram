package org.rone.study.springBoot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.rone.study.springBoot.utils.DateJsonSerializer;

import java.util.Date;

/**
 * Created by zouRongHui on 2018/6/7.
 */
public class ViewLog {
    private String des;
    @JsonSerialize(using = DateJsonSerializer.class)
    private Date date;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date date2;

    public ViewLog(String des, Date date, Date date2) {
        this.des = des;
        this.date = date;
        this.date2 = date2;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }
}
