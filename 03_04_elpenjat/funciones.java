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

public class funciones {


    public static void mostraFigura(int intentsDisponibles) throws IOException{

        int i=10;
        int num=i-intentsDisponibles;
        if(num>0){
            String txt = "recursos/figura"+num+".txt";
            BufferedReader input = new BufferedReader(new FileReader(txt));
            String linea = "";
            while((linea = input.readLine()) != null){

                System.out.println(linea);
            }
        }
        input.close();

    }
/* 
   public static void intentos(char [] palabra, char letra) {

        if(!contieneLetra(palabra, letra)){
            i_intentos--;
        }
    }
*/
    public static boolean contieneLetra(char [] palabra, char letra) {

        for (int i = 0; i <= palabra.length; i++) {
            if(palabra[i]==letra){
                return true;
            }
        }
        return false;
    }



}