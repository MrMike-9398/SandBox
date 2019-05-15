package mx.edu.itlapiedad.demo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.itlapiedad.demo.dao.ClienteDAO;
import mx.edu.itlapiedad.demo.modelos.Cliente;

@Service
public class LogicaCliente implements ClienteService{
	
	@Autowired
	ClienteDAO repositorio;

	@Override
	public List<Cliente> consultar() {
		// TODO Auto-generated method stub
		return repositorio.consultar();
	}

	@Override
	public Cliente buscar(int id) {
		// TODO Auto-generated method stub
		return repositorio.buscar(id);
	}

	@Override
	public Cliente crear(Cliente cliente) {
		// TODO Auto-generated method stub
		int id = repositorio.insertar(cliente);
		cliente.setId(id);
		return cliente;
	}

	@Override
	public void modificar(Cliente cliente) {
		// TODO Auto-generated method stub
		repositorio.actualizar(cliente);
	}

	@Override
	public void borrar(int id) {
		// TODO Auto-generated method stub
		repositorio.borrar(id);
	}
	

	

}
