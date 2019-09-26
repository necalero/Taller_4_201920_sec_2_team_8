package model.logic;


import java.io.FileReader;

import com.opencsv.CSVReader;

import model.data_structures.DoublyLinkedList;


/**
 * Definicion del modelo del mundo
 *
 */
public class MVCModelo {
	/**
	 * Atributos del modelo del mundo
	 */
	private DoublyLinkedList datos;
	
	//-----------------------------------------------------------------
	
	/**
	 * Constructor del modelo del mundo
	 */
	public MVCModelo()
	{
	}
	
	//-----------------------------------------------------------------
	
	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamano()
	{
		return datos.darSize();
	}

	/**
	 * Requerimiento de agregar dato
	 * @param dato
	 */
	public void cargar(int trimestre) throws NoExisteException
	{	
		CSVReader reader;
		if(trimestre==1)
		{
			FileReader fr = new FileReader("./data/bogota-cadastral-2018-1-All-HourlyAggregate.csv");
			reader = new CSVReader(fr);
			String [] nextLine=reader.readNext();
			while (nextLine != null) 
			{
				datos.aņadirUltimo(new UBERTrip(nextLine[0],nextLine[1],nextLine[2],nextLine[3],nextLine[4],nextLine[5], nextLine[6]));
				nextLine = reader.readNext();
			}
		} 
		else if(trimestre==2)
		{
			FileReader fr = new FileReader("./data/bogota-cadastral-2018-2-All-HourlyAggregate.csv");
			reader = new CSVReader(fr);
			String [] nextLine=reader.readNext();
			while (nextLine != null) 
			{
				datos.aņadirUltimo(new UBERTrip(nextLine[0],nextLine[1],nextLine[2],nextLine[3],nextLine[4],nextLine[5], nextLine[6]));
				nextLine = reader.readNext();
			}
		} 
		else
		{
			throw new NoExisteException("No existe el trimestre ingresado");
		}
	}
}