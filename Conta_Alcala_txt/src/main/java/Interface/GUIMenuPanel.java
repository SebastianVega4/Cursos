package Interface;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class GUIMenuPanel {
    private final JPanel panel;

    public GUIMenuPanel(GUIstore guiStore) {
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

        ImageIcon catalogIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Icons/catalogo.png")));
        Image catalogImage = catalogIcon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        ImageIcon scaledCatalogIcon = new ImageIcon(catalogImage);
        JButton catalogButton = new JButton("Catálogo", scaledCatalogIcon);
        catalogButton.setPreferredSize(new Dimension(200, 200));
        catalogButton.setFont(new Font("Serif", Font.ITALIC, 14));
        catalogButton.setBackground(new Color(63, 81, 181));
        catalogButton.setForeground(Color.WHITE);
        catalogButton.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        catalogButton.setFocusPainted(false);
        catalogButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        centerPanel.add(catalogButton);

        ImageIcon cartIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Icons/carrito.png")));
        Image cartImage = cartIcon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        ImageIcon scaledCartIcon = new ImageIcon(cartImage);
        JButton cartButton = new JButton("Carrito", scaledCartIcon);
        cartButton.setPreferredSize(new Dimension(200, 200));
        cartButton.setFont(new Font("Serif", Font.ITALIC, 14));
        cartButton.setBackground(new Color(63, 81, 181));
        cartButton.setForeground(Color.WHITE);
        cartButton.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        cartButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        centerPanel.add(cartButton);

        JButton boxBotton = new JButton("CAJA", scaledCartIcon);
        boxBotton.setPreferredSize(new Dimension(200, 200));
        boxBotton.setFont(new Font("Serif", Font.ITALIC, 14));
        boxBotton.setBackground(new Color(63, 81, 181));
        boxBotton.setForeground(Color.WHITE);
        boxBotton.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        boxBotton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        centerPanel.add(boxBotton);

        JButton calculatorBotton = new JButton("CALCULADORA", scaledCartIcon);
        calculatorBotton.setPreferredSize(new Dimension(200, 200));
        calculatorBotton.setFont(new Font("Serif", Font.ITALIC, 14));
        calculatorBotton.setBackground(new Color(63, 81, 181));
        calculatorBotton.setForeground(Color.WHITE);
        calculatorBotton.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        calculatorBotton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        centerPanel.add(calculatorBotton);

        JPanel buttomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttomPanel.setOpaque(false);

        ImageIcon signoutIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Icons/signout11.png")));
        Image signoutImage = signoutIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon scaledSignoutIcon = new ImageIcon(signoutImage);
        JButton signOffButton = new JButton("Cerrar Sesión", scaledSignoutIcon);

        signOffButton.setForeground(Color.WHITE);
        signOffButton.setBackground(Color.black);
        signOffButton.setFont(new Font("Serif", Font.ITALIC, 9));
        signOffButton.setPreferredSize(new Dimension(150, 30));
        signOffButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        buttomPanel.add(signOffButton);

        panel.add(topPanel, BorderLayout.PAGE_START);
        panel.add(centerPanel, BorderLayout.CENTER);
        panel.add(buttomPanel, BorderLayout.PAGE_END);

        catalogButton.addActionListener(e -> guiStore.showCatalogPanel());
        cartButton.addActionListener(e -> guiStore.showCartPanel());
        boxBotton.addActionListener(e -> guiStore.showBoxPanel());
        calculatorBotton.addActionListener(e -> guiStore.showCalculatorPanel());
        signOffButton.addActionListener(e -> guiStore.showLoginPanel());
    }

    public JPanel getPanel() {
        return panel;
    }
}