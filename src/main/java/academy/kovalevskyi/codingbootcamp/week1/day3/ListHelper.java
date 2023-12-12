package academy.kovalevskyi.codingbootcamp.week1.day3;

import java.util.function.Function;

public class ListHelper {

  public static <T> boolean contains(ListNode<T> someNode, T value) {
    ListNode<T> step = someNode;
    while (hasPrev(step)) {
      if (step.getValue() == value) {
        return true;
      }
      step = step.getPrev();
    }
    if (step.getValue() == value) {
      return true;
    }

    step = someNode;
    while (hasNext(step)) {
      if (step.getValue() == value) {
        return true;
      }
      step = step.getNext();
    }
    return (step.getValue() == value) ? true : false;
  }

  public static <T> int length(ListNode<T> someNode) {
    if (someNode == null) {
      throw new NullPointerException("Node is null");
    }
    int length = 1;
    ListNode<T> step = someNode;
    while (hasNext(step)) {
      length++;
      step = step.getNext();
    }
    step = someNode;
    while (hasPrev(step)) {
      length++;
      step = step.getPrev();
    }
    return length;
  }

  public static <T> ListNode<T> addToEnd(ListNode<T> someNode, T newValue) {
    ListNode<T> tail = setTail(someNode);
    tail = setTail(new ListNode<>(tail, null, newValue));
    return tail;
  }

  public static <T> ListNode<T> addToStart(ListNode<T> someNode, T newValue) {
    ListNode<T> head = setHead(someNode);
    head = setHead(new ListNode<>(null, head, newValue));
    return head;
  }

  public static <T, R> ListNode<R> map(ListNode<T> someNode, Function<T, R> mapFunction) {
    if (someNode == null) {
      throw new NullPointerException("Node is null");
    }
    ListNode<T> step = setHead(someNode);
    ListNode<R> node = new ListNode<>(null, null, mapFunction.apply(step.getValue()));
    while (hasNext(step)) {
      step = step.getNext();
      node = addToEnd(node, mapFunction.apply(step.getValue()));
    }
    return node;
  }  

  public static <T> ListNode<T> insertAfter(ListNode<T> prev, T newValue) {
    return new ListNode<>(prev, prev.getNext(), newValue);
  }

  public static <T> void insertAfter(ListNode<T> prev, T[] newValues) {
    if (newValues.length > 0) {
      ListNode<T> node = insertAfter(prev, newValues[0]);
      for (int i = 1; i < newValues.length; i++) {
        node = insertAfter(node, newValues[i]);
      }
    }
  }

  public static <T> T delete(ListNode<T> current) {
    if (hasPrev(current)) {
      current.getPrev().setNext(current.getNext());
      current.setPrev(null);
    }
    if (hasNext(current)) {
      current.getNext().setPrev(current.getPrev());
      current.setNext(null);
    }
    return current.getValue();
  }

  private static <T> boolean hasPrev(ListNode<T> node) {
    return node.getPrev() != null;
  }

  private static <T> boolean hasNext(ListNode<T> node) {
    return node.getNext() != null;
  }

  private static <T> ListNode<T> setHead(ListNode<T> node) {
    ListNode<T> head = node;
    while (hasPrev(head)) {
      head = head.getPrev();
    }
    return head;
  }

  private static <T> ListNode<T> setTail(ListNode<T> node) {
    ListNode<T> tail = node;
    while (hasNext(tail)) {
      tail = tail.getNext();
    }
    return tail;
  }
}