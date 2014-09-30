import java.util.Calendar;
import java.util.Date;


public class PrincipalEx1 {
/*
 * Ejercicio M03-UF4.1 -01.
		Haz un programa en Java que obtenga la fecha actual del sistema y
			
			a. Permita obtener por separado y lo muestre por consola: el día del mes, el día de la 
				semana y la hora (formato 24h). Revisa la documentación de las clases
				java.util.Calendar, java.util.GregorianCalendar para llevar a cabo este apartado
				Por ejemplo si la fecha actual del sistema es Fri Aug 29 16:05:13 CEST 2014, la salida por 
				consola sería
					 Día del mes: 29
					 Día de la semana: 6
					 Hora del día (24Hrs): 16
			
			b. Permita añadir un mes a la fecha actual y muestre la fecha calculada por consola. La 
			   fecha calculada se mostrará en el formato dd/MM/yyyy hh:mm. Para mostrar la fecha 
			   puedes hacer uso de la clase java.text.SimpleDateFormat
		
		Requisitos no funcionales del programa:
					 El programa sólo puede contener una Clase. 
					 El programa debe ser modular
					 Cada módulo del programa debe disponer de una breve descripción funcional del mismo
					 El programa debe respetar The Clean Coding Practices
 */

public static void main(String[] args) {
		Date hoy=new Date();
		Calendar calendario=Calendar.getInstance();
		calendario.setTime(hoy);
		//apartado a
		System.out.println("Hoy es => "+hoy);
		System.out.println("Dia del mes: "+hoy.getDate());
		System.out.println("Dia de la semana: "+hoy.getDay());
		System.out.println("Hora del día: "+hoy.getHours());
		//apartado b
		System.out.println("Incremento de un mes ala fecha actual: ");
		System.out.println(calendario.get(Calendar.DAY_OF_MONTH)+"/"+calendario.get(Calendar.MONTH)+"/"+calendario.get(Calendar.YEAR));
	}
}
