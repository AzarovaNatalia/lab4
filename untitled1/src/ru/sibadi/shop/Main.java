package ru.sibadi.shop;

import ru.sibadi.shop.model.Customer;
import ru.sibadi.shop.model.Product;
import ru.sibadi.shop.model.Sale;
import ru.sibadi.shop.model.Shop;

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop();

        for (Product product : shop.getProducts()) {
            System.out.println(product);
        }

        Customer vladimir = new Customer("Vladimir", 150);
        Customer daria = new Customer("Daria", 300);
        System.out.println(vladimir);
        System.out.println(daria);


        buy(vladimir, shop.getProducts().get(0), shop);
        buy(daria, shop.getProducts().get(2), shop);
        buy(daria, shop.getProducts().get(1), shop);
        buy(daria, shop.getProducts().get(1), shop);
        buy(daria, shop.getProducts().get(1), shop);
        shop.setSale(Sale.BLACK_FRIDAY);
        buy(daria, shop.getProducts().get(1), shop);
        shop.setSale(Sale.WITHOUT);
        buy(daria, shop.getProducts().get(1), shop);
        buy(vladimir, shop.getProducts().get(1), shop);

        shop.watchPurchases();
    }

    private static void buy(Customer c, Product p, Shop shop) {
        System.out.println(shop.createBuy(c, p) + ". Remainder " + c.getMoney());
    }
}