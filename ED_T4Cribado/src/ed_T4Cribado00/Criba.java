package ed_T4Cribado00;

import java.util.Scanner;

public class Criba {
	//generar números primos de 1 a max definido por user
	public static int[] generarPrimos(int max) {
			int i, j;
			if(max >= 2) {
				//declaracion del array
				int dimension= max + 1;
				//array boolean de aciertos
				boolean [] esPrimo = new boolean[dimension];
					//inicilizacion array aciertos
					for( i=0; i<dimension; i++) {
							esPrimo[i] = true;
							//eliminar el 0 y el 1 por no ser nºs primos
							esPrimo[0] = esPrimo[1] = false;
							//cribado
							for(i=2; i<Math.sqrt(dimension)+1; i++) {
									//si valor de indice actual del array es true...
									if(esPrimo[i]) {
											//...tachamos los múltiplos del índice actual
											for(j=2*i; j<dimension; j+=i) {
													esPrimo[j]= false;
											}
									}
							}
					}
					//contar los nºs primos que hay finalmente
					int totalPrimos= 0;
					for(i=0; i<dimension; i++) {
							//si la posición actual es true = no tachado
							if(esPrimo[i]) {
									//aumentamos contador
									totalPrimos++;
							}
					}
					//almacenar los primos en un array de primos
					int[] primos= new int[totalPrimos];
					for(i=0, j=0; i<dimension; i++) {
							//si el índice actual del vetor de criba es true = es primo
							if(esPrimo[i]) {
									//almacenamos el indice en array de primos
									primos[j++]= i;
							}
					}
					//devolvemos el array de nºs primos final
					return primos;
			}else {
				//si max < 2, devolvemos un vector vacio
				return new int[0];
			}
	}
	//método principal de la aplicación
	public static void main(String[] args) {
		//tomar valor tope del usuario
		Scanner teclado= new Scanner(System.in);
		System.out.println("Introducir un nº tope para la criba de Erastótenes:");
		int dato= teclado.nextInt();
		//crear y mostrar un vector de resultado inicialmente vacio
		int vector[]= new int[dato];
		System.out.println("\nVector inicial hasta tope: " + dato);
		//recorremos vector resultado
		for(int i=0; i<vector.length; i++) {
			//si resto de dividir por 10 es cero...
			if(i%10 == 0) {
				//si estamos en índice 0, pasamos al siguiente
				System.out.println();
			}
			// mostramos vector inicial de datos de partida
			System.out.print(i+1 + "\t");
		}
		//cribamos los primos
		vector= generarPrimos(dato);
		//damos feedback de incio de criba
		System.out.print("\nVector de primos hasta: " + dato);
		//mostramos los resutlados
		for(int i=0; i<vector.length; i++) {
			//ignoramos la posicion 0
			if(i%10 == 0) {
				System.out.println();
			}
			//mostramos los nºs primos de resultado
			System.out.print(vector[i] + "\t");
		}
	}
}