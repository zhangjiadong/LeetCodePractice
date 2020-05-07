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
  
  /**
   * 添加节点到头部
   * 时间复杂度 O(1)
   * 空间复杂度 O(1)
   */
  public E addFirst(E element) {
    if (head == null) {
      head = new Node<>(element, null);
    } else {
      head = new Node<>(element, head);
    }
    size++;
    return element;
  }
  
  /**
   * 添加节点到尾部
   * 时间复杂度 O(N)
   * 空间复杂度 O(1)
   */
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
  
  /**
   * 打印所有节点
   * 时间复杂度 O(N)
   * 空间复杂度 O(1)
   */
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
  
  /**
   * 根据index查找数据
   * 时间复杂度 O(N)
   * 空间复杂度 O(1)
   */
  public E get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("The index is out of bounds!");
    }
    int count = 0;
    for (Node<E> x = head; x != null; x = x.next) {
      if (count == index) {
        return x.element;
      }
      count++;
    }
    return null;
  }
  
  public boolean isEmpty() {
    return size == 0;
  }
  
  /**
   * 判断元素是够存在
   * <p>
   * 时间复杂度O(N)
   * 空间复杂度O(1)
   */
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
  
  /**
   * 移除元素
   * 时间复杂度 O(N)
   * 空间复杂度 O(1)
   */
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
        } else {
          pre.next = target.next;
          target.element = null; //help gc
          target.next = null; // help gc
        }
        size--;
        return true;
      } else {
        pre = x;
      }
    }
    return false;
  }
  
  /**
   * 循环翻转链表
   * https://www.javazhiyin.com/32787.html
   */
  public void reverseByLoop() {
    if (head == null || head.next == null) {
      return;
    }
    Node<E> preNode = null;
    Node<E> nextNode = null;
    while (head != null) {
      nextNode = head.next;
      head.next = preNode;
      preNode = head;
      head = nextNode;
    }
    head = preNode;
  }
  
  /**
   * 递归链表翻转
   */
  public Node<E> reverseByRecursion(Node<E> head) {
    if (head == null || head.next == null) {
      return head;
    }
    Node<E> newHead = reverseByRecursion(head.next);
    head.next.next = head;
    head.next = null;
    return newHead;
  }
  
  public static void main(String[] args) {
    SingleLinkedList<Integer> list = new SingleLinkedList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    System.out.println("------翻转之前----");
    list.printAllElement();
    Node<Integer> head = list.reverseByRecursion(list.head);
    System.out.println("-----翻转之后----");
    while (head != null) {
      System.out.printf("%s ", head.element);
      head = head.next;
    }
  }
  
}