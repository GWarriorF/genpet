package cadastro.modelo;

import java.util.ArrayList;

public class ProcedimentosModelo 
{
	private String nomeAnimal;
	private ArrayList<String> procedimentos= new ArrayList<String>();
	private ArrayList<Double> valores = new ArrayList<Double>();
	
	public ProcedimentosModelo(String nomeAnimal, ArrayList<String> procedimentos, ArrayList<Double> valores) {
		super();
		this.nomeAnimal = nomeAnimal;
		this.procedimentos = procedimentos;
		this.valores = valores;
	}

	public String getNomeAnimal() {
		return nomeAnimal;
	}

	public void setNomeAnimal(String nomeAnimal) {
		this.nomeAnimal = nomeAnimal;
	}

	public ArrayList<String> getProcedimentos() {
		return procedimentos;
	}

	public void setProcedimentos(ArrayList<String> procedimentos) {
		this.procedimentos = procedimentos;
	}

	public ArrayList<Double> getValores() {
		return valores;
	}

	public void setValores(ArrayList<Double> valores) {
		this.valores = valores;
	}
	
	
	
	
}
