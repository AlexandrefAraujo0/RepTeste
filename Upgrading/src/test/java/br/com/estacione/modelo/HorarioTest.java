package br.com.estacione.modelo;

import java.time.LocalDateTime;
import static org.junit.Assert.*;
import org.junit.Test;

public class HorarioTest {

	
	@Test
	public void testaPegaHoraAtualFormatoTexto(){
		Horario h = new Horario();
		
		assertEquals(h.retornaDataEmFormatoTexto(LocalDateTime.now()), h.retornaDataEmFormatoTexto(h.pegaDataHora()));
	}
	
	@Test
	public void testaCalculoDe2DiasSemTolerancia(){
		Horario h = new Horario();
		LocalDateTime t1 = LocalDateTime.of(2014, 5, 27, 13, 00);
		LocalDateTime t2 = LocalDateTime.of(2014, 5, 29, 13, 00);

		assertEquals(48L, h.totalDeHorasEntreData(t1, t2,0L));	
	}

	@Test
	public void testaCalculoDe2DiasComTolerancia(){
		Horario h = new Horario();
		LocalDateTime t1 = LocalDateTime.of(2014, 5, 27, 13, 00);
		LocalDateTime t2 = LocalDateTime.of(2014, 5, 29, 13, 10);

		assertEquals(48L, h.totalDeHorasEntreData(t1, t2,10L));	
	}
	
	@Test
	public void testaTolerancia(){
		Horario h = new Horario();
		LocalDateTime t1 = LocalDateTime.of(2014, 5, 27, 13, 00);
		LocalDateTime t2 = LocalDateTime.of(2014, 5, 27, 13, 25);

		assertEquals(0L, h.totalDeHorasEntreData(t1, t2,25L));	
		
	}
	
	@Test(expected=java.time.DateTimeException.class)
	public void testaDataInvalida(){
		 LocalDateTime.of(2014, 5, 32, 13, 00); // 32/05/2014 as 13:00
	}
	
	@Test(expected=java.time.DateTimeException.class)
	public void testaDataSaidaMenorQueDataEntrada(){
	
		Horario h = new Horario();
		LocalDateTime t1 = LocalDateTime.of(2014, 5, 29, 13, 1);
		LocalDateTime t2 = LocalDateTime.of(2014, 5, 29, 13, 00);

		h.totalDeHorasEntreData(t1, t2,0L);
	}
}
