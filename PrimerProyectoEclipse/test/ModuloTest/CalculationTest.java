package ModuloTest;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import Modulo.Calculation;

public class CalculationTest {
	
	@Test
	public void testFindMaxConvencional() {
		assertEquals(12,Calculation.findMax(new int[]{-10,-5,0,1,-2,12,5}));
	}
	
	
	@Test
	public void testFindMaxOrdenados() {
		assertEquals(7,Calculation.findMax(new int[]{-10,-5,0,3,7}));
		assertEquals(7,Calculation.findMax(new int[]{7,3,0,-5,-10}));
	}
	
	
	@Test
	public void testFindMaxRepetido() {
		assertEquals(9,Calculation.findMax(new int[]{9,9,9,9,9,9}));
	}
	
	
}
