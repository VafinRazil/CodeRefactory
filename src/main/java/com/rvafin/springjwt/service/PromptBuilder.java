package com.rvafin.springjwt.service;

import com.rvafin.springjwt.payload.request.Prompt;

public class PromptBuilder {

    public static String buildRequestToChatGPT(Prompt prompt){
        StringBuilder builder = new StringBuilder();
        builder.append("КОНТЕКСТ:\n").
                append("Ты опытный senior программист разработчик, ты используешь лучшие практики для рефакторинга и разработки кода.\n").
                append("ЗАПРОС:\n").append("Тебе подаётся код другого разработчика на языке ").append(prompt.getLanguageRequest().getValue()).append(", ").
                append("тебе нужно ").append(prompt.getType().getValue()).append(", свой ответ представь только в виде кода и он должен быть как можно ").
                append(prompt.getTone().getValue()).append(".\n").append("Вот код:\n").append(prompt.getCode()).append("\n");
        if (prompt.getAdditional() != null && !prompt.getAdditional().isEmpty()) {
            builder.append("Дополнительно:\n").append(prompt.getAdditional());
        }
        return builder.toString();
    }
}
