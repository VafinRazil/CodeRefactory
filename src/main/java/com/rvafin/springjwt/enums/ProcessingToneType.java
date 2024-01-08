package com.rvafin.springjwt.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ProcessingToneType {
    PROFESSIONAL("1", "профессиональнее"),
    BASIC("2", "понятнее");

    private String index;

    private String value;

    ProcessingToneType(String index, String value){
        this.index = index;
        this.value = value;
    }

    @JsonValue
    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
