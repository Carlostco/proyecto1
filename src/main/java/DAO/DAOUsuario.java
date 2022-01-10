package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import modelo.Persona;
import modelo.Usuario;
import utilidades.Conexion;

public class DAOUsuario {
	private Connection conn;
	private PreparedStatement statement;
	private boolean estadoOperacion;
	
	public boolean guardar(Usuario user) throws SQLException {
		
				
		return true;
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
	
	public Usuario obtenerUsuario(String user) throws SQLException {
		String sql=null;
		Resultset rs;
		estadoOperacion=false;
		Usuario u=null;
		conn=obtenerConexion();
		
		try {
			conn.setAutoCommit(false);
			
			sql="SELEC * FROM usuario WHERE username=?";
			statement=conn.prepareStatement(sql);
			
			statement.setString(1, user);
			
			
			rs = (Resultset) statement.executeQuery();
            if (((ResultSet) rs).next()) {
            	
            	u = new Usuario(((ResultSet) rs).getString("Rut"), ((ResultSet) rs).getString("username"), ((ResultSet) rs).getString("password")); 
            }
            
            statement.close();
            conn.close();
            return u;

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
