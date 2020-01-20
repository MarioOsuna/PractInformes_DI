/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Usuario
 */
public class ConexionBD {

    private static Connection conexion = null;

    public static Connection generar() throws ClassNotFoundException, SQLException {
        if (conexion == null) {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conexion = DriverManager.getConnection("jdbc:mysql://localhost/portatilbaratodb?serverTimezone=UTC", "root", "");
        }
        return conexion;

    }

    static ResultSet hacerConsulta(String consultaSQL) throws ClassNotFoundException, SQLException {
        if (conexion == null) {
            generar();
        }
        Statement consulta = conexion.createStatement();
        return consulta.executeQuery(consultaSQL);
    }
}
