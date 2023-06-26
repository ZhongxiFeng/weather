package com.example.studentservicedev.response;

import org.springframework.http.HttpStatus;

import java.util.Date;

public class GeneralResponse {
    private int code;
    private Date timestamp;
    private Object data;

    public GeneralResponse(Object o){
        this.code = HttpStatus.OK.value();
        this.timestamp = new Date();
        this.data = o;
    }
    public GeneralResponse(){
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
