
public class PrimeThreadSheduler extends Thread{

	private int maxThreads;
	private PrimeThread threads[];
	PrimeThreadSheduler(int maxThreads)
	{
		this.maxThreads = maxThreads;
		threads = new PrimeThread[maxThreads];
		for(int i = 0; i < maxThreads; i++)
		{
			threads[i] = new PrimeThread(i);
		}
	}
	
	public void run()
	{
		for(int i = 0; i < maxThreads; i++)
		{
			threads[i].start();
		}
		for(;;)
		{
			this.displayThreadStates();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	public String getHighestPrimes()
	{
		String s="";
		for(int i = 0; i < maxThreads; i++)
			
		{
			s += "Highest prime thread " +i+ ":" +threads[i].getHighestPrime()+"\n";
		}
		return s;
	}
	
	public void stopThreads()
	{
		for(int i = 0; i < maxThreads; i++)
		{
			threads[i].stop();
		}
		this.stop();
		
	}
	public void displayThreadStates()
	{
		for(int i = 0; i < maxThreads;i++)
		{
			System.out.println("Thread "+i+" state: "+threads[i].getState()+" last found prime:"+threads[i].getHighestPrime());
		}
		System.out.println("\n\n");
	}
}
