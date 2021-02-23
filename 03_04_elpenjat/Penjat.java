import java.io.*;
public class Penjat{
      public static void main(String[] args)throws IOException{
    
    	String txt = "recursos/paraules.txt";
	BufferedReader input = new BufferedReader(new FileReader(txt));
	String linea = "";
	while((linea = input.readLine()) != null){
		linea = ino	
		System.out.println(linea);
	}
	input.close();
    }			
}
