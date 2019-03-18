package model.data_structures;

public class HashTableLinear<K extends Comparable<K>,V> implements IHashTableLinear<K,V>
{
	//Atributos
		/**
		 * Arreglo que almacena la informacion del Hash (NO ARREGLO DINAMICO)
		*/
		private Dupla[] hashTable;
		/**
		 * Numero de llaves en uso
		*/
		private int nKeys;
		
		//Constructor
		public HashTableLinear()
		{
			
		}
		//M�todos
		/**
		 * Agregar una dupla (K,V) a la tabla. Si la llave K existe reemplaza su valor V asociado
		 * V no puede ser null.
		*/
		public void	put(K pLlave, V pValor)
		{
			
		}
		/**
		 * Obtener el valor V asociada a la llave K. V no puede ser null.
		*/
		public V	get(K pLlave)
		{
			return null;
		}
		/**
		 * Borrar la dupla asociada a la llave K. Se obtiene el valor V asociado a la llave K.
		 * Se obtiene null si la llave K no existe.
		*/
		public V	delete(K pLlave)
		{
			return null;
		}
		/**
		 * Conjunto de llaves K presentes en la tabla.
		*/
		public Iterador<K>	keys()
		{
			return null;
		}

}
