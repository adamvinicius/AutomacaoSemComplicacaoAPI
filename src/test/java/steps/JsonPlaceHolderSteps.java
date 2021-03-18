package steps;

import java.util.Map;

import entidades.Header;
import entidades.JsonPlaceHolder;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import massas.JsonPlaceHolderMassa;
import utils.RestUtils;

public class JsonPlaceHolderSteps {
	
	String url = "";
	String endpoint = "";
	String token = "";
	Header header;
	JsonPlaceHolder jsonPlaceHolder;
	
	@Dado("que sejam preenchidos os campos do JsonPlaceHolder")
	public void queSejamPreenchidosOsCamposDoJsonPlaceHolder() {
	    JsonPlaceHolderMassa.inicializaJsonPlaceHolderMassa();
	    
		url = JsonPlaceHolderMassa.url;
	    endpoint = JsonPlaceHolderMassa.endpoint;
	    token = "Bearer "+JsonPlaceHolderMassa.token;
	    header = JsonPlaceHolderMassa.header;
	    jsonPlaceHolder = JsonPlaceHolderMassa.jsonPlaceHolder;
	    
	    header.setHeader("Authorization", token);
	    
	}
	@Quando("forem alterados os campos do JsonPlaceHolder")
	public void foremAlteradosOsCamposDoJsonPlaceHolder(Map<String, Object> map) {
	    jsonPlaceHolder.setNome(map.get("nome"));
	    jsonPlaceHolder.setIdade(map.get("idade"));
	}
	
	@Quando("for realizado uma requisicao do tipo POST do JsonPlaceHolder")
	public void forRealizadoUmaRequisicaoDoTipoPOSTDoJsonPlaceHolder() {
	    RestUtils.postRequest(endpoint, header.getHeader(), jsonPlaceHolder);
	    System.out.println(RestUtils.getBody());
	}
	



	



}
