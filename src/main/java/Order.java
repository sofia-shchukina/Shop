import java.util.List;
import java.util.Map;

public class Order {

    int id;
    Map<Integer, Product> products;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", products=" + products +
                '}';
    }

    public Order(Integer i, Map<Integer, Product> productsToOrder) {
        id = i;
        products = productsToOrder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<Integer, Product> getProducts() {
        return products;
    }

    public void setProducts(Map<Integer, Product> products) {
        this.products = products;
    }
}
