package cadastro.modelo;

import java.util.Scanner;

public class AgendamentoModelo 
{
	private String agendamento, nomeAnimal, valorTotal;

	public AgendamentoModelo(String agendamento, String nomeAnimal, String valorTotal) {
		super();
		this.agendamento = agendamento;
		this.nomeAnimal = nomeAnimal;
		this.valorTotal = valorTotal;
	}

	public String getAgendamento() {
		return agendamento;
	}

	public void setAgendamento(String agendamento) {
		this.agendamento = agendamento;
	}

	public String getNomeAnimal() {
		return nomeAnimal;
	}

	public void setNomeAnimal(String nomeAnimal) {
		this.nomeAnimal = nomeAnimal;
	}

	public String getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(String valorTotal) {
		this.valorTotal = valorTotal;
	}

	
	
}
