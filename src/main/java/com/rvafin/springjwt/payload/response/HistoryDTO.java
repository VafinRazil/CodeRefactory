package com.rvafin.springjwt.payload.response;

public class HistoryDTO {

    private String body;
    private String dateTimeCreate;

    public HistoryDTO() {
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDateTimeCreate() {
        return dateTimeCreate;
    }

    public void setDateTimeCreate(String dateTimeCreate) {
        this.dateTimeCreate = dateTimeCreate;
    }
}
