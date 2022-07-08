import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ShopServiceTest {


    @Test
    void listProducts() {
        Product one = new Product(4, "Spoon");
        Product two = new Product(54, "Knife");
        Product three = new Product(3456, "Fork");
        HashMap<Integer, Product> testHashMap = new HashMap<>();
        testHashMap.put(one.getId(), one);
        testHashMap.put(two.getId(), two);
        testHashMap.put(three.getId(), three);
        ProductRepo testProductRepo = new ProductRepo(testHashMap);
        ShopService testShopservice = new ShopService(testProductRepo);

        Map<Integer, Product> actual = testShopservice.listProducts();
        Assertions.assertEquals(testHashMap, actual);
    }

    @Test
    void emptyListProducts() {
        HashMap<Integer, Product> testHashMap = new HashMap<>();
        ProductRepo testProductRepo = new ProductRepo(testHashMap);
        ShopService testShopservice = new ShopService(testProductRepo);

        Map<Integer, Product> actual = testShopservice.listProducts();
        Assertions.assertEquals(testHashMap, actual);
    }

    @Test
    void getProduct() throws NotAProductException {
        Product one = new Product(4, "Spoon");
        Product two = new Product(54, "Knife");
        Product three = new Product(3456, "Fork");
        HashMap<Integer, Product> testHashMap = new HashMap<>();
        testHashMap.put(one.getId(), one);
        testHashMap.put(two.getId(), two);
        testHashMap.put(three.getId(), three);
        ProductRepo testProductRepo = new ProductRepo(testHashMap);
        ShopService testShopservice = new ShopService(testProductRepo);

        Product actual = testShopservice.getProduct(4);
        Assertions.assertEquals(one, actual);

    }

    @Test
    void getProductIndexDoesNotExist() throws NotAProductException, NotAnOrderException {
        Product one = new Product(4, "Spoon");
        Product two = new Product(54, "Knife");
        Product three = new Product(3456, "Fork");
        HashMap<Integer, Product> testHashMap = new HashMap<>();
        testHashMap.put(one.getId(), one);
        testHashMap.put(two.getId(), two);
        testHashMap.put(three.getId(), three);
        ProductRepo testProductRepo = new ProductRepo(testHashMap);
        ShopService testShopservice = new ShopService(testProductRepo);

        try {
            testShopservice.getProduct(5646);
            Assertions.fail();
        } catch (NotAProductException e) {

        }

    }

    @Test
    void addOrderAndGetOrder() throws NotAnOrderException {
        Product one = new Product(4, "Spoon");
        Product two = new Product(54, "Knife");
        Map <Integer, Product> testHashMap = new HashMap<>();
        testHashMap.put(one.getId(),one);
        testHashMap.put(two.getId(),two);
        Order order = new Order(0,testHashMap);
        OrderRepo testOrderRepo = new OrderRepo();
        ShopService shopService = new ShopService(testOrderRepo);

        shopService.addOrder(order);

        Order actual = shopService.getOrder(0);
        Assertions.assertEquals(order,actual);
    }

    @Test
    void addOrderAndGetOrderFails() throws NotAnOrderException {
        Product one = new Product(4, "Spoon");
        Product two = new Product(54, "Knife");
        Map <Integer, Product> testHashMap = new HashMap<>();
        testHashMap.put(one.getId(),one);
        testHashMap.put(two.getId(),two);
        Order order = new Order(0,testHashMap);
        OrderRepo testOrderRepo = new OrderRepo();
        ShopService shopService = new ShopService(testOrderRepo);

        shopService.addOrder(order);

        try {
            shopService.getOrder(5);
            Assertions.fail();
        } catch (NotAnOrderException e) {

        }

    }

    @Test
    void listOrders() {
        Product one = new Product(4, "Spoon");
        Product two = new Product(54, "Knife");
        Map <Integer, Product> testHashMap = new HashMap<>();
        testHashMap.put(one.getId(),one);
        testHashMap.put(two.getId(),two);
        Order order = new Order(0,testHashMap);
        Map <Integer, Product> testHashMap2 = new HashMap<>();
        testHashMap2.put(one.getId(),one);
        Order order2 = new Order(1,testHashMap2);

        OrderRepo testOrderRepo = new OrderRepo();
        ShopService shopService = new ShopService(testOrderRepo);

        shopService.addOrder(order);
        shopService.addOrder(order2);
        Map<Integer,Order> actual = shopService.listOrders();
        Map<Integer,Order> expected = new HashMap<>();
        expected.put(0,order);
        expected.put(1,order2);

        Assertions.assertEquals(expected, actual);
    }
}