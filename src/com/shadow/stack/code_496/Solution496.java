package com.shadow.stack.code_496;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
 * <p>
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * 解释:
 * 对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
 * 对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
 * 对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-greater-element-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Map<Integer, Integer> num2Map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int value : nums2) {
            while (!stack.isEmpty() && stack.peek() < value) {
                num2Map.put(stack.pop(), value);
            }
            stack.push(value);
        }
        while (!stack.isEmpty()) {
            num2Map.put(stack.pop(), -1);
        }
        for (int i = 0; i < nums1.length; i++) {
            result[i] = num2Map.get(nums1[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] result = new Solution496().nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2});
        System.out.println(result.toString());
    }
}
