package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.demo.tesService.InputPageController;

@SpringBootTest
public class WebTest {
  private MockMvc mockMvc;

  @Autowired
  InputPageController target;

  @BeforeEach
  public void setup() {
    mockMvc = MockMvcBuilders.standaloneSetup(target).build();
  }

  @Test
  public void isStatusTest() throws Exception {

    mockMvc.perform(get("/input")).andExpect(status().isOk());
  }
}
