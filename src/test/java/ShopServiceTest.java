import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShopServiceTest {

    @org.junit.jupiter.api.Test
    void listProducts() {
        Product one = new Product(4, "Spoon");
        Product two = new Product(5, "Chair");
        Product three = new Product(6, "Sofa");
        List<Product> productList = new ArrayList<>(List.of(one, two, three));
        //ProductRepo productRepo = new ProductRepo(productList);

    }

    @org.junit.jupiter.api.Test
    void getProduct() {
    }

    @org.junit.jupiter.api.Test
    void addOrder() {
    }

    @org.junit.jupiter.api.Test
    void getOrder() {
    }

    @org.junit.jupiter.api.Test
    void listOrders() {
    }
}