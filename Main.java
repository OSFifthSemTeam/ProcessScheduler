

public class Main
{
	public static void main(String args[])
	{
		/* Call 
		ConfigInput
		ReadJobs
		ReadModelFiles */

		int current_time=0;
		while (true)
		{
			InputTable.checkfornewprocess(current_time);
			Ready.update(SystemConfig.psg);
			IOQueues.update(SystemConfig.psg);
			MemQueue.update();	
		}
	}
}
