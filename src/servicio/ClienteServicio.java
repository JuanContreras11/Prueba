package servicio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import modelo.CategoriaEnum;
import modelo.Cliente;


public class ClienteServicio {
	Scanner scanner = new Scanner(System.in);
	List<Cliente> listaCliente;

	public ClienteServicio() {
		listaCliente = new ArrayList<>();
	}

	public List<Cliente> getlistaCliente() {
		return listaCliente;
	}

	public void setListaCliente(List<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}
	
	public void retornolistarClientes() {

		for (Cliente cliente : listaCliente) {
			System.out.println("--------------------Datos del cliente------------------");
			System.out.println("RUN del cliente: " + cliente.getRunCliente());
			System.out.println("Nombre del cliente: " + cliente.getNombreCliente());
			System.out.println("Apellido del cliente: " + cliente.getApellidoCliente());
			System.out.println("Años como cliente: " + cliente.getAniosCliente());
			System.out.println("Categoria del cliente: " + cliente.getNombreCategoria());
			System.out.println("-----------------------------------------------------");
		}
		
		
	}

	public String agregarCliente(String run, String nombre, String apellido, String anios, CategoriaEnum Activo) {

		Cliente cliente = new Cliente(run, nombre, apellido, anios, Activo);

		if (listaCliente != null) {
			listaCliente.add(cliente);
		} else {
			System.out.println("El Producto es nulo");
		}
		return cliente.toString();
	}

	public void editarCliente(Cliente cliente) {
		System.out.println("---------------------------------------");
		System.out.println("1- El RUN del cliente es: " + cliente.getRunCliente());
		System.out.println("2- El Nombre del cliente es: " + cliente.getNombreCliente());
		System.out.println("3- El Apellido del cliente es: " + cliente.getApellidoCliente());
		System.out.println("4- Los Años como cliente son: " + cliente.getAniosCliente());
		
		System.out.println("");
		System.out.println("- ¿Que opcion quiere editar? -");
		int opcion = scanner.nextInt();
		scanner.nextLine();

		switch (opcion) {

		case 1:
			System.out.println("Ingrese el nuevo Run");
			String run = scanner.nextLine();
			cliente.setRunCliente(run);
			break;

		case 2:
			System.out.println("Ingrese el nuevo Nombre");
			String nombre = scanner.nextLine();
			cliente.setNombreCliente(nombre);
			break;

		case 3:
			System.out.println("Ingrese el nuevo Apellido");
			String apellido = scanner.nextLine();
			cliente.setApellidoCliente(apellido);
			break;

		case 4:
			System.out.println("Ingrese los Años");
			String anios = scanner.nextLine();
			cliente.setAniosCliente(anios);
			break;
			
			default:
				System.out.println("Opcion no valida");
		}
	}

	public List<Cliente> cargarDatos(String nomArchivo) {
		
		String ruta = scanner.nextLine();
		String archivo = ruta + "/" + nomArchivo;

		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(new File(archivo));
			br = new BufferedReader(fr);
			List<Cliente> l = br.lines().map(line -> line.split(",")).map(
					values -> new Cliente(values[0],values[1],values[2],values[3],CategoriaEnum.valueOf(values[4])))
					.collect(Collectors.toList());
			System.out.println(l.toString());
			return l;
		} catch (Exception error) {
			System.out.println("No se pudo cargar" + error);
		} finally {
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception error) {
				System.out.println("Error al crear el archivo");
			}
		}
		
		
		
		
		
		return null;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
