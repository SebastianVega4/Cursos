package persistence;

import model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Inventory {
    private final List<Product> products;

    public Inventory() throws IOException {
        this.products = new ArrayList<>();
        obtainProductToTxt();
    }

    public void obtainProductToTxt() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("/ProductsAlcala.txt");
        InputStreamReader reader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] parts = line.split(",");
            int idProduct = Integer.parseInt(parts[0]);
            String nameProduct = parts[1];
            String description = parts[2];
            double price = Double.parseDouble(parts[3]);
            int stock = Integer.parseInt(parts[4]);
            Product product = new Product(idProduct, nameProduct, description, price,stock);
            products.add(product);
        }
        bufferedReader.close();
    }

    public void updateProductToTxt() throws IOException {
        FileWriter writer = new FileWriter(String.valueOf(getClass().getResource("/ProductsAlcala.txt")) ,false);
        for (Product product : products) {
            writer.write(product.toString() + "\n");
        }
        writer.close();
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void eraseProduct(Product product) {
        this.products.remove(product);
    }

    public List<Product> getProducts() {
        return products;
    }
}