package servicio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import modelo.Cliente;

public class ExportadorCsv extends ArchivoServicio{
	Scanner sc = new Scanner(System.in);
	
	String filename;
	List<Cliente> listaClientes;
	
	
	@Override
	public void exportar(String nomArchivo, List<Cliente> listaClientes) {
		if (listaClientes == null) {
			System.out.println("La lista esta vacia");
		} else {
			System.out.println("------------------- Exportar datos --------------------");
			System.out.println("Ingresa la ruta para guardar el archivo: ");
			String cvsSeparatorValue = ",";
			String ruta = sc.nextLine();
			String archivo = ruta + "/" + nomArchivo;
			File fl = new File(archivo);
			if (fl.exists()) {
				fl.delete();

			}

			try {

				PrintWriter pWriter = new PrintWriter(new FileWriter(archivo));

				listaClientes.forEach(cliente -> {
					pWriter.append(cliente.getRunCliente()).append(cvsSeparatorValue).append(cliente.getNombreCliente())
							.append(cvsSeparatorValue).append(cliente.getApellidoCliente()).append(cvsSeparatorValue)
							.append(cliente.getAniosCliente()).append(cvsSeparatorValue).append(cliente.getNombreCategoria().toString())
							.append(System.lineSeparator());
				});

				pWriter.close();
				System.out.println("Datos de clientes exportados correctamente en formato csv");
			} catch (IOException error) {
				System.out.println("No se pudo crear el archivo");
			} finally {
				System.out.println("*********************************** ");
			}

		}
	}
	
	
	
	
}
