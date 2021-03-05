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
	
	

}
