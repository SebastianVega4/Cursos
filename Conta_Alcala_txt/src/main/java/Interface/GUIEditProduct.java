package Interface;

import logic.LogicCustomer;
import model.Product;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class GUIEditProduct {

    private final JPanel panel;
    private LogicCustomer lA;

    public GUIEditProduct(GUIstore guiStore, Product product, int index) {
        panel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundImage = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Icons/Menu.png")));
                g.drawImage(backgroundImage.getImage(), 0, 0, panel.getWidth(), panel.getHeight(), this);
            }
        };

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setOpaque(false);

        ImageIcon imageLogo = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Icons/Logo.png")));
        Image image = imageLogo.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        ImageIcon scaledImageLogo = new ImageIcon(image);
        JLabel imgLogo = new JLabel(scaledImageLogo);
        topPanel.add(imgLogo, BorderLayout.WEST);


        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setOpaque(false);

    	JLabel lblName = new JLabel("Name:");
        JLabel JLabellblDescription = new JLabel("Description:");
        JLabel lblPrice = new JLabel("Price:");
        JLabel lblStock = new JLabel("Stock:");
        JTextField txtName = new JTextField(product.getNameProduct(), 10);
        JTextField txtDescription = new JTextField(product.getDescription(), 10);
        JTextField txtPrice = new JTextField(String.valueOf(product.getPrice()), 10);
        JSpinner spnStock = new JSpinner(new SpinnerNumberModel(product.getStock(), 0, Integer.MAX_VALUE, 1));
        centerPanel.setLayout(new GridLayout(5, 2));
        centerPanel.add(lblName);
        centerPanel.add(txtName);
        centerPanel.add(JLabellblDescription);
        centerPanel.add(txtDescription);
        centerPanel.add(lblPrice);
        centerPanel.add(txtPrice);
        centerPanel.add(lblStock);
        centerPanel.add(spnStock);


        JPanel buttonPanel = new JPanel();

        JButton btnSave = new JButton("Save");
        JButton btnCancel = new JButton("Cancel");
        buttonPanel.add(btnSave);
        buttonPanel.add(btnCancel);

        panel.add(topPanel, BorderLayout.PAGE_START);
        panel.add(centerPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.PAGE_END);

        btnSave.addActionListener(e -> {
        // Guardar los cambios en el producto
        product.setNameProduct(txtName.getText());
        product.setDescription(txtDescription.getText());
        product.setPrice(Double.parseDouble(txtPrice.getText()));
        product.setStock((int) spnStock.getValue());

        // Actualizar el producto en la base de datos
            try {
                lA.editProduct(txtName.getText(),txtDescription.getText(),txtPrice.getText(), (String) spnStock.getValue(),index);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            JOptionPane.showMessageDialog(null, "Product edited successfully");
    	});

        btnCancel.addActionListener(e ->guiStore.showCatalogPanel());
    }
    public JPanel getPanel() {
        return panel;
    }
}