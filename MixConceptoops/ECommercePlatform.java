package MixConceptoops;


interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

abstract class Product {
    private final int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract double calculateDiscount();

    public void displayProductDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Price: $" + price);
        System.out.println("Discounted Price: $" + calculateDiscount());
    }
}

class Electronics extends Product implements Taxable {
    private double taxRate; // in percentage
    private double discountRate; // in percentage

    public Electronics(int productId, String name, double price, double taxRate, double discountRate) {
        super(productId, name, price);
        this.taxRate = taxRate;
        this.discountRate = discountRate;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() - (getPrice() * discountRate / 100);
    }

    @Override
    public double calculateTax() {
        return getPrice() * taxRate / 100;
    }

    @Override
    public String getTaxDetails() {
        return "Electronics Tax: $" + calculateTax();
    }

    @Override
    public void displayProductDetails() {
        super.displayProductDetails();
        System.out.println(getTaxDetails());
    }
}

class Clothing extends Product implements Taxable {
    private double taxRate;
    private double discountRate;

    public Clothing(int productId, String name, double price, double taxRate, double discountRate) {
        super(productId, name, price);
        this.taxRate = taxRate;
        this.discountRate = discountRate;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() - (getPrice() * discountRate / 100);
    }

    @Override
    public double calculateTax() {
        return getPrice() * taxRate / 100;
    }

    @Override
    public String getTaxDetails() {
        return "Clothing Tax: $" + calculateTax();
    }

    @Override
    public void displayProductDetails() {
        super.displayProductDetails();
        System.out.println(getTaxDetails());
    }
}

class Groceries extends Product {
    private double discountRate;

    public Groceries(int productId, String name, double price, double discountRate) {
        super(productId, name, price);
        this.discountRate = discountRate;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() - (getPrice() * discountRate / 100);
    }
}

public class ECommercePlatform {
    public static void main(String[] args) {
        Electronics e1 = new Electronics(101, "Laptop", 1200, 18, 10);
        Clothing c1 = new Clothing(102, "T-Shirt", 50, 5, 20);
        Groceries g1 = new Groceries(103, "Rice", 30, 5);

        Product[] products = {e1, c1, g1};

        for (Product p : products) {
            p.displayProductDetails();
            System.out.println();
        }
    }
}
