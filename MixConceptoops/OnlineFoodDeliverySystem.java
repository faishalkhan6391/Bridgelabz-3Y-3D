package MixConceptoops;

    


interface Discountable {
    void applyDiscount(double discountRate); 
    String getDiscountDetails();
}

abstract class FoodItem {
    private final String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public abstract double calculateTotalPrice();

    public void getItemDetails() {
        if (this instanceof FoodItem) {
            System.out.println("Item Name: " + itemName);
            System.out.println("Price per unit: $" + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Total Price: $" + calculateTotalPrice());
        } else {
            System.out.println("Invalid food item.");
        }
    }
}

class VegItem extends FoodItem implements Discountable {
    private double discountRate = 0;

    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity() * (1 - discountRate / 100);
    }

    @Override
    public void applyDiscount(double discountRate) {
        if (discountRate >= 0 && discountRate <= 100) {
            this.discountRate = discountRate;
        } else {
            System.out.println("Invalid discount rate.");
        }
    }

    @Override
    public String getDiscountDetails() {
        return "Veg Item Discount Applied: " + discountRate + "%";
    }
}

class NonVegItem extends FoodItem implements Discountable {
    private double discountRate = 0;
    private double additionalCharge = 5; // extra charge per item for non-veg

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() + additionalCharge) * getQuantity() * (1 - discountRate / 100);
    }

    @Override
    public void applyDiscount(double discountRate) {
        if (discountRate >= 0 && discountRate <= 100) {
            this.discountRate = discountRate;
        } else {
            System.out.println("Invalid discount rate.");
        }
    }

    @Override
    public String getDiscountDetails() {
        return "Non-Veg Item Discount Applied: " + discountRate + "% (includes $5 additional charge per item)";
    }
}

public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        FoodItem item1 = new VegItem("Paneer Butter Masala", 10, 2);
        FoodItem item2 = new NonVegItem("Chicken Biryani", 15, 3);

        Discountable[] discounts = {(Discountable)item1, (Discountable)item2};
        discounts[0].applyDiscount(10);
        discounts[1].applyDiscount(5);

        FoodItem[] order = {item1, item2};
        for (FoodItem item : order) {
            item.getItemDetails();
            if (item instanceof Discountable) {
                System.out.println(((Discountable) item).getDiscountDetails());
            }
            System.out.println();
        }
    }
}

