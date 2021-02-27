import java.io.*;
public class ficheros {
	public static void main(String[] args) {
 	File dir = new File("recursos/");
	String[] ficheros = dir.list();

	if(ficheros == null){
		System.out.println("No hay ficheros");
	}
	else{
		for(int i =0; i < ficheros.length; i++){
			System.out.println(ficheros[i]);
		}
	}

    }
}
