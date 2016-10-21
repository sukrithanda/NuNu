/**
 * 
 */
package estimate;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

import constants.Markups;

/**
 * @author Sukrit Handa
 *
 */
public class Calculator {
	
	private double base;
	private int workers;
	private ArrayList<Markups> markups;
	
	/*
	 * Calculator Constructor that sets the intial Base vale
	 */
	public Calculator(double base, int workers, ArrayList<Markups> markups){
		
		this.base = base;
		this.workers = workers;
		this.markups = markups;
		
		if(this.base < 0){
			throw new IllegalArgumentException("The base price should not be negative");
		}
		if(this.workers < 0){
			throw new IllegalArgumentException("the number of workers cannot be negative");
		}

	}
	
	
}
