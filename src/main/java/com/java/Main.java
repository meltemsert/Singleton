package com.java;

class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }

        return instance;
    }
}

class Product {
    private String instance1;
    private String instance2;

    private Product() {
    }

    public String getInstance1() {
        return instance1;
    }

    public String getInstance2() {
        return instance2;
    }

    public static class Builder {
        private Product product = new Product();

        public Builder withInstance1(String instance1) {
            product.instance1 = instance1;
            return this;
        }
        public Builder withInstance2(String instance2) {
            product.instance2 = instance2;
            return this;
        }
        public Product build() {
            return product;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Singleton singleton1=Singleton.getInstance();
        Singleton singleton2=Singleton.getInstance();

        System.out.println("Singleton: " + (singleton1==singleton2));

        Product product= new Product.Builder()
                .withInstance1("İnstance 1")
                .withInstance2("İnstance 2")
                .build();

        System.out.println("Product instance 1:" + product.getInstance1());
        System.out.println("Product instance 2:" + product.getInstance2());
    }
}