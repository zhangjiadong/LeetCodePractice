package com.shadow.base.sort;

/**
 * 选择排序
 * 分已排序区间和未排序区间。但是选择排序每次会从未排序区间中找到最小的元素，将其放到已排序区间的末尾。
 */
public class SelectionSort {
  
  /**
   * <p>
   * 时间复杂度 O(n2)
   * </p>
   */
  public void sort(int[] values) {
    if (values.length <= 1) {
      return;
    }
    for (int i = 0; i < values.length; i++) {
      //寻找最小值index
      int minIndex = i;
      for (int j = i + 1; j < values.length; j++) {
        if (values[minIndex] > values[j]) {
          minIndex = j;
        }
      }
      //如果需要排序，则交换
      if (minIndex != i) {
        int tmp = values[i];
        values[i] = values[minIndex];
        values[minIndex] = tmp;
      }
    }
  }
  
  public static void main(String[] args) {
    int[] values = new int[]{4, 5, 6, 3, 2, 1};
    new SelectionSort().sort(values);
    for (int val : values) {
      System.out.println(val);
    }
  }
}