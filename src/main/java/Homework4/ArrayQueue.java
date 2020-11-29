package Homework4;

public class ArrayQueue implements Queueable {
  int[] queue;
  int head, tail;

  public ArrayQueue(int capacity) {
    this.queue = new int[capacity];
    this.head = -1;
    this.tail = 0;
  }

  @Override
  public void push(int data) {
    this.queue[++this.head] = data;
  }

  @Override
  public int pop() {
    if (this.tail > this.head) throw new IndexOutOfBoundsException();
    return this.queue[this.tail++];
  }
}
