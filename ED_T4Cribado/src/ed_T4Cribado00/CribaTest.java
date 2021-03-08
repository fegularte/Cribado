package ed_T4Cribado00;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CribaTest {
	
	private Criba pruebaTrue1= new Criba(10);
	private Criba pruebaTrue2= new Criba(22);
	private Criba pruebaFalse1= new Criba(0);
	private Criba pruebaFalse2= new Criba(1);
	
	@Test
	void test() {
		assertTrue(pruebaTrue1.inicio());
		assertTrue(pruebaTrue2.inicio());
		assertFalse(pruebaFalse1.inicio());
		assertFalse(pruebaFalse2.inicio());
	}

}
