package model;

public class Administrator {
    private final String name;
    private final String password;

    public Administrator() {
        this.name = "admin";
        this.password = "1234";
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}