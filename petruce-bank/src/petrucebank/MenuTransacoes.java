package petrucebank;
import java.util.Scanner;


public class MenuTransacoes {
	private Transacoes cofrinhoMenu;
	private Scanner escolha; // Declaração da variável escolha do tipo Scanner, para entrada do usuário
	
	

	public MenuTransacoes(){ // Declaração do construtor da classe MenuCofrinho
		escolha = new Scanner(System.in);
		cofrinhoMenu = new Transacoes(); // Inicializa um objeto da classe Cofrinho
	}
	
	public void exibirMenu(){ // Declaração do método exibirMenu(), responsável por mostrar o menu de serviços e receber a escolha do usuário
				System.out.println(" __________________________________");
				System.out.println("|PETRUCE BANK                      |");
				System.out.println("|Menu de Serviços                  |");
			    System.out.println("|1 - Deposito                      |");
			    System.out.println("|2 - Saque                         |");
			    System.out.println("|3 - Historico de Transações       |");
			    System.out.println("|4 - Total Convertido para BRL     |");
			    System.out.println("|5 - Sair                          |");
				System.out.println("|__________________________________|");
			    System.out.print("Opção: ");
				String escolhaMenu = escolha.next();
			
				
				switch(escolhaMenu) {  // Inicia uma estrutura de controle switch para tratar a escolha do usuário do menu
				case "1": 
					cofrinhoMenu.adicionarMoedas();
					exibirMenu();
					break;
					
				case"2": // Caso o usuário escolha remover uma moeda
					
					cofrinhoMenu.removerMoeda();
					exibirMenu();
					break;
					
				case"3": // Caso o usuário escolha listar as moedas
					cofrinhoMenu.mostrarTransacoes();
					exibirMenu();
					break;
					
				case"4":// Caso o usuário escolha verificar o total convertido
					cofrinhoMenu.totalConvertido();
					exibirMenu();
					break;
					
				case "5": // Caso o usuário escolha sair do menu
					System.out.println("Saindo do menu de serviços...");
					break;
				default:
					System.out.println("Opção invalida!!");
					exibirMenu(); // Chama recursivamente o método exibirMenu() para mostrar novamente o menu e permitir ao usuário fazer uma nova escolha como em todas outras opções acima
					break;
				
				}
		
	}

}
