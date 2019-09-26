package model.logic;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;

import model.data_structures.DoublyLinkedList;
import model.data_structures.UBERTrip;


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
	 * @throws IOException 
	 */
	@SuppressWarnings("unchecked")
	public void cargar(int trimestre) throws NoExisteException, IOException
	{	
		CSVReader reader;
		if(trimestre==1)
		{
			FileReader fr = new FileReader("./data/bogota-cadastral-2018-1-All-HourlyAggregate.csv");
			reader = new CSVReader(fr);
			String [] nextLine=reader.readNext();
			while (nextLine != null) 
			{
				datos.anadirUltimo(new UBERTrip(nextLine[0],nextLine[1],nextLine[2],nextLine[3],nextLine[4],nextLine[5], nextLine[6]));
				nextLine = reader.readNext();
			}
			reader.close();
		} 
		else if(trimestre==2)
		{
			FileReader fr = new FileReader("./data/bogota-cadastral-2018-2-All-HourlyAggregate.csv");
			reader = new CSVReader(fr);
			String [] nextLine=reader.readNext();
			while (nextLine != null) 
			{
				datos.anadirUltimo(new UBERTrip(nextLine[0],nextLine[1],nextLine[2],nextLine[3],nextLine[4],nextLine[5], nextLine[6]));
				nextLine = reader.readNext();
			}
			reader.close();
		} 
		else
		{
			throw new NoExisteException("No existe el trimestre ingresado");
		}
	}
}