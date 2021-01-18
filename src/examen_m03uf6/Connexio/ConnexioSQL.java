/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen_m03uf6.Connexio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author davidcc99
 */
public class ConnexioSQL {

    private static final String bbdd = "damm03uf6final";
    private static final String usuari = "root";
    private static final String psw = "";
    private static final String url = "jdbc:mysql://localhost:3306/" + bbdd;

    private static Connection conn = null;

    public static Connection getConnexio() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"
                        + "damm03uf6final?useUnicode=true&useJDBCCompliantTimezoneShift=true&"
                        + "useLegacyDatetimeCode=false&serverTimezone=UTC",
                        usuari, psw);
            } catch (SQLException ex) {
                Logger.getLogger(ConnexioSQL.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnexioSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
}
