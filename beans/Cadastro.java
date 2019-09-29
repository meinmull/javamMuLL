package beans;

public class Cadastro {
	String email;
	String email_digitado;
	String COD_USUARIO;
	
	
	public String getCOD_USUARIO() {
		return COD_USUARIO;
	}
	public void setCOD_USUARIO(String cOD_USUARIO) {
		COD_USUARIO = cOD_USUARIO;
	}
	public  String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail_digitado() {
		return email_digitado;
	}
	public void setEmail_digitado(String email_digitado) {
		this.email_digitado = email_digitado;
	}

}
