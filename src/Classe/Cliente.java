package Classe;


public class Cliente {
	
	static int ids;
	
	private int id;
	private String nome;
	private String Email;
	
	
	
	
	public Cliente(String nome, String email) {
		
		Cliente.ids++;
		this.id = Cliente.ids;
		
		this.nome = nome;
		this.Email = email;
		
	}
	
	public int getId() {
		return id;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
	
	

}
