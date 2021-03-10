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
	
	public static LoginMap login = new LoginMap("adam", "123456", "2fa3e708-7840-481f-bf57-8f6ff1f5ce2c");
	public static DocumentoMap documentoMap = new DocumentoMap("cpf", "3454215412");
	public static List<LinkedHashMap<String, Object>> documentos = new ArrayList<>();
	public static JsonPlaceHolderMap jsonPlaceHolderMap = new JsonPlaceHolderMap("xptqoaa", "Adam Vinicius", 32, null);
	public static Header header = new Header(null);
	
	public static void addDocumentos() {
		documentos.add(documentoMap.getDocumentoMap());
		jsonPlaceHolderMap.setJsonPlaceHolderMap("documentos", documentos);
	}
}
