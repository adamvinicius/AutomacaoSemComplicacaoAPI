package viaCep;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ViaCepGetTest {

	static String url = "http://viacep.com.br/ws/";
	static Response response;
	
	@BeforeAll
	public static void setResponse() {
		baseURI = url;
		String cep = "04055041";
		getRequest(cep+"/json");
	}
	
	@Test
	public void validaStatusGet() {
		
		baseURI = url;
		String cep = "04055041";
		getStatusEndereco(cep+"/json");
		
		cep = "01214100";
		String endpoint = cep+"/json";
		getStatusEndereco(endpoint);
		
	}
		
	@Test
	public void validaLogradouro() {
		assertEquals("Rua Mauro", getResponse("logradouro"));
	}
	
	@Test
	public void validaBairro() {
		assertEquals("Saúde", getResponse("bairro"));
	}
	@Test
	public void validaLocalidade() {
		assertEquals("São Paulo", getResponse("localidade"));
	}
	
	@Test
	public void validaCep() {
		assertEquals("040", getResponse("cep"));
	}
	
	@Test
	public void validaDDD() {
		assertEquals("11", getResponse("ddd"));
	}
	
	@Test
	public void validaUF() {
		assertEquals("SPAAA", getResponse("uf"));
	}
	
	public Object getResponse(String key) {
		return response.getBody().jsonPath().get(key);
	}
	
	public void validaStatusCode(int status) {
		assertEquals(status, response.getStatusCode());
	}
	
	public static void getRequest(String endpoint) {
		response =
				given()
				.relaxedHTTPSValidation()
				.when()
				.get(endpoint)
				.then()
				.extract()
				.response();
	}
	
	

	public void getStatusEndereco(String endpoint) {
		getRequest(endpoint);
		System.out.println(getBody());
		validaStatusCode(200);
	}

	public static String getBody() {
		return response.getBody().asString();
	}
	
	
}
