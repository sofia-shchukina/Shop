import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {


        Product one = new Product(0, "Table");
        Product two = new Product(1, "Chair");
        Product three = new Product(2, "Sofa");
        List<Product> productList = new ArrayList<>(List.of(one, two, three));
        ProductRepo productRepo = new ProductRepo(productList);
        OrderRepo orderRepo = new OrderRepo();
        ShopService shopService = new ShopService(productRepo, orderRepo);
        System.out.println(shopService.listProducts ());
        try{
        System.out.println(shopService.getProduct(5));
        }catch (Exception e){
            System.out.println("Sorry, this product does not exist.");
        }
        List<Product> productsToOrder = new ArrayList<>(List.of(one, two));
        Order order = new Order(0, productsToOrder);
        shopService.addOrder(order);
        try {
            System.out.println(shopService.getOrder(2));
        } catch (Exception e){
            System.out.println("Sorry, there is no order with this index.");
        }
        System.out.println(shopService.listOrders());
        List<Product> productsToOrder2 = new ArrayList<>(List.of(two, three));
        Order order2 = new Order(1, productsToOrder2);
        shopService.addOrder(order2);
        System.out.println(shopService.listOrders());
    }
}
