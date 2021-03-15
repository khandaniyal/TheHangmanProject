/*
 *Funciones 2 
 *Clase con las funciones para la lógica del programa
 */

import java.util.ArrayList;
import java.util.List;
import java.io.*;
public class danifunciones {	
	//Funcion donde comprueba la palabra actual, si tiene el char de la palabra lo sustituye por el * y si la palabra coincide con el contador, por cada char como input devuelve true
	public static boolean paraulaActual(String par, List<Character> characterInput){
		String output = "Paraula: ";
		int contadorCorrectes = 0;
		for(int i=0; i < par.length(); i++){
			if(characterInput.contains(par.charAt(i))){
				output += par.charAt(i);
				contadorCorrectes++;
			}
			else{            
				output += "*";
			}
		}
		if(par.length() != contadorCorrectes){ //En caso de que la palabra sea diferente al contador, no hará falta mostrar el ultimo char utilizado
			System.out.println(output);
			utilitzades(characterInput);
		}
		return(par.length() == contadorCorrectes);
	}
	//Funcion donde el jugador adivina que palabra es y dependiendo del input comprueba si es un string o un char, dependiendo de eso devulve un booleano
	public static boolean adivinaJugador(BufferedReader entrada, String par, List<Character> characterInput, String adivinaLletra) throws IOException{
		
		boolean checkCharAndString = true;
	
		if(!("prou".equals(adivinaLletra) || "glups".equals(adivinaLletra) || adivinaLletra.length() > 1)){
			checkUtilitzades(characterInput, adivinaLletra); //Llamamos a la funcion donde comprueba si el input del char ya existe
		}		
		if(par.contains(adivinaLletra)){
			checkCharAndString = false;
		}
		else{
			checkCharAndString = true;
		}
		return checkCharAndString;
   	}
	//Procediemiento donde te imprime los char utilizados
	public static void utilitzades(List<Character> characterInput){
		String output = "Utilitzades: ";
		if(characterInput.isEmpty()){
			System.out.println(output + "cap");	
		}
		else{
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
	}
	//Funcion regex que devuelve true si el input contiene acentos
	public static boolean checkInput(String adivinaLletra){
		return(adivinaLletra.matches("[À-ÿ]"));
	}
	//Funcion que comprueba si los chars han sido utilizados previamente y que no los muestre
	public static boolean checkUtilitzades(List<Character> characterInput, String adivinaLletra){
	
		boolean checkChar = false;
	
		for(int i=0; i < characterInput.size(); i++){
			if(characterInput.get(i) == adivinaLletra.charAt(0) && !(adivinaLletra.charAt(0) == ' ')){
					checkChar = true;
			}	
		}
		if(!checkChar){
			characterInput.add(adivinaLletra.charAt(0));
		}
		return checkChar;	
	}
}	
