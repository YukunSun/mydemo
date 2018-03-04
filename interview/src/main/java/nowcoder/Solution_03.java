package nowcoder;

import nowcoder.util.LinkedList;
import nowcoder.util.ListNode;

import java.util.ArrayList;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2018/2/22 下午3:16
 * Blog: coderdaily.net
 * <p>
 * 输入一个链表，从尾到头打印链表每个节点的值。
 */
public class Solution_03 {
    ArrayList<Integer> result = new ArrayList<Integer>();

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode != null) {
            this.printListFromTailToHead(listNode.next);
            result.add(listNode.val);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution_03 s = new Solution_03();
        LinkedList linkedList = new LinkedList();
        linkedList.addTail(1);
        linkedList.addTail(2);
        linkedList.addTail(3);
        linkedList.addTail(4);
        linkedList.addTail(5);
        linkedList.printLinkedList();

        ArrayList<Integer> result = s.printListFromTailToHead(linkedList.getHead());
        System.out.println(result);
    }
}
