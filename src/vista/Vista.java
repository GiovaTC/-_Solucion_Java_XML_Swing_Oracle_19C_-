package vista;

import javax.swing.*;
import java.awt.*;

public class Vista extends JFrame {

    public JButton btnProcesar;
    public JTextField txtResultado;

    public Vista() {

        setTitle("Contador XML");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        btnProcesar = new JButton("Procesar XML");
        txtResultado = new JTextField(20);

        add(btnProcesar);
        add(txtResultado);
    }
}   
