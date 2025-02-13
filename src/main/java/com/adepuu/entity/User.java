package com.adepuu.entity;

public class User {
  private final String username;
  private final String password;

  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public boolean login(String username, String password) {
    return this.username.equalsIgnoreCase(username) && this.password.equals(password);
  }

  public String getUsername() {
    return this.username;
  }
}
