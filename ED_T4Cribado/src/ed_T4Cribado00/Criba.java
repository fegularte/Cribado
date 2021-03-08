package ed_T4Cribado00;

import java.util.Scanner;

public class Criba {
	//método principal de la aplicación
	public static void main(String[] args) {
		//tomar valor tope del usuario
			Scanner teclado= new Scanner(System.in);
			System.out.println("Introducir un valor tope para la criba de Erastótenes:");
			int dato= teclado.nextInt();
			//instancia de criba
			Criba vector = new Criba((int) dato);			
	}
	
	//atributos
	private int tope;
	private int[] primos;
	//contructor
		public Criba(int max){
			this.tope= max;
			this.inicio();
			return;
		}
	//método de feedback inicial usado por el constructor
	public boolean inicio() {
		if(tope >= 2) {
			//mostrar la serie inicial de números ayudandonos de un vector
			int vector[]= new int[tope];
			System.out.println("\nSerie de números de partida (hasta " + tope + "): ");
			//recorremos vector para mostrar sus indices hasta tope
			for(int i=0; i<vector.length; i++) {
				// mostramos serie inicial de números de partida
				System.out.print(i+1 + "\t");
			}
			//generamos la serie de números primos
			generarPrimos();
			return true;
		}else {
			//si tope < 2, devolvemos mensaje
			System.out.println("El valor tope debe ser un número entero >= 2");
			return false;
		}
	}
	
	//generar números primos de 1 a max definido por user
	public boolean generarPrimos() {
			int i, j;
			//array boolean de aciertos
			boolean [] esPrimo = new boolean[tope];
			//inicilizacion array aciertos
			for( i=0; i<tope; i++) {
				//inicialmente categorizamos todos como true
				esPrimo[i] = true;
				//eliminamos el 0 
				esPrimo[0] =  false;
			}
			
			//cribado
			for(i=2; i<Math.sqrt(tope)+1; i++) {
				//si valor de indice actual del array es true...
				if(esPrimo[i]) {
					//...tachamos los múltiplos del índice actual
					for(j=2*i; j<tope; j+=i) {
						esPrimo[j]= false;
					}
				}
			}
				
			//contar los nºs primos que hay finalmente
			int totalPrimos= 0;
			for(i=0; i<tope; i++) {
				//si la posición actual es true = no tachado = primo
				if(esPrimo[i]) {
					//aumentamos contador
					totalPrimos++;
				}
			}
			System.out.println("\nTotal nºs primos encontrados: " + totalPrimos);
				
			//almacenar los primos en un array de primos
			primos= new int[totalPrimos];
			for(i=0, j=0; i<tope; i++) {
				//si el índice actual del vetor de criba es true = es primo
				if(esPrimo[i]) {
					//almacenamos el indice en array de primos
					primos[j]= i;
					j++;
				}
			}
			System.out.print("Serie de números primos hallados:");
			//devolvemos el array de nºs primos final
			for(i=0; i<primos.length; i++) {
				System.out.print("\t" + primos[i]);
			}
			return true;
	}
	
}