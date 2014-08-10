import java.util.Scanner;
import java.util.Random;

public class Ahorcado{
	public static void main(String[] args) {
		Scanner lea = new Scanner(System.in);
		
		String [] palabras = {"Complejo", "Ingeniero", "Geek", "Binario", "Hexadecimal",
				"Infinito", "Externo", "Tarjeta", "Memoria", "Vicario",
				"Alterno", "Guitarra", "Milagro", "Creativo", "Fascinante",
				"Falacia", "Acelerado", "Ninja", "Caballero", "Mensaje"};

		String dificultad = "NORMAL"; 
		int opcion;

		do {
			System.out.println("Escoja el numero de la opcion que desea usar:" + 
				"\n1 - Jugar Ahorcado." + 
				"\n2 - Inicializar repositorio." + 
				"\n3 - Dificultad" + 
				"\n4 - Reporte historico." +
				"\n5 - Salir");

				opcion = lea.nextInt();

				switch (opcion){
					case 1:
					
					break;
					case 2:
						
						String frase=""; 
 						Scanner lea2 = new Scanner(System.in); 
						for(;frase.contains("No")==false;) 
						{ 
							System.out.println("\tIngrese Una Palabra Nueva \n\tCaso Contrario escriba No: ");
							frase=lea2.nextLine(); 
							System.out.println("Ingreso "+frase.length()+" letras");
						} 
						 
					break;
					case 3:
						System.out.println("Ingrese la dificultad que desea jugar: " +
							"\n1 - FACIL" + 
							"\n2 - NORMAL" +
							"\n3 - DIFICIL");
						dificultad = lea.next();
					break;
					case 4:

					break;
					case 5:

					break;
					default:
						System.out.println("Ingrese una opcion valida.");
				}

		} while (opcion != 5);

	}
}