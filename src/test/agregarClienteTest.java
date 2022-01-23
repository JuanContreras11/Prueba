package test;



import org.junit.Assert;
import org.junit.Test;
import servicio.ClienteServicio;
import modelo.CategoriaEnum;
import modelo.Cliente;



public class agregarClienteTest {
	
		
	 ClienteServicio clienteservicio = new ClienteServicio();
		
		
		@Test
		public void testAgregarCliente(){
			//given
			Cliente juan = new Cliente ("123", "juan", "contreras","2",CategoriaEnum.ACTIVO);
			
			clienteservicio.agregarCliente("123", "juan", "contreras","2",CategoriaEnum.ACTIVO);
			
			
			Assert.assertNotNull(juan);
		}
				
				
	
}
