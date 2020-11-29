package Homework4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ArrayQueueTest {
  ArrayQueue queue;
  int QUEUE_CAPACITY = 100;

  @BeforeEach
  void setUp() {
    this.queue = new ArrayQueue(this.QUEUE_CAPACITY);
  }

  @Test
  void push() {
    this.queue.push(1);
    this.queue.push(2);
    this.queue.push(3);

    assertThat(this.queue.queue[0], is(1));
    assertThat(this.queue.queue[1], is(2));
    assertThat(this.queue.queue[2], is(3));
  }

  @Test
  void push_failWhenCapacityOut() {
    for (int i = 0; i < this.QUEUE_CAPACITY; i++) {
      this.queue.push(1);
    }
    assertThrows(ArrayIndexOutOfBoundsException.class, () -> this.queue.push(1));
  }

  @Test
  void pop() {
    this.queue.push(1);
    this.queue.push(2);
    this.queue.push(3);

    assertThat(this.queue.pop(), is(1));
    assertThat(this.queue.pop(), is(2));
    assertThat(this.queue.pop(), is(3));
  }

  @Test
  void pop_failWhenQueueEmpty() {
    assertThrows(IndexOutOfBoundsException.class, () -> this.queue.pop());
  }
}
