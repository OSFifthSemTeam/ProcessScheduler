import java.io.File;



public class Main
{
	public static void main(String args[])
	{
		boolean debug=true;
		
		File sysconfigfile = new File("Z:\\OS assignment progs\\Assignment 2\\Sample inputs\\simulator_config");
		File jobfile = new File ("Z:\\OS assignment progs\\Assignment 2\\Sample inputs\\sample1\\test1.job");
		String Modelfilepath = ("/Z:\\OS assignment progs\\Assignment 2\\Sample inputs\\sample1\\");
		
		/* Call 
		ConfigInput
		ReadJobs
		ReadModelFiles */
		
		if (debug)
		{
			System.out.println("Starts here...");
			System.out.println("---------------------------------");
		}
		//ConfigInput newconf = new ConfigInput();
		ConfigInput.readSysConfig(sysconfigfile);
		ReadJobs.readJobFile(jobfile);
		if (debug)
			System.out.println("---------------------------------");
		ReadModelFiles.ReadModels(Modelfilepath);
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
		while (SystemConfig.total_jobs_submitted>PCB.numDone)
		{
			System.out.println("CURRENT TIME - " + current_time);
			InputTable.checkfornewprocess(current_time);
			Ready.update(SystemConfig.PSG);
			IOQueues.update(SystemConfig.PSG);
			MemQueue.update();
			current_time+=SystemConfig.PSG;
			PCB.removeDoneProcesses();	
				if(OutputTable.getCurrentSize()>0)
				{
					Integer next_output_time = OutputTable.getNextOutputTime();
					if((int)next_output_time<=current_time)
					{
						System.out.println("Printing Process Table");
						PCB.printProcessTable();
						OutputTable.removeFirstEntry();
					}
				}
		}
		System.out.println("---------------------\nSimulation Complete\n------------------------");
		PsLogger.printMethod("----------------\nSimulation Ended\n-----------------------");
		PsLogger.printMethod(""+current_time);
	}
}
