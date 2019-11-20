package designpattern.iterator;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2019/11/20 23:28
 * Blog: coderdaily.net
 */
public class Main {
    public static void main(String[] args) {
        NameRepository repository = new NameRepository();
        Iterator iterator = repository.getIterator();
        while (iterator.hasNext()) {
            String value = (String) iterator.next();
            System.out.println(value);
        }
    }
}