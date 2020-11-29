package Homework4;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.in;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class ListNodeQueueTest {

  ListNodeQueue queue;

  @BeforeEach
  void setUp() {
    this.queue = new ListNodeQueue();
  }

  @Test
  void push() {
    this.queue.push(1);
    this.queue.push(2);
    this.queue.push(3);

    ListNode cur = this.queue.head;
    assertThat(cur.next.data, is(1));
    assertThat(cur.next.next.data, is(2));
    assertThat(cur.next.next.next.data, is(3));
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
    assertThrows(NullPointerException.class, () -> this.queue.pop());
  }
}
