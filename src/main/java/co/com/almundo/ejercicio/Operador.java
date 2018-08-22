package co.com.almundo.ejercicio;


import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase que representa la atencion de solicitudes por parte de operadores
 * @author Oscar Bermudez - oscar.bermudez87@gmail.com
 *
 */
public class Operador implements IDispatcher {

	private IDispatcher nextDispatcher;
	private static Map<Long,Llamada> empleados = new HashMap<>();
	
	/**
	 * Agrega un empleado 
	 * @param idEmpleado Identificador del empleado
	 */
	public void agregarEmpleado(long idEmpleado){
		
		empleados.put(idEmpleado, null);
	}
	
	@Override
	public void dispatchCall(Llamada call) {
		
		if (validarOperadores(call)) {
			System.out.println("LLamada atentida por un operador");
			
		}else{
			System.out.println("Llamada " + call.getIdLlamada() + " no pudo ser atendida por un operador " );
			nextDispatcher.dispatchCall(call);
		}

	}

	@Override
	public void setNextDispatch(IDispatcher dispatcher) {
		this.nextDispatcher = dispatcher;

	}
	
	/**
	 * Metodo encargado de asignar una llamada a operadores
	 * @param llamada
	 * @return
	 */
	private synchronized  boolean validarOperadores(final Llamada llamada) {
		 
		
		 boolean asignado = false;
		
		//Valida si un operador ya se encuentra disponible dependiendo la duracion de la llamada
		empleados.forEach((k,v)->{
			
			if (v != null && Calendar.getInstance().after(v.getFinLlamda())) {
				System.out.println("Liberando operador: " + k + " LLamada: " + v.getIdLlamada() );
				empleados.put(k, null);
			}
		});
		
		
		//Valida si algun operador puede atender la solicitud
		for (Long key : empleados.keySet()) {
			if (empleados.get(key) == null) {
				System.out.println("Asignado llamada " + llamada.getIdLlamada() + " Duración " +llamada.getDuracion() +  " al operador: " + key);
				//Se asigna el tiempo en que finaliza la llamada
				llamada.setFinLlamda(Calendar.getInstance());
				empleados.put(key, llamada);
				ContadorSingleton.incrementar();
				asignado = true;
				break;
			}
		}
		
		return asignado;
		

	}

}
