package ru.panyukovnn.javabasementoring.mapexample;

public class Product {

    private String description;

    public Product(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
            "description='" + description + '\'' +
            '}';
    }
}
