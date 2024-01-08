package com.rvafin.springjwt.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rvafin.springjwt.config.OpenaiConfiguration;
import com.rvafin.springjwt.models.History;
import com.rvafin.springjwt.models.User;
import com.rvafin.springjwt.payload.request.ChatRequest;
import com.rvafin.springjwt.payload.request.Prompt;
import com.rvafin.springjwt.repository.HistoryRepository;
import com.rvafin.springjwt.security.services.UserService;
import com.rvafin.springjwt.service.PromptBuilder;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/request/")
public class MainController {

    @Autowired
    public OpenaiConfiguration openaiConfiguration;

    @Autowired
    public UserService userService;

    @Autowired
    public HistoryRepository historyRepository;

    @PostMapping("/chatgpt-3.5")
    public ResponseEntity<?> sendRequestToChatGPT(@RequestBody Prompt prompt) throws IOException {
        Optional<User> user = userService.getAuthenticateUser();
        URL url = new URL(openaiConfiguration.getUrl());
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        System.out.println(openaiConfiguration.getKey());
        con.setRequestProperty("Authorization", "Bearer " + openaiConfiguration.getKey());
        con.setDoOutput(true);
        ChatRequest chatRequest = new ChatRequest(openaiConfiguration.getModel(), PromptBuilder.buildRequestToChatGPT(prompt));
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(chatRequest);
        OutputStream os = con.getOutputStream();
        os.write(json.getBytes());
        os.flush();
        os.close();
        int responseCode = con.getResponseCode();
        InputStream inputStream;
        if (responseCode >= 400) {
            inputStream = con.getErrorStream();
        } else {
            inputStream = con.getInputStream();
        }
        if (user.isPresent()){
            History history = new History();
            history.setBody(prompt.toString());
            history.setRequestCreator(user.get());
            history.setDateTimeCreate(LocalDateTime.now());
            historyRepository.save(history);
        }
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return ResponseEntity.ok(response);
    }
}
