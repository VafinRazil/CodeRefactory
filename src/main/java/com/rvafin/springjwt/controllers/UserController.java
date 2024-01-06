package com.rvafin.springjwt.controllers;

import com.rvafin.springjwt.mapper.HistoryMapper;
import com.rvafin.springjwt.models.History;
import com.rvafin.springjwt.models.User;
import com.rvafin.springjwt.payload.response.HistoryDTO;
import com.rvafin.springjwt.repository.HistoryRepository;
import com.rvafin.springjwt.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private HistoryMapper historyMapper;

    @Autowired
    private HistoryRepository historyRepository;

    @GetMapping("/history")
    public ResponseEntity<?> getHistory(){
        User user = userService.getAuthenticateUser().get();
        List<History> historyList = historyRepository.getHistoriesByUser(user.getId());
        List<HistoryDTO> historyDTOList = historyList.stream().map(history -> historyMapper.mapToHistoryDTO(history)).collect(Collectors.toList());
        return ResponseEntity.ok(historyDTOList);
    }
}