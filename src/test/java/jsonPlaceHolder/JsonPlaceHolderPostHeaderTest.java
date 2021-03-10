package jsonPlaceHolder;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.junit.jupiter.api.Test;

import entidades.Documento;
import entidades.Header;
import entidades.JsonPlaceHolder;
import entidades.Login;
import entidadesMap.JsonPlaceHolderMap;
import entidadesMap.LoginMap;
import massas.JsonPlaceHolderMapMassa;
import massas.JsonPlaceHolderMassa;
import utils.RestUtils;

class JsonPlaceHolderPostHeaderTest {

	@Test
	void postHeaderTokenMapTest() {
		LinkedHashMap<String, Object> json = new LinkedHashMap<>();
		json.put("usuario", "Adam");
		json.put("senha", "12345");
		json.put("token", "2fa3e708-7840-481f-bf57-8f6ff1f5ce2c");
		
		RestUtils.setBaseUri("https://jsonplaceholder.typicode.com/");
		
		RestUtils.postRequest("posts", json);
		
		String token = "Bearer " + RestUtils.getResponse("token").toString();
		
		json = new LinkedHashMap<>();
		json.put("body", "xptqoaa");
		json.put("nome", "Adam Vinicius");
		json.put("idade", 32);
		
		LinkedHashMap<String, Object> documento = new LinkedHashMap<>();
		documento.put("tipo", "cpf");
		documento.put("valor", "3454215412");
		
		List<LinkedHashMap<String, Object>> documentos = new ArrayList<>();
		documentos.add(documento);
		json.put("documentos", documentos);
		
		LinkedHashMap<String, String> header = new LinkedHashMap<>();
		header.put("Authorization", token);
		
		RestUtils.postRequest("posts", header, json);
		
		//System.out.println(RestUtils.getBody());
			
		assertEquals("Adam Vinicius", RestUtils.getResponse("nome"));
		assertEquals(201, RestUtils.getStatusCode());
		
		
	}
	
	@Test
	void postHeaderTokenTest() {
		String json = "{"
				+ "    \"usuario\":\"adam\","
				+ "    \"senha\":\"123456\","
				+ "    \"token\":\"2fa3e708-7840-481f-bf57-8f6ff1f5ce2c\""
				+ "}";
		
		RestUtils.setBaseUri("https://jsonplaceholder.typicode.com/");
		
		RestUtils.postRequest("posts", json);
		
		String token = "Bearer " + RestUtils.getResponse("token").toString();
		
		json = "{"
				+ "    \"body\":\"xptqoaa\","
				+ "    \"nome\": \"Adam Vinicius\","
				+ "    \"idade\": 32,"
				+ "    \"documentos\": ["
				+ "        {"
				+ "            \"tipo\": \"cpf\","
				+ "            \"valor\": \"3454215412\""
				+ "        }"
				+ "    ]"
				+ "}";
		
		LinkedHashMap<String, String> header = new LinkedHashMap<>();
		header.put("Authorization", token);
		
		RestUtils.postRequest("posts", header, json);
		
		assertEquals("Adam Vinicius", RestUtils.getResponse("nome"));
		assertEquals(201, RestUtils.getStatusCode());
			
		
	}
	
	@Test
	void postHeaderTokenClasseTest() {
		Login login = new Login("adam", "123456", "2fa3e708-7840-481f-bf57-8f6ff1f5ce2c");
		
		RestUtils.setBaseUri("https://jsonplaceholder.typicode.com/");
		RestUtils.postRequest("posts", login);
		
		String token = RestUtils.getResponse("token").toString();
				
		Documento documento = new Documento("cpf", "3454215412");
		List<Documento> documentos = new ArrayList<>();
		
		documentos.add(documento);
		
		JsonPlaceHolder json = new JsonPlaceHolder("xptqoaa", "Adam Vinicius", 32, documentos);
		
		Header header = new Header(token, "xptqo", "121");
		header.removeKey("apikey");
		header.removeKey("id");
		
		RestUtils.postRequest("posts", header.getHeader(), json);
		
		assertEquals("Adam Vinicius", RestUtils.getResponse("nome"));
		assertEquals(201, RestUtils.getStatusCode());
	}
	
	@Test
	void postHeaderTokenMassaTest() {
		Login login = JsonPlaceHolderMassa.login;
		
		RestUtils.setBaseUri(JsonPlaceHolderMassa.url);
		RestUtils.postRequest(JsonPlaceHolderMassa.endpoint, login);
		
		JsonPlaceHolderMassa.token = RestUtils.getResponse("token").toString();
		
		JsonPlaceHolderMassa.addDocumentos();
		
		Header header = JsonPlaceHolderMassa.header;
		header.setHeader("Authorization", JsonPlaceHolderMassa.token);
		
		JsonPlaceHolder json = JsonPlaceHolderMassa.jsonPlaceHolder;
		
		RestUtils.postRequest(JsonPlaceHolderMassa.endpoint, header.getHeader(), json);
		
		assertEquals("Adam Vinicius", RestUtils.getResponse("nome"));
		assertEquals(201, RestUtils.getStatusCode());
		
	}
	
	@Test
	void postHeaderTokenMapMassaTest() {
		LoginMap loginMap = JsonPlaceHolderMapMassa.login;
		
		RestUtils.setBaseUri(JsonPlaceHolderMapMassa.url);
		RestUtils.postRequest(JsonPlaceHolderMapMassa.endpoint, loginMap.getLoginMap());
		
		JsonPlaceHolderMapMassa.token = (String) RestUtils.getResponse("token");
		
		JsonPlaceHolderMapMassa.addDocumentos();
		
		Header header = JsonPlaceHolderMapMassa.header;
		header.setHeader("Authorization", JsonPlaceHolderMapMassa.token);
		
		JsonPlaceHolderMap jsonMap = JsonPlaceHolderMapMassa.jsonPlaceHolderMap;
		
		RestUtils.postRequest(JsonPlaceHolderMapMassa.endpoint, header.getHeader(), jsonMap.getJsonPlaceHolderMap());
		
		assertEquals("Adam Vinicius", RestUtils.getResponse("nome"));
		assertEquals(201, RestUtils.getStatusCode());
	}
		
	
	

}
