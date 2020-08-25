package com.shadow.base.sort;

/**
 * 插入排序
 */
public class InsertionSort {
  
  /**
   * 时间复杂度 O(n2)
   */
  public void sort(int[] values) {
    if (values.length <= 1) {
      return;
    }
    for (int i = 1; i < values.length; i++) {
      int val = values[i];
      int j = i - 1;
      for (; j >= 0; --j) {
        if (values[j] > val) {
          values[j + 1] = values[j];
        } else {
          break;
        }
      }
      values[j + 1] = val;
    }
  }
  
  public static void main(String[] args) {
    int[] data = new int[]{4, 5, 6, 1, 3, 2};
    new InsertionSort().sort(data);
    for (int val : data) {
      System.out.println(val);
    }
  }
}