package co.com.almundo.ejercicio;

import java.util.Calendar;

/**
 * Clase que representa un empleado
 * @author Oscar Bermudez - oscar.bermudez87@gmail.com
 *
 */
public class Empleado {
	
	private Calendar timeCall; 
	private long idEmpleado;
	
	public Calendar getTimeCall() {
		return timeCall;
	}
	public void setTimeCall(Calendar timeCall) {
		this.timeCall = timeCall;
	}
	public long getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
}
