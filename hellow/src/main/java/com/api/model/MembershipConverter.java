package com.api.model;

import org.springframework.core.convert.converter.Converter;
import com.api.model.UserResponse.Membership;;

public class MembershipConverter implements Converter<String, Membership> {
  @Override
  public Membership convert(String source) {
    if (source != null) {
      for (Membership membership : Membership.values()) {
        if (String.valueOf(membership.getValue()).equals(source)) {
          return membership;
        }
      }
    }
    return null;
  }
}
