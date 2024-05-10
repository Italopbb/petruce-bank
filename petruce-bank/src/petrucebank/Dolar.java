package petrucebank;

import java.util.Date;

//Classe concreta Dolar, que representa a moeda Dólar Americano
public class Dolar extends Moeda{
	
	
	public Dolar(int idTransacao, double valorDolar, Date dataHoraTransacao) { 
		this.idTransacao = idTransacao;
        this.valorMoeda = valorDolar;
        this.dataHoraTransacao = dataHoraTransacao;
	}
	
	public Dolar() {
	// Este construtor vazio pode ser útil em determinadas situações
	}
	@Override
	public void infoDeposito() {
		
		System.out.printf("%d | + US$%-15.2f        | %s\n", idTransacao, valorMoeda, formatarDataHora(dataHoraTransacao));
	}
	@Override
	public void infoSaque() {
		System.out.printf("%d | - US$%-15.2f        | %s\n", idTransacao, valorMoeda, formatarDataHora(dataHoraTransacao));

	}
}
