package com.example.demo.tesService;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public class CheckForm {

  @NotEmpty(message = "未入力です")
  @Pattern(regexp = "\\d{4}", message = "整数4桁を入力してください")
  private String number;

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }
}
