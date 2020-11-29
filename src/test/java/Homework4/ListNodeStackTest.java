package Homework4;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ListNodeStackTest {
  ListNodeStack stack;

  @BeforeEach
  void setUp() {
    this.stack = new ListNodeStack();
  }

  @Test
  void push() {
    this.stack.push(1);
    this.stack.push(2);
    this.stack.push(3);

    ListNode head = this.stack.head;
    assertThat(head.next.data, Matchers.is(1));
    assertThat(head.next.next.data, Matchers.is(2));
    assertThat(head.next.next.next.data, Matchers.is(3));
  }

  @Test
  void pop() {
    this.stack.push(1);
    this.stack.push(2);
    this.stack.push(3);

    assertThat(this.stack.pop(), Matchers.is(3));
    assertThat(this.stack.pop(), Matchers.is(2));
    assertThat(this.stack.pop(), Matchers.is(1));
  }

  @Test
  void pop_failWhenStackEmpty() {
    assertThrows(IndexOutOfBoundsException.class, () -> this.stack.pop());
  }
}
