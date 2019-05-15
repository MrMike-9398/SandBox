package mx.edu.itlapiedad.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mx.edu.itlapiedad.demo.modelos.Cliente;

public class ClienteRM implements RowMapper<Cliente> {

	@Override
	public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Cliente c =  new Cliente();
		c.setId(rs.getInt("id"));
		c.setNombre(rs.getString("nombre"));
		c.setRfc(rs.getString("rfc"));
		c.setDomicilio(rs.getString("domicilio"));
		c.setActivo(rs.getInt("activo"));
		return c;
	}

}
