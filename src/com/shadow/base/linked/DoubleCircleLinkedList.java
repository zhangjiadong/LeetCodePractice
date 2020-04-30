package com.shadow.base.linked;

/**
 * 双向循环链表
 *
 * @author Shadow
 * @createDate 2020-04-30
 */
public class DoubleCircleLinkedList<E> {
  
  /**
   * 节点
   */
  private static class Node<E> {
    private E element;
    private Node<E> prev;
    private Node<E> next;
    
    public Node(Node<E> prev, E element, Node<E> next) {
      this.prev = prev;
      this.element = element;
      this.next = next;
    }
  }
  
  private Node<E> head;
  private int size;
  
  /**
   * 初始化head为空节点
   */
  public DoubleCircleLinkedList() {
    this.head = new Node<>(null, null, null);
    head.next = head.prev = head;
    this.size = 0;
  }
  
  
  /**
   * 添加节点 ,等同于 {@code addFirst}
   * 时间复杂度 O(1)
   * 空间复杂度 O(1)
   *
   * @param element 元素
   * @return
   */
  public E add(E element) {
    set(0, element);
    return element;
  }
  
  /**
   * 添加至头结点
   *
   * @param element 元素
   * @return
   */
  public E addFirst(E element) {
    set(0, element);
    return element;
  }
  
  /**
   * 添加尾结点
   * <p>
   * 时间复杂度 O(1)
   * 空间复杂度 O(1)
   *
   * @param element 元素
   * @return E
   */
  public E addLast(E element) {
    set(size, element);
    return element;
  }
  
  public boolean isEmpty() {
    return size == 0;
  }
  
  public int getSize() {
    return size;
  }
  
  /**
   * 移除元素
   * 时间复杂度是 O(1)
   * 空间复杂度 O(1)
   *
   * @param element 元素
   * @return {@code true} 成功
   */
  public boolean remove(E element) {
    if (isEmpty()) {
      return false;
    }
    Node<E> target = null;
    Node<E> node = head.next;
    if (node.element.equals(element)) {
      target = node;
    } else {
      for (int i = 0; i < size; i++) {
        node = node.next;
        if (node.element.equals(element)) {
          target = node;
          break;
        }
      }
    }
    if (target == null) {
      return false;
    }
    if (target.prev == head) {
      //移除头结点
      target.next.prev = head;
      head.next = target.next;
    } else if (target.next == head) {
      //移除尾结点
      target.prev.next = head;
      head.prev = target.prev;
    } else {
      //中间节点删除
      target.prev.next = target.next;
      target.next.prev = target.prev;
    }
    //help gc
    target.prev = null;
    target.next = null;
    target.element = null;
    size--;
    return true;
  }
  
  private void set(int index, E element) {
    if (index == 0) {
      //头结点插入
      Node<E> node = new Node<>(head, element, head.next);
      head.next.prev = node;
      head.next = node;
    } else if (index >= size) {
      //尾结点插入
      Node<E> node = new Node<>(head.prev, element, head);
      head.prev.next = node;
      head.prev = node;
    } else {
      Node<E> cur = index(index);
      Node<E> node = new Node<E>(cur.prev, element, cur);
      cur.prev.next = node;
      cur.prev = node;
    }
    size++;
  }
  
  /**
   * 根据索引查询
   * <p>
   * 时间复杂度 O(1)
   * 空间复杂度 O(1)
   *
   * @param index 索引
   * @return E
   */
  public E get(int index) {
    return index(index).element;
  }
  
  private Node<E> index(int index) {
    validateIndex(index);
    if (index < (size << 1)) {
      //从head顺序查找
      Node<E> next = head.next;
      for (int i = 0; i < index; i++) {
        next = next.next;
      }
      return next;
    } else {
      //从尾结点开始查找
      Node<E> last = head.prev;
      index = size - index - 1;
      for (int i = 0; i < index; i++) {
        last = last.prev;
      }
      return last;
    }
  }
  
  private void validateIndex(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("The index is out of bounds!");
    }
  }
  
  public void printAllNode() {
    if (isEmpty()) {
      System.out.println("空链表！");
    } else {
      Node<E> node = head;
      for (int i = 0; i < size; i++) {
        Node<E> cur = node.next;
        System.out.println(cur.element);
        node = node.next;
      }
    }
  }
  
  public static void main(String[] args) {
    DoubleCircleLinkedList<Integer> list = new DoubleCircleLinkedList<>();
    list.addLast(1);
    list.addLast(2);
    list.addLast(3);
    list.remove(1);
    System.out.println("---" + list.get(0));
    list.printAllNode();
    System.out.println(list.getSize());
  }
}