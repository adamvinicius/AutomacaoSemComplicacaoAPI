package entidadesMap;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JsonPlaceHolderMap {
	private LinkedHashMap<String, Object> jsonPlaceHolderMap = new LinkedHashMap<>();
	
	public JsonPlaceHolderMap(Object body, Object nome, Object idade, List<LinkedHashMap<String, Object>> documentos) {
		jsonPlaceHolderMap.put("body", body);
		jsonPlaceHolderMap.put("nome", nome);
		jsonPlaceHolderMap.put("idade", idade);
		jsonPlaceHolderMap.put("documentos", documentos);
	}
	
	public LinkedHashMap<String, Object> getJsonPlaceHolderMap(){
		return jsonPlaceHolderMap;
	}
	
	public void setJsonPlaceHolderMap(String key, Object value) {
		jsonPlaceHolderMap.put(key, value);
	}
	
	public void setJsonPlaceHolderMap(Map<String, Object> map) {
		jsonPlaceHolderMap.putAll(map);
	}
	
	public void removeKey(String key) {
		jsonPlaceHolderMap.remove(key);
	}
}
