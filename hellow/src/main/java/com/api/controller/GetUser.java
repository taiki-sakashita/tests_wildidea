package com.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.model.UserResponse;

@RestController
@RequestMapping("/getUser")
public class GetUser {
  @GetMapping("/hello")
  public UserResponse hello(@RequestParam String name,
      @RequestParam int age) {
    return new UserResponse(name, age);
  }

}
