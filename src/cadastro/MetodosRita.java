package cadastro;
/*	package cadastro;

import procedimentos.Vacina;

import java.util.ArrayList;
import java.util.Scanner;
import cadastro.modelo.CadastroAnimal;
import cadastro.modelo.CadastroAnimalGato;

public class MetodosRita{

	
	
	float valor, valorTotal, valorTotalDia;
	
/*	public void banho()
	{
		CadastroAnimalGato fichaGato = new CadastroAnimalGato(null, null, null, null, null, null, null, null, 0.0f, null, null);
		CadastroAnimalCachorro fichaCachorro = new CadastroAnimalCachorro(null, null, null, null, null, null, null, null, 0.0f, 0, null);
		CadastroAnimal conferirEspecie = new CadastroAnimal(null, null, null, null, null, null, null, null, valor);
		
		
		if(conferirEspecie.getEspecie().equalsIgnoreCase("Gato")) 
		{
			switch(fichaGato.getPelo())
			{
				case 1:
					valor = 30;
					valorTotal += valor;
					valorTotalDia = valorTotal;
					break;
		
				case 2:
					valor = 40;
					valorTotal += valor;
					valorTotalDia = valorTotal;
					break;
				
				case 3:
					valor = 50;
					valorTotal += valor;
					valorTotalDia = valorTotal;
					break;
			
				case 4:
					valor = 80;
					valorTotal += valor;
					valorTotalDia = valorTotal;
					break;
					
				default:
					System.out.println("Tipo de Pelo inválido!");
					
			}
		}
		
		if(conferirEspecie.getEspecie().equalsIgnoreCase("Cachorro")) 
		{
			switch(fichaCachorro.getTipoPeloCachorro())
			{
				case 1:
					valor = 270;
					valorTotal += valor;
					valorTotalDia = valorTotal;
					break;
		
				case 2:
					valor = 120;
					valorTotal += valor;
					valorTotalDia = valorTotal;
					break;
				
				case 3:
					valor = 150;
					valorTotal += valor;
					valorTotalDia = valorTotal;
					break;
			
				case 4:
					valor = 170;
					valorTotal += valor;
					valorTotalDia = valorTotal;
					break;
					
				case 5:
					valor = 170;
					valorTotal += valor;
					valorTotalDia = valorTotal;
					break;
					
				case 6:
					valor = 180;
					valorTotal += valor;
					valorTotalDia = valorTotal;
					break;
				default: 
					System.out.println("Tipo de Pelo inválido!");
			}
		}
	}*/
	
	
	
	/*public void tosa()
	{
		CadastroAnimalGato fichaGato = new CadastroAnimalGato(null, null, null, null, null, null, null, null, 0.0f, null, null);
		CadastroAnimalCachorro fichaCachorro = new CadastroAnimalCachorro(null, null, null, null, null, null, null, null, 0.0f, 0, null);
		CadastroAnimal conferirEspecie = new CadastroAnimal(null, null, null, null, null, null, null, null, valor);
		
		if(conferirEspecie.getEspecie().equalsIgnoreCase("Gato")) 
		{
			switch(fichaGato.getPelo())
			{
				case 1:
					valor = 50;
					valorTotal += valor;
					valorTotalDia = valorTotal;
					break;
		
				case 2:
					valor = 60;
					valorTotal += valor;
					valorTotalDia = valorTotal;
					break;
				
				case 3:
					valor = 75;
					valorTotal += valor;
					valorTotalDia = valorTotal;
					break;
			
			}
		}
		
		if(conferirEspecie.getEspecie().equalsIgnoreCase("Cachorro")) 
		{
			switch(fichaCachorro.getTipoPeloCachorro())
			{
				case 1:
					valor = 270;
					valorTotal += valor;
					valorTotalDia = valorTotal;
					break;
		
				case 2:
					valor = 120;
					valorTotal += valor;
					valorTotalDia = valorTotal;
					break;
				
				case 3:
					valor = 180;
					valorTotal += valor;
					valorTotalDia = valorTotal;
					break;
			
				case 4:
					valor = 130;
					valorTotal += valor;
					valorTotalDia = valorTotal;
					break;
					
				case 5:
					valor = 150;
					valorTotal += valor;
					valorTotalDia = valorTotal;
					break;
			}
		}
		
		else
		{
			System.out.println("Tipo de Pelo inválido!");
		}
	}*/
	
	
	
	/*public void vacina()
	{
		ArrayList<String> VacinasGato = Vacina.getVacinaGato();
		ArrayList<String> VacinasCachorro = Vacina.getVacinaCachorro();
		CadastroAnimal conferirEspecie = new CadastroAnimal(null, null, null, null, null, null, null, null, valor);
	
		Scanner leia = new Scanner(System.in);
		int tipoVacina;
		
		if(conferirEspecie.getEspecie().equalsIgnoreCase("Gato")) {
			System.out.println("Vacinas Gato: ");
			for(int indice = 0; indice < VacinasGato.size(); indice++) {
				int ivacina = indice+1;
				String vacinaGato = VacinasGato.get(ivacina);
				System.out.println(ivacina + " - " + vacinaGato);
			}
			System.out.println("Informe o tipo de vacina: ");
			tipoVacina = leia.nextInt();
			
			switch(tipoVacina){
				case 1:
					valor = 150;
					valorTotal += valor;
					valorTotalDia = valorTotal;
					break;
					
				case 2:
					valor = 100;
					valorTotal += valor;
					valorTotalDia = valorTotal;
					break;
					
				case 3:
					valor = 80;
					valorTotal += valor;
					valorTotalDia = valorTotal;
					break;
					
				case 4:
					valor = 60;
					valorTotal += valor;
					valorTotalDia = valorTotal;
					break;
					
				default: 
					System.out.println("Não trabalhamos com este tipo de vacina!");
					break;
			}
				
		}else if(conferirEspecie.getEspecie().equalsIgnoreCase("Cachorro")) {
			System.out.println("Vacinas Cachorro: ");
			for(int indice = 0; indice < VacinasCachorro.size(); indice++) {
				int ivacina = indice+1;
				String vacinaCachorro = VacinasGato.get(ivacina);
				System.out.println(ivacina + " - " + vacinaCachorro);
			}
			System.out.println("Informe o tipo de vacina: ");
			tipoVacina = leia.nextInt();
			
			switch(tipoVacina){
				case 1:
					valor = 150;
					valorTotal += valor;
					valorTotalDia = valorTotal;
					break;
					
				case 2:
					valor = 100;
					valorTotal += valor;
					valorTotalDia = valorTotal;
					break;
					
				case 3:
					valor = 60;
					valorTotal += valor;
					valorTotalDia = valorTotal;
					break;
					
				default: 
					System.out.println("Não trabalhamos com este tipo de vacina!");
					break;
			}
		}
<<<<<<< HEAD
	}
}
	
	*/
