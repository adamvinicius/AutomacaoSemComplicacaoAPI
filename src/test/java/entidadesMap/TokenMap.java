package entidadesMap;

import java.util.LinkedHashMap;

public class TokenMap{
    LinkedHashMap<String, Object> token = new LinkedHashMap<>();
    public TokenMap(Object email, Object senha){
        token.put("email",email);
        token.put("senha",senha);
    }
    
    public void setToken(String key, Object value) {
    	token.put(key, value);
    }

    public LinkedHashMap<String, Object> getToken() {
        return token;
    }
}
