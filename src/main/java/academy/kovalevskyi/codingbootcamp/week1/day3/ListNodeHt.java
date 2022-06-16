package academy.kovalevskyi.codingbootcamp.week1.day3;

import java.util.function.Function;

public class ListNodeHt<T> {
  private ListNode<T> head;
  private ListNode<T> tail;

  public ListNodeHt(ListNode<T> node) {
    setHead(node);
    setTail(node);
  }

  public void setHead(ListNode<T> node) {
    head = node;
    while (head.hasPrev()) {
      head = head.getPrev();
    }
  }

  public void setTail(ListNode<T> node) {
    tail = node;
    while (tail.hasNext()) {
      tail = tail.getNext();
    }
  }

  public ListNode<T> getHead() {
    return head;
  }

  public ListNode<T> getTail() {
    return tail;
  }

  public boolean isHead(ListNode<T> node) {
    return !node.hasPrev();
  }
 
  public boolean isTail(ListNode<T> node) {
    return !node.hasNext();
  }
 
  public boolean contains(T value) {
    ListNode step = head;
    while (step.hasNext()) {
      if (step.getValue() == value) {
        return true;
      }
      step = step.getNext();
    }   
    return (step.getValue() == value) ? true : false;
  }
 
  public int length() {
    int length = 1;
    ListNode step = head;
    while (step.hasNext()) {
      length++;
      step = step.getNext();
    } 
    return length;
  }
}
