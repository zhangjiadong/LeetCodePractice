package com.shadow.base.sort;

/**
 * 插入排序
 * <p>
 * 区分已排序区间和未排序区间
 * 插入算法的核心思想是取未排序区间中的元素，在已排序区间中找到合适的插入位置将其插入，并保证已排序区间数据一直有序。重复这个过程，直到未排序区间中元素为空，算法结束。
 * </p>
 */
public class InsertionSort {
  
  /**
   * 时间复杂度 O(n2)
   * <p>
   * 左边排序区+右边未排序：[ 0 , j (即 i-1 )][ i , n-1 ] 从尾到头在有序区里查找插入的位置，每次只需要比较一个； 循环的意义：如果前面的a[j]大，
   * 就把a[j]后移一个（后面的位置是比较的元素，已经空出来了，每次只需要覆盖一个），看大小关系决定移动后移多少个。 当a[j]不够大了，说明要插入了，
   * 就break出来，否则就一直往前查找比较。
   * </p>
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