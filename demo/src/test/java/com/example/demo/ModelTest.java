package com.example.demo;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.demo.tesService.InputPageController;
import com.example.demo.tesService.TesService;

@SpringBootTest
public class ModelTest {
  private MockMvc mockMvc;

  @Autowired
  InputPageController target;

  @BeforeEach
  public void setup() {
    mockMvc = MockMvcBuilders.standaloneSetup(target).build();
  }

  @MockBean
  private TesService tesService;

  @Test
  public void isModelTest() throws Exception{
    when(tesService.findByNo("1000")).thenReturn("DIあり いち");
    mockMvc.perform(post("/chkScreen?number=1000")).andExpect(model().attribute("name", "DIあり いち"));
  }

  @Test
  public void isModelTest2() throws Exception{
    when(tesService.findByNo("1001")).thenReturn("DIあり に");
    mockMvc.perform(post("/chkScreen?number=1001")).andExpect(model().attribute("name", "DIあり に"));
  }
}
