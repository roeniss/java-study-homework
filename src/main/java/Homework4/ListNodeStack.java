package Homework4;

public class ListNodeStack implements Stackable {
  ListNode head;

  public ListNodeStack() {
    this.head = new ListNode();
  }

  @Override
  public void push(int data) {
    ListNode node = new ListNode(data);
    ListNode curNode = this.head;
    while (curNode.next != null) curNode = curNode.next;

    curNode.next = node;
  }

  @Override
  public int pop() {
    if (this.head.next == null) throw new IndexOutOfBoundsException();

    ListNode curNode = this.head.next, before = this.head;
    while (curNode.next != null) {
      before = curNode;
      curNode = curNode.next;
    }

    before.next = null;
    return curNode.data;
  }
}
