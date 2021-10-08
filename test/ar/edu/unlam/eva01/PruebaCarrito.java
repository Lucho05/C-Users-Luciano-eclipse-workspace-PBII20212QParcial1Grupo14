package ar.edu.unlam.eva01;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashSet;

import org.junit.Test;

public class PruebaCarrito {

	@Test
	public void testQueVerificaQueElCarritoNoEstaVacío() {
		Carrito dia = new Carrito(null);

		Producto lenteja = new Vegetal("Lenteja", 80.0, "25/12/2021");
		dia.agregarProducto(lenteja);

		assertNotNull(dia.getProductos());
	}

	@Test
	public void testQueVerificaTenerElCarritoConProducto() {
		Carrito dia = new Carrito(null);

		Producto zanahoria = new Vegetal("Zanahorias", 75.0, "25/12/2021");
		Producto papa = new Vegetal("Papa Blanca", 160.0, "25/12/2021");
		dia.agregarProducto(papa);
		dia.agregarProducto(zanahoria);
		Integer valorEsperado = 2;
		Integer valorObtenido = dia.obtenerLaCantidadDeProductosEnElCarrito();

		assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void testQueVerificaTenerElCarritoConVariosProductos() {
		Carrito dia = new Carrito(null);

		Producto tofu = new Vegetal("Tofu", 80.0, "25/12/2021");
		Producto algas = new Vegetal("Algas", 60.0, "25/12/2021");
		Producto garbanzos = new Vegetal("Garbanzos", 40.0, "25/12/2021");
		Producto milanesaDeSoja = new Vegetal("Milanesa de soja", 80.0, "25/12/2021");

		dia.agregarProducto(tofu);
		dia.agregarProducto(algas);
		dia.agregarProducto(garbanzos);
		dia.agregarProducto(milanesaDeSoja);

		Integer valorEsperado = 4;
		Integer valorObtenido = dia.obtenerLaCantidadDeProductosEnElCarrito();

		assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void testQueVerificaAplicarElDescuento() {

		Producto anco = new Vegetal("Anco", 160.0, "25/12/2021");
		Producto limon = new Vegetal("Limón", 20.0, "25/12/2021");
		Producto leche = new Lacteos("Leche Entera", 120.0, "25/12/2021");
		Producto yogurt = new Lacteos("Yogurt Cremoso", 40.0, "25/12/2021");
		Producto cocacola = new Bebida("Coca Cola", 230.0);
		Producto schneider = new Bebida("Cerveza Schneider Retornable 970 ml.", 130.0);

		Descuento treintaPorCientoAPartirDeTresUnidades = new Descuento(cocacola, 3, 0.3);
		Descuento veintePorCientoAPartirDeDosUnidades = new Descuento(schneider, 2, 0.2);

		HashSet<Descuento> productosEnPromocion = new HashSet<Descuento>();
		productosEnPromocion.add(treintaPorCientoAPartirDeTresUnidades);
		productosEnPromocion.add(veintePorCientoAPartirDeDosUnidades);

		Carrito dia = new Carrito(productosEnPromocion);

		dia.agregarProducto(anco);
		dia.agregarProducto(limon);
		dia.agregarProducto(leche);
		dia.agregarProducto(yogurt);
		dia.agregarProducto(yogurt);
		dia.agregarProducto(yogurt);
		dia.agregarProducto(cocacola);
		dia.agregarProducto(cocacola);
		dia.agregarProducto(schneider);
		dia.agregarProducto(schneider);
		dia.agregarProducto(schneider);
		dia.agregarProducto(schneider);

		Double valorEsperado = 1296.0;
		Double valorObtenido = dia.getImporteTotal();

		assertEquals(valorEsperado, valorObtenido);

	}
}
