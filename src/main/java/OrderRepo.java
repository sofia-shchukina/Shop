import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderRepo {
    Map<Integer, Order> orders = new HashMap<>();

    public void add(Order order) {
        orders.put(order.getId(), order);
    }

    public Order get(int i) throws NotAnOrderException {

        if (orders.containsKey(i)) {
            return orders.get(i);
        }
        else {
            throw new NotAnOrderException("There is no order with this index");
        }
    }

    public Map<Integer, Order> list() {
        return orders;
    }
}
