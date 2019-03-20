package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.opencsv.CSVReader;
import com.sun.corba.se.impl.orbutil.graph.Node;
import com.sun.javafx.scene.paint.GradientUtils.Parser;

import model.data_structures.HashTableChaining;
import model.data_structures.HashTableLinear;
import model.data_structures.IQueue;
import model.data_structures.IStack;
import model.data_structures.Iterador;
import model.data_structures.Nodo;
import model.data_structures.Queue;
import model.data_structures.Stack;
import model.vo.VOMovingViolations;
import view.MovingViolationsManagerView;

import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;



public class controller 
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
	
	private HashTableLinear linear; 
	
	private HashTableChaining chain; 

	public controller() {
		view = new MovingViolationsManagerView();

		//TODO, inicializar la pila y la cola
		movingViolationsQueue = null;
		movingViolationsStack = null;
		linear=null; 
		chain=null; 
	}

	public void run() {
		Scanner sc = new Scanner(System.in);
		boolean fin = false;

		while(!fin)
		{
			view.printMenu();

			int option = sc.nextInt();
			//carga del primer semestre de infracciones
			this.loadMovingViolations();
			System.out.println("q");
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
				loadMovingViolations();
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
	public void loadMovingViolations()
	{
		//estructuras de almacenamiento de infracciones
		movingViolationsStack= new Stack<VOMovingViolations>();
		linear= new HashTableLinear();
		chain= new HashTableChaining(); 
		
		//creacion e inicializacion de arreglo con nombre de los archivos de infracciones por mes 
		String[] nombresArchivos=new String[6];
		nombresArchivos[0]="."+File.separator+"data"+File.separator+"Moving_Violations_Issued_in_January_2018.json";
		nombresArchivos[1]="."+File.separator+"data"+File.separator+"Moving_Violations_Issued_in_February_2018.json";
		nombresArchivos[2]="."+File.separator+"data"+File.separator+"Moving_Violations_Issued_in_March_2018.json";
		nombresArchivos[3]="."+File.separator+"data"+File.separator+"Moving_Violations_Issued_in_April_2018.json";
		nombresArchivos[4]="."+File.separator+"data"+File.separator+"Moving_Violations_Issued_in_May_2018.json";
		nombresArchivos[5]="."+File.separator+"data"+File.separator+"Moving_Violations_Issued_in_June_2018.json";
		for (int i=0; i<nombresArchivos.length; i++){
			try{
				JsonParser parser = new JsonParser();
				String datos=nombresArchivos[i];
				JsonArray arr= (JsonArray) parser.parse(new FileReader(datos));
				
				for(int j=0; arr!=null&&j<arr.size(); j++){
					JsonObject obj=(JsonObject) arr.get(j);
					int id=0; 
					if (obj.get("OBJECTID")!=null){
					id=Integer.parseInt(obj.get("OBJECTID").getAsString());
					}
					String location="NaN";
					if(obj.get("LOCATION")!=null){
					location=obj.get("LOCATION").getAsString();
					}
					int adressId=0; 
					if(obj.get("ADDRESS_ID")!=null){
					adressId=Integer.parseInt(obj.get("ADDRESS_ID").getAsString());
					}
					int coordx=0; 
					if(obj.get("XCOORD")!=null){
					coordx=Integer.parseInt(obj.get("XCOORD").getAsString());
					}
					int coordy=0; 
					if(obj.get("YCOORD")!=null){
					coordy=Integer.parseInt(obj.get("YCOORD").getAsString());
					}
					double fineAMT=0; 
					if(obj.get("FINEAMT")!=null){
					fineAMT=Double.parseDouble(obj.get("FINEAMT").getAsString());
					}
					double totalPaid=0; 
					if(obj.get("TOTALPAID")!=null){
					totalPaid=Double.parseDouble(obj.get("TOTALPAID").getAsString());
					}
					double penalty1=0; 
					if(obj.get("PENALTY1")!=null){
					penalty1=Double.parseDouble(obj.get("PENALTY1").getAsString());
					}
					double penalty2=0; 
					if(obj.get("PENALTY2")!=null){
					penalty2=Double.parseDouble(obj.get("PENALTY2").getAsString());
					}
					String accidenIndicator="NaN";
					if(obj.get("ACCIDENTINDICATOR")!=null){
					accidentIndicator=obj.get("ACCIDENTINDICATOR").getAsString();
					}
					String ticketIssueDate="NaN"; 
					if(obj.get("TICKETISSUEDATE")!=null){
					ticketIssueDate=obj.get("TICKETISSUEDATE").getAsString();
					}
					String violationcode="NaN";
					if(obj.get("VIOLATIONCODE")!=null){
					violationcode=obj.get("VIOLATIONCODE").getAsString(); 
					}
					String description="NaN"; 
					if(obj.get("VIOLATIONDESC")!=null){
					description=obj.get("VIOLATIONDESC").getAsString(); 
					}
					VOMovingViolations vo= new VOMovingViolations(id,location,ticketIssueDate,totalPaid,accidenIndicator,description,violationcode,fineAMT,adressId,penalty1,penalty2,coordx,coordy);
					linear.put(j,vo); 
					chain.put(j,vo); 					
				}
				
			}catch (JsonIOException e1 ) {
				
				e1.printStackTrace();
			}
			catch (JsonSyntaxException e2) {
		
				e2.printStackTrace();
			}
			catch (FileNotFoundException e3) {
				e3.printStackTrace();
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















