package controller;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.opencsv.CSVReader;
import com.sun.corba.se.impl.orbutil.graph.Node;

import model.data_structures.IQueue;
import model.data_structures.IStack;
import model.data_structures.Iterador;
import model.data_structures.Nodo;
import model.data_structures.Queue;
import model.data_structures.Stack;
import model.vo.VOMovingViolations;
import view.MovingViolationsManagerView;

public class Controller 
{

	private MovingViolationsManagerView view;

	/**
	 * Cola donde se van a cargar los datos de los archivos
	 */
	private IQueue<VOMovingViolations> movingViolationsQueue;

	/**
	 * Pila donde se van a cargar los datos de los archivos
	 */
	private IStack<VOMovingViolations> movingViolationsStack;


	public Controller() {
		view = new MovingViolationsManagerView();

		//TODO, inicializar la pila y la cola
		movingViolationsQueue = null;
		movingViolationsStack = null;
	}

	public void run() {
		Scanner sc = new Scanner(System.in);
		boolean fin = false;

		while(!fin)
		{
			view.printMenu();

			int option = sc.nextInt();
			//carga del primer semestre de infracciones
			this.loadMovingViolations(1);
			System.out.println("Hay "+movingViolationsQueue.size()+" elementos en cola y "+""+movingViolationsStack.size()+" en pila");
			
			switch(option)
			{
			case 1:
				IStack<Integer> lista= verificarObjectId(); 
				if(lista.isEmpty()){
					view.printMensage("No hay OBJECTID repetidos");
					break;
				}else{

					break;
				}

			case 2:
				break;
				
			case 3:
				break;
			}
		}
	}


	/**
	 * Metodo para carga de archivos segun semestre de seleccion
	 * @param num Semestre a cargar datos (1 para primer semestre, cualquier otro numero para segundo semestre)
	 */
	public void loadMovingViolations(int num)
	{
		//estructuras de almacenamiento de infracciones
		movingViolationsQueue=new Queue<VOMovingViolations>();
		movingViolationsStack= new Stack<VOMovingViolations>();
		//creacion e inicializacion de arreglo con nombre de los archivos de infracciones por mes 
		String[] nombresArchivos=new String[12];
		nombresArchivos[0]="."+File.separator+"data"+File.separator+"Moving_Violations_Issued_in_January_2018_ordered.csv";
		nombresArchivos[1]="."+File.separator+"data"+File.separator+"Moving_Violations_Issued_in_February_2018_ordered.csv";
		nombresArchivos[2]="."+File.separator+"data"+File.separator+"Moving_Violations_Issued_in_March_2018.csv";
		nombresArchivos[3]="."+File.separator+"data"+File.separator+"Moving_Violations_Issued_in_April_2018.csv";
		nombresArchivos[4]="."+File.separator+"data"+File.separator+"Moving_Violations_Issued_in_May_2018.csv";
		nombresArchivos[5]="."+File.separator+"data"+File.separator+"Moving_Violations_Issued_in_June_2018.csv";
		nombresArchivos[6]="."+File.separator+"data"+File.separator+"Moving_Violations_Issued_in_July_2018.csv";
		nombresArchivos[7]="."+File.separator+"data"+File.separator+"Moving_Violations_Issued_in_August_2018.csv";
		nombresArchivos[8]="."+File.separator+"data"+File.separator+"Moving_Violations_Issued_in_September_2018.csv";
		nombresArchivos[9]="."+File.separator+"data"+File.separator+"Moving_Violations_Issued_in_October_2018.csv";
		nombresArchivos[10]="."+File.separator+"data"+File.separator+"Moving_Violations_Issued_in_November_2018.csv";
		nombresArchivos[11]="."+File.separator+"data"+File.separator+"Moving_Violations_Issued_in_December_2018.csv";
		
		CSVReader reader=null;
		int inicio=-1; 
		if(num==1)
		{
			inicio=0; //lectura de archivos a partir del primer mes.
		}
		else
		{
			inicio=6; //lectura de archivos a partir del septimo mes.
		}
		for(int i=inicio; i<inicio+6;i++)//ciclo para lectura de semestre seleccionado
		{		
			try
			{
				//Lector de archivos para la posicion i-esima
				reader=new CSVReader(new FileReader(nombresArchivos[i]));
				String[] linea=reader.readNext();
				linea=reader.readNext();
				while(linea!=null)
				{
					int tres=linea[3].equals("")?0:Integer.parseInt(linea[3]);
					//separacion de coordenadas X y Y
					int seis=linea[3].equals("")?0:Integer.parseInt(linea[6]);
					int siete=linea[3].equals("")?0:Integer.parseInt(linea[7]);
					
					double diez=linea[10].equals("")?0: Double.parseDouble(linea[10]);
					double once=linea[11].equals("")?0:Double.parseDouble(linea[11]);
					//creacion de infraccion en estructura de datos para campos definidos
					movingViolationsStack.push(new VOMovingViolations(Integer.parseInt(linea[0]), linea[2], linea[13], Double.parseDouble(linea[9]), linea[12], linea[15], linea[14], Double.parseDouble(linea[8]),tres,diez,once,seis,siete));
					movingViolationsQueue.enqueue(new VOMovingViolations(Integer.parseInt(linea[0]), linea[2], linea[13], Double.parseDouble(linea[9]), linea[12], linea[15], linea[14], Double.parseDouble(linea[8]),tres,diez, once,seis,siete));
					linea=reader.readNext();
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				if(reader!=null)
				{
					try
					{
						reader.close();
					}
					catch(IOException e)
					{
						e.printStackTrace();	
					}
				}
			}
		}
	}

	public IStack<Integer> verificarObjectId (){
		IStack<Integer> retornar= new Stack<>();
		Iterador<VOMovingViolations> iter=(Iterador<VOMovingViolations>)movingViolationsStack.iterator();
		VOMovingViolations actual=iter.next();
		Nodo<VOMovingViolations> primero=movingViolationsStack.darPrimero();
		int objectid=actual.objectId();
		while(iter.hasNext()){
			boolean repetido=false; 
			while(primero.darSiguiente()!=null&&!repetido){
				if(primero.darSiguiente().darElemento().objectId()==objectid){
					retornar.push(objectid);
					repetido=true; 
				}
				primero=primero.darSiguiente();
			}
			objectid=iter.next().objectId();
		}
		return retornar; 
	}

}















