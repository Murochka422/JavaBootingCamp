package academy.kovalevskyi.codingbootcamp.week1.day3;

import java.util.function.Function;

public class ListHelper<T> {

  public static <T> int length(ListNode<T> someNode) throws NullPointerException {
    if (someNode == null) {
      throw new NullPointerException("Node is null");
    }
    ListNodeHt ht = new ListNodeHt(someNode);
    return ht.length();
  } 

  public static <T> ListNode<T> addToEnd(ListNode<T> someNode, T newValue) {
    ListNodeHt ht = new ListNodeHt(someNode);
    ht.setTail(new ListNode(ht.getTail(), null, newValue));
    return ht.getTail();
  }

  public static <T> ListNode<T> addToStart(ListNode<T> someNode, T newValue) {
    ListNodeHt ht = new ListNodeHt(someNode);
    ht.setHead(new ListNode(null, ht.getHead(), newValue));
    return ht.getHead();
  }

  public static <T> boolean contains(ListNode<T> someNode, T value) {
    ListNodeHt ht = new ListNodeHt(someNode);
    return ht.contains(value);
  }

  public static <T, R> ListNode<R> map(ListNode<T> someNode, Function<T, R> mapFunction)
                                   throws NullPointerException {
    ListNodeHt ht = new ListNodeHt(someNode);
    if (someNode == null) {
      throw new NullPointerException("Node is null");
    }
    ListNode<T> step = ht.getHead();
    ListNode<T> node = new ListNode(null, null, mapFunction.apply(step.getValue()));
    while (step.hasNext()) {
      step = step.getNext();
      node = addToEnd(node, (T) mapFunction.apply(step.getValue()));
    }
    return (ListNode<R>) node;
  }  

  public static <T> ListNode<T> insertAfter(ListNode<T> prev, T newValue) {
    return new ListNode(prev, prev.getNext(), newValue);  
  }

  public static <T> void insertAfter(ListNode<T> prev, T[] newValues) {
    if (newValues.length > 0) {
      ListNode node = insertAfter(prev, newValues[0]);
      for (int i = 1; i < newValues.length; i++) {
        node = insertAfter(node, newValues[i]);
      }
    }
  }

  public static <T> T delete(ListNode<T> current) {
    if (current.hasPrev()) {
      current.getPrev().setNext(current.getNext());
      current.setPrev(null);
    }
    if (current.hasNext()) {
      current.getNext().setPrev(current.getPrev());
      current.setNext(null);
    }
    return current.getValue();
  }
}
