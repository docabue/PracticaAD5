package paquete;









import java.util.Arrays;

import javax.swing.JOptionPane;

import org.bson.Document;
import com.mongodb.client.*;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;


public class Principal {

	public static  void main(String[] args) {
		
       //
		
		MongoClient conexion = MongoClients.create("mongodb://localhost:27017");
	    MongoDatabase database = conexion.getDatabase("harry");
	    MongoCollection<Document> harry= database.getCollection("harry");
	    
	    
	    int opcion=0;
	    boolean finalizar=false;
	    
	    do
	    {
	    	opcion=Integer.parseInt(JOptionPane.showInputDialog("1º: Mostrar todos los personajes cuyo atributo species tenga como valor human. "+ "\n"+
	    			"2º:Mostrar todos los personajes cuyo atributo yearOfBirth sea anterior a 1979 " + "\n"  +
	    			"3º:Mostrar todos los personajes cuyo atributo wood de la propiedad wand sea holly." +"\n"+ 
	    			"4º:Mostrar todos los personajes que estén vivos (propiedad alive igual a true )y además sean estudiantes (propiedad hogwartsStudent igual a true"+"\n"+ "5º: salir"
	               ));
	    	
	    	switch(opcion)
	    	{
	    	case 1:
	    	{
	    		 buscaSpecie(harry);
	    		
	    	}
	    	case 2:
	    	{
	    		buscaMayores(harry);
	    	}
	    	case 3:
	    	{
	    		buscaWood(harry);
	    		
	    	}
	    	case 4:
	    	{
	    		
	    		BuscaVivosYEstudiantes(harry);
	    	}
	    	
	    	case 5:
	    	{
	    		finalizar=true;
	    	}
	    	
	    	}
	    	
	    }while(!finalizar);
	    
	    
	    
	    
	    
	    
	    
	    
	    //Mostrar todos los personajes cuyo atributo "species" tenga como valor "human".
	     
	    
	    
	    
	    
	    
	    
	    //Mostrar todos los personajes cuyo atributo "yearOfBirth" sea anterior a 1979.
	    
	  
	}
	
	private static void buscaSpecie(MongoCollection<Document> harry) {
		FindIterable<Document> buscaHumanos = harry.find(eq("species", "human"));
	
		

		for(Object humano :buscaHumanos)
		{
		
		System.out.println(((Document) humano).toJson());	
		}
		
	}


	private static void buscaMayores(MongoCollection<Document> harry) {
		
		FindIterable<Document> buscaMayor = harry.find(lte("yearOfBirth", 1979 ));
	
		
		
		for(Object humano :buscaMayor)
		{
		
		System.out.println(((Document) humano).toJson());	
		}
		
	}
	
	
	
private static void buscaWood(MongoCollection<Document> harry) {
		
	FindIterable buscaHolly = harry.find(eq("wand.wood", "holly"));
	
		
		
		for(Object humano :buscaHolly)
		{
		
		System.out.println(((Document) humano).toJson());	
		}
		
	}
	

	
	
private static void BuscaVivosYEstudiantes(MongoCollection<Document> harry) {
	
	FindIterable buscaEstudiandtesVivos =harry.find(and(eq("alive", true), eq("hogwartsStudent",true)));
	
	
		
		for(Object humano :buscaEstudiandtesVivos)
		{
		
		System.out.println(((Document) humano).toJson());	
		}
		
	}

}
