package Interface;

import model.Product;
import persistence.Inventory;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GUIstore {
    private final JFrame frame;
    private static Inventory inventory = null;

    public GUIstore() throws IOException {
        frame = new JFrame("Restaurante Alcala");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(950, 750);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        inventory = new Inventory();
    }

    public void showLoginPanel() {
        GUILoginPanel gUILoginPanel = new GUILoginPanel(this);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(gUILoginPanel.getPanel(), BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
    }

    public void showCustomerMenuPanel() {
        GUIMenuPanel gUIMenuPanel = new GUIMenuPanel(this);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(gUIMenuPanel.getPanel(), BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
    }

    public void showCatalogPanel() {
        GUICatalogPanel gUICatalogPanel =new GUICatalogPanel(this);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(gUICatalogPanel.getPanel(), BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
    }
    public void showCartPanel() {
        GUICartPanel gUICartPanel =new GUICartPanel(this);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(gUICartPanel.getPanel(), BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
    }
    public void showEditProdut(Product product, int index) {
        GUIEditProduct gUIEditPanel =new GUIEditProduct(this,product, index);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(gUIEditPanel.getPanel(), BorderLayout.CENTER);
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