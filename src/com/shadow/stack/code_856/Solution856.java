package com.shadow.stack.code_856;

import java.util.Stack;

/**
 * 给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
 * <p>
 * () 得 1 分。
 * AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
 * (A) 得 2 * A 分，其中 A 是平衡括号字符串。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入： "()"
 * 输出： 1
 * 示例 2：
 * <p>
 * 输入： "(())"
 * 输出： 2
 * 示例 3：
 * <p>
 * 输入： "()()"
 * 输出： 2
 * 示例 4：
 * <p>
 * 输入： "(()(()))"
 * 输出： 6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/score-of-parentheses
 *
 * @author Shadow
 * @createDate 2020/4/20
 * @since 1.0.0
 */
public class Solution856 {
  public int scoreOfParentheses(String S) {
    Stack<Integer> stack = new Stack<>();
    stack.push(0);
    for (char c : S.toCharArray()) {
      if (c == '(') {
        stack.push(0);
      } else {
        Integer v = stack.pop();
        Integer w = stack.pop();
        stack.push(w + Math.max(v * 2, 1));
      }
    }
    return stack.pop();
  }
  
  public static void main(String[] args) {
    System.out.println(new Solution856().scoreOfParentheses("(()(()))"));
  }
}
