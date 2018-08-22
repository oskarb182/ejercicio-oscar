package co.com.almundo.ejercicio;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Clase para llevar el control del total llamadas atentidas
 * @author Oscar Bermudez - oscar.bermudez87@gmail.com
 *
 */
public class ContadorSingleton {
	
	private ContadorSingleton(){}
	
	private static AtomicInteger totalAtentidos = new AtomicInteger(0);
	
	/**
	 * Incrementa el total de llamadas atentidas
	 */
	public static void incrementar(){
		System.out.println("Total atendidos: "+ totalAtentidos.incrementAndGet());
		
	}

}
