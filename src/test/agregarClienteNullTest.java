package test;



import org.junit.Assert;
import org.junit.Test;
import modelo.Cliente;
import servicio.ClienteServicio;

public class agregarClienteNullTest {
	 
	 ClienteServicio clienteservicio = new ClienteServicio();
	
	@Test
	public void testAgregarCliente(){
		//given
		Cliente juan = null;
		
		//clienteservicio.agregarCliente(juan);
		
		
		Assert.assertNotNull(juan);
	}
}