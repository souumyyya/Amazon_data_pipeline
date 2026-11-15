package Service;

import dao.ProductDAO;
import generator.ProductImporter;
import model.Product;

public class ProductService {

    public static void importProducts(){

        ProductImporter.importProducts(
                "src/main/resources/product.csv"
        );

    }

    public static Product getRandomProduct(){

        return ProductDAO.getRandomProduct();

    }

}