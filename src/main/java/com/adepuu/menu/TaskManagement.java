package com.adepuu.menu;

import com.adepuu.entity.ToDo;
import com.adepuu.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class TaskManagement {
  private final Scanner scanner = new Scanner(System.in);
  private HashMap<String, List<ToDo>> tasks = new HashMap<>();
  private User currentUser;

  public void setUserSession(User user) {
    System.out.println("Welcome, " + user.getUsername());
    this.currentUser = user;
  }

  public void manageTaskPrompt() {
    while(true) {
      System.out.println("1. Add task");
      System.out.println("2. View tasks");
      System.out.println("3. Mark task as done");
      System.out.println("4. Delete task");
      System.out.println("5. Exit");
      System.out.println("Choose an option: ");
      int option = scanner.nextInt();
      scanner.nextLine();
      System.out.print("\033[H\033[2J");
      switch(option) {
        case 1:
          addTask();
          break;
        case 2:
          viewTasks();
          break;
        case 3:
          markTaskAsDone();
          break;
        case 4:
          deleteTask();
          break;
        case 5:
          return;
        default:
          System.out.println("Invalid option");
      }
    }
  }

  private void deleteTask() {
    this.viewTasks();
    while (true) {
      System.out.println("Enter task number to delete: ");
      int taskNumber = scanner.nextInt();
      scanner.nextLine();

      List<ToDo> userTasks = tasks.get(currentUser.getUsername());
      if (userTasks == null || userTasks.isEmpty()) {
        System.out.println("No tasks found");
        return;
      }

      if (taskNumber < 1 || taskNumber > userTasks.size()) {
        System.out.println("Invalid task number");
        continue;
      }

      userTasks.remove(taskNumber - 1);
      System.out.println("Task deleted successfully");
      break;
    }
  }

  private void markTaskAsDone() {
    this.viewTasks();
    while (true) {
      System.out.println("Enter task number to mark as done: ");
      int taskNumber = scanner.nextInt();
      scanner.nextLine();

      List<ToDo> userTasks = tasks.get(currentUser.getUsername());
      if (userTasks == null || userTasks.isEmpty()) {
        System.out.println("No tasks found");
        return;
      }

      if (taskNumber < 1 || taskNumber > userTasks.size()) {
        System.out.println("Invalid task number");
        continue;
      }

      ToDo task = userTasks.get(taskNumber - 1);
      task.markAsDone();
      System.out.println("Task marked as done successfully");
      break;
    }
  }

  private void viewTasks() {
    List<ToDo> userTasks = tasks.get(currentUser.getUsername());
    if (userTasks == null || userTasks.isEmpty()) {
      System.out.println("No tasks found");
      return;
    }

    for (int i = 0; i < userTasks.size(); i++) {
      ToDo task = userTasks.get(i);
      System.out.println((i + 1) + ". " + task.getTask() + " - " + (task.isDone() ? "Done" : "Not done"));
    }
  }

  private void addTask() {
    while (true) {
      System.out.println("Enter task: ");
      String task = scanner.nextLine();
      if (task.isEmpty()) {
        System.out.println("Task cannot be empty");
        continue;
      }

      List<ToDo> userTasks = tasks.computeIfAbsent(currentUser.getUsername(), k -> new ArrayList<>());

      userTasks.add(new ToDo(task));
      System.out.println("Task added successfully");
      break;
    }
  }
}
