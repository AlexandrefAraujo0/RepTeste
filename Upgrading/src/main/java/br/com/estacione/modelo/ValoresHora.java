package br.com.estacione.modelo;

import java.math.BigDecimal;
import java.math.RoundingMode;
/**
 * Classe responsável por reter os valores de hora e definição de valor a ser pago.
 * @author Alexandre F
 *
 */
public class ValoresHora {
	
	private BigDecimal valorPrimeiraHora , valorDemaisHoras;
	private Horario horario = new Horario();
	
	
	/**
	 * Metodo Responsavel por calcular o valor de servico.
	 *  Recebe o metodo totaldeHorasEntreData da classe Horario junto com os valores de horarios para calculo.
	 * @param totalHoras
	 * @param valorPrimeiraHora
	 * @param valorDemaisHoras
	 * @return - String, valor do servico.
	 */
	public String calculaValorASerPago(long totalHoras, String  valorPrimeiraHora, String valorDemaisHoras){
			
			BigDecimal numeroHoras= new BigDecimal(totalHoras);
			this.valorDemaisHoras = new BigDecimal(valorDemaisHoras);
			this.valorPrimeiraHora = new BigDecimal(valorPrimeiraHora)	;
			BigDecimal valorASerPago;
	
	if(numeroHoras.equals(new BigDecimal(1L))){
	valorASerPago = new BigDecimal(valorPrimeiraHora);
	}else{ // numero de horas - 1  * valor das demais horas + primeira hora
	valorASerPago = ((numeroHoras.subtract(new BigDecimal("1")).multiply(this.valorDemaisHoras)).add(this.valorPrimeiraHora))
					.setScale(2,RoundingMode.HALF_UP);
	}
	return valorASerPago.toString();
	}
	
	
	
	public BigDecimal getValorPrimeiraHora() {
		return valorPrimeiraHora;
	}

	public void setValorPrimeiraHora(BigDecimal valorPrimeiraHora) {
		this.valorPrimeiraHora = valorPrimeiraHora;
	}

	public BigDecimal getValorDemaisHoras() {
		return valorDemaisHoras;
	}

	public void setValorDemaisHoras(BigDecimal valorDemaisHoras) {
		this.valorDemaisHoras = valorDemaisHoras;
	}

	public Horario getHorario() {
		return horario;
	}
	
	
}
