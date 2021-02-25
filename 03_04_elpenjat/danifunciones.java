import java.util.ArrayList;
import java.util.List;
import java.io.*;
public class danifunciones {
	
	public static boolean paraulaRandomActual(String randParaules, List<Character> characterInput){
	System.out.print("Paraula: ");
	int contadorCorrectes = 0;
	for(int i=0; i < randParaules.length(); i++){
		if(characterInput.contains(randParaules.charAt(i))){
			System.out.print(randParaules.charAt(i));
			contadorCorrectes++;
		}
		else{
			System.out.print("*");
		}
	}
	System.out.println();	
	return (randParaules.length() == contadorCorrectes); //devuelve true si acierta todos lo chars de la palabra
	}

	public static boolean adivinaJugador(BufferedReader entrada, String randParaules, List<Character> characterInput) throws IOException{
		
		System.out.println("Introdueix una lletra");
        	String adivinaLletra = entrada.readLine();  //input de las letras que vas a adivinar
        	characterInput.add(adivinaLletra.charAt(0)); //añade la primera letra del string al arraylist de chars

		if("prou".equals(adivinaLletra)){ //aún pensar lógica 
			
			return true;
		}
		return false;
   	}

/*	public static void utilitzades(String adivinaLletra, String randParaules, List<Character> characterInput)throws IOException{
		
		for(int i=0; i < randParaules.length(); i++){
			if(adivinaLletra == randParaules.charAt(i)){
				System.out.println("Utilitzades: " + randParaules.charAt(i));
			}
		}
	}
*/	

}

