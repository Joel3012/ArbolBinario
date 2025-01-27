package arbolBinarioOrdenado;

public class Estudiante implements Comparador{
	int numMat;
	String nombre;
	
	public int getNumMat() {
		return numMat;
	}

	public void setNumMat(int numMat) {
		this.numMat = numMat;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public boolean menorQue(Object op2) {
		Estudiante p2 = (Estudiante) op2;
		return numMat < p2.numMat;
	}

	@Override
	public boolean igualQue(Object op2) {
		Estudiante p2 = (Estudiante) op2;
		return numMat == p2.numMat;
	}

	@Override
	public boolean menorIgualQue(Object op2) {
		Estudiante p2 = (Estudiante) op2;
		return numMat <= p2.numMat; 
	}

	@Override
	public boolean mayorQue(Object op2) {
		Estudiante p2 = (Estudiante) op2;
		return numMat > p2.numMat;
	}

	@Override
	public boolean mayorIgualQue(Object op2) {
		Estudiante p2 = (Estudiante) op2;
		return numMat >= p2.numMat;
	}

}
