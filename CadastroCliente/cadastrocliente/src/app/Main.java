package app;

import javax.swing.SwingUtilities;
import view.TelaCliente;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                TelaCliente tela = new TelaCliente();

                tela.setVisible(true);
            }
        });
    }
}
