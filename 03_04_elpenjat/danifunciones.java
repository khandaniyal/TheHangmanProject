import java.util.ArrayList;
import java.util.List;
import java.io.*;


public class danifunciones {
	
	public static boolean paraulaRandomActual(String par, List<Character> characterInput){
	System.out.print("Paraula: ");
	int contadorCorrectes = 0;
	for(int i=0; i < par.length(); i++){
		if(characterInput.contains(par.charAt(i))){
			System.out.print(par.charAt(i));
			contadorCorrectes++;
		}
		else{
			System.out.print("*");
		}
	}
	System.out.println();	
	if(par.length() == contadorCorrectes){
		return true;
	}
	else{
		return false;
	}
	}

	public static boolean adivinaJugador(BufferedReader entrada, String par, List<Character> characterInput) throws IOException{
		
		System.out.println("Introdueix una lletra");
        	String adivinaLletra = entrada.readLine();  //input de las letras que vas a adivinar
        	characterInput.add(adivinaLletra.charAt(0)); //añade la primera letra del string al arraylist de chars
		
		utilitzades(characterInput);

		if("prou".equals(adivinaLletra)){ //aún pensar lógica 
			
			return true;
		}
		return false;
   	}

	public static void utilitzades(List<Character> characterInput){
	for(int i=0; i < characterInput.size(); i++){
		if(characterInput.isEmpty()){
			System.out.println("Utilitzades: cap");
		}
	}
	
	}	

}	
/*for(int i = 0; i < args.length; i++){

                if(i == args.length-2){
                        System.out.print(args[i] + " i ");
                }

                else if(i == args.length-1){
                        System.out.println(args[i]);
                }
                else{
                        System.out.print(args[i] + ", ");
                }
        }

        System.out.println();
    }
*/
=======
>>>>>>> 71770e7d1bfd5158b4e9dc34116b8083f54fa2ac
