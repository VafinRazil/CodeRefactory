package com.rvafin.springjwt.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PromptType {
    EXPLAIN_CODE_WITH_COMMENTS("1", "написать комментарии поясняющие код"),
    WRITE_CODE_BRIEFLY_POSSIBLE("2", "сделать рефакторинг, сделав код более коротким"),
    REMOVE_COMMENTS("3", "удалить все комментарии"),
    RENAME_VARIABLES("5", "переименовать переменные и функции, сделав код понятнее"),
    REFACTORING_USING_CAMELCASE_METHOD("9", "сделать рефакторинг, переименовав все переменные и функции методом camelcase"),
    REFACTORING_USING_SNAKECASE_METHOD("10", "сделать рефакторинг, переименовав все переменные и функции методом snakecase");

    private String index;
    private String value;

    PromptType(String index, String value){
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
