package com.shadow.base.stack;

/**
 * 栈
 *
 * @author Shadow
 * @createDate 2020/4/16
 * @since 1.0.0
 */
public class IStack<E> {
  
  private Object[] elements;
  private int elementsCount = 0;
  
  public IStack() {
    elements = new Object[10];
  }
  
  public IStack(int capacity) {
    elements = new Object[capacity];
  }
  
  /**
   * 弹出栈顶元素
   *
   * @return E
   */
  @SuppressWarnings("unchecked")
  public synchronized E pop() {
    if (isEmpty()) {
      throw new RuntimeException("The stack is empty");
    }
    --elementsCount;
    E top = (E) elements[elementsCount];
    elements[elementsCount] = null;
    return top;
  }
  
  /**
   * 查看栈顶元素
   *
   * @return E
   */
  @SuppressWarnings("unchecked")
  public synchronized E peek() {
    if (isEmpty()) {
      throw new RuntimeException("The stack is empty");
    }
    return (E) elements[elementsCount - 1];
  }
  
  /**
   * 入栈
   *
   * @param e 入栈元素
   * @return E
   */
  public synchronized E push(E e) {
    ensureCapacityHelper(elementsCount + 1);
    elements[elementsCount++] = e;
    return e;
  }
  
  /**
   * 元素数量
   *
   * @return int
   */
  public int size() {
    return elementsCount;
  }
  
  /**
   * 容量助手
   */
  private void ensureCapacityHelper(int minCapacity) {
    if (minCapacity - elements.length > 0) {
      grow(minCapacity);
    }
  }
  
  private void grow(int minCapacity) {
    int maxCapacity = Integer.MAX_VALUE - 8;
    if (minCapacity > maxCapacity) {
      throw new OutOfMemoryError("内存溢出，超过最大容量:" + maxCapacity);
    }
    int newLength = elements.length * 2;
    if (newLength - minCapacity < 0) {
      newLength = minCapacity;
    }
    Object[] newElements = new Object[newLength];
    for (int i = 0; i < elements.length; i++) {
      newElements[i] = elements[i];
    }
    elements = newElements;
  }
  
  /**
   * 是否为空
   *
   * @return Boolean
   */
  public boolean isEmpty() {
    return elementsCount == 0;
  }
  
}
