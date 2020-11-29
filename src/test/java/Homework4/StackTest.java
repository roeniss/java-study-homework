package Homework4;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StackTest {
  Stack stack = new Stack();

  @Test
  void push() {
    this.stack.push(1);
    this.stack.push(2);
    this.stack.push(3);

    assertThat(this.stack.stack.get(0), is(1));
    assertThat(this.stack.stack.get(1), is(2));
    assertThat(this.stack.stack.get(2), is(3));
  }

  @Test
  void pop() {
    this.stack.push(1);
    this.stack.push(2);
    this.stack.push(3);

    assertThat(this.stack.pop(), is(3));
    assertThat(this.stack.pop(), is(2));
    assertThat(this.stack.pop(), is(1));
  }

  @Test
  void pop_failWhenStackEmpty() {
    assertThrows(IndexOutOfBoundsException.class, () -> this.stack.pop());
  }
}
