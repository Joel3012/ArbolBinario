package arbolBinario;
import arbolBinarioOrdenado.*;

public class ArbolBinario {
	
	protected NodoArbol raiz;
	public ArbolBinario() {
		raiz = null;
	}

	public ArbolBinario(NodoArbol raiz) {
		this.raiz = raiz;
	}

	public NodoArbol raizArbol() {
		return raiz;
	}

	public static NodoArbol nuevoArbol(NodoArbol ramaIzqda, Estudiante dato, NodoArbol ramaDrcha) {
		return new NodoArbol(ramaIzqda, dato, ramaDrcha);
	}

	//Comprueba el estatus del árbol
	public boolean esVacio() {
		return raiz == null;
	}

	// Recorrido de un árbol binario en preorden
	public static void preorden(NodoArbol r) {
		if (r != null)
		{
			r.visitar();
			preorden (r.subarbolIzdo());
			preorden (r.subarbolDcho());
		}
	}

	// Recorrido de un árbol binario en inorden
	public static void inorden(NodoArbol r) {
		if (r != null)
		{
			inorden (r.subarbolIzdo());
			r.visitar();
			inorden (r.subarbolDcho());
		}
	}

	// Recorrido de un árbol binario en postorden
	public static void postorden(NodoArbol r) {
		if (r != null)
		{
			postorden (r.subarbolIzdo());
			postorden (r.subarbolDcho());
			r.visitar();
		}
	}

	public static int numNodos(NodoArbol raiz) {
		if (raiz == null)
			return 0;
		else
			return 1 + numNodos(raiz.subarbolIzdo()) +
					numNodos(raiz.subarbolDcho());
	}
	
	
}

