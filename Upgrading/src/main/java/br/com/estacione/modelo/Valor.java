package br.com.estacione.modelo;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Valor {

	private BigDecimal valorPago;
	private BigDecimal troco;
	private BigDecimal valorAPagar;
	private ValoresHora valoresHora = new ValoresHora();
	
	/**
	 * Metodo responsável por receber o valor a ser pago pelo parametro valorAPagar e por receber o valor recebido pelo
	 * cliente para efetuar o pagamento, tendo por finalidade devolver o valor troco.
	 * @param valorAPagar - Valor referente ao servico.
	 * @param valorPago   - valor que o cliente ofereceu como pagamento.
	 * @return BigDecimal -  troco do servico.
	 */
	public BigDecimal calculaTroco(String valorAPagar, String valorPago) {
		
this.valorAPagar = new BigDecimal(valorAPagar).setScale(2,RoundingMode.HALF_UP);
this.valorPago = new BigDecimal(valorPago).setScale(2,RoundingMode.HALF_UP);

	if (!this.isValoresOK()) {
		throw new IllegalArgumentException("O valor Pago não equivale ao valor necessario para efetuar o pagamento");
}
this.troco = this.valorPago.subtract(this.valorAPagar).setScale(2,RoundingMode.HALF_UP);

return this.troco;

}

	
	public String toStringTeste(){
		StringBuilder builder = new StringBuilder();
		
		builder.append("[");
		builder.append(" Valor A Pagar: ");
		builder.append(getValorAPagar());
		builder.append(" Valor Pago: ");
		builder.append(getValorPago());
		builder.append("   Troco: ");
		builder.append(getTroco());
		
		builder.append("\n  Valor da 1ª Hora: ");
		builder.append(valoresHora.getValorPrimeiraHora());
		builder.append("  \n  Valor das Demais horas: ");
		builder.append(valoresHora.getValorDemaisHoras());
		builder.append("\n  Horario que o cliente entrou no estacionamento: ");
		builder.append(valoresHora.getHorario().retornaDataEmFormatoTexto(valoresHora.getHorario().getEntrada()));
		builder.append("\n  Horario que o cliente saiu do estacionamento: ");
		builder.append(valoresHora.getHorario().retornaDataEmFormatoTexto(valoresHora.getHorario().getSaida()));
		
		builder.append("\n]\n");
		return builder.toString();
	}
	
	public BigDecimal getValorPago() {
		return valorPago;
	}

	public BigDecimal getTroco() {
		return troco;
	}

	public BigDecimal getValorAPagar() {
		return valorAPagar;
	}
	
	public ValoresHora getValoresHora() {
		return valoresHora;
	}

				private  boolean isValoresOK() {
				return this.valorPago.doubleValue() > this.valorAPagar.doubleValue()
				|| this.valorPago.doubleValue() == this.valorAPagar.doubleValue() ;
				}

				@Override
				public String toString(){
					StringBuilder builder = new StringBuilder();
					
					builder.append("[");
					builder.append(" Valor A Pagar: ");
					builder.append(getValorAPagar());
					builder.append(" Valor Pago: ");
					builder.append(getValorPago());
					builder.append("   Troco: ");
					builder.append(getTroco());
					builder.append(" ]\n");
					
					return builder.toString();
				}
}