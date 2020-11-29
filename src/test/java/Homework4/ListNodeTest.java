package Homework4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class ListNodeTest {

  ListNode head;

  @BeforeEach
  void setUp() {
    this.head = new ListNode();
    ListNode first = new ListNode(1);
    ListNode second = new ListNode(2);
    ListNode third = new ListNode(3);
    this.head.next = first;
    first.next = second;
    second.next = third;
  }

  @Test
  void add() {
    ListNode node = new ListNode(4);
    ListNode.add(this.head, node, 2);
    this.assertListNodeData(1, 4, 2, 3);
  }

  @Test
  void add_addOnFirstSlot() {
    ListNode node = new ListNode(99);
    ListNode.add(this.head, node, 1);
    this.assertListNodeData(99, 1, 2, 3);
  }

  @Test
  void add_failWhenAddingToWrongPosition() {
    ListNode node = new ListNode(1);
    assertThrows(NullPointerException.class, () -> ListNode.add(this.head, node, 100));
  }

  @Test
  void remove() {
    ListNode.remove(this.head, 1);
    this.assertListNodeData(2, 3);
  }

  @Test
  void remove_successWhenRemovingMiddleNode() {
    ListNode.remove(this.head, 2);
    this.assertListNodeData(1, 3);
  }

  @Test
  void remove_failWhenNoNode() {
    assertThrows(NullPointerException.class, () -> ListNode.remove(this.head, 4));
  }

  @Test
  void contains() {
    assertTrue(ListNode.contains(this.head, this.head.next.next));
    assertFalse(ListNode.contains(this.head, new ListNode(1)));
  }

  private void assertListNodeData(int... data) {
    ListNode cur = this.head;
    for (int i : data) {
      cur = cur.next;
      assertThat(cur.data, is(i));
    }
    assertNull(cur.next);
  }
}
