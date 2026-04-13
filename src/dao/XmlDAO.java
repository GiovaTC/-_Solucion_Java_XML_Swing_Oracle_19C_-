package dao;

import model.Registro;
import java.sql.*;

public class XmlDAO {

    private final String URL = "jdbc:oracle:thin:@//localhost:1521/orcl";
    private final String USER = "system";
    private final String PASS = "Tapiero123";

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
