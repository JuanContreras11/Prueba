package servicio;

import java.util.List;

import modelo.Cliente;

public abstract class Exportador {
	
	String filename;
	List<Cliente> listaClientes;
	
	
	
	public String getFilename() {
		return filename;
	}



	public void setFilename(String filename) {
		this.filename = filename;
	}



	public List<Cliente> getListaClientes() {
		return listaClientes;
	}



	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}




	
	
}
