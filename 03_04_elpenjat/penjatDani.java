import java.util.ArrayList; 
import java.util.List;
import java.util.Random;
import java.io.*; 
public class penjatDani extends funciones{
	public static void main(String[] args)throws IOException{
		BufferedReader entrada = new BufferedReader (new InputStreamReader (System.in));		
       
	BufferedReader path = new BufferedReader(new FileReader("recursos/paraules.txt"));
	List<String> paraules = new ArrayList<>();
	String currentLine = "";	
	while((currentLine = path.readLine()) != null){
		paraules.add(currentLine); 
	}	
	path.close();

	String par = ""; //paraules.get(paraules.size()-1);

/*	Random rand = new Random();// declaramos la clase random
	String randParaules = paraules.get(rand.nextInt(paraules.size()));
*/	
	System.out.println("HINT: " + par + "\n");
	List<Character> characterInput = new ArrayList<>();
	
	System.out.println("Comencem a jugar");
	danifunciones.paraulaActual(par, characterInput);
	System.out.println("Utilitzades: cap");
        System.out.println("Intents disponibles: " + funciones.intentos(i_intents));
		
	for(int i=0; i < paraules.size(); i++){
		par = paraules.get(i);	
		i_jugades++;
		while(true) {
			
			System.out.println("Introdueix una lletra");
        		String adivinaLletra = entrada.readLine();  //input de las letras que vas a adivinar
			
			if("prou".equals(adivinaLletra)){
				i_cancelades++;
				funciones.estadisticas(i_jugades, i_encertades, i_fallades, i_cancelades);
				return;
			}
			if("glups".equals(adivinaLletra)){
				i_cancelades++;
				characterInput = new ArrayList<>();
				break;
			}
			if(danifunciones.checkInput(adivinaLletra)){
				System.out.println("Error: cal una lletra entre 'a' i 'z', 'prou' o 'glups'");
			}
			if(danifunciones.adivinaJugador(entrada, par, characterInput, adivinaLletra)){ //input
				i_intents--; // he tenido que hacerlo manual :(
				funciones.mostraFigura(i_intents);
			}
	/*		else{
        			funciones.estadisticas(i_jugades, i_encertades, i_fallades, i_cancelades);
				return;	
            			//i_fallades++; las fallades no funciona bien
			}
	*/		if(danifunciones.paraulaActual(par, characterInput)){ 	
            			i_encertades++;
				characterInput = new ArrayList<>();
				System.out.println("Has encertat! La paraula era " + par);
				i_intents = 11;
				break;
			}
        	System.out.println("Intents disponibles: " + funciones.intentos(i_intents));
        	}		
	}
   }
}
