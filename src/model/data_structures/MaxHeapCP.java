package model.data_structures;
import java.lang.*;
/**
 *Heap de prioridad siempre ordenado de mayor a menor, mediante una implementación de una arreglo variable generica.
 */
public class MaxHeapCP <T extends Comparable<T>>
{
  //Atributos

	/**
	 * Lista generica.
	 */
	public ArregloDinamico<T> arreglo;
	
	/**
	 * numero de elementos en Heap, NO TAMANO DEL ARREGLO.
	 */
	public int cantidad;
	
 	/**
	 * altura actual del Heap.
	 */
	public int altura;
  
	//Metodo Constructor
	public MaxHeapCP ()
	{
		//Inicializa el maximo nodo como vacio, y la cantidad y altura como 0.
		arreglo= new ArregloDinamico<T>();
		altura = 0;
		cantidad= 0;
	}
	//Metodos del Heap

	/**
	 * Retorna true si Heap esta vacio
	 * @return true si Heap esta vacio, false de lo contrario
	 */
	public boolean isEmpty()
	{
		return arreglo==null;
	}
	
	/**
	 * Recalcula la altura actual del Heap cada vez que el metodo sea llamado
	 */
	public int recalcularAltura()
	{
		altura = (int) ((Math.log(arreglo.length+1) / Math.log(2))-1);
		return = altura;
	}
	
	/**
	 * Retorna el numero de elementos contenidos
	 * @return el numero de elementos contenidos
	 */
	public int size()
	{
		return arreglo.darTamano();
	}
	
	/**
	 *Agrega un elemento al final del Heap y lo ubica en la misma
	 */
	public void agregar(T pElemento)
	{
		//se agrega el elemento al final del arreglo dinamico
		arreglo.agregar(pElemento);
		//este elemento es elevado hasta su posicion correcta
		float(pElemento);
		//se actualiza la cantidad de elementos en el arbol y su altura
		cantidad=arreglo.darTamano();
		recalcularAltura();
	}
	
	/**
	 * Retorna el maximo elemento y lo elimina del Heao ordenando el arbol resultante
	 * @return el elemento maximo
	 */
	public T delMax()
	{
		//se cambia el primer por el ultimo termino y se elimina la ultima posicion
		T primeroProvisional= arreglo[0];
		arreglo[0]= arreglo.darUltimo();
		arreglo[arreglo.darTamano()]= primeroProvisional;
		maximoEliminado = arreglo.eliminar(primeroProvisional);
		
		
		swim(); //el primer (antiguo menor) elemento es hundido hasta su nueva posicion
		//se actualiza la cantidad de elementos en el arbol y su altura
		cantidad=arreglo.darTamano();
		recalcularAltura();
		
		return maximoEliminado; //se retorna el elemento eliminado de la lista
	}
	
	/**
	 * Se hunde el primer termino en el Heap hasta la posicion adecuada
	 */
	public void swim()
	{
		boolean terminamos=false; //no se ha hundido mas el primer elemento
		T intercambio =null;
		int i= 0;
		int j =2*i;
		while(i<cantidad && j<cantidad && !terminamos)
		{
			if(arreglo[i].compareTo(arreglo[j+1])<0)
			{
				//se intercambian los elementos y actualizan indices, primer hijo
				intercambio=arreglo[i];
				arreglo[i]=arreglo[j+1];
				arreglo[j+1]=intercambio;
				i=j+1;
				j=2*i;
			}
			else if(arreglo[i].compareTo(arreglo[j+1])<0)
			{
				//se intercambian los elementos y actualizan indices, segundo hijo
				intercambio=arreglo[i];
				arreglo[i]=arreglo[j+2];
				arreglo[j+2]=intercambio;
				i=j+2;
				j=2*i;
			}
			else
			{
				terminamos=true; //no hubo intercambio entre los hijos
			}
		}
		
		
		
	}

	/**
	 * Se eleva el ultimo termino en el Heap hasta la posicion adecuada
	 */
	public void float()
	{
		boolean terminamos=false; //no se ha elevado mas el ultimo elemento
		T intercambio =null;
		int i= arreglo.darTamano()-1;
		int j= 0;
		while(i>=0 && j>=0 && !terminamos)
		{
			if(i%2=1)
			{
				j=(i-1)/2; //es el primer hijo
			}
			else
			{
				j=(i-2)/2 //es el segundo hijo
			}
			if(arreglo[i].compareTo(arreglo[j+1])>0)
			{
				//se intercambian los elementos y actualizan indices, primer hijo mayor a padre
				intercambio=arreglo[i];
				arreglo[i]=arreglo[j];
				arreglo[j]=intercambio;
				i=j;
			}
			else
			{
				terminamos=true; //no hubo intercambio entre los hijos
			}
		}
		
		

	}

	public Iterador<T> iterator() {
		return new Iterador<T>(primero);
	}

  
}