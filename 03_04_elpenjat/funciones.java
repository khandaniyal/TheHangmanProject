/*
 * 
mostrar figuras
    si falla
    si acierta
intentos
    10--
array char
    base *
    añadir letras
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class funciones {
	
	public static int i_intents=11;
        public static int i_jugades=0;
        public static int i_encertades=0;
        public static int i_fallades=0;
	public static int i_cancelades=0;
    
    public static void mostraFigura(int intentsDisponibles) throws IOException{

        int i=11;
        int num=i-intentsDisponibles;
        if(num>0){
            String txt = "recursos/figura"+num+".txt";
            BufferedReader input = new BufferedReader(new FileReader(txt));
            String linea = "";
            while((linea = input.readLine()) != null){

                System.out.println(linea);
            }
            input.close();
        }
        

    }
     public static int intentos(int i_intentos){
     		i_intentos--;
         return i_intentos;
     }
    
    public static void estadisticas(int i_jugades, int i_encertades,int i_fallades,int i_cancelades) {
        System.out.println("Paraules jugades: "+i_jugades);
        System.out.println("Paraules encertades: "+i_encertades);
        System.out.println("Paraules fallades: "+i_fallades);
        System.out.println("Paraules cancel·lades: "+i_cancelades);
        System.out.println("Espero que t'hagis divertit");
       
    }
    
    public static boolean contieneLetra(char [] palabra, char letra) {

        for (int i = 0; i <= palabra.length; i++) {
            if(palabra[i]==letra){
                return true;
            }
        }
        return false;
    }



}
