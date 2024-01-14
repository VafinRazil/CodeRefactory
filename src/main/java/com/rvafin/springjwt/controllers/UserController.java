package com.rvafin.springjwt.controllers;

import com.rvafin.springjwt.models.History;
import com.rvafin.springjwt.models.User;
import com.rvafin.springjwt.payload.response.HistoryDTO;
import com.rvafin.springjwt.repository.HistoryRepository;
import com.rvafin.springjwt.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private HistoryRepository historyRepository;

    @GetMapping("/history")
    public ResponseEntity<?> getHistory(){
        User user = userService.getAuthenticateUser().get();
        List<History> historyList = historyRepository.getHistoriesByUser(user.getId());
        List<HistoryDTO> historyDTOList = historyList.stream().map(history -> {
            HistoryDTO historyDTO = new HistoryDTO();
            historyDTO.setRequestCode(history.getRequestCode());
            historyDTO.setResponseCode(history.getResponseCode());
            historyDTO.setProgLang(String.valueOf(history.getProgrammingLanIndex()));
            historyDTO.setId(history.getId());
            historyDTO.setDateTimeCreate(history.getDateTimeCreate().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss")));
            return historyDTO;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(historyDTOList);
    }
}
