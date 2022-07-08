import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderRepo {
    Map<Integer, Order> orders = new HashMap<>();

    public void add(Order order) {
        orders.put(order.getId(), order);
    }

    public Order get(int i) {
        return orders.get(i);
    }

    public Map<Integer, Order> list() {
        return orders;
    }
}
