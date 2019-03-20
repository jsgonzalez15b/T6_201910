package model.data_structures;

public class HashTableLinear<K extends Comparable<K>,V> implements IHashTableLinear<K,V>
{
	//Atributos
		/**
		 * Arreglo que almacena la informacion del Hash implementado para variar tamaño (NO ARREGLO DINAMICO)
		*/
		private Dupla[] hashTable;
		
		/**
		 * Numero de indices en uso
		*/
		private int nCarga;
		
		/**
		 * Factor de carga maximo
		*/
		private double factorCarga;
		
		//Constructor
		public HashTableLinear()
		{
			hashTable= new Dupla[10];
			factorCarga=0.75;
		}
		//Métodos
		
		/**
		 * Calcula el hash asociado a la llave
		 * @return.
		*/
		public int	hash(K pLlave)
		{
			return 1; //CAMBIAR
		}
		
		/**
		 * Actualiza la posicion de todos los elementos del hashTable segun su llave y el nuevo tamano
		*/
		public void	rehash(K pLlave)
		{
			//CAMBIAR
		}
		
		/**
		 * Agregar una dupla (K,V) a la tabla. Si la llave K existe reemplaza su valor V asociado
		 * V no puede ser null.
		*/
		public void	put(K pLlave, V pValor)
		{
			int pIndice= hash(pLlave);//calculo indice de la dupla
			
			//booleanos para indicar el estado de insercion de la dupla para linear colision
			boolean insertado = false;
			boolean colision = false;
			
			while(!insertado)//se recorre la tabla hasta insertar el elemento
			{
				if(hashTable[pIndice]==null)//cuando se encuente una dupla vacia esta es inicializada con la nueva dupla
				{
					hashTable[pIndice]= new Dupla(pLlave,pValor);
					insertado=true; //se actualiza estado de insercion
				}
				else
				{
					colision = true; //ya que la dupla esta ocupada ocurrio una colision
					pIndice++; //se busca en el siguiente bloque en la siguiente iteracion
					if(pIndice==hashTable.length) //cuando se llega al fin del arreglo se reanuda la busqueda desde cero
					{
						pIndice=0; 
					}
				}
			}
			
			if(!colision) //si no hubo colision se actualiza el numero de carga en uso
			{
				nCarga++;
				if(nCarga/hashTable.length>=factorCarga)
				{
					reHash();
				}
			}
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
