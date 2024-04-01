package model;

public class Administrator {
    private static final String name= "admin";
    private static final String password= "1234";
    private static ShoppingCart shoppingCart = null;

    public Administrator() {
        this.shoppingCart = new ShoppingCart();
    }

    public static String getName() {
        return name;
    }

    public static String getPassword() {
        return password;
    }

    public static ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

}