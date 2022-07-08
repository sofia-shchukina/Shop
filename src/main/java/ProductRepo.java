import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepo {
    List<Product> products;


    public List<Product> list (){
        return products;
    }

    public ProductRepo(List<Product> products) {
        this.products = products;
    }


    public Product get(int i) {
        return products.get(i);
    }
}
