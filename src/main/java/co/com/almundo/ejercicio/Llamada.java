package co.com.almundo.ejercicio;

import java.util.Calendar;

/**
 * Clase que representa la información de una llamada
 * @author Oscar Bermudez - oscar.bermudez87@gmail.com
 * @date 22/08/2018
 */
public class Llamada {
	
	private long idLlamada;
	private int duracion;
	private Calendar finLlamda;
	
	public Llamada(){}
	public Llamada(long idLlamada, int duracion){
		
		this.idLlamada = idLlamada;
		this.duracion=duracion;
	}
	
	
	public Calendar getFinLlamda() {
		return finLlamda;
	}
	public void setFinLlamda(Calendar finLlamda) {
		finLlamda.add(Calendar.SECOND, duracion);
		this.finLlamda = finLlamda;
	}
	public long getIdLlamada() {
		return idLlamada;
	}
	public void setIdLlamada(long idLlamada) {
		this.idLlamada = idLlamada;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
}
