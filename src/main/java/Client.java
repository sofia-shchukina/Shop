import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Client {
    public static void main(String[] args) {


        Product one = new Product(0, "Table");
        Product two = new Product(1, "Chair");
        Product three = new Product(2, "Sofa");
        Map<Integer, Product> productList = new HashMap<>();
        productList.put(one.getId(), one);
        productList.put(two.getId(), two);
        productList.put(three.getId(), three);
        ProductRepo productRepo = new ProductRepo(productList);
        OrderRepo orderRepo = new OrderRepo();
        ShopService shopService = new ShopService(productRepo, orderRepo);
        System.out.println(shopService.listProducts ());
        try{
        System.out.println(shopService.getProduct(10));
        }catch (Exception e){
            System.out.println("Sorry, this product does not exist.");
        }

        Map<Integer, Product> productsToOrder = new HashMap<>();
        productsToOrder.put(one.getId(), one);
        productsToOrder.put(two.getId(), two);

        Order order = new Order(0, productsToOrder);
        shopService.addOrder(order);
        try {
            System.out.println(shopService.getOrder(0));
        } catch (Exception e){
            System.out.println("Sorry, there is no order with this index.");
        }
        System.out.println(shopService.listOrders());
        Map<Integer, Product> productsToOrder2 = new HashMap<>();
        productsToOrder2.put(two.getId(), two);
        productsToOrder2.put(three.getId(), three);


        Order order2 = new Order(1, productsToOrder2);
        shopService.addOrder(order2);
        System.out.println(shopService.listOrders());
    }
}
