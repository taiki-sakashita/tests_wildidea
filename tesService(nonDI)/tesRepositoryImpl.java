package com.example.demo.tesService;

public class tesRepositoryImpl implements tesRepository {
  public String searchByNo(String number) {

    String name;
    if (number.equals("1000")) {
      name = "DIなし いち";
    } else {
      name = "DIなし に";
    }

    return name;
  }
}
