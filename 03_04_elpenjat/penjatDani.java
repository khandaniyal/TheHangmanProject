import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.*; 
public class penjatDani {
	public static void main(String[] args)throws IOException {
		BufferedReader entrada = new BufferedReader (new InputStreamReader (System.in));		
        
	int i_intents=11;
        int i_jugades=0;
        int i_encertades=0;
        int i_fallades=0;
        int i_cancelades=0;
       	
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
        System.out.println("Intents disponibles: "+funciones.intentos(i_intents));
	
	while(true){//loopify
	
		if(!danifunciones.adivinaJugador(entrada, par, characterInput)){
			i_intents--; // he tenido que hacerlo manual :(
			funciones.mostraFigura(i_intents);
		}		        
		if(danifunciones.paraulaActual(par, characterInput)){	
            		i_encertades++;
			System.out.println("Has encertat! La paraula era " + par);		
		}
		else{
             		i_fallades++;
        	}
       	 	//falta bajar el intento ( i_intents-- )
        	System.out.println("Intents disponibles: "+funciones.intentos(i_intents));
        }
        //funciones.estadisticas(i_jugades, i_encertades, i_fallades, i_cancelades);
   }
}
