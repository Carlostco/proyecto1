/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author IIE
 */
public class Conexion {
    public String mensaje;

    public String getMensaje() {
        return mensaje;
    }
    public Connection conectar() {
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        String DB_URL = "jdbc:mysql://localhost:3306/Platinum";
        String USER = "root";
        String PASS = "chaijc";
        Connection conn = null;
        
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            if (conn != null)
            mensaje = "conectado";
            return conn;
        }
        catch (Exception e)
        {
            mensaje= e.getMessage();
            return conn;
        }
    }
    
}
