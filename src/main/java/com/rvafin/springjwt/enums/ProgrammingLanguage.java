package com.rvafin.springjwt.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ProgrammingLanguage {
    JAVASCRIPT(1, "javascript"),
    C(2, "c"),
    SWIFT(3, "swift"),
    TYPESCRIPT(4, "typescript"),
    JAVA(5, "java");

    private int index;

    private String value;

    ProgrammingLanguage(int index, String value){
        this.index = index;
        this.value = value;
    }

    @JsonValue
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


}
