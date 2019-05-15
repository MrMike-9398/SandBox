package mx.edu.itlapiedad.demo.webservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.itlapiedad.demo.modelos.Cliente;
import mx.edu.itlapiedad.demo.servicios.ClienteService;

@RestController
@RequestMapping("/gps")
public class ClienteWS {

	@Autowired
	ClienteService s;

	@GetMapping("/mensaje")
	public String Mensaje() {
		return "Hola WS";
	}

	@GetMapping("/clientes")//el get es para consultar
	public ResponseEntity<List<Cliente>> consultar() {
		List<Cliente> resultado = s.consultar();
		if (resultado.isEmpty()) 
			return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<List<Cliente>>(resultado,HttpStatus.OK);
	}
	
	@GetMapping("/clientes/{id}")
	public ResponseEntity<Cliente> buscar(@PathVariable int id){
		Cliente resultado = s.buscar(id);
		if (resultado ==null) {
			return new ResponseEntity<Cliente>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Cliente>(resultado,HttpStatus.OK);
		}
		
	}
	
	@PostMapping("/clientes")// el post es para insertar
	public ResponseEntity<Cliente> insertar(@RequestBody Cliente cliente){
		Cliente resultado = s.crear(cliente);
		return new ResponseEntity<Cliente>(resultado,HttpStatus.OK);
	}
	
	@PutMapping("/clientes")//el put es para actualizar
	public ResponseEntity<Void> actualizar(@RequestBody Cliente cliente){
		s.modificar(cliente);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/clientes/{id}")
	public ResponseEntity<Void> borrar(@PathVariable int id){
		s.borrar(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	

}
