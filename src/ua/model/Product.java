package ua.model;

import ua.util.Utils;
import java.time.LocalDate;
import java.util.Objects;

public class Product {
    private String name;
    private double price;
    private int stock;
    private LocalDate createdDate;

    public Product(String name, double price, int stock, LocalDate createdDate) {
        setName(name);
        setPrice(price);
        setStock(stock);
        setCreatedDate(createdDate);
    }

    public static Product create(String name, double price, int stock, LocalDate createdDate) {
        return new Product(name, price, stock, createdDate);
    }

    public String getName() { return name; }
    public void setName(String name) {
        if (!Utils.isValidString(name)) {
            throw new IllegalArgumentException("Invalid product name");
        }
        this.name = name;
    }

    public double getPrice() { return price; }
    public void setPrice(double price) {
        if (price < 0) {  // тут можна залишити просту перевірку
            throw new IllegalArgumentException("Invalid price");
        }
        this.price = price;
    }

    public int getStock() { return stock; }
    public void setStock(int stock) {
        if (stock < 0) {
            throw new IllegalArgumentException("Invalid stock");
        }
        this.stock = stock;
    }

    public LocalDate getCreatedDate() { return createdDate; }
    public void setCreatedDate(LocalDate createdDate) {
        if (!Utils.isValidDate(createdDate)) {
            throw new IllegalArgumentException("Invalid created date");
        }
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', price=" + price + ", stock=" + stock + ", createdDate=" + createdDate + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 &&
                stock == product.stock &&
                Objects.equals(name, product.name) &&
                Objects.equals(createdDate, product.createdDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, stock, createdDate);
    }
}
