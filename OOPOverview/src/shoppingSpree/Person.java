package shoppingSpree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person {
    private String name;
    private int money;
    private List<Product> bag;

    public Person(String name, int money) {
        this.name = name;
        this.money = money;
        this.bag = new ArrayList<>();
    }

    public int getMoney() {
        return this.money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void addProduct(Product product) {
        this.bag.add(product);
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(this.bag);
    }
}
