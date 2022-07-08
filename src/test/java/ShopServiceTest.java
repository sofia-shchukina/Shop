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
    void getProduct() throws NotAProductException, NotAnOrderException {
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

    //@Test
    void addOrder() {
    }

    @Test
    void getOrder() {
    }

    @Test
    void listOrders() {
    }
}