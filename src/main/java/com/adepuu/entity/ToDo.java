package com.adepuu.entity;

public class ToDo {
  private final String task;
  private boolean isDone;

  public ToDo(String task) {
    this.task = task;
    this.isDone = false;
  }

  public String getTask() {
    return this.task;
  }

  public boolean isDone() {
    return this.isDone;
  }

  public void markAsDone() {
    this.isDone = true;
  }
}
