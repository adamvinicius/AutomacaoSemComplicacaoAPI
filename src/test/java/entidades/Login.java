package entidades;

public class Login {
	private Object usuario;
	private Object senha;
	private Object token;
	
	
	public Login(Object usuario, Object senha, Object token) {
		this.usuario = usuario;
		this.senha = senha;
		this.token = token;
	}
	
	public Object getUsuario() {
		return usuario;
	}
	public void setUsuario(Object usuario) {
		this.usuario = usuario;
	}
	public Object getSenha() {
		return senha;
	}
	public void setSenha(Object senha) {
		this.senha = senha;
	}
	public Object getToken() {
		return token;
	}
	public void setToken(Object token) {
		this.token = token;
	}
	
	
}
