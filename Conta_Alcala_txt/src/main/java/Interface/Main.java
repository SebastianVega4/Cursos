package Interface;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        GUIstore guiStore = new GUIstore();
        guiStore.showCatalogPanel();
        guiStore.getFrame().setVisible(true);
    }
}