package view;

import model.logic.MVCModelo;

public class MVCView 
{
	    /**
	     * Metodo constructor
	     */
	    public MVCView()
	    {
	    	
	    }
	    
		public void printMenu()
		{
			System.out.println("1. Cargar viajes por un trimestre seleccionado (1 o 2)");
			System.out.println("2. Generar muestra de datos");
			
			System.out.println("Dar el numero de opcion a resolver, luego oprimir tecla Return:");
		}

		public void printMessage(String mensaje) {

			System.out.println(mensaje);
		}		
		
		public void printModelo(MVCModelo modelo)
		{
			// TODO implementar
		}
}
