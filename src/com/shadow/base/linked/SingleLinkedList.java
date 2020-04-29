package com.shadow.base.linked;

/**
 * 单链表
 */
public class SingleLinkedList<E> {
  
  private Node<E> head;
  private int size;
  
  public SingleLinkedList() {
    this.size = 0;
    head = null;
  }
  
  /**
   * 节点
   */
  private static class Node<E> {
    private Node<E> next;
    private E element;
    
    private Node(E element, Node<E> next) {
      this.element = element;
      this.next = next;
    }
  }
  
  public E add(E element) {
    return addLast(element);
  }
  
  public E addFirst(E element) {
    if (head == null) {
      head = new Node<>(element, null);
    } else {
      head = new Node<>(element, head);
    }
    size++;
    return element;
  }
  
  public E addLast(E element) {
    if (head == null) {
      head = new Node<>(element, null);
    } else {
      Node<E> newNode = new Node<>(element, null);
      for (Node<E> x = head; ; x = x.next) {
        if (x.next == null) {
          x.next = newNode;
          break;
        }
      }
    }
    size++;
    return element;
  }
  
  public void printAllElement() {
    if (head == null) {
      System.out.println("Element is empty!");
    }
    System.out.println("----------Print All Elements----------");
    for (Node<E> x = head; x != null; x = x.next) {
      System.out.println(x.element);
    }
  }
  
  public int size() {
    return size;
  }
  
  public E get(int index) {
    if (index >= size) {
      throw new IndexOutOfBoundsException("The index is out of bounds!");
    }
    return null;
  }
  
  public boolean isEmpty() {
    return size == 0;
  }
  
  public boolean contain(E element) {
    for (Node<E> x = head; x != null; x = x.next) {
      if (element == null && x.element == null) {
        return true;
      }
      if (x.element != null && x.element.equals(element)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean remove(E element) {
    if (head == null) {
      return false;
    }
    Node<E> pre = null;
    for (Node<E> x = head; x != null; x = x.next) {
      Node<E> target = null;
      if (element == null && x.element == null) {
        target = x;
      }
      if (x.element != null && x.element.equals(element)) {
        target = x;
      }
      if (target != null) {
        if (pre == null) {
          head = null;
          size--;
        } else {
          pre.next = target.next;
          target.element = null; //help gc
          target.next = null; // help gc
        }
        return true;
      } else {
        pre = x;
      }
    }
    return false;
  }
  
  public static void main(String[] args) {
    SingleLinkedList<Integer> list = new SingleLinkedList<>();
    list.add(1);
    list.add(2);
    list.add(null);
    list.add(3);
    list.add(4);
    System.out.println(list.remove(null));
    list.printAllElement();
  }
  
}