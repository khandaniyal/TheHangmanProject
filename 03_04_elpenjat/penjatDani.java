import java.util.ArrayList; 
import java.util.List;
import java.util.Random;
import java.io.*; 
public class penjatDani extends funciones{
	public static void main(String[] args)throws IOException{
		BufferedReader entrada = new BufferedReader (new InputStreamReader (System.in));		
       
       // En vez de declarar las variables de los contadores, las he declarado en tu class de funciones y le añadido el extends al nuestro
	
	BufferedReader path = new BufferedReader(new FileReader("recursos/paraules.txt"));
	List<String> paraules = new ArrayList<>();
	String currentLine = "";	
	while((currentLine = path.readLine()) != null){
		paraules.add(currentLine); 
	}	
	path.close();

	String par = paraules.get(paraules.size()-1);

/*	Random rand = new Random();// declaramos la clase random
	String randParaules = paraules.get(rand.nextInt(paraules.size()));
*/	
	System.out.println("HINT: " + par + "\n");
	List<Character> characterInput = new ArrayList<>();
	
	System.out.println("Comencem a jugar");
	danifunciones.paraulaActual(par, characterInput);
	System.out.println("Utilitzades: cap");
        System.out.println("Intents disponibles: " + funciones.intentos(i_intents));
	
	while(true){//loopify
	
		if(!danifunciones.adivinaJugador(entrada, par, characterInput)){
			i_intents--; // he tenido que hacerlo manual :(
			funciones.mostraFigura(i_intents);
		}		        
		if(danifunciones.paraulaActual(par, characterInput)){	
            		i_encertades++;
			System.out.println("Has encertat! La paraula era " + par);
			break;
		}
		else{
             		i_fallades++;
			
        	}
        	System.out.println("Intents disponibles: "+funciones.intentos(i_intents));
        }
	//Las estadísticas ya funcionan, falta mejorar un poquillo y ale
        funciones.estadisticas(i_jugades, i_encertades, i_fallades, i_cancelades);
   }
}
