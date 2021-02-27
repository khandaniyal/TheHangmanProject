import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.*; 
public class penjatDani {
	public static void main(String[] args)throws IOException {
        int i_intents=10;
        int i_jugades=0;
        int i_encertades=0;
        int i_fallades=0;
        int i_cancelades=0;
        
        
		BufferedReader entrada = new BufferedReader (new InputStreamReader (System.in));		
	
	BufferedReader path = new BufferedReader(new FileReader("recursos/paraules.txt"));
	List<String> paraules = new ArrayList<>();
	String currentLine = "";	
	while((currentLine = path.readLine()) != null){
		paraules.add(currentLine); 
	}
	
	path.close();

	String par = paraules.get(paraules.size()-1);

//	Random rand = new Random();// declaramos la clase random
//	String randParaules = paraules.get(rand.nextInt(paraules.size()));
	System.out.println(par);
	
	List<Character> characterInput = new ArrayList<>();
	danifunciones.paraulaRandomActual(par, characterInput);
	
	while(true){ //loopify
        System.out.println("Comencem a jugar");
        
		if(danifunciones.adivinaJugador(entrada, par, characterInput)){
			System.out.println("Mostrar las estadísticas");
		}else{
            funciones.mostraFigura(i_intents);
        }
        
		if(danifunciones.paraulaRandomActual(par, characterInput)){	
            i_encertades++;
			System.out.println("Has encertat! La paraula era " + par);		
		}else{
             i_fallades++;
        }
        
        if(!danifunciones.paraulaRandomActual(par, characterInput)){
            i_intentos--;
        }
        System.out.println("Intents disponibles: "+i_intentos);
        
        funciones.estadisticas(i_jugades,i_encertades,i_fallades,i_cancelades);
	}

   }
}
