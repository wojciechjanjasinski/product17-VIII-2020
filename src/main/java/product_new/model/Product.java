package product_new.model;

public class Product {
    private String name;
    private double price;
    private Section section;

    public Product() {
    }

    public Product(String name, double price, Section section) {
        this.name = name;
        this.price = price;
        this.section = section;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Section getSection() {
        return section;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", section=" + section +
                '}';
    }
}
