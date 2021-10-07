package ar.edu.unlam.eva01;

import java.util.ArrayList;
import java.util.HashSet;

public class Carrito {

	private ArrayList<Producto> productos;
	private HashSet<Descuento> descuentosActivos;
	private Boolean descuentosCalculados;

	public Carrito(HashSet<Descuento> activos) {
		this.descuentosActivos = activos;
		this.productos = new ArrayList<Producto>();
		this.descuentosCalculados = false;
	}

	public Integer obtenerLaCantidadDeProductosEnElCarrito() {
		return productos.size();
	}

	public boolean agregarProducto(Producto nuevo) {
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

	public void aplicarPromociones() {
		for (Producto actual : productos) {
			Descuento descuentoAAplicar = buscarDescuento(actual);
			if (descuentoAAplicar != null) {
				if (contarLaCantidadDeProductosIguales(actual) >= descuentoAAplicar.getCantidadNecesariaParaAplicarElDescuento()) {
					actual.setPrecio(actual.getPrecio() * (1 - descuentoAAplicar.getPorcentaje()));	
					break;
				}
			}
		}
		this.descuentosCalculados = true;
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
		if (descuentosCalculados == false) {
			aplicarPromociones();
		}
		for (Producto actual : productos) {
			importeTotal += actual.getPrecio();
		}
		return importeTotal;
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
