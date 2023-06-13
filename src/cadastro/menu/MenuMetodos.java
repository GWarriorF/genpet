package cadastro.menu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import cadastro.modelo.CadastroAnimalCachorro;
import cadastro.modelo.CadastroAnimalGato;
import cadastro.modelo.ProcedimentosModelo;
import cadastro.modelo.VacinaModelo;

public class MenuMetodos implements MenuRepositorio {

	// variaveis Uteis
	Scanner leia = new Scanner(System.in);
	int indiceCadastro = -1;
	double lerDouble = 0.0, valorTotalDia = 0.0, valor = 0.0, valorTotal = 0.0;
	String lerString;

	// Variaveis do Cadastro
	String nomeTutor, cpf, endereco, nomeAnimal, cor, sexo, idade, especie, pelo, raca;
	int lerInteiro, numero;
	Double peso;

	// Variaveis agendamento
	ArrayList<String> procedimentosLista = new ArrayList<String>();
	ArrayList<Double> valorLista = new ArrayList<Double>();

	// Listas para guardar os Objetos
	ArrayList<CadastroAnimalCachorro> listaCadastroCachorro = new ArrayList<CadastroAnimalCachorro>();
	ArrayList<CadastroAnimalGato> listaCadastroGato = new ArrayList<CadastroAnimalGato>();
	ArrayList<ProcedimentosModelo> listaPV = new ArrayList<ProcedimentosModelo>();

	// Cadastro Animal Geral
	@Override
	public void cadastrar() {
		if (nomeTutor == null) {
			leia.skip("\\R");
			System.out.println("\n  *--------*--------*--------*-------*");
			System.out.println("              Cadastrar Pet           ");
			System.out.println("  *--------*--------*--------*-------*");
			System.out.print("\nNome do Tutor: ");
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
			peso = leia.nextDouble();
			leia.skip("\\R");

			System.out.print("Especie do Pet [Felino] ou [Canina]: ");
			especie = leia.nextLine();
		}
	}

	// Cadastro Animal Gato
	@Override
	public void cadastrarGato() {
		if (especie.replaceAll("\\s", "").equalsIgnoreCase("Felino")
				|| especie.replaceAll("\\s", "").equalsIgnoreCase("Felina") && especie == null) {
			List<String> racas = CadastroAnimalGato.getRacas();
			List<String> tipoPelo = CadastroAnimalGato.getTipoPelo();

			System.out.println("\n                 |\\__/,|   (`\\");
			System.out.println("               _.|o o  |_   ) )");
			System.out.println("             -(((---(((--------");

			System.out.println("\n  *--------*--------*--------*-------*");
			System.out.println("             Tipos de Pelo ");
			System.out.println("  *--------*--------*--------*-------*");

			for (int indice = 0; indice < tipoPelo.size(); indice++) {
				System.out.println("            " + (indice + 1) + " - " + tipoPelo.get(indice));
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
				System.out.println("      " + numero + " - " + raca);
			}

			System.out.print("\nEscolha o tipo de Raça: ");
			lerInteiro = leia.nextInt();
			raca = racas.get(lerInteiro - 1);

			CadastroAnimalGato animalGato = new CadastroAnimalGato(nomeTutor, endereco, cpf, especie, nomeAnimal, cor,
					sexo, idade, peso, procedimentosLista, valorLista, pelo, raca);

			listaCadastroGato.add(animalGato);
			indiceCadastro += 1;

		}
	}

	// Atualizar Especie
	public void atualizarEspecieGato() {
		List<String> racas = CadastroAnimalGato.getRacas();
		List<String> tipoPelo = CadastroAnimalGato.getTipoPelo();
		System.out.println("\n                 |\\__/,|   (`\\");
		System.out.println("               _.|o o  |_   ) )");
		System.out.println("             -(((---(((--------");

		System.out.println("\n  *--------*--------*--------*-------*");
		System.out.println("             Tipos de Pelo ");
		System.out.println("  *--------*--------*--------*-------*");

		for (int indice = 0; indice < tipoPelo.size(); indice++) {
			System.out.println("            " + (indice + 1) + " - " + tipoPelo.get(indice));
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
			System.out.println("      " + numero + " - " + raca);
		}

		System.out.print("\nEscolha o tipo de Raça: ");
		lerInteiro = leia.nextInt();
		raca = racas.get(lerInteiro - 1);

	}

	// Cadastro Animal Cachorro
	@Override
	public void cadastrarCachorro() {
		if (especie.replaceAll("\\s", "").equalsIgnoreCase("Canina")
				|| especie.replaceAll("\\s", "").equalsIgnoreCase("Canino") && pelo == null && valor != 0.0) {
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
				System.out.println("       " + (indice + 1) + " - " + racaCachorro);
			}

			System.out.print("\nEscolha o tipo de raça: ");
			lerInteiro = leia.nextInt();
			raca = racasCachorro.get(lerInteiro - 1);

			System.out.println("\n  *--------*--------*--------*-------*");
			System.out.println("             Tipos de Pelo ");
			System.out.println("  *--------*--------*--------*-------*");

			for (int indice = 0; indice < pelosCachorro.size(); indice++) {
				String peloCachorro = pelosCachorro.get(indice);
				System.out.println("            " + (indice + 1) + " - " + peloCachorro);
			}

			System.out.print("\nEscolha o tipo de pelo: ");
			lerInteiro = leia.nextInt();
			pelo = pelosCachorro.get(lerInteiro - 1);

			CadastroAnimalCachorro animalCachorro = new CadastroAnimalCachorro(nomeTutor, endereco, cpf, especie,
					nomeAnimal, cor, sexo, idade, peso, procedimentosLista, valorLista, pelo, raca);

			listaCadastroCachorro.add(animalCachorro);
			indiceCadastro += 1;

		}
	}

	// Atualizar Especie
	public void atualizarEspecieCachorro() {
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
			System.out.println("       " + (indice + 1) + " - " + racaCachorro);
		}

		System.out.print("\nEscolha o tipo de raça: ");
		lerInteiro = leia.nextInt();
		raca = racasCachorro.get(lerInteiro - 1);

		System.out.println("\n  *--------*--------*--------*-------*");
		System.out.println("             Tipos de Pelo ");
		System.out.println("  *--------*--------*--------*-------*");

		for (int indice = 0; indice < pelosCachorro.size(); indice++) {
			String peloCachorro = pelosCachorro.get(indice);
			System.out.println("            " + (indice + 1) + " - " + peloCachorro);
		}

		System.out.print("\nEscolha o tipo de pelo: ");
		lerInteiro = leia.nextInt();
		pelo = pelosCachorro.get(lerInteiro - 1);
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
			System.out.println("Idade do Pet: " + listarGato.getIdade());
			System.out.println("Sexo do Pet: " + listarGato.getSexo());
			System.out.println("Peso do Pet: " + listarGato.getPeso());
			System.out.println("Cor do Pet: " + listarGato.getCor());
			System.out.println("Tipo de Pelo: " + listarGato.getPelo());
			System.out.println("Especie: " + listarGato.getEspecie());
			System.out.println("Raça: " + listarGato.getRaca());

			for (ProcedimentosModelo procedimentoDoPet : listaPV) {
				if (procedimentoDoPet.getNomeAnimal().equalsIgnoreCase(listarGato.getNomeAnimal())) {
					ArrayList<String> procedimentos = procedimentoDoPet.getProcedimentos();
					ArrayList<Double> valores = procedimentoDoPet.getValores();
					System.out.println("\n  *--------*--------*--------*-------*");
					System.out.println("               Procedimentos       ");
					System.out.println("  *--------*--------*--------*-------*");
					for (int indice = 0; indice < procedimentos.size(); indice++) {
						System.out.println((indice + 1) + " - Procedimento: " + procedimentos.get(indice) + " Valor: "
								+ valores.get(indice));
					}
				}
			}
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
			System.out.println("Idade do Pet: " + listarCachorro.getIdade());
			System.out.println("Sexo do Pet: " + listarCachorro.getSexo());
			System.out.println("Peso do Pet: " + listarCachorro.getPeso());
			System.out.println("Tipo de Pelo: " + listarCachorro.getTipoPeloCachorro());
			System.out.println("Cor do Pet: " + listarCachorro.getCor());
			System.out.println("Especie: " + listarCachorro.getEspecie());
			System.out.println("Raça: " + listarCachorro.getRacaCachorro());
			for (ProcedimentosModelo procedimentoDoPet : listaPV) {
				if (procedimentoDoPet.getNomeAnimal().equalsIgnoreCase(listarCachorro.getNomeAnimal())) {
					ArrayList<String> procedimentos = procedimentoDoPet.getProcedimentos();
					ArrayList<Double> valores = procedimentoDoPet.getValores();
					System.out.println("\n  *--------*--------*--------*-------*");
					System.out.println("               Procedimentos       ");
					System.out.println("  *--------*--------*--------*-------*");
					for (int indice = 0; indice < procedimentos.size(); indice++) {
						System.out.println((indice + 1) + " - Procedimento: " + procedimentos.get(indice) + " Valor: "
								+ valores.get(indice));
					}
				}
			}
		}
	}

	// Junção do listar
	@Override
	public void listarPets() {
		listarGato();
		listarCachorro();
	}

	// Print Gato
	public void printCadastroGato() {
		Iterator<CadastroAnimalGato> iFichaGato = listaCadastroGato.iterator();

		if (especie.replaceAll("\\s", "").equalsIgnoreCase("Felino")
				|| especie.replaceAll("\\s", "").equalsIgnoreCase("Felina") && iFichaGato.hasNext()) {
			CadastroAnimalGato fichaGato = iFichaGato.next();

			System.out.println("\n              |\\__/,|   (`\\");
			System.out.println("            _.|o o  |_   ) )");
			System.out.println("          -(((---(((--------");

			System.out.println("\n  *--------*--------*--------*-------*");
			System.out.println("           Dados do seu Pet ");
			System.out.println("  *--------*--------*--------*-------*");

			System.out.println("Nome Tutor: " + fichaGato.getNomeDono());
			System.out.println("CPF: " + fichaGato.getCpf());
			System.out.println("Endereço: " + fichaGato.getEndereco());
			System.out.println("Nome do Pet: " + fichaGato.getNomeAnimal());
			System.out.println("Idade do Pet: " + fichaGato.getIdade());
			System.out.println("Peso do Pet: " + fichaGato.getPeso());
			System.out.println("Cor do Pet: " + fichaGato.getCor());
			System.out.println("Sexo do Pet: " + fichaGato.getSexo());
			System.out.println("Especie: " + fichaGato.getEspecie());
			System.out.println("Tipo de Pelo: " + fichaGato.getPelo());
			System.out.println("Raça: " + fichaGato.getRaca());

			listaProcedimentos();
			System.out.println("\n  *--------*--------*--------*-------*");
			System.out.println("             Valor total: " + valorTotal);
			System.out.println("  *--------*--------*--------*-------*");
		}
	}

	// Print Cachorro
	public void printCadastroCachorro() {
		Iterator<CadastroAnimalCachorro> iFichaCachorro = listaCadastroCachorro.iterator();

		if (especie.replaceAll("\\s", "").equalsIgnoreCase("Canina")
				|| especie.replaceAll("\\s", "").equalsIgnoreCase("Canino") && iFichaCachorro.hasNext()) {
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
			System.out.println("Nome Tutor: " + fichaCachorro.getNomeDono());
			System.out.println("CPF: " + fichaCachorro.getCpf());
			System.out.println("Endereço: " + fichaCachorro.getEndereco());
			System.out.println("Nome do Pet: " + fichaCachorro.getNomeAnimal());
			System.out.println("Idade do Pet: " + fichaCachorro.getIdade());
			System.out.println("Peso do Pet: " + fichaCachorro.getPeso());
			System.out.println("Cor do Pet: " + fichaCachorro.getCor());
			System.out.println("Sexo do Pet: " + fichaCachorro.getSexo());
			System.out.println("Especie: " + fichaCachorro.getEspecie());
			System.out.println("Tipo de Pelo: " + fichaCachorro.getTipoPeloCachorro());
			System.out.println("Raça: " + fichaCachorro.getRacaCachorro());
			System.out.println("Valor total: " + valorTotal);
			listaProcedimentos();
			System.out.println("\n  *--------*--------*--------*-------*");
			System.out.println("             Valor total: " + valorTotal);
			System.out.println("  *--------*--------*--------*-------*");

		}
	}

	// Banho Gato Rita
	@Override
	public void banhoGato() {
		if (especie.replaceAll("\\s", "").equalsIgnoreCase("Felino")
				|| especie.replaceAll("\\s", "").equalsIgnoreCase("Felina")) {
			if (pelo.equalsIgnoreCase("Curto")) {
				valor = 30.0;
				valorTotal += valor;
				valorTotalDia = valorTotal;
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("         Valor do banho Acrescentado     ");
				System.out.println("  *--------*--------*--------*-------*");
				procedimentosLista.add("Banho           ");
				valorLista.add(valor);
			} else if (pelo.equalsIgnoreCase("Médio")) {
				valor = 40.0;
				valorTotal += valor;
				valorTotalDia = valorTotal;
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("         Valor do banho Acrescentado     ");
				System.out.println("  *--------*--------*--------*-------*");
				procedimentosLista.add("Banho           ");
				valorLista.add(valor);
			} else if (pelo.equalsIgnoreCase("Longo")) {
				valor = 50.0;
				valorTotal += valor;
				valorTotalDia = valorTotal;
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("         Valor do banho Acrescentado     ");
				System.out.println("  *--------*--------*--------*-------*");
				procedimentosLista.add("Banho           ");
				valorLista.add(valor);
			} else if (pelo.equalsIgnoreCase("Sem pelos")) {
				valor = 80.0;
				valorTotal += valor;
				valorTotalDia = valorTotal;
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("         Valor do banho Acrescentado     ");
				System.out.println("  *--------*--------*--------*-------*");
				procedimentosLista.add("Banho           ");
				valorLista.add(valor);
			} else {
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("          Tipo de pelo Inválido     ");
				System.out.println("  *--------*--------*--------*-------*");
			}

		}
	}

	// Banho Cachorro
	@Override
	public void banhoCachorro() {
		if (especie.replaceAll("\\s", "").equalsIgnoreCase("Canina")
				|| especie.replaceAll("\\s", "").equalsIgnoreCase("Canino")) {
			if (pelo.equalsIgnoreCase("Curto")) {
				valor = 120.0;
				valorTotal += valor;
				valorTotalDia = valorTotal;
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("         Valor do banho Acrescentado     ");
				System.out.println("  *--------*--------*--------*-------*");
				procedimentosLista.add("Banho          ");
				valorLista.add(valor);
			} else if (pelo.equalsIgnoreCase("Médio")) {
				valor = 150.0;
				valorTotal += valor;
				valorTotalDia = valorTotal;
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("         Valor do banho Acrescentado     ");
				System.out.println("  *--------*--------*--------*-------*");
				procedimentosLista.add("Banho          ");
				valorLista.add(valor);
			} else if (pelo.equalsIgnoreCase("Longo")) {
				valor = 270.0;
				valorTotal += valor;
				valorTotalDia = valorTotal;
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("         Valor do banho Acrescentado     ");
				System.out.println("  *--------*--------*--------*-------*");
				procedimentosLista.add("Banho          ");
				valorLista.add(valor);
			} else if (pelo.equalsIgnoreCase("Sem pelos")) {
				valor = 150.0;
				valorTotal += valor;
				valorTotalDia = valorTotal;
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("         Valor do banho Acrescentado     ");
				System.out.println("  *--------*--------*--------*-------*");
				procedimentosLista.add("Banho          ");
				valorLista.add(valor);
			} else if (pelo.equalsIgnoreCase("Pelagem Dupla")) {
				valor = 180.0;
				valorTotal += valor;
				valorTotalDia = valorTotal;
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("         Valor do banho Acrescentado     ");
				System.out.println("  *--------*--------*--------*-------*");
				procedimentosLista.add("Banho          ");
				valorLista.add(valor);
			} else if (pelo.equalsIgnoreCase("Encaracolado")) {
				valor = 130.0;
				valorTotal += valor;
				valorTotalDia = valorTotal;
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("         Valor do banho Acrescentado     ");
				System.out.println("  *--------*--------*--------*-------*");
				procedimentosLista.add("Banho          ");
				valorLista.add(valor);
			} else {
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("          Tipo de pelo Inválido     ");
				System.out.println("  *--------*--------*--------*-------*");
			}

		}
	}

	// Vacinar Gato
	@Override
	public void vacinarGato() {
		int tipoVacina;
		ArrayList<String> VacinasGato = VacinaModelo.getVacinaGato();
		if (especie.replaceAll("\\s", "").equalsIgnoreCase("Felino")
				|| especie.replaceAll("\\s", "").equalsIgnoreCase("Felina")) {
			System.out.println("\n  *--------*--------*--------*-------*");
			System.out.println("              Gato Vacinas ");
			System.out.println("  *--------*--------*--------*-------*");

			for (int indice = 0; indice < VacinasGato.size(); indice++) {
				String vacinaGato = VacinasGato.get(indice);
				System.out.println("\n" + (indice + 1) + " - " + vacinaGato);
			}
			System.out.print("\nInforme o tipo de vacina: ");
			tipoVacina = leia.nextInt();

			switch (tipoVacina) {
			case 1:
				valor = 150.0;
				valorTotal += valor;
				valorTotalDia = valorTotal;
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("      Valor da vacina acrescentado     ");
				System.out.println("  *--------*--------*--------*-------*");
				procedimentosLista.add("Vacina V5      ");
				valorLista.add(valor);
				break;
			case 2:
				valor = 100.0;
				valorTotal += valor;
				valorTotalDia = valorTotal;
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("      Valor da vacina acrescentado     ");
				System.out.println("  *--------*--------*--------*-------*");
				procedimentosLista.add("Vacina V4      ");
				valorLista.add(valor);
				break;
			case 3:
				valor = 80.0;
				valorTotal += valor;
				valorTotalDia = valorTotal;
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("      Valor da vacina acrescentado     ");
				System.out.println("  *--------*--------*--------*-------*");
				procedimentosLista.add("Vacina V3       ");
				valorLista.add(valor);
				break;
			case 4:
				valor = 60.0;
				valorTotal += valor;
				valorTotalDia = valorTotal;
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("      Valor da vacina acrescentado     ");
				System.out.println("  *--------*--------*--------*-------*");
				procedimentosLista.add("Antirrábica     ");
				valorLista.add(valor);
				break;
			default:
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("     Não trabalhamos com essa vacina     ");
				System.out.println("  *--------*--------*--------*-------*");
				break;
			}
		}
	}

	// Vacinar Cachorro
	@Override
	public void vacinarCachorro() {
		int tipoVacina;
		ArrayList<String> VacinasCachorro = VacinaModelo.getVacinaCachorro();

		if (especie.replaceAll("\\s", "").equalsIgnoreCase("Canina")
				|| especie.replaceAll("\\s", "").equalsIgnoreCase("Canino")) {
			System.out.println("\n  *--------*--------*--------*-------*");
			System.out.println("            Cachorro Vacinas ");
			System.out.println("  *--------*--------*--------*-------*");

			for (int indice = 0; indice < VacinasCachorro.size(); indice++) {
				String vacinaCachorro = VacinasCachorro.get(indice);
				System.out.println("\n" + (indice + 1) + " - " + vacinaCachorro);
			}
			System.out.print("\nInforme o tipo de vacina: ");
			tipoVacina = leia.nextInt();

			switch (tipoVacina) {
			case 1:
				valor = 150.0;
				valorTotal += valor;
				valorTotalDia = valorTotal;
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("      Valor da vacina acrescentado     ");
				System.out.println("  *--------*--------*--------*-------*");
				procedimentosLista.add("Vacina V10     ");
				valorLista.add(valor);
				break;
			case 2:
				valor = 100.0;
				valorTotal += valor;
				valorTotalDia = valorTotal;
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("      Valor da vacina acrescentado     ");
				System.out.println("  *--------*--------*--------*-------*");
				procedimentosLista.add("Vacina V8      ");
				valorLista.add(valor);
				break;
			case 3:
				valor = 60.0;
				valorTotal += valor;
				valorTotalDia = valorTotal;
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("      Valor da vacina acrescentado     ");
				System.out.println("  *--------*--------*--------*-------*");
				procedimentosLista.add("Antirrábica     ");
				valorLista.add(valor);
				break;
			default:
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("     Não trabalhamos com essa vacina     ");
				System.out.println("  *--------*--------*--------*-------*");
				break;
			}
		}
	}

	// Tosa Gato Rita
	@Override
	public void tosaGato() {

		if (especie.replaceAll("\\s", "").equalsIgnoreCase("Felino")
				|| especie.replaceAll("\\s", "").equalsIgnoreCase("Felina")) {
			if (pelo.equalsIgnoreCase("Curto")) {
				valor = 50.0;
				valorTotal += valor;
				valorTotalDia = valorTotal;
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("         Valor da tosa Acrescentado     ");
				System.out.println("  *--------*--------*--------*-------*");
				procedimentosLista.add("Tosa            ");
				valorLista.add(valor);
			} else if (pelo.equalsIgnoreCase("Médio")) {
				valor = 60.0;
				valorTotal += valor;
				valorTotalDia = valorTotal;
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("         Valor da tosa Acrescentado     ");
				System.out.println("  *--------*--------*--------*-------*");
				procedimentosLista.add("Tosa            ");
				valorLista.add(valor);
			} else if (pelo.equalsIgnoreCase("Longo")) {
				valor = 75.0;
				valorTotal += valor;
				valorTotalDia = valorTotal;
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("         Valor da tosa Acrescentado     ");
				System.out.println("  *--------*--------*--------*-------*");
				procedimentosLista.add("Tosa            ");
				valorLista.add(valor);
			} else {
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("          Tipo de pelo Inválido     ");
				System.out.println("  *--------*--------*--------*-------*");
			}
		}
	}

	// Tosa Cachorro
	@Override
	public void tosaCachorro() {

		if (especie.replaceAll("\\s", "").equalsIgnoreCase("Canina")
				|| especie.replaceAll("\\s", "").equalsIgnoreCase("Canino")) {
			if (pelo.equalsIgnoreCase("Curto")) {
				valor = 120.0;
				valorTotal += valor;
				valorTotalDia = valorTotal;
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("        Valor da tosa Acrescentado     ");
				System.out.println("  *--------*--------*--------*-------*");
				procedimentosLista.add("Tosa            ");
				valorLista.add(valor);
			} else if (pelo.equalsIgnoreCase("Médio")) {
				valor = 180.0;
				valorTotal += valor;
				valorTotalDia = valorTotal;
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("        Valor da tosa Acrescentado     ");
				System.out.println("  *--------*--------*--------*-------*");
				procedimentosLista.add("Tosa            ");
				valorLista.add(valor);
			} else if (pelo.equalsIgnoreCase("Longo")) {
				valor = 270.0;
				valorTotal += valor;
				valorTotalDia = valorTotal;
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("        Valor da tosa Acrescentado     ");
				System.out.println("  *--------*--------*--------*-------*");
				procedimentosLista.add("Tosa            ");
				valorLista.add(valor);
			} else if (pelo.equalsIgnoreCase("Pelagem Dupla")) {
				valor = 130.0;
				valorTotal += valor;
				valorTotalDia = valorTotal;
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("        Valor da tosa Acrescentado     ");
				System.out.println("  *--------*--------*--------*-------*");
				procedimentosLista.add("Tosa            ");
				valorLista.add(valor);
			} else if (pelo.equalsIgnoreCase("Encaracolado")) {
				valor = 150.0;
				valorTotal += valor;
				valorTotalDia = valorTotal;
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("        Valor da tosa Acrescentado     ");
				System.out.println("  *--------*--------*--------*-------*");
				procedimentosLista.add("Tosa            ");
				valorLista.add(valor);
			} else {
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("          Tipo de pelo Inválido     ");
				System.out.println("  *--------*--------*--------*-------*");
			}

		}
	}

	// Castrar Gato Gabi
	@Override
	public void castrarGato() {

		Iterator<CadastroAnimalGato> iFichaGato = listaCadastroGato.iterator();

		if (especie.replaceAll("\\s", "").equalsIgnoreCase("Felino")
				|| especie.replaceAll("\\s", "").equalsIgnoreCase("Felina")) {
			if (iFichaGato.hasNext()) {
				CadastroAnimalGato fichaGato = iFichaGato.next();
				if (fichaGato.getEspecie().replaceAll("\\s", "").equalsIgnoreCase("Felino")) {
					System.out.println("\n  *--------*--------*--------*-------*");
					System.out.println("     Valor da castração Acrescentado  ");
					System.out.println("  *--------*--------*--------*-------*");
					valor = 400.0;
					valorTotal += valor;
					valorTotalDia += valorTotal;
					procedimentosLista.add("Castração      ");
					valorLista.add(valor);
				} else {
					System.out.println("\n  *--------*--------*--------*-------*");
					System.out.println("            Castração Inválida  ");
					System.out.println("  *--------*--------*--------*-------*");
				}
			}
		}
	}

	// Castrar Cachorro Gabi
	@Override
	public void castrarCachorro() {
		Iterator<CadastroAnimalCachorro> iFichaCachorro = listaCadastroCachorro.iterator();

		if (iFichaCachorro.hasNext()) {
			if (especie.replaceAll("\\s", "").equalsIgnoreCase("Canina")
					|| especie.replaceAll("\\s", "").equalsIgnoreCase("Canino")
							&& sexo.replaceAll("\\s", "").equalsIgnoreCase("macho")) {
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("     Valor da castração Acrescentado  ");
				System.out.println("  *--------*--------*--------*-------*");
				valor = 400.0;
				valorTotal += valor;
				valorTotalDia += valorTotal;
				procedimentosLista.add("Castração      ");
				valorLista.add(valor);
			} else if (especie.replaceAll("\\s", "").equalsIgnoreCase("Canina")
					|| especie.replaceAll("\\s", "").equalsIgnoreCase("Canino")
							&& sexo.replaceAll("\\s", "").equalsIgnoreCase("Femea")
					|| sexo.replaceAll("\\s", "").equalsIgnoreCase("Fêmea")) {
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("     Valor da castração Acrescentado  ");
				System.out.println("  *--------*--------*--------*-------*");
				valor = 600.0;
				valorTotal += valor;
				valorTotalDia += valorTotal;
				procedimentosLista.add("Castração      ");
				valorLista.add(valor);
			} else {

				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("            Castração Inválida  ");
				System.out.println("  *--------*--------*--------*-------*");

			}
		}
	}

	// Acrescenta o Valor da Consulta
	@Override
	public void consulta() {

		if (listaCadastroGato.isEmpty() && listaCadastroCachorro.isEmpty()) {
			System.out.println("\n  *--------*--------*--------*-------*");
			System.out.println("            Cadastro pendente         ");
			System.out.println("  *--------*--------*--------*-------*");
		} else {

			System.out.println("\n  *--------*--------*--------*-------*");
			System.out.println("     Valor da consulta Acrescentado  ");
			System.out.println("  *--------*--------*--------*-------*");

			valor = 200.00;
			valorTotal += valor;
			valorTotalDia += valorTotal;
			procedimentosLista.add("Consulta       ");
			valorLista.add(200.00);
		}
	}

	// Saída Gabi
	@Override
	public void saidaAnimal() {
		printCadastroGato();
		printCadastroCachorro();
		ProcedimentosModelo listaModeloPV = new ProcedimentosModelo(nomeAnimal, procedimentosLista, valorLista);

		listaPV.add(listaModeloPV);

		System.out.println("\n  *--------*--------*--------*-------*");
		System.out.println("        Agradecemos a preferência ");
		System.out.println("  *--------*--------*--------*-------*");

		zerarVariaveis();
	}

	public void gravarObjeto() {
		if (especie.replaceAll("\\s", "").equalsIgnoreCase("Canina")
				|| especie.replaceAll("\\s", "").equalsIgnoreCase("Canino")) {
			CadastroAnimalCachorro animalCachorro = new CadastroAnimalCachorro(nomeTutor, endereco, cpf, especie,
					nomeAnimal, cor, sexo, idade, peso, procedimentosLista, valorLista, pelo, raca);

			listaCadastroCachorro.add(animalCachorro);
			indiceCadastro += 1;

		} else if (especie.replaceAll("\\s", "").equalsIgnoreCase("Felino")
				|| especie.replaceAll("\\s", "").equalsIgnoreCase("Felina")) {
			CadastroAnimalGato animalGato = new CadastroAnimalGato(nomeTutor, endereco, cpf, especie, nomeAnimal, cor,
					sexo, idade, peso, procedimentosLista, valorLista, pelo, raca);

			listaCadastroGato.add(animalGato);
			indiceCadastro += 1;

		}
	}

	// Zerar Variaveis
	public void zerarVariaveis() {
		procedimentosLista.clear();
		valorLista.clear();
		valorTotal = 0.0;
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
		peso = 0.0;
	}

	// Confere se o cadastro foi finalizado ou não
	public void cadastrarPets() {
		if (nomeTutor != null) {
			System.out.println("\n  *--------*--------*--------*-------*");
			System.out.println("    Finalize o cadastro e crie outro");
			System.out.println("  *--------*--------*--------*-------*");
		} else {
			cadastrar();
			cadastrarCachorro();
			cadastrarGato();
		}
	}

	// Buscar
	public void buscarAnimalGato() {
		leia.skip("\\R?");
		System.out.print("Digite o nome do pet: ");
		lerString = leia.nextLine();

		for (CadastroAnimalGato Gato : listaCadastroGato) {
			if (Gato.getNomeAnimal().equalsIgnoreCase(lerString)) {

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

				for (ProcedimentosModelo procedimentoDoPet : listaPV) {
					if (procedimentoDoPet.getNomeAnimal().equalsIgnoreCase("lerString")) {
						ArrayList<String> procedimentos = procedimentoDoPet.getProcedimentos();
						ArrayList<Double> valores = procedimentoDoPet.getValores();
						System.out.println("\n  *--------*--------*--------*-------*");
						System.out.println("               Procedimentos       ");
						System.out.println("  *--------*--------*--------*-------*");
						for (int indice = 0; indice < procedimentos.size(); indice++) {
							System.out.println((indice + 1) + " - Procedimento: " + procedimentos.get(indice)
									+ " Valor: " + valores.get(indice));
						}
					}
				}
			} else {
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("    Você ainda não cadastrou seu Pet");
				System.out.println("  *--------*--------*--------*-------*");
			}
		}
	}

	public void buscarAnimalCachorro() {
		listarPets();
		leia.skip("\\R?");
		System.out.print("Digite o nome do pet: ");
		lerString = leia.nextLine();

		for (CadastroAnimalCachorro cachorro : listaCadastroCachorro) {
			if (cachorro.getNomeAnimal().equalsIgnoreCase(lerString)) {
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

				for (ProcedimentosModelo procedimentoDoPet : listaPV) {
					if (procedimentoDoPet.getNomeAnimal().equalsIgnoreCase("lerString")) {
						ArrayList<String> procedimentos = procedimentoDoPet.getProcedimentos();
						ArrayList<Double> valores = procedimentoDoPet.getValores();
						System.out.println("\n  *--------*--------*--------*-------*");
						System.out.println("               Procedimentos       ");
						System.out.println("  *--------*--------*--------*-------*");
						for (int indice = 0; indice < procedimentos.size(); indice++) {
							System.out.println((indice + 1) + " - Procedimento: " + procedimentos.get(indice)
									+ " Valor: " + valores.get(indice));
						}
					}
				}
			} else {
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("    Você ainda não cadastrou seu Pet");
				System.out.println("  *--------*--------*--------*-------*");
			}
		}
	}

	// Junção Do buscar
	public void buscarAnimal() {
		leia.skip("\\R?");
		System.out.print("\nDigite a especie do seu pet: ");
		lerString = leia.nextLine();
		if (lerString.replaceAll("\\s", "").equalsIgnoreCase("Felino")
				|| lerString.replaceAll("\\s", "").equalsIgnoreCase("Felina")) {
			if (listaCadastroCachorro.isEmpty() && listaCadastroGato.isEmpty()) {
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("            Cadastro pendente         ");
				System.out.println("  *--------*--------*--------*-------*");
			} else {
				buscarAnimalGato();
			}

		} else if (lerString.replaceAll("\\s", "").equalsIgnoreCase("Canina")
				|| lerString.replaceAll("\\s", "").equalsIgnoreCase("Canino")) {
			if (listaCadastroCachorro.isEmpty() && listaCadastroGato.isEmpty()) {
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("            Cadastro pendente         ");
				System.out.println("  *--------*--------*--------*-------*");
			} else {
				buscarAnimalCachorro();
			}
		} else {
			System.out.println("\n  *--------*--------*--------*-------*");
			System.out.println("   Só trabalhamos com Felino e Canina");
			System.out.println("  *--------*--------*--------*-------*");
		}
	}

	// Remover Cadastro
	@Override
	public void removerCadastro() {
		listarPets();
		leia.skip("\\R?");
		System.out.println("\n  *--------*--------*--------*-------*");
		System.out.println("            Removendo Cadastro");
		System.out.println("  *--------*--------*--------*-------*");
		System.out.print("\nDigite o nome do pet: ");
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

	// Atualizar cadastro
	@Override
	public void atualizarCadastro() {
		leia.skip("\\R?");
		System.out.println("\n  *--------*--------*--------*-------*");
		System.out.println("           Atualizando Cadastro");
		System.out.println("  *--------*--------*--------*-------*");
		System.out.print("\nDigite especie [Felino] ou [Canina]: ");
		lerString = leia.nextLine();
		listarPets();
		if (conferirEspecieGato()) {
			if (listaCadastroCachorro.isEmpty() && listaCadastroGato.isEmpty()) {
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("            Cadastro pendente         ");
				System.out.println("  *--------*--------*--------*-------*");
			} else {
				atualizarCadastroGato();
			}

		} else if (!conferirEspecieGato()) {
			if (listaCadastroCachorro.isEmpty() && listaCadastroGato.isEmpty()) {
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("            Cadastro pendente         ");
				System.out.println("  *--------*--------*--------*-------*");
			} else {
				atualizarCadastroCachorro();
			}
		} else {
			System.out.println("\n  *--------*--------*--------*-------*");
			System.out.println("   Só trabalhamos com Felino e Canina");
			System.out.println("  *--------*--------*--------*-------*");
		}

	}

	public boolean conferirEspecieGato() {
		if (lerString.replaceAll("\\s", "").equalsIgnoreCase("Felino")
				|| lerString.replaceAll("\\s", "").equalsIgnoreCase("Felina")) {
			return true;
		} else {
			return false;
		}

	}

	public void atualizarCadastroGato() {
		System.out.print("\nDigite o nome do pet: ");
		String lerString = leia.nextLine();

		for (CadastroAnimalGato fichaGato : listaCadastroGato) {
			if (fichaGato.getNomeAnimal().replaceAll("\\s", "").equalsIgnoreCase(lerString)) {
				CadastroAnimalGato atualizarCadastro = fichaGato;

				listaCadastroGato.remove(fichaGato);
				zerarVariaveis();

				nomeTutor = atualizarCadastro.getNomeDono();
				cpf = atualizarCadastro.getCpf();
				endereco = atualizarCadastro.getEndereco();
				nomeAnimal = atualizarCadastro.getNomeAnimal();
				cor = atualizarCadastro.getCor();
				sexo = atualizarCadastro.getSexo();
				idade = atualizarCadastro.getIdade();
				especie = atualizarCadastro.getEspecie();
				pelo = atualizarCadastro.getPelo();
				raca = atualizarCadastro.getRaca();
				peso = atualizarCadastro.getPeso();
				procedimentosLista = atualizarCadastro.getProcedimentos();
				valorLista = atualizarCadastro.getValor();

				boolean continua = true;
				while (continua) {
					System.out.println("\n  *--------*--------*--------*-------*");
					System.out.println("          1 - Alterar nome do tutor");
					System.out.println("          2 - Alterar CPF");
					System.out.println("          3 - Alterar endereço");
					System.out.println("          4 - Alterar nome do pet");
					System.out.println("          5 - Alterar cor");
					System.out.println("          6 - Alterar sexo");
					System.out.println("          7 - Alterar idade");
					System.out.println("          8 - Alterar peso");
					System.out.println("          9 - Alterar espécie");
					System.out.println("          10 - Sair");
					System.out.println("  *--------*--------*--------*-------*");
					System.out.print("\nEscolha a opção: ");
					lerInteiro = leia.nextInt();

					switch (lerInteiro) {
					case 1 -> {
						System.out.print("Digite o novo nome: ");
						leia.skip("\\R?");
						lerString = leia.nextLine();
						atualizarCadastro.setNomeDono(lerString);
						nomeTutor = lerString;
						cadastroAtualizado();
					}
					case 2 -> {
						System.out.print("Digite o novo CPF: ");
						leia.skip("\\R?");
						lerString = leia.nextLine();
						atualizarCadastro.setCpf(lerString);
						cpf = lerString;
						cadastroAtualizado();
					}
					case 3 -> {
						System.out.print("Digite o novo endereço: ");
						leia.skip("\\R?");
						lerString = leia.nextLine();
						atualizarCadastro.setEndereco(lerString);
						endereco = lerString;
						cadastroAtualizado();
					}
					case 4 -> {
						System.out.print("Digite o novo nome do Pet: ");
						leia.skip("\\R?");
						lerString = leia.nextLine();
						atualizarCadastro.setNomeAnimal(lerString);
						nomeAnimal = lerString;
						cadastroAtualizado();
					}
					case 5 -> {
						System.out.print("Digite a nova cor: ");
						leia.skip("\\R?");
						lerString = leia.nextLine();
						atualizarCadastro.setCor(lerString);
						cor = lerString;
						cadastroAtualizado();
					}
					case 6 -> {
						System.out.print("Digite o novo sexo: ");
						leia.skip("\\R?");
						lerString = leia.nextLine();
						atualizarCadastro.setSexo(lerString);
						sexo = lerString;
						cadastroAtualizado();
					}
					case 7 -> {
						System.out.print("Digite a novo Idade: ");
						leia.skip("\\R?");
						lerString = leia.nextLine();
						atualizarCadastro.setIdade(lerString);
						idade = lerString;
						cadastroAtualizado();
					}
					case 8 -> {
						System.out.print("Digite o novo peso: ");
						lerDouble = leia.nextDouble();
						atualizarCadastro.setPeso(lerDouble);
						peso = lerDouble;
						cadastroAtualizado();
					}
					case 9 -> {
						System.out.print("Digite a nova especie [Felino] ou [Canina]: ");
						leia.skip("\\R?");
						lerString = leia.nextLine();
						atualizarCadastro.setEspecie(lerString);
						especie = lerString;
						atualizarEspecieGato();
						atualizarCadastroCachorro();
						atualizarCadastro.setPelo(pelo);
						atualizarCadastro.setRaca(raca);
						cadastroAtualizado();
					}
					case 10 -> {

						listaCadastroGato.add(atualizarCadastro);
						System.out.println("\n  *--------*--------*--------*-------*");
						System.out.println("           Atualização encerrada");
						System.out.println("  *--------*--------*--------*-------*");
						continua = false;
					}
					default -> {
						System.out.println("\n  *--------*--------*--------*-------*");
						System.out.println("              Opção Invalida");
						System.out.println("  *--------*--------*--------*-------*");
					}
					}
				}
			} else {
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("              Nome Invalido");
				System.out.println("  *--------*--------*--------*-------*");
			}
		}
	}

	public void cadastroAtualizado() {
		System.out.println("\n  *--------*--------*--------*-------*");
		System.out.println("            Cadastro Atualizado ");
		System.out.println("  *--------*--------*--------*-------*");
	}

	public void atualizarCadastroCachorro() {
		System.out.print("Digite o nome do pet: ");
		String lerString = leia.nextLine();

		for (CadastroAnimalCachorro fichaCachorro : listaCadastroCachorro) {
			if (fichaCachorro.getNomeAnimal().replaceAll("\\s", "").equalsIgnoreCase(lerString)) {
				CadastroAnimalCachorro atualizarCadastro = fichaCachorro;

				listaCadastroCachorro.remove(fichaCachorro);
				zerarVariaveis();
				nomeTutor = atualizarCadastro.getNomeDono();
				cpf = atualizarCadastro.getCpf();
				endereco = atualizarCadastro.getEndereco();
				nomeAnimal = atualizarCadastro.getNomeAnimal();
				cor = atualizarCadastro.getCor();
				sexo = atualizarCadastro.getSexo();
				idade = atualizarCadastro.getIdade();
				especie = atualizarCadastro.getEspecie();
				pelo = atualizarCadastro.getTipoPeloCachorro();
				peso = atualizarCadastro.getPeso();
				raca = atualizarCadastro.getRacaCachorro();
				procedimentosLista = atualizarCadastro.getProcedimentos();
				valorLista = atualizarCadastro.getValor();

				boolean continua = true;
				while (continua) {
					System.out.println("\n  *--------*--------*--------*-------*");
					System.out.println("          1 - Alterar nome do tutor");
					System.out.println("          2 - Alterar CPF");
					System.out.println("          3 - Alterar endereço");
					System.out.println("          4 - Alterar nome do pet");
					System.out.println("          5 - Alterar cor");
					System.out.println("          6 - Alterar sexo");
					System.out.println("          7 - Alterar idade");
					System.out.println("          8 - Alterar peso");
					System.out.println("          9 - Alterar espécie");
					System.out.println("          10 - Sair");
					System.out.println("  *--------*--------*--------*-------*");
					System.out.print("\nEscolha a opção: ");
					lerInteiro = leia.nextInt();

					switch (lerInteiro) {
					case 1 -> {
						System.out.print("Digite o novo nome: ");
						leia.skip("\\R?");
						lerString = leia.nextLine();
						atualizarCadastro.setNomeDono(lerString);
						nomeTutor = lerString;
						cadastroAtualizado();
					}
					case 2 -> {
						System.out.print("Digite o novo CPF: ");
						leia.skip("\\R?");
						lerString = leia.nextLine();
						atualizarCadastro.setCpf(lerString);
						cpf = lerString;
						cadastroAtualizado();
					}
					case 3 -> {
						System.out.print("Digite o novo endereço: ");
						leia.skip("\\R?");
						lerString = leia.nextLine();
						atualizarCadastro.setEndereco(lerString);
						endereco = lerString;
						cadastroAtualizado();
					}
					case 4 -> {
						System.out.print("Digite o novo nome do Pet: ");
						leia.skip("\\R?");
						lerString = leia.nextLine();
						atualizarCadastro.setNomeAnimal(lerString);
						nomeAnimal = lerString;
						cadastroAtualizado();
					}
					case 5 -> {
						System.out.print("Digite a nova cor: ");
						leia.skip("\\R?");
						lerString = leia.nextLine();
						atualizarCadastro.setCor(lerString);
						cor = lerString;
						cadastroAtualizado();
					}
					case 6 -> {
						System.out.print("Digite o novo sexo: ");
						leia.skip("\\R?");
						lerString = leia.nextLine();
						atualizarCadastro.setSexo(lerString);
						sexo = lerString;
						cadastroAtualizado();
					}
					case 7 -> {
						System.out.print("Digite a novo Idade: ");
						leia.skip("\\R?");
						lerString = leia.nextLine();
						atualizarCadastro.setIdade(lerString);
						idade = lerString;
						cadastroAtualizado();
					}
					case 8 -> {
						System.out.print("Digite o novo peso: ");
						lerDouble = leia.nextDouble();
						atualizarCadastro.setPeso(lerDouble);
						peso = lerDouble;
						cadastroAtualizado();
					}
					case 9 -> {
						System.out.print("Digite a nova especie [Felino] ou [Canina]: ");
						leia.skip("\\R?");
						lerString = leia.nextLine();
						atualizarCadastro.setEspecie(lerString);
						especie = lerString;
						atualizarEspecieGato();
						atualizarCadastroCachorro();
						atualizarCadastro.setTipoPeloCachorro(pelo);
						atualizarCadastro.setRacaCachorro(raca);
						cadastroAtualizado();
					}
					case 10 -> {
						listaCadastroCachorro.add(atualizarCadastro);
						System.out.println("\n  *--------*--------*--------*-------*");
						System.out.println("           Atualização encerrada");
						System.out.println("  *--------*--------*--------*-------*");
						continua = false;
					}
					default -> {
						System.out.println("\n  *--------*--------*--------*-------*");
						System.out.println("              Opção Invalida");
						System.out.println("  *--------*--------*--------*-------*");
					}
					}
				}
			} else {
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("              Nome Invalido");
				System.out.println("  *--------*--------*--------*-------*");
			}
		}
	}

	// Sair Expediente
	public boolean sairExpediente() {
		if (nomeTutor != null) {
			return true;
		}

		return false;
	}

	// Mostra Cadastro Pendente
	public void mostraCadastroPendenteSaida() 
	{
		System.out.println("\n  *--------*--------*--------*-------*");
		System.out.println("    Finalização de cadastro pendente ");
		System.out.println("  *--------*--------*--------*-------*");
	}

	// Mostra Valor total do dia
	public void mostraSaida() {
		System.out.println("\n  *--------*--------*--------*-------*");
		System.out.println("          Expediente Finalizado      ");
		System.out.println("  *--------*--------*--------*-------*");
		System.out.println("         Valor Total do dia: " + valorTotalDia);
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

	// Listagem de procedimentos por animal
	public void listaProcedimentos() {
		if (nomeAnimal != null && procedimentosLista != null && valorLista != null) {
			System.out.println("\n  *--------*--------*--------*-------*");
			System.out.println("               Procedimentos       ");
			System.out.println("  *--------*--------*--------*-------*");
			for (int indice = 0; indice < procedimentosLista.size(); indice++) {
				System.out.println(
						 "  - Procedimento: " + procedimentosLista.get(indice) + valorLista.get(indice));
			}

		}
	}
}
