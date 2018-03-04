package nowcoder.util;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2018/2/25 下午1:31
 * Blog: coderdaily.net
 * <p>
 * 构造链表
 */
public class LinkedList {
    private ListNode head;
    private ListNode tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public void addTail(int value) {
        if (this.head == null) {//链表为空时
            head = new ListNode(value);
            tail = null;
        } else if (this.head == this.tail) {//创建头节点
            tail = new ListNode(value);
            head.next = tail;
        } else {//创建尾节点,都是在头结点后面直接添加，为什么不添加到末尾，因为本链表构造的是单向链表，所以需要遍历到最后才能添加。
            ListNode preNext = head.next;
            ListNode newNode = new ListNode(value);
            preNext = head.next;
            head.next = newNode;
            newNode.next = preNext;
        }
    }

    public ListNode getHead() {
        return head;
    }

    public void printLinkedList() {
        ListNode node = this.head;
        while (node != null) {
            System.out.println("node val:" + node.val);
            node = node.next;
        }
    }
}
