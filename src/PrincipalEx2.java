import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;


public class PrincipalEx2 {
/*
 *		 Ejercicio M03-UF4.1 -02.
		Haz un programa en Java que permita listar por consola los ficheros/directorios que contiene 
		un directorio que el usuario introducirá por consola. Para cada fichero/directorio contenido en 
		el directorio introducido por el usuario, muestra los siguientes datos:
			 Ruta (path)
			 Indicar si es un directorio o un archivo. 
			 Si es un directorio indicar el número de ficheros y directorios que contiene.
			 Si tiene permisos de lectura
 */
	private static BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
	static byte cont_f=0, cont_d=0;
	public static void main(String[] args) {
		boolean entra=false;
		String input="";
		do{
		try{
		System.out.print("Introduce la ruta de un directorio o archivo => ");
		input=stdin.readLine();
		entra=true;
		}catch(Exception e){
			System.out.println("Valor fuera de rango");
			entra=false;
		}
		}while(entra==false);
		File dir=new File(input);
		System.out.println(input);
		PrincipalEx2.listarDirectorio(dir, "\t");
		System.out.println("El directorio "+input+" tiene "+cont_d+" directorios i "+cont_f+" ficheros");
	}
	  
	public static void listarDirectorio(File f, String separador){
          File[] ficheros = f.listFiles();
                          
          for (int x=0;x<ficheros.length;x++){                    
                  System.out.println(separador + ficheros[x].getName());
                  
                  if (ficheros[x].isDirectory()){
                	  cont_d++;
                	  //System.out.println(" => Es un directorio");
                          String nuevo_separador;
                          nuevo_separador = separador + "\t";
                          listarDirectorio(ficheros[x],nuevo_separador);
                  }
                  else{
                	  cont_f++;
                	  //System.out.println(" => Es un archivo");
                  }
          }       
  }

}
