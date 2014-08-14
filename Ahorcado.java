import java.util.Scanner;
import java.util.Random;

public class Ahorcado{
	public static void main(String[] args) {
		Scanner lea = new Scanner(System.in);
		Random rnd = new Random();
		
		String [] palabras = {"Complejo", "Ingeniero", "Geek", "Binario", "Hexadecimal",
				"Infinito", "Externo", "Tarjeta", "Memoria", "Vicario",
				"Alterno", "Guitarra", "Milagro", "Creativo", "Fascinante",
				"Falacia", "Acelerado", "Ninja", "Caballero", "Mensaje"};

		String dificultad = "NORMAL"; 
		int opcion, ganados=0, perdidos=0, jugados=0;
		char [] popular = new char[26];
		char entrada;

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
						String opjugar;
						do{
							String cadena;
							char caracter;
							int palabrax = (int)(rnd.nextDouble() * 20.0);
							int longitud = palabras[palabrax].length();
							int acertados=0, contador=0, espacios=1, restantes=0;
							char [] encontrados= new char[longitud];
							//Inicializar variable restantes para intentos segun Dificultad
							switch (dificultad){
								case "FACIL":
									restantes=20;
								break;
								case "NORMAL":
									restantes=15;
								break;
								case "DIFICIL":
									restantes=10;
								break;
								default:
									dificultad="FACIL";
									restantes=20;
							}

							//Imprimiendo _ de acuerdo a longitud de la palabra
							while (espacios<=longitud){
								encontrados[espacios-1]='_';
								System.out.print(encontrados[espacios-1]+" ");
								espacios++;
							}

							do{
								System.out.printf("%nEscoja el numero de la opcion que desea usar:%n1 - Ingresar un Caracter %n2 - Ingresar una Cadena%n");
								entrada=lea.next().charAt(0);
								switch (entrada){
									case '1':
										contador=0;
										System.out.print("Ingrese caracter: "); caracter=lea.next().charAt(0);
										//Encontrando coincidencias
										while (contador<longitud){
											if (Character.toLowerCase(palabras[palabrax].charAt(contador))==Character.toLowerCase(caracter)){
												encontrados[contador]=caracter;
												acertados++;
											}
											contador++;
										}
										//Guardando registros de caracteres mas ingresados
										contador=1;
										while(contador<=26){
											if (caracter == contador+100 || caracter == contador + 140){
												popular[contador]++;
											}
											contador++;
										}
										//Imprimiendo los espacios y caracteres encontrados
										espacios=1;
										while (espacios<=longitud){
											System.out.print(encontrados[espacios-1]+" ");
											espacios++;
										}
										//Validando si palabra armada por caracter y si restan intentos, Registrando juegos ganados y perdidos
										if (acertados==longitud){
											ganados++;
											restantes=0;
											System.out.print("\nGanaste! Palabra Armada!");
										} else if(restantes==0){
											perdidos++;
											System.out.print("\nNo te quedan mas intentos! Has perdido, Intentalo de Nuevo!");
										}
										restantes--;
									break;
									case '2':
										System.out.print("Ingrese cadena: "); cadena= lea.next();
										//Validando si palabra ingresada es correcta
										if (cadena.equalsIgnoreCase(palabras[palabrax])){
											ganados++;
											restantes=0;
											System.out.print("Ganaste! Palabra ingresada correcta!");
										}else{
											perdidos++;
											restantes=0;
											System.out.print("Perdiste! Palabra ingresado incorrecta!");
										}
									break;
									default:
										System.out.println("Ingrese una opcion valida.");

								}
							}while(acertados<longitud && restantes>0);

							System.out.printf("%nDesea volver a jugar? (si/no) ");
							opjugar=lea.next();
						}while (opjugar.equalsIgnoreCase("si"));

						
					break;
					case 2:
						//Variable para condicionar si desea agregar las 20 nuevas palabras o no
						String frase=""; 
 						
 						//arreglo 
						String []palabras2= new String[20];
							 
						 	System.out.println("\tIngrese Si y Luego Ingrese Las Veinte Palabras Nuevas"+ 
						 						"\n\tCaso Contrario escriba No: ");
							
						 	frase= lea.next();								
						 	if(frase.equalsIgnoreCase("si")){
								
							for (int i=0;  i  < 20 ;  i++){	
								palabras2[i]=lea.next();
								System.out.println("Ingreso "+palabras2[i].length()+" letras");
								}						 		
						 		palabras=palabras2;
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