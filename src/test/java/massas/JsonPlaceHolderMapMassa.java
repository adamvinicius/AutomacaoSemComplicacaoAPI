package massas;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import entidades.Header;
import entidadesMap.DocumentoMap;
import entidadesMap.JsonPlaceHolderMap;
import entidadesMap.LoginMap;

public class JsonPlaceHolderMapMassa {
	
	public static String url = "https://jsonplaceholder.typicode.com/";
	public static String endpoint = "posts";
	public static String token = "";
	
	public static LoginMap login;
	public static DocumentoMap documentoMap;
	public static List<LinkedHashMap<String, Object>> documentos;
	public static JsonPlaceHolderMap jsonPlaceHolderMap;
	public static Header header;
	
	public static void inicializaJsonPlaceHolderMapMassa() {
		login = new LoginMap("adam", "123456", "2fa3e708-7840-481f-bf57-8f6ff1f5ce2c");
		documentoMap = new DocumentoMap("cpf", "3454215412");
		documentos = new ArrayList<>();
		jsonPlaceHolderMap = new JsonPlaceHolderMap("xptqoaa", "Adam Vinicius", 32, null);
		header = new Header(null);
		addDocumentos();
	}
	
	public static void addDocumentos() {
		documentos.add(documentoMap.getDocumentoMap());
		jsonPlaceHolderMap.setJsonPlaceHolderMap("documentos", documentos);
	}
}
