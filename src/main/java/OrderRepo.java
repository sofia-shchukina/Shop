import java.util.ArrayList;
import java.util.List;

public class OrderRepo {
    List<Order> orders = new ArrayList<>();

    public void add(Order order) {
        orders.add(order);
    }

    public Order get(int i) {
        return orders.get(i);
    }

    public List list() {
        return orders;
    }
}
