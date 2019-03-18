package view;

import model.data_structures.IQueue;
import model.data_structures.IStack;
import model.vo.VOMovingViolations;

public class MovingViolationsManagerView 
{
	public MovingViolationsManagerView() {
		
	}
	
	public void printMenu() {
		System.out.println("---------ISIS 1206 - Estructuras de datos----------");
		System.out.println("---------------------Taller 3----------------------");
		System.out.println("1. Verificar que no hay ObjectId repetidos entre las facturas");
		System.out.println("2. Obtener infracciones por AdressId en una tabla Hash linear");
		System.out.println("3. Obtener infracciones por AdressId en una tabla Hash chaining");
		
	}
	
	public void printOBJECTID(IQueue<Integer> lista) {
		System.out.println("Se encontraron "+ lista.size() + " elementos");
		int vez=0; 
		for (Integer Id : lista) 
		{
			System.out.println(Id+"");;
			vez++; 
			if(vez==lista.size()){
				break; 
			}
		}
	}
	
	public void printMensage(String mensaje) {
		System.out.println(mensaje);
	}


}
