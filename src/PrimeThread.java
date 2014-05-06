import java.util.ArrayList;


public class PrimeThread extends Thread{
	private  ArrayList<Long> primes;
	private long currentNumber;
	private int threadNumber;
	private boolean isRunning = true;
	PrimeThread(int threadNumber)
	{
		this.threadNumber = threadNumber;
		primes = new ArrayList<Long>();
		currentNumber = 0;
	}
	public void suspendThread()
	{
		isRunning = false;
	}
	public void run()
	{
		for(;isRunning;currentNumber++)
		{
			if(isPrime(currentNumber))
			{
				//System.out.println("Thread "+threadNumber+ " found prime "+currentNumber);
				primes.add(currentNumber);
			}
			try {
				
				//Thread.sleep((long) (Math.random() * 11));
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	public Long getHighestPrime()
	{
		if(primes.size() > 0)
			return primes.get(primes.size()-1);
		return 0L;
	}
	private static boolean isPrime(long no) {
		if (no < 2) return false;
		for (long i = 2; i < no; i++)
		if (no % i == 0) return false;
		return true;
	}
	
	
}
