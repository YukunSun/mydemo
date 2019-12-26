package net.coderdaily.generics;

import net.coderdaily.util.Generator;
import net.coderdaily.util.Generators;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2019/12/26 22:34
 * Blog: coderdaily.net
 * <p>
 * 使用泛型构造复杂模型
 */
public class ExampleTest5 {
    @Test
    public void test1() {
        System.out.println(new Store(2, 3, 5));
    }
}

class Product {
    private final int id;
    private String description;
    private double price;

    public Product(int id, String description, double price) {
        this.id = id;
        this.description = description;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=￥" + price +
                '}';
    }

    public static Generator<Product> generator = new Generator<Product>() {
        Random random = new Random(47);

        @Override
        public Product next() {
            return new Product(random.nextInt(1000), "test description", Math.round(random.nextDouble() * 1000.0) + 0.99);
        }
    };
}

class Shelf extends ArrayList<Product> {
    public Shelf(int nProducts) {
        Generators.fill(this, Product.generator, nProducts);
    }
}

class Aisle extends ArrayList<Shelf> {
    public Aisle(int nShelves, int nProducts) {
        for (int i = 0; i < nShelves; i++) {
            add(new Shelf(nProducts));
        }
    }
}

class CheckoutStand {
}

class Office {
}

class Store extends ArrayList<Aisle> {
    private ArrayList<CheckoutStand> checkoutStands = new ArrayList<>();
    private Office office = new Office();

    public Store(int nAisles, int nShelves, int nProducts) {
        for (int i = 0; i < nAisles; i++) {
            add(new Aisle(nShelves, nProducts));
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Aisle aisle : this) {
            for (Shelf shelf : aisle) {
                for (Product product : shelf) {
                    builder.append(product).append("\n");
                }
            }
        }
        return builder.toString();
    }
}