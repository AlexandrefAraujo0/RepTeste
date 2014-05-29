package br.com.estacione.modelo;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.Test;

public class ValorTest {

	@Test
	public void calculaTrocoComMetodos(){
		Valor v = new Valor();
		
assertEquals(new BigDecimal("5.00"),
		v.calculaTroco(v.getValoresHora().
		calculaValorASerPago(
		v.getValoresHora().getHorario()
		.totalDeHorasEntreData(
		LocalDateTime.of(2014, 5, 28, 13, 00),
		LocalDateTime.of(2014, 5, 28, 15, 00),
									0L),
									"10.00",
									"5.00"),
		"20.00"));
System.out.println(v.toStringTeste());
	}
	
	
	
	
	@Test
	public void calculaTrocoComValoresCorretos() {
		Valor v = new Valor();
			v.calculaTroco("20", "30");
		
		assertEquals(new BigDecimal("10.00"), v.getTroco());
		System.out.println(v);	
	}
	
	@Test
	public void validaEntradaDeValoresAoCalcularTroco(){
		Valor v = new Valor();
		v.calculaTroco("50.506", "60");
		assertEquals(new BigDecimal("50.51"), v.getValorAPagar());
		assertEquals(new BigDecimal("60.00"), v.getValorPago());
		System.out.println(v);	
	
	}

	@Test
	public void validarExatidaoNaSubtracao(){
		Valor v = new Valor();
		v.calculaTroco("0.1", "0.2");
		assertEquals(new BigDecimal("0.10"), v.getValorAPagar());
		assertEquals(new BigDecimal("0.20"), v.getValorPago());
		assertEquals(new BigDecimal("0.10"), v.getTroco());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void naoCalculaTrocoSeValorPagoForMenor(){
		Valor v = new Valor();
		v.calculaTroco("31", "30");
		System.out.println(v);	
	}

	
}
