package petrucebank;
import java.util.Date;

//Classe concreta Real, que representa a moeda Real Brasileiro
public class Real extends Moeda { 
	int total_Real;

	public Real(int idTransacao, double valorReal, Date dataHoraTransacao) {
		this.idTransacao = idTransacao;
        this.valorMoeda = valorReal;
        this.dataHoraTransacao = dataHoraTransacao; 
	}
	public Real() {
		// Este construtor vazio pode ser útil em determinadas situações
	}
	
	@Override
    public void infoDeposito() {
		
		System.out.printf("%d | + R$%-15.2f         | %s\n", idTransacao, valorMoeda, formatarDataHora(dataHoraTransacao));
	}
    @Override
	public void infoSaque() {
		System.out.printf("%d | - R$%-15.2f         | %s\n", idTransacao, valorMoeda, formatarDataHora(dataHoraTransacao));

	}
}
