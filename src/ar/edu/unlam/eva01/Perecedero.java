package ar.edu.unlam.eva01;

public abstract class Perecedero extends Producto{
	
	private String fechaDeVencimiento;

	public Perecedero(String nombre, Double precio, String fechaDeVencimiento) {
		super(nombre, precio);
		this.fechaDeVencimiento = fechaDeVencimiento;
	}

	public String getFechaDeVencimiento() {
		return fechaDeVencimiento;
	}

	public void setFechaDeVencimiento(String fechaDeVencimiento) {
		this.fechaDeVencimiento = fechaDeVencimiento;
	}

}
