import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopService {
    ProductRepo productRepo;
    OrderRepo orderRepo;


    public Map<Integer, Product> listProducts(){
        return productRepo.list();
    }

    public ShopService(ProductRepo productRepo, OrderRepo orderRepo) {
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
    }

    public Product getProduct(int i) {
        return productRepo.get(i);
    }

    public void addOrder(Order order) {
        orderRepo.add(order);

    }

    public Order getOrder(int i) {
        return orderRepo.get(i);
    }

    public Map<Integer, Order> listOrders() {
        return orderRepo.list();
    }
}
