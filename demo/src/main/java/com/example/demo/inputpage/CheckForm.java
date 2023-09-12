package com.example.demo.inputpage;

import jakarta.validation.constraints.NotEmpty;

public class CheckForm {

  @NotEmpty(message = "未入力です")
  private String number;

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }
}
