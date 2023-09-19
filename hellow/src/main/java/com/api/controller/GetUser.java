package com.api.controller;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.model.UserResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
@RequestMapping("/getUser")
public class GetUser {
  private final ObjectMapper mapper = new ObjectMapper();
  private final Resource resource = new ClassPathResource("stub/user.json");

  @GetMapping("/hello")
  public UserResponse hello(
      @RequestParam(name = "name", defaultValue = "Alice") String name,
      @RequestParam(name = "age", defaultValue = "26") int age) throws IOException {

    InputStream is = resource.getInputStream();
    JsonNode jsonNode = mapper.readTree(is);

    // クエリパラメータから値を取得して jsonNode を更新
    // ageOfCE(AgeOfContractExpirationの略)はageの値＋30として更新
    ((ObjectNode) jsonNode).put("name", name);
    ((ObjectNode) jsonNode).put("age", age);
    ((ObjectNode) jsonNode).put("ageOfCE", age + 30);

    UserResponse userResponse = mapper.treeToValue(jsonNode, UserResponse.class);

    return userResponse;
  }

}
