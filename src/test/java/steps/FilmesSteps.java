package steps;

import java.util.LinkedHashMap;

import entidadesMap.TokenMap;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import massas.FilmesMassa;
import massas.TokenMassa;
import utils.RestUtils;

public class FilmesSteps {

	String authorization;
	FilmesMassa filmesMassa;
	LinkedHashMap<String, String> header;
	
	@Dado("que sejam preenchidos os campos com valores validos do filmes")
	public void queSejamPreenchidosOsCamposComValoresValidosDoFilmes() {
	    filmesMassa = new FilmesMassa();
	    RestUtils.setBaseUri(FilmesMassa.url);
	    header = new LinkedHashMap<>();
	    authorization = TokenMassa.authorization;
	    header.put("Authorization", authorization);
	    
	}
	
	@Quando("for realizado uma requisicao do tipo POST de filmes de PlataformaFilme")
	public void forRealizadoUmaRequisicaoDoTipoPOSTDeFilmesDePlataformaFilme() {
	    RestUtils.postRequest(FilmesMassa.endpoint, header, filmesMassa.filmes.getFilmes());
	}



}
