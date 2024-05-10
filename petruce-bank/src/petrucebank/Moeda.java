package petrucebank;
import java.util.Date;
import java.text.SimpleDateFormat;

public abstract class Moeda {
	protected double valorMoeda;  // Atributo para armazenar o valor da moeda
	protected int idTransacao; //atributo para guardar o id de cada transação
	protected Date dataHoraTransacao; 
	
	
	public Moeda() {
		this.dataHoraTransacao = new Date();
	}
	
	public abstract void infoDeposito();	// Método abstrato para exibir informações sobre a moeda
	public abstract void infoSaque();
	
	
	
	protected String formatarDataHora(Date dataHoraTransacao) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return formatter.format(dataHoraTransacao);
	}
}
