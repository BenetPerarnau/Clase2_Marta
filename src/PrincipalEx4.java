import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
/*
 * Ejercicio M03-UF4.1 -04 (ENTREGABLE).
 * El fichero Alumne.dat contiene información de los alumnos de una clase, su nombre, apellidos, 
	su nota media y si se la concedido una beca para continuar estudios en extranjero en cursos 
	anteriores (V/F): Apellido1 Apellido2 Nombre NotaMedia Beca.
	Guarda este fichero en el worspace de la aplicación Java. Realiza un programa en Java que 
	permita saber a qué alumno se le concederá beca este curso académico, teniendo en cuenta 
	que debe ser el alumno que tenga mayor nota media de la clase y no se le haya concedido 
	beca previamente. Para ello tendrás que leer el contenido del fichero Alumne.dat y mostrar 
	por consola Nombre y Apellidos, nota media de la persona que cumpla con este requisito.
	
	Requisitos no funcionales del programa:
	
		 El programa sólo puede contener una Clase. 
		 El programa debe ser modular
		 Cada módulo del programa debe disponer de una breve descripción funcional del mismo
		 El programa debe respetar The Clean Coding Practices
 */

public class PrincipalEx4 {
	public static ArrayList <String[]> bbdd=new ArrayList <String[]>();
	public static void main(String[] args) {
		
		bbdd=PrincipalEx4.leerbbdd();
		PrincipalEx4.imprimirbbdd(bbdd);
		PrincipalEx4.buscarbecado(bbdd);

	}
	public static ArrayList<String[]> leerbbdd(){
		/*
		 * Aquest metode el que fa es anar a un arxiu del nostre ordinador i lleguir el seu contingut.
		 * Aquest contingut sera emagatzemat dins d'un array list.
		 * Retorna aquest array list ple de info al metode main
		 *
		 */
		File archivo=null;
		FileReader fr=null;
		BufferedReader br=null;
		try{
			archivo=new File("/Users/Benet/Documents/workspace2/Clase2_Marta/src/Alumnos.txt");
			fr=new FileReader(archivo);
			br=new BufferedReader(fr);
			
			String linea="";
			while((linea=br.readLine())!=null){
				bbdd.add(linea.split(";"));
			}
			
			fr.close();
			
		}catch(Exception e){
			System.out.println("Error en leer el archivo de la BBDD");
		}
		return bbdd;
	}
	public static void imprimirbbdd(ArrayList<String[]> bbdd){
		/*
		 * Aquest metode el que fa es rebre un array list i imprimir tot el contingut
		 */
		System.out.println("Nombre\t\t\t\tNota\t\tBeca Anterior");
		System.out.println("––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––");
		for(int i=0; i<bbdd.size(); i++){
			for(int j=0; j<3; j++ ){
				System.out.print(bbdd.get(i)[j]+"\t\t");
			}
			System.out.println("");
		}
	}
	public static void buscarbecado(ArrayList<String[]> bbdd){
		/*
		 * Aquest metode es el que fa la feina dura, es a dir, com que el enunciat demana que el
		 * alumne becat sera un alumne que l'any anterior no se li va donar la beca el primer que
		 * fara es buscar els alumnes que tenen "f" i d'aquest trobar la mitja mes alta.
		 */
		float max=0;
		for(int i=0; i<bbdd.size(); i++){
			if(bbdd.get(i)[2].equalsIgnoreCase("F")){//entra si en la fila i columa 2 hi ha una "F" o "f"
				float aux=Float.parseFloat(bbdd.get(i)[1]);//guarda la nota d'aquesta fila a "aux"
				if(aux>max){max=aux;} //si "aux" es mes gran que "max", el nou max sera aquesta nota
			}
		}
		//aqui ya sabem quina es la millor nota dels que tenen "f" 
		//ara el unic que hem de fer es trobar la fila d'aquesta nota i imprimir el nom del alumne

		for(int i=0; i<bbdd.size(); i++){
			if(bbdd.get(i)[1].equalsIgnoreCase(max+"") && bbdd.get(i)[2].equalsIgnoreCase("F") ){
				//buscar en cada fila la nota i per si agues un alumne que te la mateixa nota pero "V" posem una altre
				//condició al if que en la ultima casella a de tenir "f"
				//imprimim aquest alumne 
				System.out.println("El alumno becado es => "+bbdd.get(i)[0]+" "+bbdd.get(i)[1]+" "+bbdd.get(i)[2]);
			}
		}
	}
}
