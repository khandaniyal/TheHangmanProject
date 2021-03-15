/*
 * Funciones 1, contadores y estadísticas
 *
 */

public class funciones {
	
	//Variables globales de los contadores
	public static int i_intents=10;
        public static int i_jugades=0;
        public static int i_encertades=0;
        public static int i_fallades=0;
	public static int i_cancelades=0;
	
//Procedimiento que muestra las estadisticas	
public static void estadisticas(int i_jugades, int i_encertades, int i_fallades, int i_cancelades) {
        System.out.println("Paraules jugades: " + i_jugades);
        System.out.println("Paraules encertades: " + i_encertades);
        System.out.println("Paraules fallades: " + i_fallades);
        System.out.println("Paraules cancel·lades: " + i_cancelades);
        System.out.println("Espero que t'hagis divertit");
       
    }
}
