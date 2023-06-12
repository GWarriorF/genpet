package cadastro;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import cadastro.menu.MetodosMenu;
import util.Cores;

public class MenuPet {

	public static void main(String[] args) {

		boolean exibir = true;
		int exibicao = 0;
		Scanner ler = new Scanner(System.in);
		MetodosMenu ficha = new MetodosMenu();

		/*
		 * System.out.println(Cores.TEXT_WHITE_BRIGHT +
		 * "Bem Vindes a GenPet! \nPressione " + Cores.TEXT_GREEN_BRIGHT + "\"ENTER\"" +
		 * Cores.TEXT_WHITE_BRIGHT + " para começar!\n"); ler.skip("\\R");
		 */

		while (exibir) {
			System.out.println("\n   *--------*--------*-------*-----*");
			System.out.println("  *                                 *");
			System.out.println(" *        " + Cores.TEXT_YELLOW_BRIGHT + "Bem Vinde a " + Cores.TEXT_PURPLE_BOLD_BRIGHT
					+ "GenPet" + Cores.TEXT_RESET + "!        *");
			System.out.println("  *                                 *");
			System.out.println("   *-------*-------*-------*-------*");
			System.out.println("                                       ");
			System.out.println("  *--------*--------*--------*-------*");
			System.out.println("|                                      |");
			System.out.println(
					"*    1 - " + Cores.TEXT_YELLOW_BRIGHT + "Cadastrar Novo Pet        " + Cores.TEXT_RESET + "    *");
			System.out.println(
					"*    2 - " + Cores.TEXT_YELLOW_BRIGHT + "Listar Todos os Cadastros" + Cores.TEXT_RESET + "     *");
			System.out.println(
					"*    3 - " + Cores.TEXT_YELLOW_BRIGHT + "Buscar Cadastro" + Cores.TEXT_RESET + "               *");
			System.out.println(
					"*    4 - " + Cores.TEXT_YELLOW_BRIGHT + "Atualizar Cadastro" + Cores.TEXT_RESET + "            *");
			System.out.println(
					"*    5 - " + Cores.TEXT_YELLOW_BRIGHT + "Remover Cadastro" + Cores.TEXT_RESET + "              *");
			System.out.println(
					"*    6 - " + Cores.TEXT_YELLOW_BRIGHT + "Agendar Consulta" + Cores.TEXT_RESET + "              *");
			System.out.println(
					"*    7 - " + Cores.TEXT_YELLOW_BRIGHT + "Agendar Vacinas" + Cores.TEXT_RESET + "               *");
			System.out.println(
					"*    8 - " + Cores.TEXT_YELLOW_BRIGHT + "Agendar Banho e Tosa" + Cores.TEXT_RESET + "          *");
			System.out.println(
					"*    9 - " + Cores.TEXT_YELLOW_BRIGHT + "Agendar Castração" + Cores.TEXT_RESET + "             *");
			System.out.println(
					"*    10 - " + Cores.TEXT_YELLOW_BRIGHT + "Visualizar Cadastro      " + Cores.TEXT_RESET + "    *");
			System.out.println(
					"*    11 - " + Cores.TEXT_YELLOW_BRIGHT + "Finalizar Cadastro       " + Cores.TEXT_RESET + "    *");

			
			
			System.out.println("*    12 - " + Cores.TEXT_RED_BOLD_BRIGHT + "Sair" + Cores.TEXT_RESET
					+ "                         *");
			
			System.out.println("|                                      |");
			System.out.println("  *--------*--------*--------*-------*");
			System.out.println("                                       ");
			System.out.print("Digite o número da opção desejada: ");
			try {
				exibicao = ler.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Erro: O valor digitado não é um número inteiro válido. \nDigite um número válido.");
				ler.nextLine(); // Limpa o buffer do scanner após o erro
				continue; // Volta ao início do loop
			}

			/*if (exibicao == 10) {
				System.out.println("\nObrigado pela confiança. Volte sempre!");
				ler.close();
				System.exit(0);
			}*/

			switch (exibicao) { 
			case 1:
				ficha.cadastroEmAndamento();
				ficha.cadastrar();
				ficha.cadastrarGato();
				ficha.cadastrarCachorro();
				KeyPress(); 
				break;
			case 2:
				ficha.listarPets();
				KeyPress(); 
				break;
			case 3:
					ficha.buscarAnimal();
					/*}catch(NullPointerException e)
					{
						System.out.println("\n  *--------*--------*--------*-------*");
						System.out.println("            Cadastro pendente         ");
						System.out.println("  *--------*--------*--------*-------*");
					}*/
					KeyPress();
					break;
			case 4:
				ficha.atualizarCadastro();
				KeyPress(); 
				break;
			case 5:
				ficha.removerCadastro();
				KeyPress(); 
				break;
			case 6:
				try{
				ficha.consulta();
				}catch(NullPointerException e)
				{
					System.out.println("\n  *--------*--------*--------*-------*");
					System.out.println("            Cadastro pendente         ");
					System.out.println("  *--------*--------*--------*-------*");
				}
				KeyPress();
				break;
			case 7:
				try {
				ficha.vacinarGato();
				ficha.vacinarCachorro();
				}catch(NullPointerException e)
				{
					System.out.println("\n  *--------*--------*--------*-------*");
					System.out.println("            Cadastro pendente         ");
					System.out.println("  *--------*--------*--------*-------*");
				}
				KeyPress();
				break;
			case 8:
				try {
				ficha.banhoGato();
				ficha.banhoCachorro();
				ficha.tosaGato();
				ficha.tosaCachorro();
				}catch(NullPointerException e)
				{
					System.out.println("\n  *--------*--------*--------*-------*");
					System.out.println("            Cadastro pendente         ");
					System.out.println("  *--------*--------*--------*-------*");
				}
				KeyPress();
				break;
			case 9:
				try {
				ficha.castrarGato();
				ficha.castrarCachorro();
				}catch(NullPointerException e)
				{
					System.out.println("\n  *--------*--------*--------*-------*");
					System.out.println("            Cadastro pendente         ");
					System.out.println("  *--------*--------*--------*-------*");
				}
				KeyPress();
				break;
			case 10:
				try {
					ficha.printCadastroGato();
					ficha.printCadastroCachorro();
					}catch(NullPointerException e)
					{
						System.out.println("\n  *--------*--------*--------*-------*");
						System.out.println("            Cadastro pendente         ");
						System.out.println("  *--------*--------*--------*-------*");
					}
					KeyPress();
					break;
				
			case 11: 
					ficha.saidaAnimal();
					KeyPress();
					break;
			case 12:
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("           ExpedienteFinalizado      ");
				System.out.println("  *--------*--------*--------*-------*");
				
				System.out.println("\n\n      /^--^\\     /^--^\\     /^--^\\");
				System.out.println("      \\____/     \\____/     \\____/");
				System.out.println("      /    \\     /    \\     /    \\");
				System.out.println("     |      |   |      |   |      |");
				System.out.println("     \\__  __/   \\__  __/   \\__  __/");
				System.out.println("|^|^|^|^\\ \\^|^|^|^/ /^|^|^|^|^\\ \\^|^|^|^|");
				System.out.println("| | | | |\\ \\| | |/ /| | | | | |\\ \\| | | |");
				System.out.println("#########/ /#####\\ \\###########/ /#######");
				System.out.println(" | | | | \\/| | | |\\/| | | | | |\\/ | | | |");
				System.out.println("|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|");
				exibir = false;
				break;
			default:
				System.out.println("Opção Inválida. Tente Novamente.");
				KeyPress(); 
				break;
			}
		}
	}
	
	public static void KeyPress() 
	{
        try 
        {
            System.out.println("\nPressione Enter para Continuar ...");
            System.in.read();
        } catch (IOException e) {
            System.out.println("Você pressionou uma tecla diferente de enter!");
        }
    }
}
