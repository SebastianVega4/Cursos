package logic;

import Interface.GUIstore;
import model.Administrator;
import model.Order;
import model.Product;
import model.ShoppingCart;

import java.io.FileWriter;
import java.io.IOException;

public class LogicCustomer {
    ShoppingCart cart = Administrator.getShoppingCart();
    private Order order;
    private String facture = "";

    //logica iniciar sesion
    public boolean loginCustomer(String user, String password) {
            if (Administrator.getName().equals(user)) {
                return Administrator.getPassword().equals(password);

            }
        return false;
    }

    //logica saber cuantos productos compra y añadir al corrito
    public void addNumberPurchesed(Product product, int amount) {
        cart.setPurchased(product, amount);
    }

    public String addPurchased(Product product) {
            cart.addProduct(product);
            return "Articulo: '" + product.getNameProduct() + "' añadido al carrito.";
    }

    //logica eliminar producto del carrito
    public void eraseProductCart(Product product) {
        cart.eraseProduct(product);
    }

    //logica vaciar carrito de compra
    public void clearCart() {
        Administrator.getShoppingCart().getProducts().clear();
    }

    //logica para realizar la compra
    public void makePurchase() throws IOException {
        order = new Order(cart);
        createFileFactureUser();
        setFacture();
        lessInventary();
        clearCart();
    }

    public void lessInventary() throws IOException {
        for (Product product : Administrator.getShoppingCart().getProducts()){
            int numberPurchased=Administrator.getShoppingCart().getPurchased(product);
            product.setStock(product.getStock()-numberPurchased);
        }
        GUIstore.getInventory().updateProductToTxt();
    }


    public String getFacture() {
        return facture;
    }

    public void setFacture() {
        if (Administrator.getShoppingCart().getProducts().isEmpty()){
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
                "Total:  $" + Administrator.getShoppingCart().calcTotal()
                + "\n                 ¡Gracias por preferirnos!";
    }

    //crear archivo por cada usuario(factura)
    public void createFileFactureUser() throws IOException {
        FileWriter writerFactureUser = new FileWriter("Resourses\\Bills\\" + "getFecha" + ".txt", true);

        order.getShoppingCart().getProducts().forEach(ordenes -> {
            try {
                writerFactureUser.write(ordenes.getNameProduct() + "," + order.getShoppingCart().getPurchased(ordenes) + ","
                        + ordenes.getPrice() + "," + order.getShoppingCart().calcTotalForProduct(ordenes) + "\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        writerFactureUser.close();
    }
}