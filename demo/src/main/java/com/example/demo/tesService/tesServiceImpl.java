package com.example.demo.tesService;

public class tesServiceImpl implements tesService {
  @Override
  public String findByNo(String number) {
    tesRepository tesRepository = new tesRepositoryImpl();
    String name = tesRepository.searchByNo(number);
    return name;
  
  }
}
