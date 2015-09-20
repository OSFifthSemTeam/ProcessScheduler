

public class Main
{
	public static void main(String args[])
	{
		boolean debug=true;
		/* Call 
		ConfigInput
		ReadJobs
		ReadModelFiles */
		if (debug)
		{
			System.out.println("Starts here...");
			System.out.println("---------------------------------");
		}
		ConfigInput newconf = new ConfigInput();
		newconf.readSysConfig();
		ReadJobs.readJobFile();
		if (debug)
			System.out.println("---------------------------------");
		ReadModelFiles.ReadModels();
		if (debug)
		{
			System.out.println("---------------------------------");
			System.out.println("max proc = " + SystemConfig.max_proc);
			System.out.println("PSG = " + SystemConfig.PSG);
			System.out.println("numIO = " + SystemConfig.numIO);
			System.out.println("memory = " + SystemConfig.memory);
			System.out.println("---------------------------------");
			InputTable.display();
		}
		int current_time=0;
		while (PCB.numDone<2)
		{
			System.out.println("CURRENT TIME - " + current_time);
			InputTable.checkfornewprocess(current_time);
			Ready.update(SystemConfig.PSG);
			IOQueues.update(SystemConfig.PSG);
			MemQueue.update();	
			current_time+=SystemConfig.PSG;
			PCB.removeDoneProcesses();
		}
	}
}
