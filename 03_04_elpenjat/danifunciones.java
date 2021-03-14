import java.util.ArrayList;
import java.util.List;
import java.io.*;
public class danifunciones {	
	
	public static boolean paraulaActual(String par, List<Character> characterInput){
		String output = "Paraula: ";
		int contadorCorrectes = 0;
		for(int i=0; i < par.length(); i++){
			if(characterInput.contains(par.charAt(i))){
                //falta condicion que si sale prou use funciones.estadisticas
				output += par.charAt(i);
				contadorCorrectes++;
			}
			else{            
				output += "*";
			}
		}
		System.out.println(output);	
		
		
		if(par.length() == contadorCorrectes){
			return true;
		}
		else{
			return false;
		}
	}
	public static boolean adivinaJugador(BufferedReader entrada, String par, List<Character> characterInput, String adivinaLletra) throws IOException{
		boolean caca = true;
		if("prou".equals(adivinaLletra) || "glups".equals(adivinaLletra)){
			caca = false;
		}else{
		
			characterInput.add(adivinaLletra.charAt(0));
			utilitzades(characterInput);
		}
		if(par.contains(adivinaLletra)){
			caca = true;
		}
		return caca;
   	}
	public static void utilitzades(List<Character> characterInput){
		String output = "Utilitzades: ";	
		for(int i=0; i < characterInput.size(); i++){
			if(i == characterInput.size()-2){
				output += Character.toUpperCase(characterInput.get(i)) + " i ";
			}
			else if(i == characterInput.size()-1){
				output += Character.toUpperCase(characterInput.get(i));
			}
			else{
				output += Character.toUpperCase(characterInput.get(i)) + ", ";
			}
		}
		System.out.println(output);
	}
	public static boolean checkInput(String adivinaLletra){
	return(adivinaLletra.matches("[À-ÿ]"));
	}
}	
