package Homework4;

import java.util.Objects;

public class ListNode {
  int data; // head must have no data
  ListNode next;

  public ListNode() {}

  public ListNode(int data) {
    this.data = data;
  }

  static ListNode add(ListNode head, ListNode nodeToAdd, int position) {
    ListNode target = head;
    for (int i = 0; i < position - 1; i++) {
      target = target.next;
    }
    nodeToAdd.next = target.next;
    target.next = nodeToAdd;
    return nodeToAdd;
  }

  // caller must remove all of references for target node
  static ListNode remove(ListNode head, int positionToRemove) {
    if (positionToRemove == 0) {
      return head;

    } else {
      ListNode target = head.next, before = head;
      for (int i = 0; i < positionToRemove - 1; i++) {
        before = target;
        target = target.next;
      }
      before.next = target.next;
      return target;
    }
  }

  static boolean contains(ListNode head, ListNode nodeTocheck) {
    while (head != null) {
      if (head.equals(nodeTocheck)) return true;
      head = head.next;
    }
    return false;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ListNode other = (ListNode) o;
    return this.data == other.data && Objects.equals(this.next, other.next);
  }
}
