package cadastro.modelo;

public abstract class CadastroDono {
	
	private String nomeDono, endereco, cpf, especie;
	

	public CadastroDono(String nomeDono, String endereco, String cpf, String especie) {
		this.nomeDono = nomeDono;
		this.endereco = endereco;
		this.cpf = cpf;
		this.especie = especie;
	}

	

	public String getNomeDono() {
		return nomeDono;
	}


	public void setNomeDono(String nomeDono) {
		this.nomeDono = nomeDono;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getEspecie() {
		return especie;
	}


	public void setEspecie(String especie) {
		this.especie = especie;
	}


	
	public void visualizarDono() {
		System.out.println("\n\n                      FICHA                          ");
		System.out.println("************************************************************");
		System.out.println("Nome do tutor: " + this.nomeDono);
		System.out.println("CPF: " + this.cpf);
		System.out.println("Endereço: " + this.endereco);
		System.out.println("Especie: " + this.especie);
		System.out.println("****************************************************************");
	}
	
	

}


