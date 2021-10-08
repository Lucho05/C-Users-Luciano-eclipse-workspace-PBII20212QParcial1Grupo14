package ar.edu.unlam.eva01Interfaz;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import ar.edu.unlam.eva01.*;

public class InterfazCarrito {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);

		/* Creo que los productos del mercado */

		Producto botellaAgua = new Bebida("Botella de agua mineral", 80.0);
		Producto botellaCocaCola = new Bebida("Botella de Coca Cola", 300.0);
		Producto lataCerveza = new Bebida("Lata de Cerveza", 150.0);
		Producto cajaLeche = new Lacteos("Caja de leche", 80.0, "25/12/2021");
		Producto sacheYogur = new Lacteos("Sache de yogur", 100.0, "25/12/2021");
		Producto paqueteManteca = new Lacteos("Paquete de manteca", 130.0, "25/12/2021");
		Producto bolsaPapa = new Vegetal("Bolsa de papa", 70.0, "25/12/2021");
		Producto bolsaTomate = new Vegetal("Bolsa de tomates", 60.0, "25/12/2021");
		Producto paqueteEspinaca = new Vegetal("Paquete de espinaca", 60.0, "25/12/2021");

		/* Creo los descuentos, los aplico y creo el carrito */

		Descuento treintaPorCientoAPartirDeTresUnidadesCocaCola = new Descuento(botellaCocaCola, 3, 0.3);
		Descuento veintePorCientoAPartirDeDosUnidadesCerveza = new Descuento(lataCerveza, 2, 0.2);
		Descuento treintaPorCientoAPartirDeTresUnidadesLeche = new Descuento(cajaLeche, 3, 0.3);

		HashSet<Descuento> productosEnPromocion = new HashSet<Descuento>();
		productosEnPromocion.add(treintaPorCientoAPartirDeTresUnidadesCocaCola);
		productosEnPromocion.add(veintePorCientoAPartirDeDosUnidadesCerveza);
		productosEnPromocion.add(treintaPorCientoAPartirDeTresUnidadesLeche);

		Carrito miCarrito = new Carrito(productosEnPromocion);

		ArrayList<Producto> listaDeProductos = miCarrito.getProductos();

		int opcionMenuPrincipal;
		int opcionIngresoTipoProducto;
		int opcionIngresoProducto;

		do {
			mostrarOpcionesMenuPrincipal();
			opcionMenuPrincipal = teclado.nextInt();

			switch (opcionMenuPrincipal) {
			case 1:
				mostraOpcionesTipoProducto();
				opcionIngresoTipoProducto = teclado.nextInt();

				switch (opcionIngresoTipoProducto) {
				case 1:
					mostrarOpcionesBebidas();
					opcionIngresoProducto = teclado.nextInt();

					switch (opcionIngresoProducto) {
					case 1:
						miCarrito.agregarProducto(botellaAgua);

						break;

					case 2:
						miCarrito.agregarProducto(botellaCocaCola);

						break;

					case 3:
						miCarrito.agregarProducto(lataCerveza);

						break;

					default:
						break;
					}

					break;

				case 2:
					mostrarOpcionesLacteos();
					opcionIngresoProducto = teclado.nextInt();

					switch (opcionIngresoProducto) {
					case 1:
						miCarrito.agregarProducto(cajaLeche);

						break;

					case 2:
						miCarrito.agregarProducto(sacheYogur);

						break;

					case 3:
						miCarrito.agregarProducto(paqueteManteca);

						break;

					default:
						break;
					}

					break;

				case 3:
					mostrarOpcionesVegetales();
					opcionIngresoProducto = teclado.nextInt();

					switch (opcionIngresoProducto) {
					case 1:
						miCarrito.agregarProducto(bolsaPapa);

						break;

					case 2:
						miCarrito.agregarProducto(bolsaTomate);

						break;

					case 3:
						miCarrito.agregarProducto(paqueteEspinaca);

						break;

					default:
						break;
					}

					break;

				default:
					break;
				}

				break;

			case 2:
				System.out.println("Usted tiene " + miCarrito.obtenerLaCantidadDeProductosEnElCarrito()
						+ " productos en su carrito.");
				listaDeProductos = miCarrito.getProductos();
				for (Producto actual : listaDeProductos) {
					System.out.println(actual.getNombre());
				}

				break;

			case 3:
				System.out.println(treintaPorCientoAPartirDeTresUnidadesCocaCola.getPorcentaje() * 100
						+ "% de descuento llevando "
						+ treintaPorCientoAPartirDeTresUnidadesCocaCola.getCantidadNecesariaParaAplicarElDescuento()
						+ " " + botellaCocaCola.getNombre());

				System.out.println(veintePorCientoAPartirDeDosUnidadesCerveza.getPorcentaje() * 100
						+ "% de descuento llevando "
						+ veintePorCientoAPartirDeDosUnidadesCerveza.getCantidadNecesariaParaAplicarElDescuento() + " "
						+ lataCerveza.getNombre());

				System.out.println(treintaPorCientoAPartirDeTresUnidadesLeche.getPorcentaje() * 100
						+ "% de descuento llevando "
						+ treintaPorCientoAPartirDeTresUnidadesLeche.getCantidadNecesariaParaAplicarElDescuento() + " "
						+ cajaLeche.getNombre());

				break;

			case 4:
				miCarrito.aplicarPromociones();
				System.out.println("Su total es de " + miCarrito.getImporteTotal() + " $");

				break;

			default:
				break;
			}

		} while (opcionMenuPrincipal < 5);

	}

	private static void mostrarOpcionesVegetales() {
		System.out.println("¿Que producto desea ingresar?");
		System.out.println("Ingrese (1) para ingresar una bolsa de papas.");
		System.out.println("Ingrese (2) para ingresar una bolsa de tomates.");
		System.out.println("Ingrese (3) para ingresar un paquete de espinaca.");
		System.out.println("Ingrese otra tecla para salir.");
	}

	private static void mostrarOpcionesLacteos() {
		System.out.println("¿Que producto desea ingresar?");
		System.out.println("Ingrese (1) para ingresar una caja de leche.");
		System.out.println("Ingrese (2) para ingresar un sache de yogur.");
		System.out.println("Ingrese (3) para ingresar un paquete de manteca.");
		System.out.println("Ingrese otra tecla para salir.");
	}

	private static void mostrarOpcionesBebidas() {
		System.out.println("¿Que producto desea ingresar?");
		System.out.println("Ingrese (1) para ingresar un botella de agua.");
		System.out.println("Ingrese (2) para ingresar una botella de Coca Cola.");
		System.out.println("Ingrese (3) para ingresar una lata de Cerveza.");
		System.out.println("Ingrese otra tecla para salir.");
	}

	private static void mostraOpcionesTipoProducto() {
		System.out.println("¿Que tipo de producto desea ingesar?");
		System.out.println("Ingrese (1) para ingresar una bebida.");
		System.out.println("Ingrese (2) para ingresar un lacteo.");
		System.out.println("Ingrese (3) para ingresar un vegetal.");
		System.out.println("Ingrese otra tecla para salir.");
	}

	private static void mostrarOpcionesMenuPrincipal() {
		System.out.println("**********************************");
		System.out.println("Bievenido al carrito");
		System.out.println("Ingrese (1) para ingresar un producto.");
		System.out.println("Ingrese (2) para ver sus productos en el carrito.");
		System.out.println("Ingrese (3) para ver los descuentos.");
		System.out.println("Ingrese (4) para ver el total con los descuentos aplicados.");
		System.out.println("Ingrese otra tecla para salir.");
	}

}
