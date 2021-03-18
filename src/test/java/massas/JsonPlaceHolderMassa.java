package massas;

import java.util.ArrayList;
import java.util.List;

import entidades.Documento;
import entidades.Header;
import entidades.JsonPlaceHolder;
import entidades.Login;

public class JsonPlaceHolderMassa {

	public static String url = "https://jsonplaceholder.typicode.com/";
	public static String endpoint = "posts";
	public static String token = "";
	
	public static Login login;
	public static Documento documento;
	public static List<Documento> documentos;
	public static JsonPlaceHolder jsonPlaceHolder;
	public static Header header;
	
	public static void inicializaJsonPlaceHolderMassa() {
		login = new Login("adam", "123456", "2fa3e708-7840-481f-bf57-8f6ff1f5ce2c");
		documento = new Documento("cpf", "3454215412");
		documentos = new ArrayList<>();
		jsonPlaceHolder = new JsonPlaceHolder("xptqoaa", "Adam Vinicius", 32, null);
		header = new Header(null);
		addDocumentos();
	}
	
	public static void addDocumentos() {
		documentos.add(documento);
		jsonPlaceHolder.setDocumentos(documentos);
	}
	
}
