package controlador;

import vista.Vista;
import service.XmlService;
import dao.XmlDAO;
import model.Registro;

import java.awt.event.ActionEvent;

public class Controlador {

    private Vista vista;
    private XmlService service;
    private XmlDAO dao;

    public Controlador(Vista vista) {
        this.vista = vista;
        this.service = new XmlService();
        this.dao = new XmlDAO();

        vista.btnProcesar.addActionListener(this::procesar);
    }

    private void procesar(ActionEvent e) {

        service.generarXML();

        int total = service.contarRegistros();

        vista.txtResultado.setText("TOTAL REGISTROS: " + total);

        Registro r = new Registro(total);
        dao.insertar(r);
    }
}
