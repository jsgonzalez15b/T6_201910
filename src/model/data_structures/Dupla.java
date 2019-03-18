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
		//ATRIBUTO PARA IMPLEMENTACION DE ARREGLO DINAMICO CHAINING
		
		
		
		//Método Constructor
		public Dupla (K pKey,V pValue)
		{
			
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

		//METODOS PARA IMPLEMENTACION DE ARREGLO DINAMICO CHAINING
}
