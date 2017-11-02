package collection;

import java.util.Arrays;

/**
 * Author: sun.yukun@foxmail.com
 * Time: 2017/10/9 下午8:51
 * Blog: coderdaily.net
 * <p>
 * 使用数组模拟Map.
 * <p>
 * 缺点：缺乏效率，尺寸固定。
 */
public class AssociativeArray<K, V> {
    private Object[][] pairs;
    private int index;

    public AssociativeArray(int length) {
        pairs = new Object[length][2];//深度为2的二维数组,使用Object[i][0]表示key,Object[i][1]表示value。
    }

    public void put(K key, V value) {
        if (index >= pairs.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        pairs[index++] = new Object[]{key, value};
    }

    public V get(K key) {
        for (int i = 0; i < index; i++) {
            if (key.equals(pairs[i][0])) {
                return (V) pairs[i][0];
            }
        }
//        如果找不到，返回null
        return null;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < index; i++) {
            builder.append(pairs[i][0].toString());
            builder.append(":");
            builder.append(pairs[i][1].toString());
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        AssociativeArray<String, String> map = new AssociativeArray<String, String>(3);
        map.put("k1", "v1");
        map.put("k2", "v2");
        map.put("k3", "v3");
        System.out.println(map);
        System.out.println(map.get("k1"));
        System.out.println(map.get("k5"));
        try {
            map.put("k4", "v4");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
