package com.example.greenbay.models;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String username;
  private String password;
  private String roles;
  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, mappedBy = "user")
  private List<Item> notSoldItems;

  //region Getters&Setters
  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public String getRoles() {
    return roles;
  }
  //endregion
}
