/*
 *Utilidades para el Penjat.
 */

public class UtilString {
	public static boolean esEnter(String str){ //Comprueba si es entero con un thread
		
        try {
            	Integer.parseInt(str);
            	return true;
 	} 
	catch (NumberFormatException e) {
            	return false;
       	 }
    }

    	public static boolean esVocal(char ch){ // Comprueba vocales (no sé si hace falta)

                if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'à' || ch == 'è' || ch == 'é' ||
                   ch == 'í' || ch == 'ò' || ch == 'ó' || ch == 'ú' || ch == 'ü' || ch == 'A' || ch == 'À' || ch == 'E' ||
		   ch == 'È' || ch == 'É' || ch == 'I' || ch == 'Í' || ch == 'Ì' || ch == 'Ï' || ch == 'O' || ch == 'Ó' ||
		   ch == 'Ò' || ch == 'U' || ch == 'Ú' || ch == 'Ü' || ch == 'ï'){

                        return true;
                }
                else{
                        return false;
                }
        }
}
