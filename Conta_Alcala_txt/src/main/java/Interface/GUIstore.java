package Interface;

import model.Administrator;
import persistence.Inventory;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GUIstore {
    private final JFrame frame;
    private static Inventory inventory = null;

    public GUIstore() throws IOException {
        frame = new JFrame("Ferreteria ideal");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(950, 750);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        inventory = new Inventory();
    }

    public void showLoginPanel() {
        GUILoginPanel GUILoginPanel = new GUILoginPanel(this);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(GUILoginPanel.getPanel(), BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
    }

    public void showCustomerMenuPanel() {
        GUICustomerMenuPanel GUICustomerMenuPanel = new GUICustomerMenuPanel(this);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(GUICustomerMenuPanel.getPanel(), BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
    }

    public void showCatalogPanel() {
        GUICatalogPanel GUICatalogPanel =new GUICatalogPanel(this);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(GUICatalogPanel.getPanel(), BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
    }
    public void showCartPanel() {
        GUICartPanel GUICartPanel =new GUICartPanel(this);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(GUICartPanel.getPanel(), BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
    }
    public JFrame getFrame() {
        return frame;
    }

    public static Inventory getInventory() {
        return inventory;
    }
}