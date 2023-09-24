package com.api.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.api.hellow.HellowApplication;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = HellowApplication.class)
@AutoConfigureMockMvc
public class GetUserControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void tesHelloEndpoint() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/getUser/hello")
        .param("name", "John")
        .param("age", "25")
        .param("membershio", "NORMAL"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$name").value("John"))
        .andExpect(jsonPath("$age").value(25))
        .andExpect(jsonPath("$ageOfCE").value(55))
        .andExpect(jsonPath("$membership").value("NORMAL"));

  }
}
