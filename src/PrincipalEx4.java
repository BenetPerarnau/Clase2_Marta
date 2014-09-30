import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;


public class PrincipalEx4 {
	public static ArrayList <String[]> bbdd=new ArrayList <String[]>();
	public static void main(String[] args) {
		
		bbdd=PrincipalEx4.leerbbdd();
		PrincipalEx4.imprimirbbdd(bbdd);
		PrincipalEx4.buscarbecado(bbdd);

	}
	public static ArrayList<String[]> leerbbdd(){
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
		float max=0;
		for(int i=0; i<bbdd.size(); i++){
			if(bbdd.get(i)[2].equalsIgnoreCase("F")){
				float aux=Float.parseFloat(bbdd.get(i)[1]);
				if(aux>max){max=aux;}
			}
		}

		for(int i=0; i<bbdd.size(); i++){
			if(bbdd.get(i)[1].equalsIgnoreCase(max+"")){
				System.out.println("El alumno becado es => "+bbdd.get(i)[0]+" "+bbdd.get(i)[1]+" "+bbdd.get(i)[2]);
			}
		}
	}
}
