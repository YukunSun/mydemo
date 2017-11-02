package 类;

/**
 * Author: sun.yukun@foxmail.com
 * Time: 2017/10/19 下午11:14
 * Blog: coderdaily.net
 */
public class Sequence {
    private Object items[];
    private int next = 0;

    public Sequence(int size) {
        items = new Object[size];
    }

    public void add(Object obj) {
        if (next < items.length) {
            items[next++] = obj;
        }
    }

    //    内部类
    private class SequenceSelector implements Selector {
        private int i = 0;

        public boolean end() {
            return i == items.length;
        }

        public Object current() {
            return items[i];
        }

        public void next() {
            if (i < items.length) {
                i++;
            }
        }
    }

    interface Selector {
        boolean end();

        Object current();

        void next();
    }

    public Selector selector() {
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        Sequence seq = new Sequence(10);
        for (int i = 0; i < 10; i++) {
            seq.add(i);
        }
        Selector selector = seq.selector();
        while (!selector.end()) {
            System.out.println(selector.current());
            selector.next();
        }
    }
}
