import java.io.*;
public class Penjat{
    public static void main(String[] args)throws IOException{

        String txt = "recursos/paraules.txt";
        BufferedReader input = new BufferedReader(new FileReader(txt));
        String linea = "";
        int i=0;
        linea = input.readLine();
        System.out.println("Comencem a jugar");
        System.out.println("Paraula: ");
        dani.printWord(linia, playerGuesses);
        System.out.println("Utilitzades: cap");
        System.out.println("Intents disponibles: 10");
        System.out.println("Introdueix una lletra");
        //leer primera letra (cuidado con glups y prou)

        while((linea = input.readLine()) != null){
            while(/*intentos>10, no glups, no prou, palabra no completada*/){
                //leer letra
                //poner letras en el array
                funciones.mostra_figura();
                System.out.println("Paraula: ");
                dani.printWord(linia, playerGuesses); //cambio de letra en posicion si existe
                System.out.println("Utilitzades: ");
                //lista de palabras utilizadas
                System.out.println("Intents disponibles: ");
                funciones.intentos(/*array de la palabra, ?char letra?*/);
                System.out.println("Introdueix una lletra");
                //leer letra
            }
        }


        input.close();
    }			
}

