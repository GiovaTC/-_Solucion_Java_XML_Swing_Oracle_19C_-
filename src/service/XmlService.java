// servicio XML ( generar xml + contar elementos del archivo ) :.

package service;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XmlService {

    private  static final String FILE_PATH = "datos.xml";

    // GENERAR XML .
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

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    // CONTAR ELEMENTOS <REGISTRO> :. . / .
    public int contarRegistros() {
        int total = 0;
        try {
            File file = new File(FILE_PATH);
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.parse(file);

            NodeList list = doc.getElementsByTagName("registro");
            total = list.getLength();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }
}   
