package co.com.almundo.ejercicio;

/**
 * Interface que determina el comportamiento de los empleados
 * @author Oscar Bermudez - oscar.bermudez87@gmail.com
 *
 */
public interface IDispatcher {
	
	/**
	 * Metodo encargado de atenter las solicitudes
	 * @param call
	 */
	void dispatchCall(Llamada call);
	
	
	/**
	 * Metodo encargado de asociar dispatcher en la caden
	 * @param dispatcher
	 */
	void setNextDispatch(IDispatcher dispatcher);
}
