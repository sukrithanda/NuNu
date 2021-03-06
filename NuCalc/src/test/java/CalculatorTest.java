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
	
	@Test
	public void testvalidinputs(){
		
		ArrayList<Markups> m = new ArrayList<Markups>();
		m.add(Markups.ELECTRONIC);
		m.add(Markups.PHARMA);
		m.add(Markups.FOOD);
		m.add(Markups.ELSE);
		
		Calculator valid1 = new Calculator(0,0,m);
		assertNotNull(valid1);
		Calculator valid2 = new Calculator(100.4,7,m);
		assertNotNull(valid2);

	}
	
	@Test
	public void testzeroadditionalmarkup(){
		
		assertEquals(1329.3, testcalc.CalculateMarkup(),0);
		
		ArrayList<Markups> m = new ArrayList<Markups>();
		m.add(Markups.ELSE);
		
		Calculator testcalc2 = new Calculator(1266,0,m);
		assertEquals(1329.3, testcalc2.CalculateMarkup(),0);
		
		Calculator testcalc3 = new Calculator(12456.95,4,m);
		assertEquals(13707.63, testcalc3.CalculateMarkup(),0);
	}
	
	@Test
	public void testfoodonly(){
		ArrayList<Markups> m = new ArrayList<Markups>();
		m.add(Markups.FOOD);
		m.add(Markups.ELSE);
		
		Calculator food1 = new Calculator(1299.99,3,m);
		assertEquals(1591.58, food1.CalculateMarkup(),0);
		
		m.remove(1);
		
		Calculator food2 = new Calculator(1299.99,3,m);
		assertEquals(1591.58, food2.CalculateMarkup(),0);

	}
	
	@Test
	public void testpharmaonly(){
		ArrayList<Markups> m = new ArrayList<Markups>();
		m.add(Markups.PHARMA);
		m.add(Markups.ELSE);
		
		Calculator food1 = new Calculator(5432.00,1,m);
		assertEquals(6199.81, food1.CalculateMarkup(),0);
		
		m.remove(1);
		
		Calculator food2 = new Calculator(5432.00,1,m);
		assertEquals(6199.81, food2.CalculateMarkup(),0);

	}
	
	@Test
	public void testelectroniconly(){
		ArrayList<Markups> m = new ArrayList<Markups>();
		m.add(Markups.ELECTRONIC);
		m.add(Markups.ELSE);
		
		Calculator elec1 = new Calculator(399.99,11,m);
		assertEquals(483.83, elec1.CalculateMarkup(),0);
		
		m.remove(1);
		
		Calculator elec2 = new Calculator(399.99,11,m);
		assertEquals(483.83, elec2.CalculateMarkup(),0);

	}
	
	


}
