package br.com.estacione.modelo;

import static org.junit.Assert.*;


import java.time.LocalDateTime;



import org.junit.Test;

public class ValoresHoraTest {

	
	@Test
	public void testaCalculaValorASerPagoDeUmDia(){
		ValoresHora vh = new ValoresHora();
		
		assertEquals("125.00",	vh.calculaValorASerPago(vh.getHorario().totalDeHorasEntreData
																	 (LocalDateTime.of(2014, 5, 28, 12, 00),
																	  LocalDateTime.of(2014, 5, 29, 12, 00),
																	  									0L),
																	  					   "10.00", "5.00"));
		
	}
	
	@Test
	public void testaValorDeUmaHora(){
		ValoresHora vh = new ValoresHora();
		assertEquals("10.00",	vh.calculaValorASerPago(vh.getHorario().totalDeHorasEntreData
				 (LocalDateTime.of(2014, 5, 29, 12, 00),
				  LocalDateTime.of(2014, 5, 29, 13, 00),
				  									0L),
				  					   "10.00", "5.00"));
	}
	@Test
	public void testaValorDeUmaHoraComTolerancia(){
		ValoresHora vh = new ValoresHora();
		assertEquals("10.00",	vh.calculaValorASerPago(vh.getHorario().totalDeHorasEntreData
				 (LocalDateTime.of(2014, 5, 29, 12, 00),
				  LocalDateTime.of(2014, 5, 29, 13, 10),
				  									10L), //tolerancia de 10 min.
				  					   "10.00", "5.00"));
	
}
	
	
}
