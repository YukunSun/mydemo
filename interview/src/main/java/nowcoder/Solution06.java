package nowcoder;

import nowcoder.util.ListNode;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2019-06-21 10:52
 * Blog: coderdaily.net
 * <p>
 * 翻转链表：https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca?tpId=13&tqId=11168&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class Solution06 {
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) { //如果没有结点或者只有一个结点直接返回pHead
            return head;
        }
        ListNode pNext = head.next; //保存当前结点的下一结点
        head.next = null; //打断当前结点的指针域
        ListNode reverseHead = ReverseList(pNext); //递归结束时 reverseHead 一定是新链表的头结点
        pNext.next = head; //修改指针域
        return reverseHead;
    }
}