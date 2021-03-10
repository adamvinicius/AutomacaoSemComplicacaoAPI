package entidadesMap;

import java.util.LinkedHashMap;

public class LoginMap {
private LinkedHashMap<String, Object> loginMap = new LinkedHashMap<>();
	
	public LoginMap(Object usuario, Object senha, Object token) {
		loginMap.put("usuario", usuario);
		loginMap.put("senha", senha);
		loginMap.put("token", token);
	}
	
	public LinkedHashMap<String, Object> getLoginMap(){
		return loginMap;
	}
	
	public void setLoginMap(String key, Object value) {
		loginMap.put(key, value);
	}
}
