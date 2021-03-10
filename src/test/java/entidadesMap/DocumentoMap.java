package entidadesMap;

import java.util.LinkedHashMap;

public class DocumentoMap {
	private LinkedHashMap<String, Object> documentoMap = new LinkedHashMap<>();
	
	public DocumentoMap(Object tipo, Object valor) {
		documentoMap.put("tipo", tipo);
		documentoMap.put("valor", valor);
	}
	
	public LinkedHashMap<String, Object> getDocumentoMap(){
		return documentoMap;
	}
	
	public void setDocumentoMap(String key, Object value) {
		documentoMap.put(key, value);
	}
}
