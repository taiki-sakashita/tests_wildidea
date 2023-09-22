package com.api.model;

public class UserResponse {
  private String name;
  private int age;
  private int ageOfCE;
  private Membership membership;

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

  public Membership getMembership() {
    return membership;
  }

  public void setMembership(Membership membership) {
    this.membership = membership;
  }

  public enum Membership {
    NOMEMBER(0, "メンバーではない"),
    NORMAL(1, "一般"),
    PREMIUM(2, "プレミアメンバー");

    private final int value;
    private final String viewName;

    private Membership(int value, String viewName) {
      this.value = value;
      this.viewName = viewName;
    }

    public int getValue() {
      return this.value;
    }

    public String getViewName() {
      return this.viewName;
    }
  }

  public static Membership toEnum(String value) {
    for (var enumValue : Membership.values()) {
      if (enumValue.getViewName().equals(value)) {
        return enumValue;
      }
    }
    return null;
  }

}
