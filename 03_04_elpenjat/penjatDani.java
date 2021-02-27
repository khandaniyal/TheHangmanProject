import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.*; 
public class penjatDani {
	public static void main(String[] args)throws IOException {
		BufferedReader entrada = new BufferedReader (new InputStreamReader (System.in)); //user input		
	
	BufferedReader path = new BufferedReader(new FileReader("recursos/paraules.txt")); //path de las palabras wey
	List<String> paraules = new ArrayList<>(); //declaramos la lista donde vamos a guardar las palabras
	String currentLine = "";	
	while((currentLine = path.readLine()) != null){
		paraules.add(currentLine); //añadimos las palabras a la lista de Strings
	}
	
	path.close();

	String par = paraules.get(paraules.size()-1);

//	Random rand = new Random();// declaramos la clase random
//	String randParaules = paraules.get(rand.nextInt(paraules.size()));//creamos un string donde vamos a ir llamando palabras random del array
	System.out.println(par); // ayudita para ver las palabras random que salen, de algun modo se suelen repetir seguidamente pd: preguntar al Moisès
	
	List<Character> characterInput = new ArrayList<>(); // declaramos el arralist de chars
	danifunciones.paraulaRandomActual(par, characterInput); //llamamos a la clase con la funcion donde va a ir sustituyendo los asterisks
	
	while(true){ //loopify
		if(danifunciones.adivinaJugador(entrada, par, characterInput)){
			System.out.println("Mostrar las estadísticas");
			break;
		}
		
		if(danifunciones.paraulaRandomActual(par, characterInput)){	
			System.out.println("Has encertat! La paraula era " + par);		
			break;
		}
	}

   }
}
