package cadastro;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import cadastro.menu.MenuMetodos;
import util.Cores;

public class MenuPet {

	public static void main(String[] args) {

		boolean exibir = true;
		int exibicao = 0;
		Scanner ler = new Scanner(System.in);
		MenuMetodos ficha = new MenuMetodos();

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
					"*    6 - " + Cores.TEXT_YELLOW_BRIGHT + "Consulta        " + Cores.TEXT_RESET + "              *");
			System.out.println(
					"*    7 - " + Cores.TEXT_YELLOW_BRIGHT + "Vacinas        " + Cores.TEXT_RESET + "               *");
			System.out.println(
					"*    8 - " + Cores.TEXT_YELLOW_BRIGHT + "Banho               " + Cores.TEXT_RESET + "          *");
			System.out.println(
					"*    9 - " + Cores.TEXT_YELLOW_BRIGHT + "Tosa                " + Cores.TEXT_RESET + "          *");
			System.out.println(
					"*    10 - " + Cores.TEXT_YELLOW_BRIGHT + "Castração        " + Cores.TEXT_RESET + "            *");
			System.out.println(
					"*    11 - " + Cores.TEXT_YELLOW_BRIGHT + "Visualizar Cadastro      " + Cores.TEXT_RESET + "    *");
			System.out.println(
					"*    12 - " + Cores.TEXT_YELLOW_BRIGHT + "Finalizar Cadastro       " + Cores.TEXT_RESET + "    *");
			System.out.println("*    13 - " + Cores.TEXT_RED_BOLD_BRIGHT + "Sair" + Cores.TEXT_RESET
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
			switch (exibicao) { 
			case 1:
				ficha.cadastrarPets();
				KeyPress(); 
				break;
			case 2:
				ficha.listarPets();
				KeyPress(); 
				break;
			case 3:
					ficha.buscarAnimal();
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
			case 10:
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
			case 11: 
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
			case 12:
				try {
				ficha.saidaAnimal();
				}catch(NullPointerException e)
				{
					System.out.println("\n  *--------*--------*--------*-------*");
					System.out.println("            Cadastro pendente         ");
					System.out.println("  *--------*--------*--------*-------*");					
				}
				KeyPress();
				break;
			case 13:
				if(ficha.sairExpediente()) 
				{
					ficha.mostraCadastroPendenteSaida();
				}else 
				{
					ficha.mostraSaida();
					exibir = false;
				}
				KeyPress();
				break;
			default:
				System.out.println("\n  *--------*--------*--------*-------*");
				System.out.println("              Opção Inválida        ");
				System.out.println("  *--------*--------*--------*-------*");
				KeyPress(); 
				break;
			}
		}
		ler.close();
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
