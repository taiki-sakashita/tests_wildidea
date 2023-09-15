package com.example.demo.tesService;

import org.springframework.stereotype.Repository;

@Repository
public class TesRepositoryImpl implements TesRepository {

  @Override
  public String searchByNo(String number) {
    String name;
    if (number.equals("1000")) {
      name = "DIあり いち";
    } else {
      name = "DIあり に";
    }

    return name;
  }
}
