package cadastro.modelo;

public class CadastroAnimal extends CadastroDono
{
	private String nomeAnimal;
	private String cor;
	private String sexo;
	private String idade;
	private float peso;
	
	public CadastroAnimal(String nomeDono, String endereco, String cpf, String especie, String nomeAnimal, String cor,
			String sexo, String idade, float peso) 
	{
		super(nomeDono, endereco, cpf, especie);
		this.nomeAnimal = nomeAnimal;
		this.cor = cor;
		this.sexo = sexo;
		this.idade = idade;
		this.peso = peso;
	}

	public String getNomeAnimal() {
		return nomeAnimal;
	}

	public void setNomeAnimal(String nomeAnimal) {
		this.nomeAnimal = nomeAnimal;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}
	
	public void visualizarAnimal() {
		super.visualizarDono();
	}

}
