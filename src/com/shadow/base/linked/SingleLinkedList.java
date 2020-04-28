package com.shadow.base.linked;

/**
 * 双向链表
 *
 * @author Shadow
 * @createDate 2020/4/20
 * @since 1.0.0
 */
public class SingleLinkedList<E> {
  
  transient Node<E> first;
  transient Node<E> last;
  transient int size;
  
  private static class Node<E> {
    E item;
    Node<E> prev;
    Node<E> next;
    
    public Node(Node<E> prev, E item, Node<E> next) {
      this.prev = prev;
      this.item = item;
      this.next = next;
    }
  }
  
  /**
   * 获取链表第一个元素
   *
   * @return E
   */
  public E getFirst() {
    return first != null ? first.item : null;
  }
  
  /**
   * 获取链表最后一个元素
   *
   * @return E
   */
  public E getLast() {
    return last != null ? last.item : null;
  }
  
  /**
   * 添加一个元素
   * 放到最后一个
   *
   * @param e 元素
   * @return E
   */
  public E add(E e) {
    linkLast(e);
    return e;
  }
  
  /**
   * 添加一个元素
   * 放到头部
   *
   * @param e 元素
   * @return E
   */
  public E addFirst(E e) {
    linkFirst(e);
    return e;
  }
  
  /**
   * 链接至最后一个元素
   *
   * @param e 元素
   */
  void linkLast(E e) {
    final Node<E> l = last;
    Node<E> newNode = new Node<E>(l, e, null);
    last = newNode;
    if (l == null) {
      first = newNode;
    } else {
      l.next = newNode;
    }
    size++;
  }
  
  /**
   * 添加至头部
   *
   * @param e 元素
   */
  void linkFirst(E e) {
    final Node<E> f = first;
    Node<E> newNode = new Node<E>(null, e, f);
    first = newNode;
    if (f == null) {
      last = newNode;
    } else {
      f.prev = newNode;
    }
    size++;
  }
  
  /**
   * 移除元素
   *
   * @param x 要移除的元素
   */
  E unlink(Node<E> x) {
    final E element = x.item;
    final Node<E> prev = x.prev;
    final Node<E> next = x.next;
    if (prev == null) {
      first = next;
    } else {
      prev.next = next;
      x.prev = null;
    }
    if (next == null) {
      last = prev;
    } else {
      next.prev = prev;
      x.next = null;
    }
    x.item = null;
    size--;
    return element;
  }
  
  /**
   * 移除第一个出现元素的位置
   *
   * @param e 要移除的元素
   * @return {@code true} 如果移除成功
   */
  public boolean remove(E e) {
    if (e == null) {
      for (Node<E> x = first; x != null; x = x.next) {
        if (x.item == null) {
          unlink(x);
          return true;
        }
      }
    } else {
      for (Node<E> x = first; x != null; x = x.next) {
        if (x.item.equals(e)) {
          unlink(x);
          return true;
        }
      }
    }
    return false;
  }
  
  /**
   * 清空链表
   */
  public void clear() {
    for (Node<E> x = first; x != null; ) {
      Node<E> next = x.next;
      x.item = null;
      x.next = null;
      x.prev = null;
      x = next;
    }
    first = last = null;
    size = 0;
  }
  
  /**
   * 根据索引查找
   *
   * @param index 索引
   * @return list中的元素
   * @throws IndexOutOfBoundsException 如果索引越界
   */
  public E get(int index) {
    checkElementIndex(index);
    return node(index).item;
  }
  
  public int size() {
    return size;
  }
  
  public E set(int index, E element) {
    checkElementIndex(index);
    final Node<E> e = node(index);
    return e.item;
  }
  
  private void checkElementIndex(int index) {
    if (!isElementIndex(index)) {
      throw new IndexOutOfBoundsException("索引越界！！");
    }
  }
  
  /**
   * 是否是元素的索引
   */
  private boolean isElementIndex(int index) {
    return index >= 0 && index < size;
  }
  
  /**
   * 是否是位置索引
   */
  private boolean isPositionIndex(int index) {
    return index >= 0 && index <= size;
  }
  
  Node<E> node(int index) {
    if (index < (size >> 1)) {
      Node<E> x = first;
      for (int i = 0; i < index; i++) {
        x = x.next;
      }
      return x;
    } else {
      Node<E> x = last;
      for (int i = size - 1; i > index; i--) {
        x = x.prev;
      }
      return x;
    }
  }
}
