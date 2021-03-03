package jsonPlaceHolder;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashMap;

import org.junit.jupiter.api.Test;

import utils.RestUtils;

class jsonPlaceHolderTest {

	@Test
	public void executaPost() {
		String json = "{"
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
		
		RestUtils.setBaseUri("https://jsonplaceholder.typicode.com/");
		
		RestUtils.postRequest("posts", json);
		
		System.out.println(RestUtils.getBody());
		
		assertEquals("Adam Vinicius", RestUtils.getResponse("nome"));
		assertEquals("cpf", RestUtils.getResponse("documentos[0].tipo"));
	}
	
	@Test
	public void mapTest() {
		String tempo = "muito muito frio";
		String resultado = "";
		
		if(tempo.equals("muito quente")) {
			resultado = "trabalhar igual ao Sampaio";
		}else if (tempo.equals("quente")) {
			resultado = "trabalhar com ar condicionado";
		}else if (tempo.equals("um pouco quente")) {
			resultado = "trabalhar com o ventilador ligado";
		}else if (tempo.equals("normal")) {
			resultado = "trabalhar com a janela aberta";
		}else if (tempo.equals("muito muito frio")) {
			resultado = "vai rolar trabalhar nao";
		}
		
		System.out.println(resultado);
		
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		map.put("muito quente", "trabalhar igual ao Sampaio");
		map.put("quente", "trabalhar com ar condicionado");
		map.put("um pouco quente", "trabalhar com o ventilador ligado");
		map.put("normal", "trabalhar com a janela aberta");
		map.put("muito muito frio", "vai rolar trabalhar nao");
		System.out.println(map.get("um pouco quente"));
		
	}

}
