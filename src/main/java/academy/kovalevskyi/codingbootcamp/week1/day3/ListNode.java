package academy.kovalevskyi.codingbootcamp.week1.day3;

public class ListNode<T> {
  private ListNode prev;
  private ListNode next;
  T value;

  public ListNode(ListNode<T> prev, ListNode<T> next, T value) {
    setPrev(prev);
    setNext(next);
    this.value = value;
  }

  public boolean hasPrev() {
    return prev != null;
  }

  public boolean hasNext() {
    return next != null;
  }

  public void setPrev(ListNode<T> prev) {
    this.prev = prev;
    if (hasPrev()) {
      prev.next = this;
    }
  }

  public void setNext(ListNode<T> next) {
    this.next = next;
    if (hasNext()) {
      next.prev = this;
    }
  }

  public ListNode<T> getNext() {
    return next;
  }

  public ListNode<T> getPrev() {
    return prev;
  }

  public T getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.format("Node{prevValue=%s, nextValue=%s, thisValue=%s}", 
                          hasPrev() ? prev.getValue() : null, 
                          hasNext() ? next.getValue() : null, getValue());
  }
}
