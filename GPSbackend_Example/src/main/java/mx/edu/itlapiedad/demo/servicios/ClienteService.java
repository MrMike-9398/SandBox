package mx.edu.itlapiedad.demo.servicios;

import java.util.List;

import mx.edu.itlapiedad.demo.modelos.Cliente;

public interface ClienteService {
	
	public List <Cliente> consultar();

	public Cliente buscar(int id);

	public Cliente crear(Cliente cliente);

	public void modificar(Cliente cliente);

	public void borrar(int id);

}
