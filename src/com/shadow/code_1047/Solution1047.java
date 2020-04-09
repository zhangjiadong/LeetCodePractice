package com.shadow.code_1047;

import java.util.Stack;

/**
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * <p>
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * <p>
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= S.length <= 20000
 * S 仅由小写英文字母组成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string
 *
 * @author Shadow
 * @createDate 2020/4/9
 * @since 1.0.0
 */
public class Solution1047 {
  private Stack<Character> result = new Stack<>();
  
  public String removeDuplicates(String S) {
    for (int i = 0; i < S.length(); i++) {
      final char ch = S.charAt(i);
      if (!result.isEmpty()) {
        if (result.peek().equals(ch)) {
          result.pop();
          return removeDuplicates(S.substring(i + 1));
        } else {
          result.push(ch);
        }
        
      } else {
        result.push(ch);
      }
    }
    StringBuilder resultStr = new StringBuilder();
    for (final char ch : result) {
      resultStr.append(ch);
    }
    return resultStr.toString();
  }
  
  public static void main(String[] args) {
    System.out.println(new Solution1047().removeDuplicates("abbaca"));
  }
}
