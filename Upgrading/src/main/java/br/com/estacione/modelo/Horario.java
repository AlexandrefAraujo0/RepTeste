package br.com.estacione.modelo;

import java.math.BigDecimal;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Horario {

	private  LocalDateTime agora;
	private LocalDateTime saida, entrada;
	private long tolerancia;
	
	public LocalDateTime pegaDataHora(){
		this.agora = LocalDateTime.now();
		return agora;
	}
	/**
	 * Metodo responsável por receber duas datas e calcular a quantidade de horas entre elas,
	 *  sendo possivel agregar um valor de tolerancia para abater um determinado intervalo de minutos.
	 * @param dataHoraEntrada - Hora que o cliente entra no estabelecimento.
	 * @param dataHoraSaida   - Hora que o cliente registra a saida.
	 * @param tolerancia	  - Valor em minutos para tolerar atrasos.
	 * @return long - quantidade de horas.
	 */
	public long totalDeHorasEntreData(LocalDateTime dataHoraEntrada ,LocalDateTime dataHoraSaida,Long tolerancia ){
		
Long totalMinutos = dataHoraEntrada.until(dataHoraSaida, ChronoUnit.MINUTES);
	if(totalMinutos < 0L) throw new DateTimeException("A Data/Hora Saida está inferior a Data/Hora Entrada");
Long totalHoras = totalMinutos/60;
	 if( totalMinutos <= tolerancia)	totalHoras =0L;
		else if( totalMinutos < 60L && totalMinutos != tolerancia ) totalHoras =1L;  
		  else if((totalMinutos-tolerancia) % 60L!= 0L)		totalHoras += 1L;
	entrada = dataHoraEntrada;
	saida =dataHoraSaida;
return totalHoras;
	}
	
	public String retornaDataEmFormatoTexto(LocalDateTime dataHora ){
		DateTimeFormatter formatador = 
				  DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
				dataHora.format(formatador);
				return dataHora.format(formatador);
	}

 public String toString(){
	 StringBuilder builder = new StringBuilder();
	 builder.append("	[");
	 builder.append("entrada: ");
	 builder.append(this.retornaDataEmFormatoTexto(entrada));
	 builder.append("\n	 saida: ");
	 builder.append(this.retornaDataEmFormatoTexto(saida));
	 builder.append(" ]");
	 return builder.toString();
 }

public LocalDateTime getSaida() {
	return saida;
}

public void setSaida(LocalDateTime saida) {
	this.saida = saida;
}

public LocalDateTime getEntrada() {
	return entrada;
}

public void setEntrada(LocalDateTime entrada) {
	this.entrada = entrada;
}

public long getTolerancia() {
	return tolerancia;
}

public void setTolerancia(long tolerancia) {
	this.tolerancia = tolerancia;
}


 
 
}
