package model.data_structures;

public class ArregloDinamico<T extends Comparable<T>> implements IArregloDinamico<T>  {
	/**
	 * Capacidad maxima del arreglo
	 */
        private int tamanoMax;
	/**
	 * Numero de elementos en el arreglo (de forma compacta desde la posicion 0)
	 */
        private int tamanoAct;
	
	/**
	 * ultimo elemento de la lista
	 */
        private T ultimo;
        /**
         * Arreglo de elementos de tamaNo maximo
         */
        private T elementos[ ];

        /**
         * Construir un arreglo con la capacidad maxima inicial.
         * @param max Capacidad maxima inicial
         */
		public ArregloDinamico( int max )
        {
               elementos = (T[]) new Object[max];
               tamanoMax = max;
               tamanoAct = 0;
	       ultimo = null;
        }
	
	/**
         * retorna el ultimo elemento del arreglo
         */
		public T darUltimo()
        {
               return ultimo;
        }
        
		public void agregar( T dato )
        {
               if ( tamanoAct == tamanoMax )
               {  // caso de arreglo lleno (aumentar tamaNo)
                    tamanoMax = 2 * tamanoMax;
                    T [ ] copia = elementos;
                    elementos = (T[])new Object[tamanoMax];
                    for ( int i = 0; i < tamanoAct; i++)
                    {
                     	 elementos[i] = copia[i];
                    } 
            	    System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
               }	
               elementos[tamanoAct] = dato;
	       ultimo = dato; //se actualiza el ultimo elemento
               tamanoAct++;
       }

		public int darTamano() {
			// TODO implementar
			return tamanoAct;
		}

		public T darElemento(int i) {
			// TODO implementar
			T buscado=null;   
			for(int j=0; j<tamanoAct && buscado==null;j++) {
				if(j==i) {
					buscado=elementos[j];
				}
			}
			return buscado;
		}

		public T buscar(T dato) {
			// TODO implementar
			// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.
			int inicio=0;
			int fin=elementos.length-1;
			T buscado=null; 
			while (inicio<=fin && buscado==null) {
				int mitad=(inicio+fin)/2;
				if(dato.compareTo(elementos[mitad])==0){
					buscado=elementos[mitad];
				}else if(dato.compareTo(elementos[mitad])>0) {
					inicio=mitad+1;
				}else {
					fin=mitad-1;
				}
			}
			return buscado; 
		}

		public T eliminar(T dato) {
			// TODO implementar
			// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.
			T aEliminar=null;
			for (int i=0; i<elementos.length; i++) {
				if(elementos[i].compareTo(dato)==0) {
					aEliminar=elementos[i];
					for(int j=i; j<elementos.length-1; j++) {
						elementos[j]=elementos[j+1];
					}
				}
			}
			tamanoAct--;
			ultimo= elementos[elementos.length-1]; //se actualiza el ultimo elemento
			return aEliminar;
		}




}
