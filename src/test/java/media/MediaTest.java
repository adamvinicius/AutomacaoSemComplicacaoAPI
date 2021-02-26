package media;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MediaTest {

	@Test
	void validaAprovado() {
		double nota1 = 5;
		double nota2 = 5;
		
		Media media = new Media(nota1, nota2);
		
		assertEquals("Aprovado", media.getResultado());
	}
	
	@Test
	void validaReprovado() {
		double nota1 = 4.9;
		double nota2 = 5;
		
		Media media = new Media(nota1, nota2);
		
		assertEquals("Reprovado", media.getResultado());
	}

}
