package Homework4;

public class ListNodeQueue implements Queueable {
  ListNode head;

  public ListNodeQueue() {
    this.head = new ListNode();
  }

  @Override
  public void push(int data) {
    ListNode node = new ListNode(data);
    ListNode cur = this.head;
    while (cur.next != null) cur = cur.next;
    cur.next = node;
  }

  @Override
  public int pop() {
    int data = this.head.next.data;
    this.head = this.head.next;
    return data;
  }
}
