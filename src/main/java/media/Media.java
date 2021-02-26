package media;

public class Media {

	private double nota1;
	private double nota2;
	
	public Media(double nota1, double nota2) {
		this.nota1 = nota1;
		this.nota2 = nota2;
	}

	public String getResultado() {
		double media = (nota1+nota2)/2;
		if (media < 5) {
			return "Reprovado";
		}
		return "Aprovado";
	}
	
	

}
