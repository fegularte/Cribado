package ed_T4Cribado00;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CribaTest {
	
	private Criba pruebaTrue1= new Criba(10);
	private Criba pruebaTrue2= new Criba(22);
	private Criba pruebaTrue3= new Criba(5);
	private boolean sobre5[] = {false, true, true, true, false, true};
	private Criba pruebaFalse1= new Criba(0);
	private Criba pruebaFalse2= new Criba(1);
	
	@Test
	void test() {
		//test sobre inicio()
		assertTrue(pruebaTrue1.inicio());
		assertTrue(pruebaTrue2.inicio());
		assertTrue(pruebaTrue3.inicio());
		assertFalse(pruebaFalse1.inicio());
		assertFalse(pruebaFalse2.inicio());
		//test sobre generarPrimos()
		//assert(sobre5.length == pruebaTrue3.generarPrimos().length);
		//test sobre getNumEncuentros()
		assert(pruebaTrue1.getNumEncuentros()) == 5;
		assert(pruebaTrue2.getNumEncuentros()) == 9;
		assert(pruebaTrue2.getNumEncuentros()) != 0;
		assert(pruebaTrue1.getNumEncuentros()) != 3;
		assert(pruebaTrue3.getNumEncuentros()) == 4;
		assert(pruebaFalse1.getNumEncuentros()) == 0;
		assert(pruebaFalse2.getNumEncuentros()) == 0;
		//test sobre getPrimos()
		assertTrue(pruebaTrue1.getPrimos());
		assertTrue(pruebaTrue2.getPrimos());
		assertTrue(pruebaTrue3.getPrimos());
		assertFalse(pruebaFalse1.getPrimos());
		assertFalse(pruebaFalse2.getPrimos());
	}

}
