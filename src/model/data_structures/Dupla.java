package model.data_structures;

/** Clase que permite el almacenamiento de objetos compuestos de una llave y un valor genericos
 *  Implementa los metodos necesarios para ambas estructuras de datos (HashTableLinear y HashTableChaining)
 */
public class Dupla<K extends Comparable<K>,V> 
{
	//Atributos

		/**
		 * llave generica. 
		 */
		private K theKey;
		
		/**
		 * valor generica. 
		 */
		private V theValue;

		/**
		 * Lista de tamano variable para implementacion chaining
		 */
		private ArregloDinamico chain;
		
		
		
		//Metodo Constructor
		public Dupla (K pKey,V pValue)
		{
			//se inicializan la llave y valor de la dupla
			theKey = pKey;
			theValue = pValue;
			
			//Inicialmente un unico elemento que corresponde a una llave
			chain= new ArregloDinamico<K, V>(1); //para linear siempre es de tamano 1
		}

		//Metodos del nodo

		/**
		 * metodo encargado de retornar el valor almacenado en la dupla. 
		 */
		public V getValue()
		{
			return theValue;
		}
		
		/**
		 * metodo encargado de retornar la llave almacenada en la dupla. 
		 */
		public K getKey()
		{
			return theKey;
		}

		/**
		 * metodo que añade un elemento a la llave en chaining. 
		 */
		public void add(V pValue)
		{
			Dupla nuevaDupla = new Dupla(theKey, pValue);
			chain.agregar(nuevaDupla);
		}
}
