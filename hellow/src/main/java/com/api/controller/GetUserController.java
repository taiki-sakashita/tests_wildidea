package com.api.controller;

import java.io.IOException;
import java.io.InputStream;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.model.UserResponse;
import com.api.model.UserResponse.Membership;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
@RequestMapping("/getUser")
public class GetUserController {
  private final ObjectMapper mapper = new ObjectMapper();
  private final Resource resource = new ClassPathResource("stub/user.json");

  private static final Logger logger = LoggerFactory.getLogger(GetUserController.class);

  @GetMapping("/hello")

  public UserResponse hello(
      @RequestParam(name = "name", required = false) String name,
      @RequestParam(name = "age", required = false) Integer age,
      @RequestParam(name = "membership", required = false) Membership membership) throws IOException {
    logger.info("名前:", name);
    logger.info("メンバーシップ:", membership);
    JsonNode jsonNode = readResorce();

    updateJsonNode(jsonNode, name, age, membership);

    return mapper.treeToValue(jsonNode, UserResponse.class);

  }

  private JsonNode readResorce() throws IOException {
    try (InputStream is = resource.getInputStream()) {
      return mapper.readTree(is);
    }
  }

  private void updateJsonNode(JsonNode jsonNode, String name, Integer age, Membership membership) {
    if (name != null) {
      ((ObjectNode) jsonNode).put("name", name);
    }
    if (age != null) {
      ((ObjectNode) jsonNode).put("age", age);
      ((ObjectNode) jsonNode).put("ageOfCE", age.intValue() + 30);
    }
    if (membership != null) {
      ((ObjectNode) jsonNode).put("membership", membership.getValue());

    }
  }
}
