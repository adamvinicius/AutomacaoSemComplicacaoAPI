package steps;

import java.util.Map;

import entidades.Header;
import entidadesMap.JsonPlaceHolderMap;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import massas.JsonPlaceHolderMapMassa;
import utils.RestUtils;

public class JsonPlaceHolderMapSteps {

	String url = "";
	String endpoint = "";
	String token = "";
	Header header;
	JsonPlaceHolderMap jsonPlaceHolderMap;
	
	@Dado("que sejam preenchidos os campos do JsonPlaceHolderMap")
	public void queSejamPreenchidosOsCamposDoJsonPlaceHolderMap() {
	    url = JsonPlaceHolderMapMassa.url;
	    endpoint = JsonPlaceHolderMapMassa.endpoint;
	    token = "Bearer "+JsonPlaceHolderMapMassa.token;
	    header = JsonPlaceHolderMapMassa.header;
	    jsonPlaceHolderMap = JsonPlaceHolderMapMassa.jsonPlaceHolderMap;
	    
	    RestUtils.setBaseUri(url);
	    header.setHeader("Authorization", token);
	}
	
	@Quando("forem alterados os campos do JsonPlaceHolderMap")
	public void foremAlteradosOsCamposDoJsonPlaceHolderMap(Map<String, Object> map) {
	   jsonPlaceHolderMap.setJsonPlaceHolderMap(map);
	}
	
	@Quando("for realizado uma requisicao do tipo POST do JsonPlaceHolderMap")
	public void forRealizadoUmaRequisicaoDoTipoPOSTDoJsonPlaceHolderMap() {
	    RestUtils.postRequest(endpoint, header.getHeader(), jsonPlaceHolderMap.getJsonPlaceHolderMap());
	}



}
