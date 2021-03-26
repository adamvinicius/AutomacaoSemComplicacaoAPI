package massas;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import entidadesMap.Categorias;
import entidadesMap.Filmes;
import entidadesMap.Plataformas;

public class FilmesMassa {

	public static String url = "http://localhost:8282/";
	public static String endpoint = "filmes";
	
	public Plataformas plataformas = new Plataformas("NetFlix");
	public List<LinkedHashMap<String, Object>> listPlataformas = new ArrayList<LinkedHashMap<String, Object>>();
	
	public Categorias terror = new Categorias("Terror");
	public Categorias thriller = new Categorias("Thriller");
	
	public List<LinkedHashMap<String, Object>> listCategorias = new ArrayList<LinkedHashMap<String, Object>>();
	
	public Filmes filmes;
	

	public FilmesMassa() {
		
		listCategorias.add(terror.getCategorias());
		listCategorias.add(thriller.getCategorias());
		
		listPlataformas.add(plataformas.getPlataformas());

		
		filmes = new Filmes("O Poço 2", "The Platform é um filme espanhol de terror e "
				+ "ficção científica de 2019 dirigido por Galder Gaztelu-Urrutia. "
				+ "O filme se passa em um grande Centro de Autogestão Vertical em estilo torre."
				+ "The Platform é um filme espanhol de terror e ficção ciadfadfadfadadfafe", 
				1.35, listCategorias, listPlataformas);

	}
	
	

}
