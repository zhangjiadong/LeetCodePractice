package com.shadow.stack.code_1249;

import java.util.Stack;

/**
 * 1249. 移除无效的括号
 * 给你一个由 '('、')' 和小写字母组成的字符串 s。
 * <p>
 * 你需要从字符串中删除最少数目的 '(' 或者 ')' （可以删除任意位置的括号)，使得剩下的「括号字符串」有效。
 * <p>
 * 请返回任意一个合法字符串。
 * <p>
 * 有效「括号字符串」应当符合以下 任意一条 要求：
 * <p>
 * 空字符串或只包含小写字母的字符串
 * 可以被写作 AB（A 连接 B）的字符串，其中 A 和 B 都是有效「括号字符串」
 * 可以被写作 (A) 的字符串，其中 A 是一个有效的「括号字符串」
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "lee(t(c)o)de)"
 * 输出："lee(t(c)o)de"
 * 解释："lee(t(co)de)" , "lee(t(c)ode)" 也是一个可行答案。
 * 示例 2：
 * <p>
 * 输入：s = "a)b(c)d"
 * 输出："ab(c)d"
 * 示例 3：
 * <p>
 * 输入：s = "))(("
 * 输出：""
 * 解释：空字符串也是有效的
 */
public class Solution1249 {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> bracketIndex = new Stack<>();
        boolean[] invalidIndex = new boolean[s.length()];
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                bracketIndex.push(i);
                invalidIndex[i] = true;
            }
            if (s.charAt(i) == ')') {
                if (bracketIndex.isEmpty()) {
                    invalidIndex[i] = true;
                } else {
                    invalidIndex[bracketIndex.pop()] = false;
                }
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (!invalidIndex[i]) {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }

    private Stack<Integer> valid(String s) {
        Stack<Character> needRemoveChar = new Stack<>();
        Stack<Integer> needRemoveIndex = new Stack<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (!needRemoveChar.isEmpty() && ch == '(' && needRemoveChar.peek() == ')') {
                needRemoveChar.pop();
                needRemoveIndex.pop();
                continue;
            }
            if (ch == '(' || ch == ')') {
                needRemoveChar.push(ch);
                needRemoveIndex.push(i);
            }
        }
        return needRemoveIndex;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1249().minRemoveToMakeValid("())()((("));
    }
}
