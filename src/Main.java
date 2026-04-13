import vista.Vista;
import controlador.Controlador;

public class Main {

    public static void main(String[] args) {

        Vista vista = new Vista();
        new Controlador(vista);

        vista.setVisible(true);
    }
}   