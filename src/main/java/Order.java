import java.util.List;

public class Order {

    int id;
    List<Product> products;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", products=" + products +
                '}';
    }

    public Order(Integer i, List productsToOrder) {
        id = i;
        products = productsToOrder;
    }


}
