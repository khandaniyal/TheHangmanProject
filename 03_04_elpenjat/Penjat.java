/*
 * Main donde hemos monstado el Hangman usando la diferentes funciones.
 * El programa es el famoso juego del Ahorcado.
 */

import java.util.ArrayList; 
import java.util.List;
import java.io.*; 
public class Penjat{
	public static void main(String[] args)throws IOException{
		BufferedReader entrada = new BufferedReader (new InputStreamReader (System.in));		
       
	BufferedReader path = new BufferedReader(new FileReader("recursos/paraules.txt"));
	List<String> paraules = new ArrayList<>(); //Lista donde vamos almacenar las palabras del .txt
	String currentLine = "";	
	// Iteramos por cada una de las palabras y las añadimos a la lista de palabras
	while((currentLine = path.readLine()) != null){
		paraules.add(currentLine); 
	}
	path.close();
	String par = ""; //String vacío que usaremos para almacenar la palabras cuando iteremos la lista con un for loop
	List<Character> characterInput = new ArrayList<>(); // declaramos la lista de chars donde se van a ir guardando los caracteres

	//LET'S BEGIN! /* LO QUE HACE CADA FUNCION LO DESCRIBO EN SU PROPIA CLASE */
	System.out.println("Comencem a jugar");
	
	for(int i=0; i < paraules.size(); i++){
		par = paraules.get(i);	
		danifunciones.paraulaActual(par, characterInput);
		funciones.i_jugades++;
		while(true) {
        		
			System.out.println("Intents disponibles: " + funciones.i_intents);
			System.out.println("Introdueix una lletra");
        		String adivinaLletra = entrada.readLine().toLowerCase();  //input de las letras que vas a adivinar
			
			if("prou".equals(adivinaLletra)){
				funciones.i_cancelades++;
				funciones.estadisticas(funciones.i_jugades, funciones.i_encertades, funciones.i_fallades, funciones.i_cancelades);
				return;
			}
			else if("glups".equals(adivinaLletra)){
				funciones.i_cancelades++;
				characterInput = new ArrayList<>();
				funciones.i_intents = 10;
				break;
			}	
			else if(danifunciones.checkInput(adivinaLletra)){ 
				System.out.println("Error: cal una lletra entre 'a' i 'z', 'prou' o 'glups'");
				continue;	
			}
			else if(adivinaLletra.length() > 1){ //quelcom
				System.out.println("Error: cal una lletra entre 'a' i 'z', 'prou' o 'glups'");	
				danifunciones.paraulaActual(par, characterInput);
				continue;
			}
			if(danifunciones.checkUtilitzades(characterInput, adivinaLletra)){
				System.out.println("La lletra ja ha estat utilitzada");
				danifunciones.paraulaActual(par, characterInput);
				continue;
			} 
			if(funciones.i_intents == 1){
				mostraFigura(0);
				System.out.println("Has mort");
				characterInput = new ArrayList<>();
            			funciones.i_fallades++; 	
				funciones.i_intents = 10;
				break;	
			}
			
			if(danifunciones.adivinaJugador(entrada, par, characterInput, adivinaLletra)){ 
				funciones.i_intents--;
				mostraFigura(funciones.i_intents);
			}
			if(danifunciones.paraulaActual(par, characterInput)){ 	
            			funciones.i_encertades++;
				characterInput = new ArrayList<>();
				System.out.println("Has encertat! La paraula era " + par);
				funciones.i_intents = 10;
				break;
			}
        	}		
	}
	System.out.println("No queden més paraules");
	funciones.estadisticas(funciones.i_jugades, funciones.i_encertades, funciones.i_fallades, funciones.i_cancelades);
   }
   	// procedimiento que recorre las figuras
	public static void mostraFigura(int intentsDisponibles) throws IOException{
        int i = 10;
        int num = i - intentsDisponibles;
        String txt = "recursos/figura" + (num-1) + ".txt";
        BufferedReader input = new BufferedReader(new FileReader(txt));
        String linea = "";
        while((linea = input.readLine()) != null){

        	System.out.println(linea);
        }
       input.close();
   }
}


