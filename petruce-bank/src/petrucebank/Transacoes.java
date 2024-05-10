package petrucebank;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;



public class Transacoes {  // Atributos que mantêm o saldo total e listas de depósitos e saques, além de contadores para cada tipo de moeda.
	private double saldoTotal;
	private ArrayList<Moeda> listaDeDepositos;
	private ArrayList<Moeda> listaDeSaques;
    private float totalDolar;
    private float totalReal;
    private float totalEuro;
    private Scanner escolha1;
    public int idTransacao;
	private double valorTransacao;

	
	public Transacoes() { // Construtor que inicializa as listas de depósitos e saques e outras variáveis necessárias.
		this.listaDeSaques = new ArrayList<>(); 
		this.listaDeDepositos = new ArrayList<>();
		this.escolha1 = new Scanner(System.in);
		this.idTransacao = 100000;
	}
	
	public void adicionarMoedas(){// Método para adicionar moedas ao cofrinho
		
		
		System.out.println(" _________________________________");
		System.out.println("|Escolha uma moeda para o deposito|");
		System.out.println("|1 - Real                         |");
		System.out.println("|2 - Dólar                        |");
		System.out.println("|3 - Euro                         |");
		System.out.println("|4 - voltar                       |");
		System.out.println("|_________________________________|");
		System.out.print  ("Opção: ");
		int escolhaDaMoeda = escolha1.nextInt();
		
		
		switch(escolhaDaMoeda) {
		case 1:
			System.out.print("Escolha o valor: ");
			this.valorTransacao = escolha1.nextDouble();
			Real moedaDeReal = new Real(idTransacao, valorTransacao, new Date());
			System.out.printf("R$%.2f adicionado a sua conta!\n", valorTransacao);
			this.listaDeDepositos.add(moedaDeReal);
			this.idTransacao++;
			this.totalReal += valorTransacao;
			break;
		case 2: 
			System.out.print("Escolha o valor: ");
			this.valorTransacao = escolha1.nextDouble();
			Dolar moedaDeDolar = new Dolar(idTransacao, valorTransacao, new Date());
			System.out.printf("US$%.2f adicionado a sua conta!\n", valorTransacao);
			this.listaDeDepositos.add(moedaDeDolar);
			this.idTransacao++;
			this.totalDolar += valorTransacao;
			break;
		case 3:
			System.out.print("Escolha o valor: ");
			this.valorTransacao = escolha1.nextDouble();
			Euro moedaDeEuro = new Euro(idTransacao, valorTransacao, new Date());
			System.out.printf("€%.2f adicionado a sua conta!\n", valorTransacao);
			this.listaDeDepositos.add(moedaDeEuro);
			this.idTransacao++;
			this.totalEuro += valorTransacao;
			break;
		case 4:
			System.out.println("Voltando pro menu...");
			break;
		default:
			System.out.println("Opção de moeda invalida, nenhum valor foi adicionado!!");
			break;
			}    
	}
	
	public void removerMoeda() {  // Método para remover moedas do cofrinho.
		System.out.println(" ______________________________");
		System.out.println("|Escolha uma moeda para o saque|");
		System.out.println("|1 - Real                      |");
		System.out.println("|2 - Dólar                     |");
		System.out.println("|3 - Euro                      |");
		System.out.println("|4 - voltar                    |");
		System.out.println("|______________________________|");
		System.out.print  ("Opção: ");
		int escolhaDaMoeda = escolha1.nextInt();
		
		
		switch(escolhaDaMoeda) { 
		case 4:
			System.out.println("Voltando pro menu...");
			return;
			
		case 1:
			System.out.print("Escolha o valor: ");
			this.valorTransacao = escolha1.nextDouble();
			if(valorTransacao>totalReal) {
				System.out.println("Valor maior do que o saldo escolha outro valor!");
				return;
			}
			Real moedaDeReal = new Real(idTransacao, valorTransacao, new Date());
			this.listaDeSaques.add(moedaDeReal);
			this.idTransacao++;
			this.totalReal -= valorTransacao;
			System.out.printf("Seu saque de R$%.2f foi processado com sucesso!\n", valorTransacao);
			break;
			
		case 2: 
			System.out.print("Escolha o valor: ");
			this.valorTransacao = escolha1.nextDouble();
			if(valorTransacao>totalDolar) {
				System.out.println("Valor maior do que o saldo escolha outro valor!");
				return;
			}
			Dolar moedaDeDolar = new Dolar(idTransacao, valorTransacao, new Date());
			this.listaDeSaques.add(moedaDeDolar);
			this.idTransacao++;
			this.totalDolar -= valorTransacao;
			System.out.printf("Seu saque de US$%.2f foi processado com sucesso!\n", valorTransacao);
			break;
			
		case 3:
			System.out.print("Escolha o valor: ");
			this.valorTransacao = escolha1.nextDouble();
			if(valorTransacao>totalEuro) {
				System.out.println("Valor maior do que o saldo escolha outro valor!");
				return;
			}
			Euro moedaDeEuro = new Euro(idTransacao, valorTransacao, new Date());
			this.listaDeSaques.add(moedaDeEuro);
			this.idTransacao++;
			this.totalEuro -= valorTransacao;
			System.out.printf("Seu saque de €%.2f foi processado com sucesso!\n", valorTransacao);
			break;
			
		default:
			System.out.println("Opção de moeda invalida, nenhum valor foi adicionado!!");
			break;
			}
	}
    
	public void mostrarTransacoes() {  // Método para exibir o histórico de transações.
		if(this.listaDeSaques.isEmpty() && this.listaDeDepositos.isEmpty()) { 
			System.out.println("Sem transações para serem visualizadas!"); 
			return;
		}
		System.out.println("Seu histórico de transações! ");
		System.out.println("_______________________________________________");
		System.out.println("Histórico de depositos       ");
		System.out.println("_______________________________________________");
		System.out.println("     id|       Valor                 | Data/Hora");
		for (Moeda moeda1 : this.listaDeDepositos) {
			moeda1.infoDeposito(); 
		}
		System.out.println("_______________________________________________");
		System.out.println("_______________________________________________");
		System.out.println("Histórico de saques          ");
		System.out.println("_______________________________________________");
		System.out.println("     id|       Valor                 | Data/Hora");
		for (Moeda moeda1 : this.listaDeSaques) {
			moeda1.infoSaque(); 
		}
	}
	
	public void totalConvertido() {   // Método para calcular e exibir o total convertido em Real.
		this.saldoTotal = (totalDolar*5.12)+(totalEuro*5.46)+(totalReal); 
		System.out.printf("Total convertido: R$%.2f\n", saldoTotal);
		
	}
	

}