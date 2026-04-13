# -_Solucion_Java_XML_Swing_Oracle_19C_- :.
🧾 Solución Java: XML + Swing + Oracle 19c:

<img width="1024" height="1024" alt="image" src="https://github.com/user-attachments/assets/8b65c91e-917a-4eda-aa69-ea19476488ce" />  

<img width="2556" height="1079" alt="image" src="https://github.com/user-attachments/assets/575ce2ec-99e1-414c-98a1-40cc79afb783" /> 

<img width="1266" height="952" alt="image" src="https://github.com/user-attachments/assets/f002c00c-f33e-47ce-89ee-3ceb99d4a8a6" />  

```

Solucion completa, funcional y estructurada en Java (IntelliJ) que cubre exactamente lo que necesitas:

✔ Generar XML de ejemplo (20 registros)
✔ Contar elementos del XML
✔ Mostrar resultado en interfaz gráfica (Swing)
✔ Insertar resultado en Oracle 19c (tabla con 12 campos)
✔ Arquitectura simple (Vista + Servicio + DAO)

🧩 1. ESTRUCTURA DEL PROYECTO
src/
 ├── Main.java
 ├── vista/
 │     └── Vista.java
 ├── controlador/
 │     └── Controlador.java
 ├── service/
 │     └── XmlService.java
 ├── dao/
 │     └── XmlDAO.java
 ├── model/
 │     └── Registro.java

🧩 2. XML DE EJEMPLO (GENERADO AUTOMÁTICAMENTE)

📄 datos.xml

<registros>
    <registro>
        <id>1</id>
        <nombre>Nombre1</nombre>
        <valor>10</valor>
    </registro>
</registros>

Se generan 20 registros automáticamente desde el código.

🧩 3. MODELO
package model;

public class Registro {

    private int campo1;
    private String campo2;
    private int campo3;
    private String campo4;
    private String campo5;
    private String campo6;
    private String campo7;
    private String campo8;
    private String campo9;
    private String campo10;
    private String campo11;
    private int campo12;

    public Registro(int total) {
        this.campo1 = total;
        this.campo2 = "Conteo XML";
        this.campo3 = total * 2;
        this.campo4 = "A";
        this.campo5 = "B";
        this.campo6 = "C";
        this.campo7 = "D";
        this.campo8 = "E";
        this.campo9 = "F";
        this.campo10 = "G";
        this.campo11 = "H";
        this.campo12 = total;
    }

    // getters
    public int getCampo1() { return campo1; }
    public String getCampo2() { return campo2; }
    public int getCampo3() { return campo3; }
    public String getCampo4() { return campo4; }
    public String getCampo5() { return campo5; }
    public String getCampo6() { return campo6; }
    public String getCampo7() { return campo7; }
    public String getCampo8() { return campo8; }
    public String getCampo9() { return campo9; }
    public String getCampo10() { return campo10; }
    public String getCampo11() { return campo11; }
    public int getCampo12() { return campo12; }
}

🧩 4. SERVICIO XML (GENERAR + CONTAR)
package service;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XmlService {

    private static final String FILE_PATH = "datos.xml";

    // Generar XML
    public void generarXML() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            Element root = doc.createElement("registros");
            doc.appendChild(root);

            for (int i = 1; i <= 20; i++) {
                Element registro = doc.createElement("registro");

                Element id = doc.createElement("id");
                id.appendChild(doc.createTextNode(String.valueOf(i)));

                Element nombre = doc.createElement("nombre");
                nombre.appendChild(doc.createTextNode("Nombre" + i));

                Element valor = doc.createElement("valor");
                valor.appendChild(doc.createTextNode(String.valueOf(i * 10)));

                registro.appendChild(id);
                registro.appendChild(nombre);
                registro.appendChild(valor);

                root.appendChild(registro);
            }

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(new DOMSource(doc), new StreamResult(new File(FILE_PATH)));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Contar elementos <registro>
    public int contarRegistros() {
        int total = 0;
        try {
            File file = new File(FILE_PATH);
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.parse(file);

            NodeList lista = doc.getElementsByTagName("registro");
            total = lista.getLength();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }
}

🧩 5. DAO (ORACLE 19c)
package dao;

import model.Registro;
import java.sql.*;

public class XmlDAO {

    private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private final String USER = "system";
    private final String PASS = "oracle";

    public void insertar(Registro r) {

        String sql = "INSERT INTO REGISTRO_XML VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, r.getCampo1());
            ps.setString(2, r.getCampo2());
            ps.setInt(3, r.getCampo3());
            ps.setString(4, r.getCampo4());
            ps.setString(5, r.getCampo5());
            ps.setString(6, r.getCampo6());
            ps.setString(7, r.getCampo7());
            ps.setString(8, r.getCampo8());
            ps.setString(9, r.getCampo9());
            ps.setString(10, r.getCampo10());
            ps.setString(11, r.getCampo11());
            ps.setInt(12, r.getCampo12());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

🧩 6. CONTROLADOR
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

        vista.txtResultado.setText("Total registros: " + total);

        Registro r = new Registro(total);
        dao.insertar(r);
    }
}

🧩 7. VISTA (SWING)
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

🧩 8. MAIN
import vista.Vista;
import controlador.Controlador;

public class Main {

    public static void main(String[] args) {

        Vista vista = new Vista();
        new Controlador(vista);

        vista.setVisible(true);
    }
}

🧩 9. SCRIPT ORACLE (TABLA 12 CAMPOS)
CREATE TABLE REGISTRO_XML (
    CAMPO1 NUMBER,
    CAMPO2 VARCHAR2(50),
    CAMPO3 NUMBER,
    CAMPO4 VARCHAR2(10),
    CAMPO5 VARCHAR2(10),
    CAMPO6 VARCHAR2(10),
    CAMPO7 VARCHAR2(10),
    CAMPO8 VARCHAR2(10),
    CAMPO9 VARCHAR2(10),
    CAMPO10 VARCHAR2(10),
    CAMPO11 VARCHAR2(10),
    CAMPO12 NUMBER
);

✅ FLUJO COMPLETO
Click en "Procesar XML"
Se genera datos.xml
Se cuentan los <registro>
Se muestra resultado en GUI
Se inserta en Oracle
🚀 MEJORAS OPCIONALES

Si quieres llevarlo a nivel más profesional:

Usar JTable para mostrar los registros
Validar conexión a Oracle
Usar pool de conexiones (HikariCP)
Manejar XML con JAXB
Agregar logs con Log4j :. . / .
