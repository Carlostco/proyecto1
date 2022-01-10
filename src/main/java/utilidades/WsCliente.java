/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//import javax.jws.WebMethod;
//import javax.jws.WebParam;
//import javax.jws.WebService;

/**
 *
 * @author IIE
 */
//@WebService
public class WsCliente {
  //  @WebMethod(operationName = "consultarCliente")
    public String consultarUsuario(String usuario, String contrasenna)  {
        Connection conn;
        PreparedStatement stmt;
        ResultSet rs;
        String salida="";
        try{
            Conexion c = new Conexion();

            conn = c.conectar();
            if (!c.getMensaje().equals("conectado"))
            {
                return c.getMensaje();
            }
            String sql;
            sql="Select * from usuarios where username=? and password=?";
            stmt = conn.prepareStatement(sql);
//            if (c!=null)
//            {
//                return "aqui: "+c.getMensaje();
//            }            

            stmt.setString(1, usuario);
            stmt.setString(2, contrasenna);
            rs = stmt.executeQuery();
            //List array = new ArrayList();
            if (rs.next()) {
                salida = rs.getString("Rut");
            }
            if(salida.equals("")){
                return "No existe cliente";
            }
            
            stmt.close();
            conn.close();
            return salida;
//            return "Cliente existe";
        }
        catch(Exception e)
        {
//            return e.getMessage();
            return "error";
        }
//        return "CC";
    }
    
    public String consultarPersona(String rut)  {
        Connection conn;
        PreparedStatement stmt;
        ResultSet rs;
        String salida="";
        try{
            Conexion c = new Conexion();

            conn = c.conectar();
            if (!c.getMensaje().equals("conectado"))
            {
                return c.getMensaje();
            }
            String sql;
            sql="Select * from persona where rut=?";
            stmt = conn.prepareStatement(sql);
//            if (c!=null)
//            {
//                return "aqui: "+c.getMensaje();
//            }            

            stmt.setString(1, rut);
            rs = stmt.executeQuery();
            //List array = new ArrayList();
            if (rs.next()) {
            	salida = rs.getString("Nombre") + ", " + rs.getString("Apellido") + ", " + rs.getString("Telefono")+ ", " + rs.getString("FechaIngreso");
//                salida = rs.getString("Rut");
            }
            if(salida.equals("")){
                return "No existe cliente";
            }
            
            stmt.close();
            conn.close();
            return salida;
//            return "Cliente existe";
        }
        catch(Exception e)
        {
//            return e.getMessage();
            return "error";
        }
//        return "CC";
    }
    
//    @WebMethod(operationName = "agregarCliente")
//    public String agregarCliente(
//            String rut,
//            String nombres,
//            @WebParam(name = "apellidos")String apellidos,
//            @WebParam(name = "proveedorCodigo")int proveedorCodigo)  {
//        
//        Connection conn;
//        PreparedStatement stmt;
//        
//        String salida="";
//        if(!(consultarCliente(rut).equals("No existe cliente")))
//        {
//            return "Cliente ya existe";
//        }
//        else
//        {
//            try{
//                Conexion c = new Conexion();
//                conn = c.conectar();   
//                String sql;
//                sql="Insert into cliente (rut, nombres, apellidos, proveedor_cod) values (?, ?, ?, ?)";
//                stmt = conn.prepareStatement(sql);
//                stmt.setInt(1, rut);
//                stmt.setString(2, nombres);
//                stmt.setString(3, apellidos);
//                stmt.setInt(4, proveedorCodigo);
//                stmt.executeUpdate();
//
//                salida = "Cliente agregado";
//
//                stmt.close();
//                conn.close();
//                return salida;
//            }
//            catch(Exception e)
//            {
//                return e.getMessage();
//            }
//        }
////        return "AC";
//    }
    
//    @WebMethod(operationName = "modificarCliente")
//    public String modificarCliente(
//            @WebParam(name = "rut")int rut,
//            @WebParam(name = "nombres")String nombres,
//            @WebParam(name = "apellidos")String apellidos,
//            @WebParam(name = "proveedorCodigo")int proveedorCodigo)  {
//        
//        Connection conn;
//        PreparedStatement stmt;
//        
//        String salida="";
//        if((consultarCliente(rut).equals("No existe cliente")))
//        {
//            return "¡Cliente no existe!";
//        }
//        else
//        {
//            try{
//                Conexion c = new Conexion();
//                conn = c.conectar();   
//                String sql;
//                sql="Update cliente set nombres=?, apellidos=?, proveedor_cod=? where rut=?";
//                stmt = conn.prepareStatement(sql);
//                stmt.setString(1, nombres);
//                stmt.setString(2, apellidos);
//                stmt.setInt(3, proveedorCodigo);
//                stmt.setInt(4, rut);
//                stmt.executeUpdate();
//
//                salida = "Cliente modificado";
//
//                stmt.close();
//                conn.close();
//                return salida;
//            }
//            catch(Exception e)
//            {
//                return e.getMessage();
//            }
//        }
//       // return "MC";
//    }
}
