package logic;

import Interface.GUIstore;
import model.Administrator;
import model.Order;
import model.Product;
import model.ShoppingCart;
import persistence.ImageProducts;
import persistence.Inventory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LogicAlcala {
    private ImageProducts ip;
    private ShoppingCart shoppingCart = new ShoppingCart();
    private Order order;
    private String facture = "";

    public LogicAlcala() {
        ip = new ImageProducts();
    }

    //logica iniciar sesion
    public boolean login(String user, String password) {
            if (Administrator.getName().equals(user)) {
                return Administrator.getPassword().equals(password);

            }
        return false;
    }

    //logica saber cuantos productos compra y añadir al carrito
    public void addNumberPurchesed(Product product, int amount) {
        shoppingCart.setPurchased(product, amount);
    }

    public String addPurchased(Product product) {
        shoppingCart.addProduct(product);
        System.out.println(shoppingCart.getProducts());
        return "Articulo: '" + product.getNameProduct() + "' añadido al carrito.";
    }

    //logica eliminar producto del carrito
    public void eraseProductCart(Product product) {
        shoppingCart.eraseProduct(product);
    }

    //logica vaciar carrito de compra
    public void clearCart() {
        shoppingCart.getProducts().clear();
    }

    //logica para realizar la compra
    public void makePurchase() throws IOException {
        order = new Order(shoppingCart);
        setFacture();
        createFileFacture();
        lessInventary();
        clearCart();
    }

    public void lessInventary() throws IOException {
        for (Product product : shoppingCart.getProducts()){
            int numberPurchased=shoppingCart.getPurchased(product);
            product.setStock(product.getStock()-numberPurchased);
        }
        GUIstore.getInventory().updateProductToTxt();
    }


    public String getFacture() {
        return facture;
    }

    public void setFacture() {
        if (shoppingCart.getProducts().isEmpty()){
            facture = "Administrador" +
                    "\n No tiene productos en el carrito\n";
        }else {
            facture = "Administrator"+
                    "\n su facura se ha generado con exito \n";
            for (Product orderliness : order.getShoppingCart().getProducts()) {
                facture += " _______________________________" + "\n" + "Producto:  " + orderliness.getNameProduct() + "\n"
                        + "Cantidad: " + order.getShoppingCart().getPurchased(orderliness) + "\n"
                        + "Precio:  " + orderliness.getPrice() + "\n";
            }
        }
        facture += " _______________________________" + "\n \n" +
                "Total:  $" + shoppingCart.calcTotal();
    }

    //crear archivo por cada factura diaria
    public void createFileFacture() throws IOException {
        // Obtén el directorio actual
        String currentDir = System.getProperty("user.dir");

        // Obtén la fecha actual y formateala en el formato deseado
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = currentDate.format(formatter);

        // Crea un archivo en el directorio actual con el nombre "factura_{fecha}.txt"
        File file = new File(currentDir, "factura_" + formattedDate + ".txt");

        // Verifica si el archivo existe
        if (!file.exists()) {
            // Si no existe, crea el archivo
            file.createNewFile();
        }

        // Escribe en el archivo
        try (FileWriter writerFacture = new FileWriter(file, true)) {
            try {
                writerFacture.write(facture+"\n \n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public ShoppingCart getCart() {
        return shoppingCart;
    }
}