package ar.edu.unlam.parcial01;

import java.util.ArrayList;
import java.util.HashSet;

public class Carrito {

	private ArrayList<Producto> productos;
	private HashSet<Descuento> descuentosActivos;

	public Carrito(HashSet<Descuento> descuentos) {
		this.descuentosActivos = descuentos;
		this.productos = new ArrayList<Producto>();
	}

	public Integer obtenerLaCantidadDeProductosEnElCarrito() {
		return productos.size();
	}

	public Boolean agregarProducto(Producto nuevo) {
		return productos.add(nuevo);
	}


	public Integer contarLaCantidadDeProductosIguales(Producto nuevo) {
		Integer cantidadDeProductosIguales = 0;

		for (Producto actual : productos) {
			if (actual.equals(nuevo)) {
				cantidadDeProductosIguales++;
			}
		}

		return cantidadDeProductosIguales;
	}

	public Double aplicarDescuentos() {
		Double importeDescuento = 0.0;

		for (Producto actual : productos) {
			Descuento descuentoAAplicar = buscarDescuento(actual);
			if (descuentoAAplicar != null) 
				if (contarLaCantidadDeProductosIguales(actual) >= descuentoAAplicar
						.getCantidadNecesariaParaAplicarElDescuento()) {
					importeDescuento += (actual.getPrecio() * (descuentoAAplicar.getPorcentaje()));				
			}
		}
		return importeDescuento;
	}

	public Descuento buscarDescuento(Producto buscado) {
		for (Descuento actual : descuentosActivos) {
			if (actual.getEnPromocion().equals(buscado)) {
				return actual;
			}
		}
		return null;
	}

	public Double getImporteTotal() {
		Double importeTotal = 0.0;

		for (Producto actual : productos) {
			importeTotal += actual.getPrecio();
		}
		return importeTotal - aplicarDescuentos();
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setListaProductos(ArrayList<Producto> listaProductos) {
		this.productos = listaProductos;
	}

	public void eliminarProducto(Producto productoAEliminar) {
		this.productos.remove(productoAEliminar);
	}
}
