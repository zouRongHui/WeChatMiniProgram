package org.rone.study.springBoot.model;

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

    public ViewLog(String des, Date date) {
        this.des = des;
        this.date = date;
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
}
