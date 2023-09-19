package com.api.model;

public class UserResponse {
  private String name;
  private int age;
  private int ageOfCE;

  public UserResponse() {

  }

  public UserResponse(String name, int age, int ageOfCE) {
    this.name = name;
    this.age = age;
    this.ageOfCE = age + 30;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public int getAgeOfCE() {
    return ageOfCE;
  }

  public void setAgeOfCE(int ageOfCE) {
    this.ageOfCE = ageOfCE;
    
  }

}
