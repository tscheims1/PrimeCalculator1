import java.util.ArrayList;
import java.util.Collections;


public class PrimeThreadSheduler extends Thread{

	private int maxThreads;
	private PrimeThread threads[];
	private ArrayList<String> threadNames;
	private boolean isRunning = true;
	PrimeThreadSheduler(int maxThreads)
	{
		this.threadNames = ThreadHelper.getThreadNames(maxThreads);
		Collections.shuffle(this.threadNames );
		
		this.maxThreads = maxThreads;
		threads = new PrimeThread[maxThreads];
		for(int i = 0; i < maxThreads; i++)
		{

			threads[i] = new PrimeThread(i,threadNames.get(i));
		}
	}
	
	public void run()
	{
		for(int i = 0; i < maxThreads; i++)
		{
			threads[i].start();
		}
		for(;isRunning;)
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
			s += "Highest prime thread " +threads[i].getThreadName()+ ":" +threads[i].getHighestPrime()+"\n";
		}
		return s;
	}
	
	public void stopThreads()
	{
		for(int i = 0; i < maxThreads; i++)
		{
			
			//threads[i].suspendThread();
			threads[i].interrupt();
		}
		this.isRunning = false;
		
	}
	public void displayThreadStates()
	{
		for(int i = 0; i < maxThreads;i++)
		{
			System.out.println("Thread "+threads[i].getThreadName()+" state: "+threads[i].getState()+" last found prime:"+threads[i].getHighestPrime());
		}
		System.out.println("\n\n");
	}
}
