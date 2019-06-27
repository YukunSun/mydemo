package nowcoder;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2019-06-21 10:52
 * Blog: coderdaily.net
 * <p>
 * 翻转链表：https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca?tpId=13&tqId=11168&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class Solution06 {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    /**
     * 需要三个指针
     *
     * @param head
     * @return
     */
    public static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        //单链表的前驱节点
        Node pre = null;
        //单链表的后续节点
        Node next = null;
        while (head != null) {
            //next 后移
            next = head.next;
            //pre 后移（指向head）
            head.next = pre;
            pre = head;
            //head 后移（指向next）
            head = next;
        }
        return pre;
    }

    /**
     * 打印，不多说，就是为了方便调试，只需传一个头结点就行。
     *
     * @param head
     */
    public static void print(Node head) {
        if (head == null || head.next == null) {
            System.out.println(head);
            return;
        }
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        //0. 存在一个如下的链表
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        System.out.println("before:");
        print(n1);

        System.out.println("reverse:");
        Node result = reverse(n1);
        print(result);
    }
}