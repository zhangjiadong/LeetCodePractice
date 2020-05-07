package com.shadow.linked.code_21;

/**
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class Solution21 {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode head = new ListNode(-1);
    ListNode prev = head;
    while (l1 != null && l2 != null) {
      if (l1.val <= l2.val) {
        prev.next = l1;
        l1 = l1.next;
      } else {
        prev.next = l2;
        l2 = l2.next;
      }
      prev = prev.next;
    }
    prev.next = l1 == null ? l2 : l1;
    return head.next;
  }
  
  public static class ListNode {
    int val;
    ListNode next;
    
    ListNode(int x) {
      val = x;
    }
  }
  
  public static void main(String[] args) {
    ListNode l1 = new ListNode(1);
    l1.next = new ListNode(3);
    l1.next.next = new ListNode(5);
    ListNode l2 = new ListNode(2);
    l2.next = new ListNode(4);
    l2.next.next = new ListNode(6);
    ListNode result = new Solution21().mergeTwoLists(l1, l2);
    while (result != null) {
      System.out.printf("%s ", result.val);
      result = result.next;
    }
  }
}