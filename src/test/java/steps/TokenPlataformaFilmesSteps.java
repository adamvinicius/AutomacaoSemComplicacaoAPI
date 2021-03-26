package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import massas.TokenMassa;
import utils.RestUtils;

public class TokenPlataformaFilmesSteps {

	TokenMassa tokenMassa;
	
	
	@Dado("que sejam preenchidos os campos com valores validos do token")
	public void queSejamPreenchidosOsCamposComValoresValidosDoToken() {
	    tokenMassa = new TokenMassa();
	    RestUtils.setBaseUri(tokenMassa.url);
	}
	
	@Quando("for realizado uma requisicao do tipo POST de Token de PlataformaFilme")
	public void forRealizadoUmaRequisicaoDoTipoPOSTDeTokenDePlataformaFilme() {
	    RestUtils.postRequest(tokenMassa.endpoint, tokenMassa.token.getToken());
	}
	@Entao("valor do token de plataformaFilmes e armazenado")
	public void valorDoTokenDePlataformaFilmesEArmazenado() {
	    String _token = RestUtils.getResponse("token").toString();
	    String tipo = RestUtils.getResponse("tipo").toString();
		
		TokenMassa.authorization = tipo + " " + _token;
	}
	
	



}
