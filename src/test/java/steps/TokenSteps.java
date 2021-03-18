package steps;

import entidades.Login;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import massas.JsonPlaceHolderMassa;
import utils.RestUtils;

public class TokenSteps {
	String url = "";
	String endpoint = "";
	String token = "";
	Login login;
	
	@Dado("que sejam preenchidos os campos para autenticacao")
	public void queSejamPreenchidosOsCamposParaAutenticacao() {
	    JsonPlaceHolderMassa.inicializaJsonPlaceHolderMassa();
		
		url = JsonPlaceHolderMassa.url;
	    endpoint = JsonPlaceHolderMassa.endpoint;
	    login = JsonPlaceHolderMassa.login;
	    
	    RestUtils.setBaseUri(url);
	    
	}
	
	@Quando("for realizado uma requisicao do tipo POST do Token")
	public void forRealizadoUmaRequisicaoDoTipoPOSTDoToken() {
	    RestUtils.postRequest(endpoint, login);
	}
	
	@Entao("o valor do token e armazenado")
	public void oValorDoTokenEArmazenado() {
	    token = (String) RestUtils.getResponse("token");
	    JsonPlaceHolderMassa.token = token;
	}
	
	@Quando("for realizado uma requisicao do tipo POST do Token e o valor do token e armazenado")
	public void forRealizadoUmaRequisicaoDoTipoPOSTDoTokenEOValorDoTokenEArmazenado() {
		this.queSejamPreenchidosOsCamposParaAutenticacao();
		this.forRealizadoUmaRequisicaoDoTipoPOSTDoToken();
		this.oValorDoTokenEArmazenado();
	}






}
