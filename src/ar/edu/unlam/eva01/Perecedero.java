package ar.edu.unlam.eva01;

import java.util.Date;

public abstract class Perecedero extends Producto{
	
	private Date fechaDeVencimiento;

	public Perecedero(String nombre, Double precio, Date fechaDeVencimiento) {
		super(nombre, precio);
		this.fechaDeVencimiento = fechaDeVencimiento;
	}

	public Date getFechaDeVencimiento() {
		return fechaDeVencimiento;
	}

	public void setFechaDeVencimiento(Date fechaDeVencimiento) {
		this.fechaDeVencimiento = fechaDeVencimiento;
	}

}
