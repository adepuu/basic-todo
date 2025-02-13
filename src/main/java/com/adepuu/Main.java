package com.adepuu;

import com.adepuu.menu.Auth;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    Auth auth = new Auth();
    while (true) {
      System.out.println("Welcome to Task Management App");
      System.out.println("1. Login");
      System.out.println("2. Register");
      System.out.println("3. Exit");
      System.out.println("Choose an option: ");
      int option = scanner.nextInt();
      scanner.nextLine();
      System.out.print("\033[H\033[2J");
      switch (option) {
        case 1:
          auth.loginPrompts();
          break;
        case 2:
          auth.registerPrompts();
          break;
        case 3:
          System.exit(0);
        default:
          System.out.println("Invalid option");
      }
    }

  }
}