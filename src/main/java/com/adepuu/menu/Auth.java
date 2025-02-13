package com.adepuu.menu;

import com.adepuu.entity.User;

import java.util.HashMap;
import java.util.Scanner;

public class Auth {
  private final Scanner scanner = new Scanner(System.in);
  HashMap<String, User> registeredUsers = new HashMap<>();
  TaskManagement taskManagementApp = new TaskManagement();

  private User currentUser;

  public Auth() {
    registeredUsers.put("ade", new User("ade", "password"));
    registeredUsers.put("user2", new User("user2", "password"));
  }

  public void loginPrompts() {
    while(true) {
      System.out.println("Username: ");
      String username = scanner.nextLine();
      System.out.println("Password: ");
      String password = scanner.nextLine();

      User user = registeredUsers.get(username);
      if (user == null) {
        // Clear terminal first
        System.out.print("\033[H\033[2J");
        System.out.println("User not found, please register first: ");
        registerPrompts();
        continue;
      }

      // Handle success state
      if (user.login(username, password)) {
        currentUser = user;
        System.out.println("Login successful");
        taskManagementApp.setUserSession(currentUser);
        taskManagementApp.manageTaskPrompt();
      } else {
        System.out.println("Invalid credentials");
      }
    }
  }

  public void registerPrompts() {
    while(true) {
      System.out.println("Username: ");
      String username = scanner.nextLine();
      System.out.println("Password: ");
      String password = scanner.nextLine();

      if (username.isEmpty() || password.isEmpty()) {
        System.out.println("Username or password cannot be empty");
        continue;
      }

      User user = new User(username, password);
      registeredUsers.put(username, user);
      System.out.println("User registered successfully");
      break;
    }
  }
}
