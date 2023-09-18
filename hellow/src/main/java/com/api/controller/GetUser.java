package com.api.controller;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.model.UserResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/getUser")
public class GetUser {
  @GetMapping("/hello")
  public UserResponse hello() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    Resource resource = new ClassPathResource("stub/user.json");
    InputStream is = resource.getInputStream();
    return mapper.readValue(is, UserResponse.class);
  }

}
