package mx.edu.itlapiedad.demo.modelos;

public class Cliente {
	
	private int id;
	private String nombre;
	private String rfc;
	private String domicilio;
	private int activo;
	public Cliente(int id, String nombre, String rfc, String domicilio, int activo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.rfc = rfc;
		this.domicilio = domicilio;
		this.activo = activo;
		
	}
	public Cliente() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public int getActivo() {
		return activo;
	}
	public void setActivo(int activo) {
		this.activo = activo;
	}
	
	

}
