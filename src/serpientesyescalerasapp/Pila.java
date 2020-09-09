package serpientesyescalerasapp;
public class Pila <T> {
	private int Tope, Max ;
	private T [] P;
	public T Dr;
	
	public Pila(){
		this(10);
	}
	public Pila(int Max){
		this.Max=Max;
		Tope=-1;
		P=(T[])new Object[Max];
	}
	public boolean Inserta(T Dato){
		if(Llena())
			return false;
		Tope++;
		P[Tope]=Dato; // P[++Tope]=Dato;
		return true;
	}
	public boolean Retira(){
		if(Vacia())
			return false;
		Dr=P[Tope];
		P[Tope]=null;
		Tope--; // --Tope; Tope=Tope-1; Tope-=1
		return true;
	}
	public boolean Vacia(){
		return Tope==-1;
	}
	public boolean Llena(){
		return Tope==Max-1;
	}
}
