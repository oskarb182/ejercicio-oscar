package co.com.almundo.ejercicio;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Clase de prueba
 * @author oskar
 *
 */
public class OperadorTest {

	
	@Test
	public void unicoHilo() {

		Operador operador = new Operador();
		Supervisor supervisor = new Supervisor();
		Director director = new Director();

		operador.setNextDispatch(supervisor);
		supervisor.setNextDispatch(director);
		director.setNextDispatch(operador);

		// Se agregan 6 empleados
		for (int i = 1; i <= 6; i++) {
			operador.agregarEmpleado(i); 
		}

		// Se agregan 2 supervisores
		for (int i = 1; i <= 2; i++) {
			supervisor.agregarEmpleado(i);
		}

		// Se agregan 2 directores
		for (int i = 1; i <= 2; i++) {
			director.agregarEmpleado(i);
		}

	
		new Thread(getRunnable(operador, 1,20)).start();

		
		try {
			Thread.sleep(30000l);
			System.out.println("Finalizando prueba");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void multiplesHilos() {

		Operador operador = new Operador();
		Supervisor supervisor = new Supervisor();
		Director director = new Director();

		operador.setNextDispatch(supervisor);
		supervisor.setNextDispatch(director);
		director.setNextDispatch(operador);

		// Se agregan 6 empleados
		for (int i = 1; i <= 7; i++) {
			operador.agregarEmpleado(i); 
		}

		// Se agregan 2 supervisores
		for (int i = 1; i <= 2; i++) {
			supervisor.agregarEmpleado(i);
		}

		// Se agregan 1 directores
		for (int i = 1; i <= 1; i++) {
			director.agregarEmpleado(i);
		}

	
		new Thread(getRunnable(operador, 1,5)).start();
		new Thread(getRunnable(operador, 6,10)).start();
		new Thread(getRunnable(operador, 11,20)).start();
		new Thread(getRunnable(operador, 21,25)).start();
		new Thread(getRunnable(operador, 26,30)).start();
		new Thread(getRunnable(operador, 31,35)).start();
		
		try {
			Thread.sleep(30000l);
			System.out.println("Finalizando prueba");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * Metodo para simular tiempo aletorio de llamadas
	 * @param maximum
	 * @param minimum
	 * @return
	 */
	public static int getRandomInteger(int maximum, int minimum) {
		return ((int) (Math.random() * (maximum - minimum))) + minimum;
	}
	
	/**
	 * Metodo utiliario para generar la simulación de identificadores de  llamadas
	 * @param operador
	 * @param init
	 * @param end
	 * @return
	 */
	public Runnable getRunnable(Operador operador, int init, int end){
		Runnable rn3 = new Runnable() {

			@Override
			public void run() {
				
				List<Llamada> llamadas3 = new ArrayList<>();
				for (int i = init; i <= end; i++) {
					llamadas3.add(new Llamada(i, getRandomInteger(10,5)));

				}

				for (Llamada llamada : llamadas3) {

					operador.dispatchCall(llamada);
				}

			}
		};
		return rn3;
	}

}
