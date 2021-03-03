package viaCep;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import utils.RestUtils;

class viaCepGetRestUtilsTest {

static String url = "http://viacep.com.br/ws/";
	
	@BeforeAll
	public static void setResponse() {
		
		RestUtils.setBaseUri(url);
		String cep = "04055041";
		RestUtils.getRequest(cep+"/json");
	}
	
	@Test
	public void validaStatusGet() {
		
		RestUtils.setBaseUri(url);
		String cep = "04055041";
		getStatusEndereco(cep+"/json");
		
		cep = "01214100";
		String endpoint = cep+"/json";
		getStatusEndereco(endpoint);
		
	}
		
	@Test
	public void validaLogradouro() {
		assertEquals("Rua Mauro", RestUtils.getResponse("logradouro"));
	}
	
	@Test
	public void validaBairro() {
		assertEquals("Saúde", RestUtils.getResponse("bairro"));
	}
	@Test
	public void validaLocalidade() {
		assertEquals("São Paulo", RestUtils.getResponse("localidade"));
	}
	
	@Test
	public void validaCep() {
		assertEquals("040", RestUtils.getResponse("cep"));
	}
	
	@Test
	public void validaDDD() {
		assertEquals("11", RestUtils.getResponse("ddd"));
	}
	
	@Test
	public void validaUF() {
		assertEquals("SPAAA", RestUtils.getResponse("uf"));
	}
	
	public void validaStatusCode(int status) {
		assertEquals(status, RestUtils.getStatusCode());
	}
	
	public void getStatusEndereco(String endpoint) {
		RestUtils.getRequest(endpoint);
		System.out.println(RestUtils.getBody());
		validaStatusCode(200);
	}

}
