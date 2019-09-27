package model.data_structures;
import model.logic.MVCModelo;
import model.logic.NoExisteException;

public class MaxHeapCP <Item extends Comparable<Integer>>
{

	//----------------------------------------------------
	// atributos.
	//----------------------------------------------------
	private Nodo<Item> first;    // beginning of queue
	private Nodo<Item> last;     // end of queue
	private int n;               // number of elements on queue
	private int tamaño;          // tamaño del heap
	private MVCModelo modelo;    //vinculo a las linked list.

	//-----------------------------------------------------
	// Constructor
	//-----------------------------------------------------

	public MaxHeapCP()
	{
		first = null;
		last  = null;
		n = 0;
	}

	/*
	 * metoodo que se encarga de dar el numero de elementos.
	 * @return numero de elementos en el arreglo.
	 */
	public int darNumElementos() 
	{
		int respuesta;
		if(n==0)
		{
			respuesta = 0;
		}
		else
		{
			respuesta =n;
		}
		return respuesta;
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
	public  Item darMax()
	{
		return null;
	}
	/*
	 * metodo que se encarga de decir si el heap esta vacio o no.
	 * @return true si esta vacia.
	 * @return false si tiene algun elemento.
	 */
	public boolean esVacia ()
	{
		boolean respuesta =false;
		if(modelo.darTamano()==0)
		{
			respuesta =true;
		}
		return respuesta;
	}

}