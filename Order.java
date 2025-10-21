import java.util.Map;

public class Order {
    private int id;
    private Product product;
    private int amount;

    public Order(int id, Product product, int amount){
        this.id = id;
        this.product = product;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public int getProductId() {
        return product.getId();
    }

    public String getProductName() {
        return product.getName();
    }

    public int getAmount() {
        return amount;
    }

    public double totalCost() {
        return product.getPrice() * amount;
    }
}
