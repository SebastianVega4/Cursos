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
        createFileFacture();
        setFacture();
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
                    " su facura se ha generado con exito \n"
                    + "    ¡Tu ferreteria de Confianza!\n";
            for (Product orderliness : order.getShoppingCart().getProducts()) {
                facture += " _______________________________" + "\n" + "Producto:  " + orderliness.getNameProduct() + "\n"
                        + "Cantidad: " + order.getShoppingCart().getPurchased(orderliness) + "\n"
                        + "Precio:  " + orderliness.getPrice() + "\n";
            }
        }
        facture += " _______________________________" + "\n \n" +
                "Total:  $" + shoppingCart.calcTotal()
                + "\n                 ¡Gracias por preferirnos!";
    }

    //crear archivo por cada factura diaria
    public void createFileFacture() throws IOException {
        // Obtén el directorio actual
        String currentDir = System.getProperty("user.dir");

        // Crea un archivo en el directorio actual con el nombre "getFecha.txt"
        File file = new File(currentDir, "getFecha.txt");

        // Verifica si el archivo existe
        if (!file.exists()) {
            // Si no existe, crea el archivo
            file.createNewFile();
        }

        // Escribe en el archivo
        try (FileWriter writerFactureUser = new FileWriter(file, true)) {
            order.getShoppingCart().getProducts().forEach(ordenes -> {
                try {
                    writerFactureUser.write(ordenes.getNameProduct() + "," + order.getShoppingCart().getPurchased(ordenes) + ","
                            + ordenes.getPrice() + "," + order.getShoppingCart().calcTotalForProduct(ordenes) + "\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }


    public ShoppingCart getCart() {
        return shoppingCart;
    }
}