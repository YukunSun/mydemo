package net.coderdaily.collection;

import org.junit.Test;

import java.util.*;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2019/11/24 12:45
 * Blog: coderdaily.net
 */
public class QueueTest {
    @Test
    public void queue() {
        //向上转型，使用 LinkedList 实现队列
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.poll();
        System.out.println("queue = " + queue);//queue = [2, 3]
    }


    @Test
    public void priorityQueueTest() {
        String str = "hello world i am a crud boy";
        PriorityQueue<String> defaultOrder = new PriorityQueue<String>(Arrays.asList(str.split(" ")));
        System.out.println("defaultOrder = " + defaultOrder);//defaultOrder = [a, am, boy, hello, world, crud, i]

        PriorityQueue<String> order2 = new PriorityQueue<String>(Arrays.asList(str.split(" ")).size(), Comparator.reverseOrder());
        order2.addAll(Arrays.asList(str.split(" ")));
        System.out.println("order2 = " + order2);//order2 = [world, hello, i, am, a, crud, boy]
    }
}
