import java.io.BufferedReader;
import java.io.InputStreamReader;


public class PrincipalEx3 {
/*
 * Ejercicio M03-UF4.1 -03.
		Haz un programa en Java que solicite al usuario 5 títulos de películas y su género
		(mini base de datos de una videoteca). Almacena estos datos en un array multidimensional.
		El programa debe permitir que el usuario pueda realizar una búsqueda por palabras del título y por género. 
		Para ello:
			
			a. Solicita al usuario una palabra de búsqueda del título. Busca en el array las coincidencias y muéstralas 
			por consola, indicando título/s completo de la/s película/s junto su género.
			
			b. Solicita al usuario un género. Busca en el array y muestra por consola los títulos de las películas que
			coincidan con el género facilitado
				
				Requisitos no funcionales del programa:
					 El programa sólo puede contener una Clase.
					 El programa debe ser modular
					 Cada módulo del programa debe disponer de una breve descripción funcional del mismo
					 El programa debe respetar The Clean Coding Practices
 */
	private static BufferedReader stdin=new BufferedReader (new InputStreamReader(System.in));
	private static String[][] bbdd=new String[5][2];
	public static void main(String[] args) {
		PrincipalEx3.pedirbbdd();
		PrincipalEx3.verbbdd();
		PrincipalEx3.buscar_titulo();
		PrincipalEx3.buscar_genero();

	}
	public static void pedirbbdd(){
		try{
			for(int i=0; i<5; i++){
					System.out.print("Nombre de la pelicula nº "+(i+1)+" => ");
					bbdd[i][0]=stdin.readLine();
					System.out.print("Nombre del  su genero => ");
					bbdd[i][1]=stdin.readLine();
			}
			
		}catch(Exception e){
			System.out.println("Valor fuera de rango");
		}
	}
	public static void verbbdd(){
		System.out.println("Titulo\tGenero");
		System.out.println("––––––––––––––");
		for(int i=0; i<bbdd.length; i++){
			for(int j=0; j<2; j++){
				System.out.print(bbdd[i][j]+"\t");
			}
			System.out.println("");
		}
	}
	public static void buscar_titulo(){
		String input="";
		try{
			System.out.print("Palabra a buscar en titulo => ");
			input=stdin.readLine();
		}catch(Exception e){
			System.out.println("Valor fuera de rango");
		}
		System.out.println("Titulo i genero de los titulos que contienen "+input+":");
		for(int i=0; i<bbdd.length; i++){
			if(bbdd[i][0].contains(input)){
			for(int j=0; j<2; j++){
				System.out.print(bbdd[i][j]+"\t");
			}
			System.out.println("");
			}
		}
	}
	public static void buscar_genero(){
		String input="";
		try{
			System.out.print("Palabra a buscar en genero => ");
			input=stdin.readLine();
		}catch(Exception e){
			System.out.println("Valor fuera de rango");
		}
		System.out.println("Titulos de las peliculas que su genero contiene "+input+":");
		for(int i=0; i<bbdd.length; i++){
			if(bbdd[i][1].contains(input)){
				System.out.println(bbdd[i][0]);
			}
		}
	}
}
