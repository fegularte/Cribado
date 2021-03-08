package ed_T4Cribado00;

import java.util.Scanner;

public class Criba {
	//m�todo principal de la aplicaci�n
	public static void main(String[] args) {
		//tomar valor tope del usuario
			Scanner teclado= new Scanner(System.in);
			System.out.println("Introducir un valor tope para la criba de Erast�tenes:");
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
	//m�todo de feedback inicial usado por el constructor
	public boolean inicio() {
		if(tope >= 2) {
			//mostrar la serie inicial de n�meros ayudandonos de un vector
			int vector[]= new int[tope];
			System.out.println("\nSerie de n�meros de partida (hasta " + tope + "): ");
			//recorremos vector para mostrar sus indices hasta tope
			for(int i=0; i<vector.length; i++) {
				// mostramos serie inicial de n�meros de partida
				System.out.print(i+1 + "\t");
			}
			//generamos la serie de n�meros primos
			generarPrimos();
			return true;
		}else {
			//si tope < 2, devolvemos mensaje
			System.out.println("El valor tope debe ser un n�mero entero >= 2");
			return false;
		}
	}
	
	//generar n�meros primos de 1 a max definido por user
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
					//...tachamos los m�ltiplos del �ndice actual
					for(j=2*i; j<tope; j+=i) {
						esPrimo[j]= false;
					}
				}
			}
				
			//contar los n�s primos que hay finalmente
			int totalPrimos= 0;
			for(i=0; i<tope; i++) {
				//si la posici�n actual es true = no tachado = primo
				if(esPrimo[i]) {
					//aumentamos contador
					totalPrimos++;
				}
			}
			System.out.println("\nTotal n�s primos encontrados: " + totalPrimos);
				
			//almacenar los primos en un array de primos
			primos= new int[totalPrimos];
			for(i=0, j=0; i<tope; i++) {
				//si el �ndice actual del vetor de criba es true = es primo
				if(esPrimo[i]) {
					//almacenamos el indice en array de primos
					primos[j]= i;
					j++;
				}
			}
			System.out.print("Serie de n�meros primos hallados:");
			//devolvemos el array de n�s primos final
			for(i=0; i<primos.length; i++) {
				System.out.print("\t" + primos[i]);
			}
			return true;
	}
	
}