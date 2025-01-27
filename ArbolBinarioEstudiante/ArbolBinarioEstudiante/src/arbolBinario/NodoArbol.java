package arbolBinario;
import arbolBinarioOrdenado.*;
public class NodoArbol {
	protected Estudiante dato;
	protected NodoArbol izdo, dcho;

	public NodoArbol(Estudiante dato) {
		this.dato = dato;
		izdo = dcho = null;
	}

	public NodoArbol(NodoArbol ramaIzdo, Estudiante dato, NodoArbol ramaDcho)	{
		this.dato = dato;
		this.izdo = ramaIzdo;
		this.dcho = ramaDcho;
	}

	// operaciones de acceso
	public Estudiante valorNodo(){ return dato; }
	public NodoArbol subarbolIzdo(){ return izdo; }
	public NodoArbol subarbolDcho(){ return dcho; }
	public void nuevoValor(Estudiante d){ dato = d; }
	public void ramaIzdo(NodoArbol n){ izdo = n; }
	public void ramaDcho(NodoArbol n){ dcho = n; }

	@Override
	public String toString() {
		return "NodoArbol [dato=" + dato + ", izdo=" + izdo + ", dcho=" + dcho + "]";
	}

	public void visitar() {
		Estudiante E1 = (Estudiante) valorNodo();
		System.out.print("Nombre: "+ E1.getNombre() + ". Matricula:" + E1.getNumMat() + "\n");
	}
}

