package DAO;
import utilidades.Conexion;
import modelo.Persona;

import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DAOPersona {
	private Connection conn;
	private PreparedStatement statement;
	private boolean estadoOperacion;
	
	public boolean guardar(Persona persona) throws SQLException {
		String sql=null;
		estadoOperacion=false;
		conn=obtenerConexion();
		
		try {
			conn.setAutoCommit(false);
			
			sql="INSERT INTO persona (Rut, Nombre, Apellido, Telefono, FechaIngreso) VALUES (?,?,?,?,?)";
			statement=conn.prepareStatement(sql);
			
			statement.setString(1, persona.getRut());
			statement.setString(2, persona.getNombre());
			statement.setString(3, persona.getApellido());
			statement.setString(4, persona.getTelefono());
			statement.setDate(5, (Date) persona.getFechaIngreso());
			
			estadoOperacion=statement.executeUpdate()>0;
			
			conn.commit();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
		}
				
		return estadoOperacion;
	}
	
	public boolean editar(Persona persona) {
		return true;
	}
	public boolean eliminar(Persona persona) {
		
		return true;
	}
	
	public List<Persona> obtenerPersonas() {
		return null;
	}
	
	public Persona obtenerPersona(String rut) throws SQLException {
		String sql=null;
		Resultset rs;
		estadoOperacion=false;
		Persona p=null;
		conn=obtenerConexion();
		
		try {
			conn.setAutoCommit(false);
			
			sql="SELEC * FROM persona WHERE Rut=?";
			statement=conn.prepareStatement(sql);
			
			statement.setString(1, rut);
			
			
			rs = (Resultset) statement.executeQuery();
            if (((ResultSet) rs).next()) {
            	p = new Persona(((ResultSet) rs).getString("Rut"), ((ResultSet) rs).getString("Nombre"), ((ResultSet) rs).getString("Apellido"), ((ResultSet) rs).getString("Telefono"), null); 
            }
            
            statement.close();
            conn.close();
            return p;

		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
		}
		
		return null;
	}
	
	private Connection obtenerConexion() {
		
		Conexion c = new Conexion();

        
		return c.conectar();
	}
	

}
