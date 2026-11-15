package generator;

import dao.ProductDAO;
import model.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProductImporter {

    private static String filePath;

    public static void importProducts(String filePath){
        ProductImporter.filePath = filePath;

        try(BufferedReader br=new BufferedReader(new FileReader(filePath))){

            String line;

            br.readLine();

            while((line=br.readLine())!=null){

                String[] data=line.split(",");

                Product product=new Product();

                product.setProductName(data[0]);
                product.setBrand(data[1]);
                product.setCategory(data[2]);
                product.setPrice(Double.parseDouble(data[3]));
                product.setStock(Integer.parseInt(data[4]));

                ProductDAO.save(product);

            }

            System.out.println("\nAll Products Imported Successfully");

        }

        catch(IOException e){

            e.printStackTrace();

        }

    }

}