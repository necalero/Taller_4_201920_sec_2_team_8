package model.data_structures;
import java.util.Comparator;

import com.sun.javafx.css.StyleCache.Key;

import model.logic.MVCModelo;
import model.logic.NoExisteException;

public class MaxHeapCP <Item extends Comparable<Integer>>
{

	//----------------------------------------------------
	// atributos.
	//----------------------------------------------------

	private Key[] pq;                    // store items at indices 1 to n
	private Comparator<Key> comparator;  // optional comparator
	private Nodo<Item> first;    // beginning of queue
	private Nodo<Item> last;     // end of queue
	private int n;               // number of elements on queue
	private int tamaño;          // tamaño del heap
	private MVCModelo modelo;    //vinculo a las linked list.

	//-----------------------------------------------------
	// Constructor
	//-----------------------------------------------------

	/**
	 * Initializes an empty priority queue with the given initial capacity.
	 *
	 * @param  initCapacity the initial capacity of this priority queue
	 */
	public MaxHeapCP(int initCapacity) 
	{
		pq = (Key[]) new Object[initCapacity + 1];
		n = 0;
	}


	/**
	 * Initializes an empty priority queue.
	 */
	public MaxHeapCP() 
	{
		this(1);
	}

	/*
	 * metoodo que se encarga de dar el numero de elementos.
	 * @return numero de elementos en el arreglo.
	 */
	public int darNumElementos() 
	{
		return n;
	}

	/*
	 * el metodo se encarga de agregar un elemento en el heap de prioridad.
	 */
	public void agregar(Item item) 
	{
		Nodo<Item> oldlast = last;
		last = new Nodo<Item>(null);
		last.cambiarItem(item);
		last.cambiarSiguiente(null); 
		if (esVacia()) first = last;
		else oldlast.cambiarSiguiente(last); 
		n++;
	}
	/*
	 * el metodo se encarga de sacar el mayor elemento del heap de prioridad.
	 * debe sacar el maximo 
	 */
	public Item sacarMax () throws NoExisteException
	{
		if (esVacia()) throw new NoExisteException("Queue underflow");
		Item item = first.darItem();
		first = first.darSiguiente();
		n--;
		if (esVacia()) last = null;   // to avoid loitering
		return item;
	}
	/*
	 * se encarga de retornar el elemento maximo del heap.
	 */
	public  Key darMax() throws NoExisteException
	{
		if (n ==0) throw new NoExisteException("No existe el elemento");
		return pq[1];
	}
	/*
	 * metodo que se encarga de decir si el heap esta vacio o no.
	 * @return true si esta vacia.
	 * @return false si tiene algun elemento.
	 */
	public boolean esVacia ()
	{
		boolean respuesta =false;
		if(n ==0)
		{
			respuesta =true;
		}
		return respuesta;
	}

}