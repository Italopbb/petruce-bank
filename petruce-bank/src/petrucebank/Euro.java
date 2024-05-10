package petrucebank;

import java.util.Date;

//Classe concreta Euro, que representa a moeda Euro
public class Euro extends Moeda{
	
	public Euro(int idTransacao, double valorEuro, Date dataHoraTransacao) {
		this.idTransacao = idTransacao;
        this.valorMoeda = valorEuro;
        this.dataHoraTransacao = dataHoraTransacao;
	}
	public Euro() {
	// Este construtor vazio pode ser útil em determinadas situações
	}
	@Override
    public void infoDeposito() {
		
		System.out.printf("%d | + €%-15.2f          | %s\n", idTransacao, valorMoeda, formatarDataHora(dataHoraTransacao));
	}
    @Override
	public void infoSaque() {
		System.out.printf("%d | - €%-15.2f          | %s\n", idTransacao, valorMoeda, formatarDataHora(dataHoraTransacao));

	}
}
