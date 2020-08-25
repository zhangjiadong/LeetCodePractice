package com.shadow.base.sort;

/**
 * 冒泡排序算法
 */
public class BubbleSort {
  
  /**
   * 从小到大排序
   * <p>
   * 时间复杂度：O(n2)
   * </p>
   *
   * @param values 排序数组
   */
  public void sort(int[] values) {
    if (values.length <= 1) {
      return;
    }
    for (int i = 0; i < values.length; i++) {
      boolean finishFlag = true;
      for (int j = 0; j < values.length - i - 1; j++) {
        if (values[j] > values[j + 1]) {
          int tmp = values[j];
          values[j] = values[j + 1];
          values[j + 1] = tmp;
          finishFlag = false;
        }
      }
      if (finishFlag) {
        break;
      }
    }
  }
  
  public static void main(String[] args) {
    int[] sortData = new int[]{3, 2, 1, 4, 5, 6};
    new BubbleSort().sort(sortData);
    for (int sortDatum : sortData) {
      System.out.println(sortDatum);
    }
  }
}