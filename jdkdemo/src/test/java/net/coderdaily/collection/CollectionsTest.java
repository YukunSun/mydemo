package net.coderdaily.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2019/12/11 22:44
 * Blog: coderdaily.net
 */
public class CollectionsTest {
    /**
     * Collections's APIs:fill,nCopies etc.
     */
    @Test
    public void collection_01() {
        List<StringAddress> list = new ArrayList<>(Collections.nCopies(4, new StringAddress("hello")));
        System.out.println("list = " + list);//same address:net.coderdaily.collection.StringAddress@3a5ed7a

        Collections.fill(list, new StringAddress("world"));
        System.out.println("list = " + list);//same address: net.coderdaily.collection.StringAddress@6325a3ee
    }
}

class StringAddress {
    private String s;

    public StringAddress(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return super.toString() + "  " + s;
    }
}