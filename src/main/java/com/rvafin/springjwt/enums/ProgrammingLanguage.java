package com.rvafin.springjwt.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ProgrammingLanguage {
    JAVASCRIPT("1", "javascript"),
    C("2", "c"),
    SWIFT("3", "swift"),
    TYPESCRIPT("4", "typescript"),
    JAVA("5", "java");

    private String index;

    private String value;

    ProgrammingLanguage(String index, String value){
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
