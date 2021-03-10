package entidades;

import java.util.LinkedHashMap;

public class Header {
	private LinkedHashMap<String, String> header = new LinkedHashMap<>();

	public Header(String authorization, String apiKey, String id) {
		
		header.put("Authorization", authorization);
		header.put("apikey", apiKey);
		header.put("id", id);
		
	}
	
	public Header(String authorization) {
		header.put("Authorization", authorization);
	}
	
	
	public LinkedHashMap<String, String> getHeader() {
		return header;
	}

	public void setHeader(String key, String value) {
		header.put(key, value);
	}
	
	public void removeKey(String key) {
		header.remove(key);
	}
	
	
}
