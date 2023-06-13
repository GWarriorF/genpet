package cadastro.modelo;

import java.util.ArrayList;

public class CadastroAnimal extends CadastroDono
{
	private String nomeAnimal;
	private String cor;
	private String sexo;
	private String idade;
	private Double peso;
	private ArrayList<String> procedimentos = new ArrayList<String>();
	private ArrayList<Double> valores = new ArrayList<Double>();
	
	public CadastroAnimal(String nomeDono, String endereco, String cpf, String especie, String nomeAnimal, String cor,
		String sexo, String idade, Double peso, ArrayList<String> procedimentos, ArrayList<Double> valores) {
		super(nomeDono, endereco, cpf, especie);
		this.nomeAnimal = nomeAnimal;
		this.cor = cor;
		this.sexo = sexo;
		this.idade = idade;
		this.peso = peso;
		this.procedimentos = procedimentos;
		this.valores = valores;
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

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public ArrayList<String> getProcedimentos() {
		return procedimentos;
	}

	public void setProcedimentos(ArrayList<String> procedimentos) {
		this.procedimentos = procedimentos;
	}

	public ArrayList<Double> getValor() {
		return valores;
	}

	public void setValor(ArrayList<Double> valores) {
		this.valores = valores;
	}
	
	


	
}
