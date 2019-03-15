package model.data_structures;

public interface IMaxHeapCP <T extends Comparable<T>>
{

	/**
	 * Retorna true si Heap esta vacio
	 * @return true si Heap esta vacio, false de lo contrario
	 */
	public boolean isEmpty();
  
	/**
	 * Recalcula la altura actual del Heap cada vez que el metodo sea llamado
	 */
	public int recalcularAltura();

	/**
	 * Retorna el numero de elementos contenidos
	 * @return el numero de elementos contenidos
	 */
	public int size();

	/**
	 * agrega un elemento al arreglo
	 */
	public void agregar(T pElemento);

	/**
	 * Retorna el maximo elemento y lo elimina
	 * @return maximo elemento
	 */
	public T delMax();
	
	/**
	 * Se hunde el primer termino en el Heap hasta la posicion adecuada
	 */
	public void swim();

	/**
	 * Se eleva el ultimo termino en el Heap hasta la posicion adecuada
	 */
	public void floate();

	public Iterador<T> iterator() ;
}
