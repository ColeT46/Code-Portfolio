import java.util.Random;
/*
 * Daily Coding Problem #14
 * Source: dailycodingproblem.com (Problem), https://ocw.mit.edu (Monte Carlo),
 * 		   https://www.youtube.com/watch?v=HDhxhywAuJM (Multi-Threading)
 * Author: Cole Thomson
 * Date: 10/02/2019
 * TTS: 180
 */

// The area of a circle is defined as πr^2. Estimate π to 3 decimal places 
// using a Monte Carlo method. (using multi-thread processing)

// Hint: The basic equation of a circle is x^2 + y^2 = r^2.

/**
 * Class is an extention of the DCP14.java class except it uses Mutli-thread
 * processing to run multiple Monte Carlo Simulations simultaneously. This is
 * my first experience with Multi-thread programming and has been interesting 
 * to see how the number of iterations required tends to decrease on average
 * as the number of threads used to process increases. There are no 
 * Synchronization issues with this program since no simulations need to access
 * the same data (all data is generated randomly).
 * simulations are 
 * @author Cole Thomson
 *
 */
public class DCP14MultiThread {
	private static final int NUM_THREADS = 16; // number of threads to use
	
	/**
	 * Control instantiation of Tasks (Threads) that run Monte Carlo 
	 * Simulations to estimate value of pi.
	 * @param args - unused
	 */
	public static void main(String[] args) {
		
		// Run the Monte-Carlo Simulation on the number of threads desired
		switch (NUM_THREADS) {
		case 1:
			Thread t1 = new Thread(new Task("Thread-1"));
			t1.start();
			break;
		case 4:
			Thread t2 = new Thread(new Task("Thread-2"));
			t2.start();
			
			Thread t3 = new Thread(new Task("Thread-3"));
			t3.start();
			
			Thread t4 = new Thread(new Task("Thread-4"));
			t4.start();
			break;
		case 8:
			Thread t5 = new Thread(new Task("Thread-5"));
			t5.start();
			
			Thread t6 = new Thread(new Task("Thread-6"));
			t6.start();
			
			Thread t7 = new Thread(new Task("Thread-7"));
			t7.start();
			
			Thread t8 = new Thread(new Task("Thread-8"));
			t8.start();
			break;
		case 16:
			Thread t9 = new Thread(new Task("Thread-9"));
			t9.start();
			
			Thread t10 = new Thread(new Task("Thread-10"));
			t10.start();
			
			Thread t11 = new Thread(new Task("Thread-11"));
			t11.start();
			
			Thread t12 = new Thread(new Task("Thread-12"));
			t12.start();
			
			Thread t13 = new Thread(new Task("Thread-13"));
			t13.start();
			
			Thread t14 = new Thread(new Task("Thread-14"));
			t14.start();
			
			Thread t15 = new Thread(new Task("Thread-15"));
			t15.start();
			
			Thread t16 = new Thread(new Task("Thread-16"));
			t16.start();
			break;
		default:
			System.out.println("Please use 1,4,8, or 16 Threads by setting "
					+ "NUM_THREADS variable.");
			break;
		}

	}	
}

	/**
	 * Class extends the Thread class and Overrides the run method.
	 * When the run method is invoked by calling the start method on the
	 * Task instance, the Monte Carlo Simulation is ran on that thread until
	 * it determines an estimate of pi to the desired accuracy. If another
	 * thread finishes first, all threads will stop their simulation. The value
	 * of pie is determined by the following: 
	 * 1) Number in unit circle piece inside Quadrant 1 (0<=r<=1)
	 *    as a ratio of the total points inside the unit square 
	 *    [Number in Circle] / [Number in square] = (pi*r^2*.25) / r^2
	 * 2) pi = 4 * [Number in Circle] / [Number in Square]
	 * Random coordinates are generated, if they land inside the circle, then
	 * the estimate of pie is updated given the new ratio of points in the
	 * circle divided by the number of points in the square. If the estimate
	 * value of pi is within 3 decimals (or other level of precision) of the
	 * known value of pie the method finishes and prints final results.
	 * @author Cole Thomson
	 *
	 */
	class Task extends Thread {
		
		private static volatile boolean isDone = false;	// estimate found?
		Random randX = new Random();	// random x coord [0,1)
		Random randY = new Random();	// random y coord [0,1)
		double piEst = 0.0;				// current estimation of pi
		int inCircle = 0;				// number of rand points in unit circle
		int i = 0;						// number of points placed in unit sq.
		double epsilon = 0.000000001; 	// level of precision desired on est.
		String name;					// name given to task
		
		/**
		 * Creates a new instance of the Task object.
		 * @param name - name of the Task instance 
		 */
		public Task(String name) {
			this.name = name;
		}
		
		/**
		 * Method invoked when start method is called on Task instance. Handles
		 * the Monte Carlo simulation. While another thread has not found an
		 * acceptable estimate, place another point in unit square, if point
		 * also lies in the first quadrant of the unit circle, then the 
		 * estimate of pi is updated to the following expression:
		 * 4*[Number in Circle] / [Number in Square]
		 * Status is printed every 10,000 estimates so user can track progress
		 * in console. Once one of the Task threads finds an acceptable
		 * estimate (within magnitude of epsilon), then all Tasks terminate
		 * simulation.
		 */
		@Override
		public void run() {
			Thread.currentThread().setName(this.name);
			// While our estimate of Pi is greater than 1/10000 different than Pi
			while(!isDone) {
				i++;
				// Generate random location in unit square and check if it lies 
				// withen quarter circle inscribed in quarter square.
				if(Math.sqrt(Math.pow(randX.nextDouble(),2)
						+ Math.pow(randY.nextDouble(),2)) <= 1) {
					inCircle++;
					piEst = 4*((double)inCircle/i);
					
					// every 10,000 estimates, print status
					if(i%10000 == 0) {
						System.out.println(i + " Guesses. Pi Est: " + piEst
								+ " - " + Thread.currentThread().getName());
					
					// Sleep thread 50ms so execution can be watched in console
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					}
				}
				
				// If estimate is within magnitude of epsilon, we are done
				if (Math.abs(Math.PI -  piEst) <= epsilon) {
					isDone = true;
					System.out.println(Thread.currentThread().getName()
							+ " - Wins!" );
					System.out.println(i + " Guesses. Pi Est: " + piEst);
					break;
				}
			}
		}
	}