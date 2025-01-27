package arbolBinarioOrdenado;
import arbolBinario.*;

public class ArbolBinarioBusqueda  extends ArbolBinario{
	public ArbolBinarioBusqueda()
	{
		super();
	}


	public NodoArbol buscar(Estudiante buscado)	{
		Comparador dato;
		dato = (Comparador) buscado;
		if (raiz == null)
			return null;
		else
			return localizar(raizArbol(), dato);
	}


	protected NodoArbol localizar(NodoArbol raizSub, Comparador buscado) {
		if (raizSub == null)
			return null;
		else if (buscado.igualQue(raizSub.valorNodo()))
			return raiz;
		else if (buscado.menorQue(raizSub.valorNodo()))
			return localizar(raizSub.subarbolIzdo(), buscado);
		else
			return localizar (raizSub.subarbolDcho(), buscado);
	}


	public NodoArbol buscarIterativo (Estudiante buscado) {
		Comparador dato;
		boolean encontrado = false;
		NodoArbol raizSub = raiz;
		dato = (Comparador) buscado;
		while (!encontrado && raizSub != null)
		{
			if (dato.igualQue(raizSub.valorNodo()))
				encontrado = true;
			else if (dato.menorQue(raizSub.valorNodo()))
				raizSub = raizSub.subarbolIzdo();
			else
				raizSub = raizSub.subarbolDcho();
		}	
		return raizSub;
	}


	public void insertar (Estudiante valor )throws Exception {
		Comparador dato;
		dato = (Comparador) valor;
		raiz = insertar(raiz, dato);
	}

	//método interno para realizar la operación
	protected NodoArbol insertar(NodoArbol raizSub, Comparador dato) throws Exception {
		if (raizSub == null)
			raizSub = new NodoArbol((Estudiante) dato);
		else if (dato.menorQue(raizSub.valorNodo())) {
			NodoArbol iz;
			iz = insertar(raizSub.subarbolIzdo(), dato);
			raizSub.ramaIzdo(iz);
		}
		else if (dato.mayorQue(raizSub.valorNodo())) {
			NodoArbol dr;
			dr = insertar(raizSub.subarbolDcho(), dato);
			raizSub.ramaDcho(dr);
		}
		else
			throw new Exception("Nodo duplicado");
		return raizSub;
	}

	public void eliminar (Estudiante valor) throws Exception
	{
		Comparador dato;
		dato = (Comparador) valor;
		raiz = eliminar(raiz, dato);
	}


	//método interno para realizar la operación
	protected NodoArbol eliminar (NodoArbol raizSub, Comparador dato) throws Exception {
		if (raizSub == null)
			throw new Exception ("No encontrado el nodo con la clave");
		else if (dato.menorQue(raizSub.valorNodo())) {
			NodoArbol iz;
			iz = eliminar(raizSub.subarbolIzdo(), dato);
			raizSub.ramaIzdo(iz);
		}
		else if (dato.mayorQue(raizSub.valorNodo())) {
			NodoArbol dr;
			dr = eliminar(raizSub.subarbolDcho(), dato);
			raizSub.ramaDcho(dr);
		} 
		else { // Nodo encontrado
			NodoArbol q;
			q = raizSub; // nodo a quitar del árbol
			if (q.subarbolIzdo() == null)
				raizSub = q.subarbolDcho();
			else if (q.subarbolDcho() == null)
				raizSub = q.subarbolIzdo();
			else { // tiene rama izquierda y derecha
				q = reemplazar(q);
			}
			q = null;
		}
		return raizSub;
	}

	// método interno para susutituir por el mayor de los menores
	private NodoArbol reemplazar(NodoArbol act)
	{
		NodoArbol a, p;
		p = act;
		a = act.subarbolIzdo(); // rama de nodos menores
		while (a.subarbolDcho() != null) {
			p = a;
			a = a.subarbolDcho();
		}
		act.nuevoValor(a.valorNodo());
		if (p == act)
			p.ramaIzdo(a.subarbolIzdo());
		else
			p.ramaDcho(a.subarbolIzdo());
		return a;
	}

}
