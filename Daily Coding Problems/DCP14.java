import java.util.Random;

/*
 * Daily Coding Problem #14
 * Source: dailycodingproblem.com (Problem), https://ocw.mit.edu (Monte Carlo)
 * Author: Cole Thomson
 * Date: 10/02/2019
 * TTS: 60
 */

// The area of a circle is defined as πr^2. Estimate π to 3 decimal places 
// using a Monte Carlo method.

// Hint: The basic equation of a circle is x^2 + y^2 = r^2.

/**
 * Class contains a Monte Carlo Simulation to determine the value of pie to
 * a specified precision. The value of pie is determined by the following: 
 * 1) Number in unit circle piece inside Quadrant 1 (0<=r<=1)
 *    as a ratio of the total points inside the unit square 
 *    [Number in Circle] / [Number in square] = (pi*r^2*.25) / r^2
 * 2) pi = 4 * [Number in Circle] / [Number in Square]
 * Random coordinates are generated, if they land inside the circle, then
 * the estimate of pie is updated given the new ratio of points in the
 * circle divided by the number of points in the square. If the estimate
 * value of pi is within 3 decimals (or other level of precision) of the
 * known value of pie the simulation finishes and prints final results.
 * @author Cole Thomson
 *
 */
public class DCP14 {

	/**
	 * Runs Monte Carlo Simulation to estimate the value of pi.
	 * @param args - unused
	 */
	public static void main(String[] args) {
		// Run Monte Carlo Simulation
		System.out.println(monteCarloPi());
	}
	
	/**
	 * Monte Carlo simulation of pi estimate. While acceptable estimate
	 * note found, place another point in unit square, if point
	 * also lies in the first quadrant of the unit circle, then the 
	 * estimate of pi is updated to the following expression:
	 * 4*[Number in Circle] / [Number in Square]
	 * Status is printed every 10,000 estimates so user can track progress
	 * in console. Once pi estimate is acceptable (within magnitude of epsilon),
	 * then simulation terminates and estimate is returned.
	 * @return piEst - estimate of pie to the desired precision
	 */
	public static double monteCarloPi() {
		Random randX = new Random();	// random x coord [0,1)
		Random randY = new Random();	// random y coord [0,1)
		double piEst = 0.0;				// current estimation of pi
		int inCircle = 0;				// number of rand points in unit circle
		int i = 0;						// number of points placed in unit sq.
		double epsilon = 0.000000001; 	// level of precision desired on est.
		
		// While our estimate of Pi is greater than 1/10000 different than Pi
		while(Math.abs(Math.PI -  piEst) > epsilon) {
			i++;
			// Generate random location in unit square and check if it lies 
			// withen quarter circle inscribed in quarter square.
			if(Math.sqrt(Math.pow(randX.nextDouble(),2)
					+ Math.pow(randY.nextDouble(),2)) <= 1) {
				inCircle++;
				piEst = 4*((double)inCircle/i);
				
				// every 10,000 estimates, print status
				if(i%10000 == 0) {
					System.out.println(i + " Guesses. Pi Est: " + piEst);
				}
			}
		}
		System.out.println("DONE - " + i + " Guesses. Pi Est: " + piEst);
		return piEst;
	}

}
