import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class PrimeSimulator {

	public static void main (String[] args)
	{
		new PrimeSimulator();
	}
	PrimeSimulator()
	{
		this.loop();
	}
	public void loop()
	{
		
		
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Insert the highest number of the prime calculation");
		
		try
		{
			int maxNumber = scanner.nextInt();
			
				
		
			System.out.println("Insert the Numbers of threads");
			
			
			int maxThreads = scanner.nextInt();
			if(maxThreads <= 0 || maxNumber <= 0)
			{
				System.out.println("Number is too small");
				this.loop();
			}
			else
			{
				ArrayList<Long> primes = new ArrayList<Long>();
				
				PrimeThreadSheduler sheduler = new PrimeThreadSheduler(maxThreads);
				sheduler.start();
				
				
				for(int i = 0; i < maxNumber; i++)
				{
					if(MathUtils.isPrime(i))
						primes.add((long)i);
					
				}
				
				sheduler.stopThreads();
				System.out.println(sheduler.getHighestPrimes());
			}
		}
		catch(InputMismatchException e)
		{
			System.out.println("Wrong Input");
			this.loop();
		}
		
	}
}
