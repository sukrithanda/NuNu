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
	/*
	 *  this function will calculate the markup
	 */
	
	public double CalculateMarkup(){

		double totalprice = 0;
		
		double basetotal = this.base + basemarkup(); 
		
		totalprice = basetotal + addedmarkup(basetotal);
		
		return totalprice;
	}


	/*
	 * this function will calculate the current base markup
	 */
	private double basemarkup() {
		
		return this.base * Markups.BASE.getValue();
	}

	/*
	 * This function will calculate the additional markup on top of the base markup
	 */
	private double addedmarkup(double basetotal) {
		
		double workerm = basetotal * this.workers * Markups.WORKER.getValue();
		
		double extram = 0;
		
		for (Markups extra: this.markups){
			
			extram += basetotal * extra.getValue();
		}
		return workerm + extram ;
	}
	
	
}
