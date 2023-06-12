package cadastro.menu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import cadastro.modelo.CadastroAnimal;
import cadastro.modelo.CadastroAnimalCachorro;
import cadastro.modelo.CadastroAnimalGato;
import procedimentos.Vacina;
import cadastro.modelo.AgendamentoModelo;

public class MetodosMenu implements MenuRepositorio {
	
	// variaveis Uteis
	Scanner leia = new Scanner(System.in);
	int indiceCadastro = -1;
	float lerFloat, valorTotalDia, valorTotal, valor;
	String lerString;

	// Variaveis do Cadastro
	String nomeTutor, cpf, endereco, nomeAnimal, cor, sexo, idade, especie, pelo, raca;
	int lerInteiro, numero;
	float peso;
	
	//Variaveis agendamento

	// Listas para guardar os Objetos
	ArrayList<CadastroAnimalCachorro> listaCadastroCachorro = new ArrayList<CadastroAnimalCachorro>();
	ArrayList<CadastroAnimalGato> listaCadastroGato = new ArrayList<CadastroAnimalGato>();
	ArrayList<AgendamentoModelo> agendamentos = new ArrayList<AgendamentoModelo>();
	
	// Cadastro Animal Geral
	@Override
	public void cadastrar() 
	{
		if (valorTotal == 0.0f && nomeTutor == null) {	
			leia.skip("\\R");
			System.out.println("\n  *--------*--------*--------*-------*");
			System.out.println("              Cadastrar Pet           ");
			System.out.println("  *--------*--------*--------*-------*");
			System.out.print("Nome do Tutor: ");
			nomeTutor = leia.nextLine();

			System.out.print("Número do CPF: ");
			cpf = leia.nextLine();

			System.out.print("Endereço: ");
			endereco = leia.nextLine();

			System.out.print("Nome do Pet: ");
			nomeAnimal = leia.nextLine();

			System.out.print("Cor do Pet: ");
			cor = leia.nextLine();

			System.out.print("Sexo do Pet: ");
			sexo = leia.nextLine();

			System.out.print("Idade do Pet: ");
			idade = leia.nextLine();

			System.out.print("Peso do Pet: ");
			peso = leia.nextFloat();
			leia.skip("\\R");

			System.out.print("Especie do Pet [Felino] ou [Canina]: ");
			especie = leia.nextLine();
		}
	}

	// Cadastro Animal Gato
	@Override
	public void cadastrarGato() {
		if (especie.replaceAll("\\s", "").equalsIgnoreCase("Felino") || 
			especie.replaceAll("\\s", "").equalsIgnoreCase("Felina") && 
			valorTotal == 0.0f && pelo == null) 
		{
			List<String> racas = CadastroAnimalGato.getRacas();
			List<String> tipoPelo = CadastroAnimalGato.getTipoPelo();
			
			System.out.println("\n                 |\\__/,|   (`\\");
			System.out.println("               _.|o o  |_   ) )");
			System.out.println("             -(((---(((--------");
			
			System.out.println("\n  *--------*--------*--------*-------*");
			System.out.println("             Tipos de Pelo ");
			System.out.println("  *--------*--------*--------*-------*");

			for (int indice = 0; indice < tipoPelo.size(); indice++) {
				System.out.println((indice + 1) + " - " + tipoPelo.get(indice));
			}

			System.out.print("\nEscolha o tipo de pelo: ");
			lerInteiro = leia.nextInt();
			pelo = tipoPelo.get(lerInteiro - 1);

			System.out.println("\n  *--------*--------*--------*-------*");
			System.out.println("             Tipos de Raças ");
			System.out.println("  *--------*--------*--------*-------*");

			for (int indice = 0; indice < racas.size(); indice++) {
				int numero = indice + 1;
				String raca = racas.get(indice);
				System.out.println(numero + " - " + raca);
			}

			System.out.print("\nEscolha o tipo de Raça: ");
			lerInteiro = leia.nextInt();
			raca = racas.get(lerInteiro - 1);

			CadastroAnimalGato animalGato = new CadastroAnimalGato(nomeTutor, endereco, cpf, especie, nomeAnimal, cor,
					sexo, idade, peso, pelo, raca);

			listaCadastroGato.add(animalGato);
			indiceCadastro += 1;
		}
	}

	// Cadastro Animal Cachorro
	@Override
	public void cadastrarCachorro() {
		if (especie.replaceAll("\\s", "").equalsIgnoreCase("Canina")|| 
			especie.replaceAll("\\s", "").equalsIgnoreCase("Canino") && 
			valorTotal == 0.0f && pelo == null) {
			ArrayList<String> racasCachorro = CadastroAnimalCachorro.getRacaCachorros();
			ArrayList<String> pelosCachorro = CadastroAnimalCachorro.getTipoPeloCachorros();

			System.out.println("\n                        __");
			System.out.println("            (\\,--------'()'--o");
			System.out.println("            (_    ___    /~\"");
			System.out.println("            (_)_)  (_)_)");

			System.out.println("\n  *--------*--------*--------*-------*");
			System.out.println("             Tipos de Raças ");
			System.out.println("  *--------*--------*--------*-------*");

			for (int indice = 0; indice < racasCachorro.size(); indice++) {
				String racaCachorro = racasCachorro.get(indice);
				System.out.println((indice + 1) + " - " + racaCachorro);
			}

			System.out.print("\nEscolha o tipo de raça: ");
			lerInteiro = leia.nextInt();
			raca = racasCachorro.get(lerInteiro - 1);

			System.out.println("\n  *--------*--------*--------*-------*");
			System.out.println("             Tipos de Pelo ");
			System.out.println("  *--------*--------*--------*-------*");

			for (int indice = 0; indice < pelosCachorro.size(); indice++) {
				String peloCachorro = pelosCachorro.get(indice);
				System.out.println((indice + 1) + " - " + peloCachorro);
			}

			System.out.print("\nEscolha o tipo de pelo: ");
			lerInteiro = leia.nextInt();
			pelo = pelosCachorro.get(lerInteiro - 1);

			CadastroAnimalCachorro animalCachorro = new CadastroAnimalCachorro(nomeTutor, endereco, cpf, especie,
					nomeAnimal, cor, sexo, idade, peso, pelo, raca);

			listaCadastroCachorro.add(animalCachorro);
			indiceCadastro += 1;
		}
	}

	// Listar Gato
	@Override
	public void listarGato() {
		
		System.out.println("\n          |\\      _,,,---,,_");
		System.out.println("    ZZZzz /,`.-'`'    -.  ;-;;,_");
		System.out.println("         |,4-  ) )-,_. ,\\ (  `'-'");
		System.out.println("        '---''(_/--'  `-'\\_) ");
		
		System.out.println("\n  *--------*--------*--------*-------*");
		System.out.println("         Lista de Cadastro Gatos       ");
		System.out.println("  *--------*--------*--------*-------*");
		for (CadastroAnimalGato listarGato : listaCadastroGato) {
			System.out.println("\nNome do Tutor: " + listarGato.getNomeDono());
			System.out.println("CPF: " + listarGato.getCpf());
			System.out.println("Endereço: " + listarGato.getEndereco());
			System.out.println("Nome do Pet: " + listarGato.getNomeAnimal());
			System.out.println("Idade: " + listarGato.getIdade());
			System.out.println("Sexo: " + listarGato.getSexo());
			System.out.println("Peso: " + listarGato.getPeso());
			System.out.println("Cor: " + listarGato.getCor());
			System.out.println("Tipo de Pelo: " + listarGato.getPelo());
			System.out.println("Especie: " + listarGato.getEspecie());
			System.out.println("Raça: " + listarGato.getRaca());
		}
	}

	// Listar Gato
	@Override
	public void listarCachorro() {
		System.out.println("\n             _=,_");
		System.out.println("           o_/6 /#\\");
		System.out.println("           \\__ |##/");
		System.out.println("            ='|--\\");
		System.out.println("              /   #'-.");
		System.out.println("              \\#|_   _'-. /");
		System.out.println("               |/ \\_( # |\" ");
		System.out.println("              C/ ,--___/");
		
		System.out.println("\n  *--------*--------*--------*-------*");
		System.out.println("         Lista Cadastro Cachorros     ");
		System.out.println("  *--------*--------*--------*-------*");
		for (CadastroAnimalCachorro listarCachorro : listaCadastroCachorro) {
			System.out.println("\nNome do Tutor: " + listarCachorro.getNomeDono());
			System.out.println("CPF: " + listarCachorro.getCpf());
			System.out.println("Endereço: " + listarCachorro.getEndereco());
			System.out.println("Nome do Pet: " + listarCachorro.getNomeAnimal());
			System.out.println("Idade: " + listarCachorro.getIdade());
			System.out.println("Sexo: " + listarCachorro.getSexo());
			System.out.println("Peso: " + listarCachorro.getPeso());
			System.out.println("Tipo de Pelo: " + listarCachorro.getTipoPeloCachorro());
			System.out.println("Cor: " + listarCachorro.getCor());
			System.out.println("Especie: " + listarCachorro.getEspecie());
			System.out.println("Raça: " + listarCachorro.getRacaCachorro());
		}
	}
	
	//Junção do listar
	@Override
	public void listarPets() {
		listarGato();
		listarCachorro();
	}
	
	//Print Gato
	public void printCadastroGato() 
	{
		Iterator<CadastroAnimalGato> iFichaGato = listaCadastroGato.iterator();
		
		if(especie.replaceAll("\\s", "").equalsIgnoreCase("Felino"))
		{
			if(iFichaGato.hasNext()) 
		{
				CadastroAnimalGato fichaGato = iFichaGato.next();
				
				System.out.println("\n              |\\__/,|   (`\\");
				System.out.println("            _.|o o  |_   ) )");
				System.out.println("          -(((---(((--------");
				
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("           Dados do seu Pet ");
				System.out.println("  *--------*--------*--------*-------*");
				System.out.println("Peso: " + fichaGato.getPeso());
				System.out.println("Nome Tutor: " + fichaGato.getNomeDono());
				System.out.println("Cor: " + fichaGato.getCor());
				System.out.println("Sexo: " + fichaGato.getSexo());
				System.out.println("Especie: " + fichaGato.getEspecie());
				System.out.println("Endereço: " + fichaGato.getEndereco());
				System.out.println("Idade: " + fichaGato.getIdade());
				System.out.println("Dono Cpf: " + fichaGato.getCpf());
				System.out.println("Nome Animal: " + fichaGato.getNomeAnimal());
				System.out.println("Tipo de Pelo: " + fichaGato.getPelo());
				System.out.println("Raça: " + fichaGato.getRaca());
				System.out.println("Valor total: " + valorTotal);
			}
		}
	}
		
	//Print Cachorro
	public void printCadastroCachorro()
	{
		Iterator<CadastroAnimalCachorro> iFichaCachorro = listaCadastroCachorro.iterator();
		
		if(especie.replaceAll("\\s", "").equalsIgnoreCase("Canina")|| 
			especie.replaceAll("\\s", "").equalsIgnoreCase("Canino")) 
		{	
			if (iFichaCachorro.hasNext()) 
			{
				CadastroAnimalCachorro fichaCachorro = iFichaCachorro.next();
				
				System.out.println("\n           |\\_/|                  ");
				System.out.println("           | @ @  ");
				System.out.println("           |   <>              _ ");
				System.out.println("           |  _/\\------____ ((| |))");
				System.out.println("           |               `--' |   ");
				System.out.println("        ___|_       ___|   |___.' ");
				System.out.println("       /_/_____/____/_______|");
				
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("           Dados do seu Pet ");
				System.out.println("  *--------*--------*--------*-------*");
				System.out.println("Peso: " + fichaCachorro.getPeso());
				System.out.println("Nome Dono: " + fichaCachorro.getNomeDono());
				System.out.println("Cor: " + fichaCachorro.getCor());
				System.out.println("Sexo: " + fichaCachorro.getSexo());
				System.out.println("Especie: " + fichaCachorro.getEspecie());
				System.out.println("Endereço: " + fichaCachorro.getEndereco());
				System.out.println("Idade: " + fichaCachorro.getIdade());
				System.out.println("Dono Cpf: " + fichaCachorro.getCpf());
				System.out.println("Nome Animal: " + fichaCachorro.getNomeAnimal());
				System.out.println("Tipo de Pelo: " + fichaCachorro.getTipoPeloCachorro());
				System.out.println("Raça: " + fichaCachorro.getRacaCachorro());
				System.out.println("Valor total: " + valorTotal);
			}
		}
	}
	
	// Banho Gato Rita
	@Override
	public void banhoGato() {
		if (especie.replaceAll("\\s", "").equalsIgnoreCase("Felino") || 
				especie.replaceAll("\\s", "").equalsIgnoreCase("Felina")) {
			if (pelo.equalsIgnoreCase("Curto")) {
				valor = 30;
				valorTotal += valor;
				valorTotalDia = valorTotal;
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("         Valor do banho Acrescentado     ");
				System.out.println("  *--------*--------*--------*-------*");
			} else if (pelo.equalsIgnoreCase("Médio")) {
				valor = 40;
				valorTotal += valor;
				valorTotalDia = valorTotal;
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("         Valor do banho Acrescentado     ");
				System.out.println("  *--------*--------*--------*-------*");
			} else if (pelo.equalsIgnoreCase("Longo")) {
				valor = 50;
				valorTotal += valor;
				valorTotalDia = valorTotal;
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("         Valor do banho Acrescentado     ");
				System.out.println("  *--------*--------*--------*-------*");
			} else if (pelo.equalsIgnoreCase("Sem pelos")) {
				valor = 80;
				valorTotal += valor;
				valorTotalDia = valorTotal;
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("         Valor do banho Acrescentado     ");
				System.out.println("  *--------*--------*--------*-------*");
			} else 
			{
				System.out.println("Tipo de Pelo inválido!");
			}

		}
	}
	
	//Banho Cachorro
	@Override
	public void banhoCachorro() {
		if (especie.replaceAll("\\s", "").equalsIgnoreCase("Canina") || 
			especie.replaceAll("\\s", "").equalsIgnoreCase("Canino")
				) {
			if (pelo.equalsIgnoreCase("Curto")) {
				valor = 120;
				valorTotal += valor;
				valorTotalDia = valorTotal;
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("         Valor do banho Acrescentado     ");
				System.out.println("  *--------*--------*--------*-------*");
			} else if (pelo.equalsIgnoreCase("Médio")) {
				valor = 150;
				valorTotal += valor;
				valorTotalDia = valorTotal;
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("         Valor do banho Acrescentado     ");
				System.out.println("  *--------*--------*--------*-------*");
			} else if (pelo.equalsIgnoreCase("Longo")) {
				valor = 270;
				valorTotal += valor;
				valorTotalDia = valorTotal;
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("         Valor do banho Acrescentado     ");
				System.out.println("  *--------*--------*--------*-------*");
			} else if (pelo.equalsIgnoreCase("Sem pelos")) {
				valor = 150;
				valorTotal += valor;
				valorTotalDia = valorTotal;
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("         Valor do banho Acrescentado     ");
				System.out.println("  *--------*--------*--------*-------*");
			} else if (pelo.equalsIgnoreCase("Pelagem Dupla")) {
				valor = 180;
				valorTotal += valor;
				valorTotalDia = valorTotal;
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("         Valor do banho Acrescentado     ");
				System.out.println("  *--------*--------*--------*-------*");
			} else if (pelo.equalsIgnoreCase("Encaracolado")) {
				valor = 130;
				valorTotal += valor;
				valorTotalDia = valorTotal;
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("         Valor do banho Acrescentado     ");
				System.out.println("  *--------*--------*--------*-------*");
			}else{
				System.out.println("Tipo de Pelo inválido!");
			}

		}
	}
	
	//Vacinar Gato
	@Override
	public void vacinarGato() {
		int tipoVacina;
		ArrayList<String> VacinasGato = Vacina.getVacinaGato();
		if (especie.replaceAll("\\s", "").equalsIgnoreCase("Felino")|| 
			especie.replaceAll("\\s", "").equalsIgnoreCase("Felina")) 
		{
			System.out.println("\n  *--------*--------*--------*-------*");
			System.out.println("              Gato Vacinas ");
			System.out.println("  *--------*--------*--------*-------*");

			for (int indice = 0; indice < VacinasGato.size(); indice++) {
				String vacinaGato = VacinasGato.get(indice);
				System.out.println((indice + 1) + " - " + vacinaGato);
			}
			System.out.print("\nInforme o tipo de vacina: ");
			tipoVacina = leia.nextInt();

			switch (tipoVacina) {
			case 1:
				valor = 150;
				valorTotal += valor;
				valorTotalDia = valorTotal;
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("      Valor da vacina acrescentado     ");
				System.out.println("  *--------*--------*--------*-------*");
				break;

			case 2:
				valor = 100;
				valorTotal += valor;
				valorTotalDia = valorTotal;
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("      Valor da vacina acrescentado     ");
				System.out.println("  *--------*--------*--------*-------*");
				break;

			case 3:
				valor = 80;
				valorTotal += valor;
				valorTotalDia = valorTotal;
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("      Valor da vacina acrescentado     ");
				System.out.println("  *--------*--------*--------*-------*");
				break;

			case 4:
				valor = 60;
				valorTotal += valor;
				valorTotalDia = valorTotal;
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("      Valor da vacina acrescentado     ");
				System.out.println("  *--------*--------*--------*-------*");
				break;

			default:
				System.out.println("Não trabalhamos com este tipo de vacina!");
				break;
			}
		}
	}
	
	//Vacinar Cachorro
	@Override
	public void vacinarCachorro() {
		int tipoVacina;
		ArrayList<String> VacinasCachorro = Vacina.getVacinaCachorro();

		if (especie.replaceAll("\\s", "").equalsIgnoreCase("Canina") || 
			especie.replaceAll("\\s", "").equalsIgnoreCase("Canino")) {
			System.out.println("\n  *--------*--------*--------*-------*");
			System.out.println("            Cachorro Vacinas ");
			System.out.println("  *--------*--------*--------*-------*");

			for (int indice = 0; indice < VacinasCachorro.size(); indice++) {
				String vacinaCachorro = VacinasCachorro.get(indice);
				System.out.println("\n" +(indice + 1) + " - " + vacinaCachorro);
			}
			System.out.print("\nInforme o tipo de vacina: ");
			tipoVacina = leia.nextInt();

			switch (tipoVacina) {
			case 1:
				valor = 150;
				valorTotal += valor;
				valorTotalDia = valorTotal;
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("      Valor da vacina acrescentado     ");
				System.out.println("  *--------*--------*--------*-------*");
				break;

			case 2:
				valor = 100;
				valorTotal += valor;
				valorTotalDia = valorTotal;
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("      Valor da vacina acrescentado     ");
				System.out.println("  *--------*--------*--------*-------*");
				break;

			case 3:
				valor = 60;
				valorTotal += valor;
				valorTotalDia = valorTotal;
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("      Valor da vacina acrescentado     ");
				System.out.println("  *--------*--------*--------*-------*");
				break;
			default:
				System.out.println("Não trabalhamos com este tipo de vacina!");
				break;
			}
		}
	}
		
	
	// Tosa Gato Rita
	@Override
	public void tosaGato() {
		
		if (especie.replaceAll("\\s", "").equalsIgnoreCase("Felino") || 
			especie.replaceAll("\\s", "").equalsIgnoreCase("Felina")) 
		{
			if (pelo.equalsIgnoreCase("Curto")) {
				valor = 50;
				valorTotal += valor;
				valorTotalDia = valorTotal;
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("         Valor da tosa Acrescentado     ");
				System.out.println("  *--------*--------*--------*-------*");
			} else if (pelo.equalsIgnoreCase("Médio")) {
				valor = 60;
				valorTotal += valor;
				valorTotalDia = valorTotal;
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("         Valor da tosa Acrescentado     ");
				System.out.println("  *--------*--------*--------*-------*");
			} else if (pelo.equalsIgnoreCase("Longo")) {
				valor = 75;
				valorTotal += valor;
				valorTotalDia = valorTotal;
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("         Valor da tosa Acrescentado     ");
				System.out.println("  *--------*--------*--------*-------*");
			} else {
				System.out.println("Tipo de Pelo inválido!");
			}
		}
	}

	
	@Override
	public void tosaCachorro() {

		if (especie.replaceAll("\\s", "").equalsIgnoreCase("Canina")|| 
			especie.replaceAll("\\s", "").equalsIgnoreCase("Canino")) {
			if (pelo.equalsIgnoreCase("Curto")) {
				valor = 120;
				valorTotal += valor;
				valorTotalDia = valorTotal;
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("        Valor da tosa Acrescentado     ");
				System.out.println("  *--------*--------*--------*-------*");
			} else if (pelo.equalsIgnoreCase("Médio")) {
				valor = 180;
				valorTotal += valor;
				valorTotalDia = valorTotal;
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("        Valor da tosa Acrescentado     ");
				System.out.println("  *--------*--------*--------*-------*");
			} else if (pelo.equalsIgnoreCase("Longo")) {
				valor = 270;
				valorTotal += valor;
				valorTotalDia = valorTotal;
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("        Valor da tosa Acrescentado     ");
				System.out.println("  *--------*--------*--------*-------*");
			} else if (pelo.equalsIgnoreCase("Pelagem Dupla")) {
				valor = 130;
				valorTotal += valor;
				valorTotalDia = valorTotal;
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("        Valor da tosa Acrescentado     ");
				System.out.println("  *--------*--------*--------*-------*");
			} else if (pelo.equalsIgnoreCase("Encaracolado")) {
				valor = 150;
				valorTotal += valor;
				valorTotalDia = valorTotal;
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("        Valor da tosa Acrescentado     ");
				System.out.println("  *--------*--------*--------*-------*");
			} else {
				System.out.println("Tipo de Pelo inválido!");
			}

		}
	}

	
	// Castrar Gato Gabi
	@Override
	public void castrarGato() {
		
		Iterator<CadastroAnimalGato> iFichaGato = listaCadastroGato.iterator();

		if (especie.replaceAll("\\s", "").equalsIgnoreCase("Felino") || 
				especie.replaceAll("\\s", "").equalsIgnoreCase("Felina")) {
			if (iFichaGato.hasNext()) {
				CadastroAnimalGato fichaGato = iFichaGato.next();
				if (fichaGato.getEspecie().replaceAll("\\s", "").equalsIgnoreCase("Felino")) {
					System.out.println("\n  *--------*--------*--------*-------*");
					System.out.println("     Valor da castração Acrescentado  ");
					System.out.println("  *--------*--------*--------*-------*");
					valor = 400.00f;
					valorTotal += valor;
					valorTotalDia += valorTotal;
				} else {
					System.out.println("Não tratamos essa especie de animal");
				}
			}
		}
	}

	//Castrar Cachorro
	// Castrar Cachorro Gabi
	@Override
	public void castrarCachorro() {
		Iterator<CadastroAnimalCachorro> iFichaCachorro = listaCadastroCachorro.iterator();
		if (especie.replaceAll("\\s", "").equalsIgnoreCase("Canina")|| 
			especie.replaceAll("\\s", "").equalsIgnoreCase("Canino")) {
			if (iFichaCachorro.hasNext()) {
				CadastroAnimal fichaCachorro = iFichaCachorro.next();
				if (fichaCachorro.getEspecie().replaceAll("\\s", "").equalsIgnoreCase("Canina")) {
					System.out.println("\n  *--------*--------*--------*-------*");
					System.out.println("     Valor da castração Acrescentado  ");
					System.out.println("  *--------*--------*--------*-------*");
					valor = 900.00f;
					valorTotal += valor;
					valorTotalDia += valorTotal;
				}
			} else {
				System.out.println("Não tratamos essa especie de animal");
			}
		}
	}

	// Consulta Gabi
	
	//Acrescenta o Valor da Consulta
	@Override
	public void consulta() {
		System.out.println("\n  *--------*--------*--------*-------*");
		System.out.println("     Valor da consulta Acrescentado  ");
		System.out.println("  *--------*--------*--------*-------*");
		valor = 200.00f;
		valorTotal += valor;
		valorTotalDia += valorTotal;
	}

	
	// Saída Gabi
	@Override
	public void saidaAnimal() {
		printCadastroGato();
		printCadastroCachorro();
		
		System.out.println("\n  *--------*--------*--------*-------*");
		System.out.println("        Agradecemos a preferência ");
		System.out.println("  *--------*--------*--------*-------*");

		zerarVariaveis();
	}
	
	public void zerarVariaveis() 
	{
		valorTotal = 0.0f;
		especie = null;
		nomeTutor = null;
		cpf = null;
		endereco = null; 
		nomeAnimal = null; 
		cor = null;
		sexo = null;
		idade = null; 
		especie = null;
		pelo = null;
		raca = null;
		peso = 0.0f;
	}
	

	//Confere se o cadastro foi finalizado ou não
	public void cadastroEmAndamento()
	{
		if(valorTotal != 0.0f || nomeTutor != null) 
		{
			System.out.println("\n  *--------*--------*--------*-------*");
			System.out.println("    Finalize o cadastro e crie outro");
			System.out.println("  *--------*--------*--------*-------*");
		}
		
	}
	
	
	//Busca um Animal Felino dentro da lista de cadastro
	public void buscarAnimalGato() 
	{
		leia.skip("\\R?");
		System.out.print("Digite o nome do pet: ");
		lerString = leia.nextLine();
		
		for (CadastroAnimalGato Gato : listaCadastroGato) 
		{
			if(Gato.getNomeAnimal().equalsIgnoreCase(lerString)) 
			{
				
					CadastroAnimalGato gatoEncontrado = Gato;
					
					System.out.println("\n              |\\__/,|   (`\\");
					System.out.println("            _.|o o  |_   ) )");
					System.out.println("          -(((---(((--------");
					
					System.out.println("\n  *--------*--------*--------*-------*");
					System.out.println("           Dados do seu Pet ");
					System.out.println("  *--------*--------*--------*-------*");
					System.out.println("Peso: " + gatoEncontrado.getPeso());
					System.out.println("Nome Tutor: " + gatoEncontrado.getNomeDono());
					System.out.println("Cor: " + gatoEncontrado.getCor());
					System.out.println("Sexo: " + gatoEncontrado.getSexo());
					System.out.println("Especie: " + gatoEncontrado.getEspecie());
					System.out.println("Endereço: " + gatoEncontrado.getEndereco());
					System.out.println("Idade: " + gatoEncontrado.getIdade());
					System.out.println("Dono Cpf: " + gatoEncontrado.getCpf());
					System.out.println("Nome Animal: " + gatoEncontrado.getNomeAnimal());
					System.out.println("Tipo de Pelo: " + gatoEncontrado.getPelo());
					System.out.println("Raça: " + gatoEncontrado.getRaca());
					System.out.println("Valor total: " + valorTotal);
			}else {
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("    Você ainda não cadastrou seu Pet");
				System.out.println("  *--------*--------*--------*-------*");
			}
		}
	}
	//Busca um Animal Canina dentro da lista de cadastro
	public void buscarAnimalCachorro() 
	{
		leia.skip("\\R?");
		System.out.print("Digite o nome do pet: ");
		lerString = leia.nextLine();
		
		for(CadastroAnimalCachorro cachorro: listaCadastroCachorro) 
		{
			if(cachorro.getNomeAnimal().equalsIgnoreCase(lerString)) 
			{
				CadastroAnimalCachorro cachorroEncontrado = cachorro;
				
				System.out.println("\n           |\\_/|                  ");
				System.out.println("           | @ @  ");
				System.out.println("           |   <>              _ ");
				System.out.println("           |  _/\\------____ ((| |))");
				System.out.println("           |               `--' |   ");
				System.out.println("        ___|_       ___|   |___.' ");
				System.out.println("       /_/_____/____/_______|");
				
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("           Dados do seu Pet ");
				System.out.println("  *--------*--------*--------*-------*");
				System.out.println("Peso: " + cachorroEncontrado.getPeso());
				System.out.println("Nome Dono: " + cachorroEncontrado.getNomeDono());
				System.out.println("Cor: " + cachorroEncontrado.getCor());
				System.out.println("Sexo: " + cachorroEncontrado.getSexo());
				System.out.println("Especie: " + cachorroEncontrado.getEspecie());
				System.out.println("Endereço: " + cachorroEncontrado.getEndereco());
				System.out.println("Idade: " + cachorroEncontrado.getIdade());
				System.out.println("Dono Cpf: " + cachorroEncontrado.getCpf());
				System.out.println("Nome Animal: " + cachorroEncontrado.getNomeAnimal());
				System.out.println("Tipo de Pelo: " + cachorroEncontrado.getTipoPeloCachorro());
				System.out.println("Raça: " + cachorroEncontrado.getRacaCachorro());
				System.out.println("Valor total: " + valorTotal);
			}else {
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("    Você ainda não cadastrou seu Pet");
				System.out.println("  *--------*--------*--------*-------*");
			}
		} 
	}	//Junção Do buscar
	public void buscarAnimal() 
	{
		leia.skip("\\R?");
		System.out.print("\nDigite a especie do seu pet: ");
		lerString = leia.nextLine();
		if (lerString.replaceAll("\\s", "").equalsIgnoreCase("Felino")|| 
				lerString.replaceAll("\\s", "").equalsIgnoreCase("Felina")) 
		{
			buscarAnimalGato();
		}else if (lerString.replaceAll("\\s", "").equalsIgnoreCase("Canina")|| 
				 lerString.replaceAll("\\s", "").equalsIgnoreCase("Canino")) 
		{
			buscarAnimalCachorro();
		}else 
		{
			System.out.println("\n  *--------*--------*--------*-------*");
			System.out.println("   Só trabalhamos com Felino e Canina"
					+ "                           ou"
							+ "             Cadastre um Pet           ");
			System.out.println("  *--------*--------*--------*-------*");
		}
	}
	

	//Atualizar Cadastro
	@Override
	public void atualizarCadastro() {
		listarPets();
		leia.skip("\\R?");
		System.out.println("\n  *--------*--------*--------*-------*");
		System.out.println("           Atualizando Cadastro");
		System.out.println("  *--------*--------*--------*-------*");
		System.out.print("Digite o nome do pet que deseja atualizar o cadastro: ");
		String nomePet = leia.nextLine();
		
		boolean encontrado = false;

		for (CadastroAnimalGato felino : listaCadastroGato) {
			if (felino.getNomeAnimal().equalsIgnoreCase(nomePet)) {
				encontrado = true;
				System.out.print("Digite o novo nome do tutor: ");
				String novoNomeTutor = leia.nextLine();
				felino.setNomeDono(novoNomeTutor);
				
				System.out.print("Digite o novo CPF: ");
				String novoCPF = leia.nextLine();
				felino.setCpf(novoCPF);
				
				System.out.print("Digite o endereço: ");
				String novoEndereco = leia.nextLine();
				felino.setEndereco(novoEndereco);
				
				System.out.print("Digite o nome atualizado do pet: ");
				String novoNomePet = leia.nextLine();
				felino.setNomeAnimal(novoNomePet);
				
				System.out.print("Digite uma nova cor: ");
				String novoCor = leia.nextLine();
				felino.setCor(novoCor);
				
				System.out.print("Digite um novo sexo do pet: ");
				String novoSexo = leia.nextLine();
				felino.setSexo(novoSexo);
				
				System.out.print("Digite uma nova idade do pet: ");
				String novoIdade = leia.nextLine();
				felino.setIdade(novoIdade);
				
				System.out.print("Digite um novo peso do pet: ");
				float novoPeso = leia.nextFloat();
				felino.setPeso(novoPeso);
				
				leia.skip("\\R?");
				
				System.out.print("Digite a espécie do pet (Felino ou Canino): ");
				String novoEspecie = leia.nextLine();
				felino.setEspecie(novoEspecie);
				
				System.out.print("Digite o Tipo de Pelo: ");
				String novoPelo = leia.nextLine();
				felino.setEspecie(novoPelo);
				
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("           Cadastro Atualizado");
				System.out.println("  *--------*--------*--------*-------*");
				break;
			}
		}

		if (encontrado == false) {
			for (CadastroAnimalCachorro cachorro : listaCadastroCachorro) {
				if (cachorro.getNomeAnimal().equalsIgnoreCase(nomePet)) {
					System.out.print("Digite o nome atualizado do tutor: ");
					String novoNomeTutor = leia.nextLine();
					cachorro.setNomeDono(novoNomeTutor);
					
					System.out.print("Digite o novo CPF: ");
					String novoCPF = leia.nextLine();
					cachorro.setCpf(novoCPF);
					
					System.out.print("Digite o endereço atualizado: ");
					String novoEndereco = leia.nextLine();
					cachorro.setEndereco(novoEndereco);
					
					System.out.print("Digite o nome atualizado do pet: ");
					String novoNomePet = leia.nextLine();
					cachorro.setNomeAnimal(novoNomePet);
					
					System.out.print("Digite uma nova cor: ");
					String novoCor = leia.nextLine();
					cachorro.setCor(novoCor);
					
					System.out.print("Digite um novo sexo do pet: ");
					String novoSexo = leia.nextLine();
					cachorro.setSexo(novoSexo);
					
					System.out.print("Digite uma nova idade do pet: ");
					String novoIdade = leia.nextLine();
					cachorro.setIdade(novoIdade);
					
					System.out.print("Digite um novo peso do pet: ");
					float novoPeso = leia.nextFloat();
					cachorro.setPeso(novoPeso);
					
					System.out.print("Digite a espécie do pet (Felino ou Canino): ");
					String novoEspecie = leia.nextLine();
					cachorro.setEspecie(novoEspecie);
					
					System.out.print("Digite o Tipo de Pelo: ");
					String novoPelo = leia.nextLine();
					cachorro.setEspecie(novoPelo);
					
					System.out.println("\n  *--------*--------*--------*-------*");
					System.out.println("           Cadastro Atualizado");
					System.out.println("  *--------*--------*--------*-------*");
					break;
				}
			}
		}

		if (encontrado == false) {
			System.out.println("Pet não encontrado.");
		}
	}
	
	//Remover Cadastro
	@Override
	public void removerCadastro() {
	    listarPets();
	    leia.skip("\\R?");
		System.out.println("\n  *--------*--------*--------*-------*");
		System.out.println("            Removendo Cadastro");
		System.out.println("  *--------*--------*--------*-------*");
	    System.out.print("Digite o nome do pet que deseja remover o cadastro: ");
	    String nomePet = leia.nextLine();

	    boolean removido = false;

	    Iterator<CadastroAnimalGato> iteratorGato = listaCadastroGato.iterator();
	    while (iteratorGato.hasNext()) {
	        CadastroAnimalGato gato = iteratorGato.next();
	        if (gato.getNomeAnimal().equalsIgnoreCase(nomePet)) {
	            iteratorGato.remove();
	            removido = true;
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("             Cadastro Removido");
				System.out.println("  *--------*--------*--------*-------*");
				zerarVariaveis();
	            break;
	        }
	    }

	    if (!removido) {
	        Iterator<CadastroAnimalCachorro> iteratorCachorro = listaCadastroCachorro.iterator();
	        while (iteratorCachorro.hasNext()) {
	            CadastroAnimalCachorro cachorro = iteratorCachorro.next();
	            if (cachorro.getNomeAnimal().equalsIgnoreCase(nomePet)) {
	                iteratorCachorro.remove();
	                removido = true;
					System.out.println("\n  *--------*--------*--------*-------*");
					System.out.println("             Cadastro Removido");
					System.out.println("  *--------*--------*--------*-------*");
					zerarVariaveis();
	                break;
	            }
	        }
	    }

	    if (!removido) {
			System.out.println("\n  *--------*--------*--------*-------*");
			System.out.println("            Pet não encontrado");
			System.out.println("  *--------*--------*--------*-------*");
	    }
	}
	
	public boolean sairExpediente()
	{
		if(valorTotal != 0.0f || nomeTutor != null) 
		{
			return true;
		}
		
		return false;
	}
	
	public void mostraCadastroPendenteSaida() 
	{
		System.out.println("\n  *--------*--------*--------*-------*");
		System.out.println("    Finalização de cadastro pendente ");
		System.out.println("  *--------*--------*--------*-------*");
	}
	public void mostraSaida() 
	{
		System.out.println("\n  *--------*--------*--------*-------*");
		System.out.println("          Expediente Finalizado      ");
		System.out.println("  *--------*--------*--------*-------*");
		System.out.println("         Valor Total do dia: " + valorTotalDia );
		System.out.println("\n      /^--^\\     /^--^\\     /^--^\\");
		System.out.println("      \\____/     \\____/     \\____/");
		System.out.println("      /    \\     /    \\     /    \\");
		System.out.println("     |      |   |      |   |      |");
		System.out.println("     \\__  __/   \\__  __/   \\__  __/");
		System.out.println("|^|^|^|^\\ \\^|^|^|^/ /^|^|^|^|^\\ \\^|^|^|^|");
		System.out.println("| | | | |\\ \\| | |/ /| | | | | |\\ \\| | | |");
		System.out.println("#########/ /#####\\ \\###########/ /#######");
		System.out.println(" | | | | \\/| | | |\\/| | | | | |\\/ | | | |");
		System.out.println("|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|");
	}
}
