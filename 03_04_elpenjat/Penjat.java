/*
 * Main donde hemos monstado el Hangman usando la diferentes funciones.
 * El programa es el famoso juego del Ahorcado.
 *
 */

import java.util.ArrayList; 
import java.util.List;
import java.io.*; 
public class Penjat{
	public static void main(String[] args)throws IOException{
		BufferedReader entrada = new BufferedReader (new InputStreamReader (System.in)); //BufferedReader solo para el input		
       
	BufferedReader path = new BufferedReader(new FileReader("recursos/paraules.txt"));
	List<String> paraules = new ArrayList<>(); //Lista donde vamos almacenar las palabras del ".txt"
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
			else if("glups".equals(adivinaLletra)){ // Reiniciamos los intentos, la lista de chars y sumamos una palabra cancelada
				funciones.i_cancelades++;
				characterInput = new ArrayList<>();
				funciones.i_intents = 10;
				break;
			}	
			else if(danifunciones.checkInput(adivinaLletra)){ //Si el char introducido contiene acento devuelve true
				System.out.println("Error: cal una lletra entre 'a' i 'z', 'prou' o 'glups'");
				continue;	
			}
			else if(adivinaLletra.length() > 1){ //"quelcom" o un string que no sea "glups" o "prou"
				System.out.println("Error: cal una lletra entre 'a' i 'z', 'prou' o 'glups'");	
				danifunciones.paraulaActual(par, characterInput);
				continue;
			}
			if(danifunciones.checkUtilitzades(characterInput, adivinaLletra)){ //Funcion que comprueba si el char ya existe 
				System.out.println("La lletra ja ha estat utilitzada");
				danifunciones.paraulaActual(par, characterInput);
				continue;
			} 
			if(funciones.i_intents == 1){ //Si no aciertas cada char de la palabra actual y los intentos llegan a uno, le ded, pasa a la siguiente iteración
				mostraFigura(0);
				System.out.println("Has mort");
				characterInput = new ArrayList<>();
            			funciones.i_fallades++; 	
				funciones.i_intents = 10;
				break;	
			}
			
			if(danifunciones.adivinaJugador(entrada, par, characterInput, adivinaLletra)){ //Funcion donde comprueba el input del jugador
				funciones.i_intents--;
				mostraFigura(funciones.i_intents);
			}
			if(danifunciones.paraulaActual(par, characterInput)){ //Funcion donde comprueba si aciertas la palabra y donde sustituye el "*" por el char que contenga la palabra
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
   	// procedimiento que recorre las figuras y la muestra
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


