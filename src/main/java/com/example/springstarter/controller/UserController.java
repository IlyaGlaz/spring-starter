package com.example.springstarter.controller;

import com.example.springstarter.dto.UserReadDto;
import com.example.springstarter.dto.UserWriteDto;
import com.example.springstarter.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public UserReadDto findById(@PathVariable Long id) {
        return userService.getById(id)
                .orElseThrow(RuntimeException::new);
    }

    @GetMapping("/")
    public List<UserReadDto> findAll() {
        return userService.findAll();
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public UserReadDto create(@RequestBody UserWriteDto userWriteDto) {
        return userService.create(userWriteDto);
    }
}
