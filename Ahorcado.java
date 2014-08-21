import java.util.Scanner;
import java.util.Random;

public class Ahorcado{
	public static void main(String[] args) {
		Scanner lea = new Scanner(System.in);
		Random rnd = new Random();
		
		//Se inicializa de manera express el arreglo de palabras
		String [] palabras = {"Complejo", "Ingeniero", "Geek", "Binario", "Hexadecimal",
				"Infinito", "Externo", "Tarjeta", "Memoria", "Vicario",
				"Alterno", "Guitarra", "Milagro", "Creativo", "Fascinante",
				"Falacia", "Acelerado", "Ninja", "Caballero", "Mensaje"};

		String dificultad = "NORMAL"; 
		int opcion, ganados = 0, perdidos = 0, jugados = 0; //variables para opcion y para juegos
		int adivinados = 0, fallados = 0, winByChar = 0, winByString = 0; //variables para caracters adivinados, fallados
		//y juegos ganados por caracteres o por cadenas
		double avgWin, avgLose; //promedios para ganes y perdidas

		char [] abecedario = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
				'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
			
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
							//int palabrax = (int)(rnd.nextDouble() * 20.0);
							int palabrax = rnd.nextInt(20);
							int longitud = palabras[palabrax].length();
							int acertados = 0, contador = 0, espacios = 1, restantes = 0;

							char [] encontrados = new char[longitud];

							//Inicializar variable restantes para intentos segun Dificultad
							switch (dificultad){
								case "FACIL":
									restantes = 20;
									break;
								case "NORMAL":
									restantes = 15;
									break;
								case "DIFICIL":
									restantes = 10;
									break;
								default:
									dificultad = "NORMAL";
									restantes = 15;
							}

							//Imprimiendo _ de acuerdo a longitud de la palabra
							for (espacios = 1; espacios <= longitud; espacios++){//espacios ya está definido arriba
								encontrados[espacios - 1] = '_';
								System.out.print(encontrados[espacios - 1] + " ");
							}

							do{
								System.out.printf("%nEscoja el numero de la opcion que desea usar:%n1 - Ingresar un Caracter %n2 - Ingresar una Cadena%n");
								entrada = lea.next().charAt(0);
								
								switch (entrada){
									case '1':
										contador = 0;
										System.out.print("\nIngrese caracter: "); 
										caracter = lea.next().charAt(0);
										
										//Encontrando coincidencias
										boolean acierto = false; //variable de control por si encuentra o no en este intento
										while (contador < longitud){
											if (Character.toLowerCase(palabras[palabrax].charAt(contador)) == Character.toLowerCase(caracter)){
												encontrados[contador] = caracter;
												acertados++;
												acierto = true;
											}
											contador++;
										}

										if (acierto == false){
											System.out.println("\nEse caracter no existe en la palabra.");
											restantes--;
										}else
											System.out.println("\nCaracter adivinado!");

										//Guardando registros de caracteres mas ingresados
										
										//contador = 1;
										for (contador = 0; contador < 26; contador++){
											if ((caracter == contador + 100) || (caracter == contador + 140)){
												abecedario[contador]++;
											}											
										}

										//System.out.println(contador); **PRUEBA

										//Imprimiendo los espacios y caracteres encontrados
										for (espacios = 1; espacios <= longitud; espacios++){//espacios ya está definido arriba										
											System.out.print(encontrados[espacios - 1] + " ");
										}

										//Validando si palabra armada por caracter y si restan intentos, Registrando juegos ganados y perdidos
										if (acertados == longitud){
											ganados++;
											winByChar++;
											restantes = 0;

											System.out.print("\nGanaste! Palabra Armada!");
										} else if(restantes == 0){
											perdidos++;

											System.out.print("\nNo te quedan mas intentos! Has perdido, intentalo de nuevo!");
										}
										break;
									case '2':
										System.out.print("\nIngrese cadena: "); 
										cadena = lea.next();
										//Validando si palabra ingresada es correcta
										if (cadena.equalsIgnoreCase(palabras[palabrax])){
											ganados++;
											winByString++;

											System.out.print("\nGanaste! Palabra ingresada correcta!");
										}else{
											perdidos++;
											System.out.print("\nPerdiste! Palabra ingresado incorrecta!");
										}

										restantes = 0;
										break;
									default:
										System.out.println("\nIngrese una opcion valida.");
								}
							}while(acertados < longitud && restantes > 0);

							System.out.printf("%nDesea volver a jugar? (si/no) ");
							opjugar = lea.next();
						}while (opjugar.equalsIgnoreCase("si"));		

						jugados++;
						break;
					case 2:
							//Variable para condicionar si desea agregar las 20 nuevas palabras o no
							String frase = ""; 
							 
						 	System.out.print("\tIngrese Si y Luego Ingrese Las Veinte Palabras Nuevas" + 
						 						"\n\tCaso Contrario escriba No: ");							
						 	frase = lea.next();		

						 	if(frase.equalsIgnoreCase("si")){
									
								for (int i = 0; i < 20; i++){	
									palabras[i] = lea.next();
									System.out.println("Ingreso " + palabras[i].length() + " letras");
								}
						 	}
						break;
					case 3:
						System.out.println("Ingrese el numero de la dificultad en la que desea jugar: " +
							"\n1 - FACIL" + 
							"\n2 - NORMAL" +
							"\n3 - DIFICIL");
						int op = lea.nextInt();

						switch (op){
							case 1:
								dificultad = "FACIL";
								break;
							case 2:
								dificultad = "NORMAL";								
								break;
							case 3:
								dificultad = "DIFICIL";								
								break;
							default:
								dificultad = "NORMAL";
						}
						break;
					case 4:
						avgWin = (double)jugados / (double)ganados;
						avgLose = (double)jugados / (double)perdidos;						
						char popular = 'a';
						System.out.println("***REPORTE ESTADISTICO***\nCantidad de veces que se eligio la opcion JUGAR: " + jugados +
							"\nJuegos ganados: " + ganados + "\nPromedio de juegos ganados: " + avgWin +
							"\nJuegos perdidos: " + perdidos + "\nPromedio de juegos perdidos: " + avgLose +
							"\nCaracter mas veces ingresado (historico): " + popular);
						break;
					case 5:
						System.out.println("SALIENDO...");						
						break;
					default:
						System.out.println("Ingrese una opcion valida.");
				}

		} while (opcion != 5);

	}
}