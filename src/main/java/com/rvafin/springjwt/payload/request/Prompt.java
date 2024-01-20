package com.rvafin.springjwt.payload.request;

import com.rvafin.springjwt.enums.ProcessingToneType;
import com.rvafin.springjwt.enums.ProgrammingLanguage;
import com.rvafin.springjwt.enums.PromptType;

public class Prompt {
    private ProcessingToneType tone;
    private PromptType type;
    private ProgrammingLanguage languageRequest;

    private String code;
    private String additional;

    public Prompt(){}

    public ProgrammingLanguage getLanguageRequest() {
        return languageRequest;
    }

    public void setLanguageRequest(ProgrammingLanguage languageRequest) {
        this.languageRequest = languageRequest;
    }

    public ProcessingToneType getTone() {
        return tone;
    }

    public void setTone(ProcessingToneType tone) {
        this.tone = tone;
    }


    public PromptType getType() {
        return type;
    }

    public void setType(PromptType type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAdditional() {
        return additional;
    }

    public void setAdditional(String additional) {
        this.additional = additional;
    }

    @Override
    public String toString() {
        return "Prompt{" +
                "tone=" + tone +
                ", type=" + type +
                ", languageRequest=" + languageRequest +
                ", code='" + code + '\'' +
                ", additional='" + additional + '\'' +
                '}';
    }
}
