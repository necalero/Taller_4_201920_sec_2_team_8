package model.data_structures;
import java.util.Comparator;

import com.sun.javafx.css.StyleCache.Key;

import model.logic.MVCModelo;
import model.logic.NoExisteException;

public class MaxColaCP <Item extends Comparable<Integer>>
{
	//----------------------------------------------------
	// atributos.
	//----------------------------------------------------
	private Key[] pq;                    // store items at indices 1 to n
	private Comparator<Key> comparator;  // optional comparator
	private Nodo<Item> first;    // beginning of queue
	private Nodo<Item> last;     // end of queue
	
	
	private int tamaño;          // tamaño del heap
	private MVCModelo modelo;    //vinculo a las linked list.
	private Nodo<Item> inicio;    // beginning of queue
	private Nodo<Item> ultimo;     // end of queue
	private int n;               // number of elements on queue
	//-----------------------------------------------------
	// Constructor
	//-----------------------------------------------------

	public MaxColaCP()
	{
		inicio = null;
		ultimo = null;
	}

	/*
	 * metoodo que se encarga de dar el numero de elementos.
	 * @return numero de elementos en el arreglo.
	 */
	public int darNumElementos() 
	{
		int respuesta =0;
		if(esVacia()==true)
		{
			respuesta =0;
		}
		else
		{
			respuesta = modelo.darTamano();
		}
		return respuesta;
	}

	/*
	 * el metodo se encarga de agregar un elemento en el heap de prioridad.
	 */
	public void agregar(Item t, int prioridad) 
	{
		Nodo nuevo = new Nodo(t, prioridad);

		if (inicio == null) {
			inicio = ultimo = nuevo;
		} else {

			if (inicio.darPrioridad()> prioridad) {
				nuevo.cambiarSiguiente(inicio);
				inicio=nuevo;
			}else{
				Nodo ant=null;
				Nodo sig=inicio;
				while(sig!=null && prioridad>=sig.darPrioridad()){
					ant=sig;
					sig=sig.darSiguiente();
				}
				nuevo.cambiarSiguiente(sig);
				ant.cambiarSiguiente(nuevo);
				if(sig==null){
					ultimo=nuevo;
				}

			}

		}
	}
	/*
	 * el metodo se encarga de sacar el mayor elemento del heap de prioridad.
	 * cambiar a que saque el de prioridad.
	 */
	public Item sacarMax () throws NoExisteException
	{
		if (esVacia()) throw new NoExisteException("Queue underflow");
		Item item = inicio.darItem();
		inicio= inicio.darSiguiente();
		n--;
		if (esVacia()) ultimo = null;   // to avoid loitering
		return item;
	}
	/*
	 * se encarga de retornar el elemento maximo del heap.
	 */
	public Item darMax() throws NoExisteException
	{
		if (esVacia()) throw new NoExisteException("Queue underflow");
		Item item = last.darItem();
		last = last.darAnterior();
		n--;
		if (esVacia()) last = null;   // to avoid loitering
		return item;
	}
	/*
	 * metodo que se encarga de decir si el heap esta vacio o no.
	 * @return true si esta vacia.
	 * @return false si tiene algun elemento.
	 */
	public boolean esVacia()
	{
		boolean respuesta =false;
		if(modelo.darTamano()==0)
		{
			respuesta =true;
		}
		return respuesta;
	}
}