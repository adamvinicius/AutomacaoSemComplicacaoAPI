package steps;


import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import utils.RestUtils;

public class CepSteps {
	String url = "http://viacep.com.br/ws/";
	String endpoint;
	
	@Dado("que seja recebido um cep valido com o valor {string}")
	public void queSejaRecebidoUmCepValidoComOValor(String cep) {
	    RestUtils.setBaseUri(url);
	    endpoint = cep+"/json/";
	}
	@Quando("for realizado uma requisicao do tipo Get do CEP")
	public void forRealizadoUmaRequisicaoDoTipoGet() {
	    RestUtils.getRequest(endpoint);
	}
	



}
