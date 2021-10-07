package ar.edu.unlam.eva01;

public class Descuento {
	
	private Producto enPromocion;
	private Integer cantidadNecesariaParaAplicarElDescuento;
	private Double porcentaje;
	
	public Descuento(Producto nuevo, Integer cantidadNecesariaParaAplicarElDescuento, Double porcentaje) {
		this.enPromocion = nuevo;
		this.cantidadNecesariaParaAplicarElDescuento = cantidadNecesariaParaAplicarElDescuento;
		this.porcentaje = porcentaje;
	}
	
	public Descuento(Producto nuevo) {
		this.enPromocion = nuevo;
	}

	public Producto getEnPromocion() {
		return enPromocion;
	}
	
	public void setEnPromocion(Producto enPromocion) {
		this.enPromocion = enPromocion;
	}

	public Integer getCantidadNecesariaParaAplicarElDescuento() {
		return cantidadNecesariaParaAplicarElDescuento;
	}

	public void setCantidadNecesariaParaAplicarElDescuento(Integer cantidadNecesariaParaAplicarElDescuento) {
		this.cantidadNecesariaParaAplicarElDescuento = cantidadNecesariaParaAplicarElDescuento;
	}

	public Double getPorcentaje() {
		return porcentaje;
	}
	
	public void setPorcentaje(Double porcentaje) {
		this.porcentaje = porcentaje;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((enPromocion == null) ? 0 : enPromocion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Descuento other = (Descuento) obj;
		if (enPromocion == null) {
			if (other.enPromocion != null)
				return false;
		} else if (!enPromocion.equals(other.enPromocion))
			return false;
		return true;
	}
	
	
}
