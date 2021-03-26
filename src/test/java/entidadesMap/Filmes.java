package entidadesMap;

import java.util.LinkedHashMap;
import java.util.List;

public class Filmes{
    LinkedHashMap<String, Object> filmes = new LinkedHashMap<>();
    public Filmes(Object nome, Object descricao, Object duracao, List<LinkedHashMap<String, Object>> listCategorias, 
                     List<LinkedHashMap<String, Object>> listPlataformas){
        filmes.put("nome",nome);
        filmes.put("descricao",descricao);
        filmes.put("duracao",duracao);
        filmes.put("categorias",listCategorias);
        filmes.put("plataformas",listPlataformas);
    }

    
    
    public LinkedHashMap<String, Object> getFilmes() {
        return filmes;
    }



	public void setFilmes(String key, Object value) {
		filmes.put(key, value);
	}
}
