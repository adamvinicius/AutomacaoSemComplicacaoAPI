package entidadesMap;

import java.util.LinkedHashMap;

public class Plataformas{
    LinkedHashMap<String, Object> plataformas = new LinkedHashMap<>();
    public Plataformas(Object nome){
        plataformas.put("nome",nome);
    }

    public LinkedHashMap<String, Object> getPlataformas() {
        return plataformas;
    }

	public void setPlataformas(String key, Object value) {
		plataformas.put(key, value);
	}
    
}
