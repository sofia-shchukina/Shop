import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepo {
    Map<Integer, Product> products;


    public Map<Integer, Product> list() {
        return products;
    }

    public ProductRepo(Map<Integer, Product> products) {
        this.products = products;
    }


    public Product get(int i) throws NotAProductException, NotAnOrderException {

        if (products.containsKey(i)) {
            return products.get(i);
        } else {
            throw new NotAnOrderException("There is no product with this index");
        }
    }
}
