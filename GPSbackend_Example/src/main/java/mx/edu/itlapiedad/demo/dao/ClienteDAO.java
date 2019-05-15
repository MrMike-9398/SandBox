package mx.edu.itlapiedad.demo.dao;

import java.util.List;

import mx.edu.itlapiedad.demo.modelos.Cliente;

public interface ClienteDAO {
	public List<Cliente> consultar();

	public Cliente buscar(int id);

	public int insertar(Cliente cliente);

	public void actualizar(Cliente cliente);

	public void borrar(int id);

}
