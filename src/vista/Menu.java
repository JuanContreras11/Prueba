package vista;

import java.util.List;
import java.util.Scanner;
import modelo.CategoriaEnum;
import modelo.Cliente;
import servicio.ArchivoServicio;
import servicio.ClienteServicio;
import servicio.ExportadorCsv;
import utilidades.Util;

public class Menu extends MenuTemplate {

	ClienteServicio clienteservicio = new ClienteServicio();
	 ArchivoServicio archivoServicio = new ArchivoServicio();
	 ExportadorCsv exportadorCsv = new ExportadorCsv();

	String fileName = "Clientes";
	String fileName1 = "DBClientes.csv";

	Scanner scanner = new Scanner(System.in);

	@Override
	public void listarCliente() {
		List<Cliente> listaCliente = clienteservicio.getlistaCliente();
		if (listaCliente != null && !listaCliente.isEmpty()) {
			clienteservicio.retornolistarClientes();
			Util.stopAndContinue();
		} else {
			System.out.println("No se ha podido listar los productos, aun no hay carga de datos");
		}

	}

	@Override
	public void agregarCliente() {
		System.out.println("------------ Crear Cliente ------------");
		System.out.println("Ingrese el RUT");
		String rut = scanner.nextLine();
		System.out.println("Ingrese el nombre del alumno");
		String nombre = scanner.nextLine();
		System.out.println("Ingrese Apellido");
		String apellido = scanner.nextLine();
		System.out.println("Ingrese los años como cliente");
		String anios = scanner.nextLine();

		System.out.println("------------****************------------");

		clienteservicio.agregarCliente(rut, nombre, apellido, anios, CategoriaEnum.ACTIVO);

	}

	@Override
	public void editarCliente() {
		List<Cliente> listaCliente = clienteservicio.getlistaCliente();
		if (listaCliente != null && !listaCliente.isEmpty()) {
			System.out.println("------------ Editar Cliente ------------");
			System.out.println("Seleccione qué desea hacer");
			System.out.println("1.-Cambiar el estado del Cliente");
			System.out.println("2.-Editar los datos ingresados del Cliente\n");
			System.out.println("");
			System.out.println("Ingrese opción");
			String opcionEdicion = scanner.nextLine();
			System.out.println("-----------------------------------------");
			System.out.println("¿Cual es el Run del cliente?");
			String run = scanner.nextLine();

			if (opcionEdicion.equals("1")) {
				System.out.println("Seleccione el estado\n1.-Activo\n2.-Inactivo");
				String estado = scanner.nextLine();
				for (Cliente cliente : listaCliente) {
					if (cliente.getRunCliente().equals(run)) {
						if (estado.equals("Activo")) {
							cliente.setNombreCategoria(CategoriaEnum.ACTIVO);
						} else if (estado.equals("Inactivo")) {
							cliente.setNombreCategoria(CategoriaEnum.INACTIVO);
						} else {
							System.out.println("Opción invalida");
						}

					}
				}
				System.out.println("Estado cambiado");
			} else if (opcionEdicion.equals("2")) {
				for (Cliente cliente : listaCliente) {

					if (cliente.getRunCliente().equals(run)) {
						clienteservicio.editarCliente(cliente);
						;
					}
				}
			}

		}else {
			System.out.println("- No hay datos para editar -");
		}
	}

	@Override
	public void cargarDatos() {
		System.out.println("------------ Cargar datos en windows ------------\n");

		String nomArchivo = "DBClientes.csv";

		System.out.println("--- Ingresa la ruta del archivo DBClientes.csv ---");

		List<Cliente> listaCliente = clienteservicio.cargarDatos(nomArchivo);
		// si lista cliente no es nula ni esta vacia
		if (listaCliente != null && !listaCliente.isEmpty()) {
			clienteservicio.setListaCliente(listaCliente);
			System.out.println("----------------------------");
			System.out.println("-- Datos correctamente cargados --");

		} else {
			System.out.println("No se pudo cargar el archivo" + nomArchivo);
		}

	}

	@Override
	public void exportarDatos() {
		System.out.println("---------------------------");
		System.out.println("Exportar Datos");
		System.out.println("");
		
		List<Cliente> listaProductos = clienteservicio.getlistaCliente();
		
		
			exportadorCsv.exportar(fileName + ".csv", listaProductos);
			Util.stopAndContinue();
			
		
		

	}

	@Override
	public void terminarPrograma() {
		System.out.println("Abandonando el sistema de productos....");
		Util.timeToWait();
		System.out.println("Acaba de salir del sistema");
		Util.stopAndContinue();
		System.exit(0);
	}

}
