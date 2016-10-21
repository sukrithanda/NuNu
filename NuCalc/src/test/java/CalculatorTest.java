/**
 * 
 */


import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import constants.Markups;
import estimate.Calculator;

/**
 * @author sukrit
 *
 */
public class CalculatorTest {
	

	Calculator testcalc = new Calculator(1266,0, new ArrayList<Markups>());

	@Test
	public void testCreateCalculatorObject() throws Exception {
		
		assertNotNull(testcalc);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testnegativebase(){
		
		Calculator negative = new Calculator(-1, 2, new ArrayList<Markups>());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testnegativeworker(){
		
		Calculator negative = new Calculator(1, -3, new ArrayList<Markups>());
	}


}
