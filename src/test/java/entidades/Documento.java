package entidades;

public class Documento {

	private Object tipo;
	private Object valor;
	
	
	public Documento(Object tipo, Object valor) {
		this.tipo = tipo;
		this.valor = valor;
	}
	
	
	public Object getTipo() {
		return tipo;
	}
	public void setTipo(Object tipo) {
		this.tipo = tipo;
	}
	public Object getValor() {
		return valor;
	}
	public void setValor(Object valor) {
		this.valor = valor;
	}
	
	
}
