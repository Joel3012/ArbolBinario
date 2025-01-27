package interfazArbolBinario;
import java.util.Scanner;
import arbolBinarioOrdenado.*;

public class Principal {
	public static void main(String[] args) throws Exception {
		ArbolBinarioBusqueda arb1 = new ArbolBinarioBusqueda();
		System.out.println(arb1.raizArbol());
		Scanner leer = new Scanner(System.in);//FUNCION PARA LEER POR TECLADO
		boolean salir = false;//VARIABLE BOOLEANA PARA VERIFICAR LA SALIDA
		int opcion;//VARIABLE PARA ELEGIR LA OPCION DE MENU
		Object dato;//VARIABLE DE DATO INGRESADO
		while (!salir){//CICLO REPETIVO PARA EL MENU
			System.out.println("==========================================");
			System.out.println("||            Menu de opciones          ||");
			System.out.println("==========================================");
			System.out.println("|| 1. Insertar nuevo Estudiante  	||");
			System.out.println("|| 2. Buscar Estudiante          	||");
			System.out.println("|| 3. Eliminar Estudiante        	||");
			System.out.println("|| 4. Recorrido preorden         	||");
			System.out.println("|| 5. Recorrido en orden         	||");
			System.out.println("|| 6. Recorrido postorden        	||");
			System.out.println("|| 7. Salir                      	||");
			System.out.println("==========================================");
			System.out.print("Escribe una de las opciones: ");//MENU DE OPCIONES
			opcion = leer.nextInt();//INGRESO PARA ELEGIR LA OPCION DE MENU
			Estudiante estN = new Estudiante();
			switch (opcion) {
			case 1://PRIMER CASO DEL MENU: INSERTA UN NUEVO ESTUDIANTE EN EL ARBOL BINARIO
				System.out.println("Has seleccionado Insertar nuevo Estudiante");
				System.out.print("Ingrese el nombre del nuevo estudiante: ");
				dato = leer.next();
				estN.setNombre(dato.toString());
				System.out.print("Ingrese el numero de la matriula del nuevo estudiante: ");
				dato = leer.nextInt();
				estN.setNumMat(((Integer) dato).intValue());
				arb1.insertar(estN);
				break;

			case 2://SEGUNDO CASO: 
				System.out.println("Has seleccionado Buscar Estudiante");
				System.out.print("Ingrese el nombre del estudiante a buscar: ");
				dato = leer.next();
				estN.setNombre(dato.toString());
				System.out.print("Ingrese el numero de la matriula del estudiante a buscar: ");
				dato = leer.nextInt();
				estN.setNumMat(((Integer) dato).intValue());
				if(arb1.buscarIterativo(estN)==null) {
					System.out.println("No se ha encontrado el Estudiante");
				}else {
					System.out.println("Si se ha encontrado el Estudiante");
				}
				break;

			case 3://TERCER CASO: 
				System.out.println("Has seleccionado Eliminar Estudiante");
				System.out.print("Ingrese el nombre del estudiante a eliminar: ");
				dato = leer.next();
				estN.setNombre(dato.toString());
				System.out.print("Ingrese el numero de la matriula del estudiante a eliminar: ");
				dato = leer.nextInt();
				estN.setNumMat(((Integer) dato).intValue());
				if(arb1.buscarIterativo(estN)==null) {
					System.out.println("No se8ha encontrado el Estudiante");
				}else {
					arb1.eliminar(estN);
					System.out.println("Si se ha podido eliminar a el Estudiante");
				}
				break;

			case 4://CUARTO CASO: 
				System.out.println("Has seleccionado Recorrido preorden");
				if(arb1.esVacio()) {
					System.out.println("El arbol se encuentra vacio");
				}else {
					arb1.preorden(arb1.raizArbol());
				}

			case 5://QUINTO CASO: 
				System.out.println("Has seleccionado Recorrido en orden");
				if(arb1.esVacio()) {
					System.out.println("El arbol se encuentra vacio");
				}else {
					arb1.inorden(arb1.raizArbol());
				}
				break;

			case 6://SEXTO CASO: 
				System.out.println("Has seleccionado Recorrido postorden");
				if(arb1.esVacio()) {
					System.out.println("El arbol se encuentra vacio");
				}else {
					arb1.postorden(arb1.raizArbol());
				}
				break;

			case 7://SEPTIMO CASO: SALE DEL MENU
				salir = true;
				System.out.println("Gracias por visitarmos :)");
				break;

			default://DEFAULT: RESTRINGE AL USO DE OPCIONES DE TIPO NUMERICO
				System.out.println("Solo numeros entre 1 y 6");
			}
		}
	}
}


