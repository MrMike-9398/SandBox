package mx.edu.itlapiedad.demo.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import mx.edu.itlapiedad.demo.modelos.Cliente;

@Repository
public class ClienteJDBC implements ClienteDAO{
	
	@Autowired
	JdbcTemplate conexion;
	
	String sql = "";

	@Override
	public List<Cliente> consultar() {
		// TODO Auto-generated method stub
		sql ="SELECT * FROM clientes WHERE activo = 1";
		return conexion.query(sql, new ClienteRM());
		
	}

	@Override
	public Cliente buscar(int id) {
		// TODO Auto-generated method stub
		sql = "SELECT * FROM clientes WHERE id=? AND activo = 1";
		return conexion.queryForObject(sql, new ClienteRM(),id);
	}

	@Override
	public int insertar(Cliente cliente) {
		// TODO Auto-generated method stub
		SimpleJdbcInsert insert = new SimpleJdbcInsert(conexion);
		List<String> columnas = new ArrayList<>();
		columnas.add("nombre");
		columnas.add("domicilio");
		columnas.add("rfc");
		insert.setTableName("clientes");
		insert.setColumnNames(columnas);
		Map<String, Object> datos = new HashMap<>();
		datos.put("nombre", cliente.getNombre());
		datos.put("domicilio", cliente.getDomicilio());
		datos.put("rfc", cliente.getRfc());
		insert.setGeneratedKeyName("id");
		Number idNumber = insert.executeAndReturnKey(datos);
		return idNumber.intValue();
	}

	@Override
	public void actualizar(Cliente cliente) {
		// TODO Auto-generated method stub
		sql ="UPDATE clientes SET nombre = ?, domicilio = ?, rfc = ? WHERE id = ? AND activo=1";
		conexion.update(sql,cliente.getNombre(),cliente.getDomicilio(),cliente.getRfc(),cliente.getId());
	}

	@Override
	public void borrar(int id) {
		// TODO Auto-generated method stub
		sql ="UPDATE clientes SET activo=0 WHERE id = ?";
		conexion.update(sql,id);
	}

}
