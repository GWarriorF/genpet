package cadastro.modelo;

import java.util.ArrayList;
import java.util.Scanner;

public class CadastroAnimalCachorro extends CadastroAnimal
{
	
	private String tipoPeloCachorro;
	private String racaCachorro;
	private static ArrayList <String> racaCachorros;
	private static ArrayList <String> tipoPeloCachorros;
	

	
	public CadastroAnimalCachorro(String nomeDono, String endereco, String cpf, String especie, String nomeAnimal,
			String cor, String sexo, String idade, Double peso, ArrayList<String> procedimentos,
			ArrayList<Double> valores, String tipoPeloCachorro, String racaCachorro) {
		super(nomeDono, endereco, cpf, especie, nomeAnimal, cor, sexo, idade, peso, procedimentos, valores);
		this.tipoPeloCachorro = tipoPeloCachorro;
		this.racaCachorro = racaCachorro;
	}
	public String getTipoPeloCachorro() 
	{
		return tipoPeloCachorro;
	}
	public void setTipoPeloCachorro(String tipoPeloCachorro) 
	{
		this.tipoPeloCachorro = tipoPeloCachorro;
	}
	
	public String getRacaCachorro() 
	{
		return racaCachorro;
	}
	
	public void setRacaCachorro(String racaCachorro) 
	{
		this.racaCachorro = racaCachorro;
	}
     
	public static ArrayList <String> getRacaCachorros()
	{ 
		ArrayList <String> racaCachorros = new ArrayList <String>();
		racaCachorros.add("SRC (Sem Raça Definida)");
		racaCachorros.add("Beagle");
		racaCachorros.add("Rottweiler");
		racaCachorros.add("Boxer");
		racaCachorros.add("Yorkshire Terrier");
		racaCachorros.add("Dachshund (Salsicha)");
		racaCachorros.add("Chihuahua");
		racaCachorros.add("Border Collie");
		racaCachorros.add("Maltese");
		racaCachorros.add("Husky Siberiano");
		racaCachorros.add("Bichon Frisé");
		racaCachorros.add("Bernese Mountain Dog");
		racaCachorros.add("Great Dane (Dogue Alemão)");
		racaCachorros.add("Labrador");
		racaCachorros.add("Doberman Pinscher");
		racaCachorros.add("Golden Retriever");
		racaCachorros.add("Bulldog Inglês");
		racaCachorros.add("Bulldog Francês");
		racaCachorros.add("Poodle");
		racaCachorros.add("Pintcher");
		racaCachorros.add("Shih-Tzu");
		racaCachorros.add("Pastor Alemão");
		return racaCachorros;
	}

	public static void setRacaCachorro (ArrayList <String> racaCachorros) 
	{
		CadastroAnimalCachorro.racaCachorros = racaCachorros;
	}
	
	public static ArrayList <String> getTipoPeloCachorros(){ 
		ArrayList <String> tipoPeloCachorros = new ArrayList <String>();
		tipoPeloCachorros.add("Curto");
		tipoPeloCachorros.add("Médio");
		tipoPeloCachorros.add("Longo");
		tipoPeloCachorros.add("Pelagem Dupla");
		tipoPeloCachorros.add("Encaracolado");
		tipoPeloCachorros.add("Sem pelos");
		return tipoPeloCachorros;
	}
	public static void setTipoPeloCachorro(ArrayList <String> tipoPeloCachorros) 
	{
		CadastroAnimalCachorro.tipoPeloCachorros = tipoPeloCachorros;
	}
	


}
