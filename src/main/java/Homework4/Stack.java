package Homework4;

import java.util.ArrayList;
import java.util.List;

public class Stack implements Stackable {
  List<Integer> stack;

  public Stack() {
    this.stack = new ArrayList<>();
  }

  @Override
  public void push(int data) {
    this.stack.add(data);
  }

  @Override
  public int pop() {
    int value = this.stack.get(this.stack.size() - 1);
    this.stack.remove(this.stack.size() - 1);
    return value;
  }
}
