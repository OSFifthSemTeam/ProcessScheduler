public class IOQueues {
	static IOModuleEntry queues[] ;
	static 
	{
		queues = new IOModuleEntry[SystemConfig.numIO+1];
		for (int i=0;i<=SystemConfig.numIO;i++)
		{
			queues[i] = new IOModuleEntry();
		}
	}

	static void addNewProc(Process proc)
	{
		IOSpec curriospec = (IOSpec)proc.specifications.getFirst();
		try 
		{
			queues[curriospec.io_module_num].addNewProcess(proc);
		}
		catch (Exception e)
		{
			System.out.println("the io_module that was accessed " + curriospec.io_module_num);
			e.printStackTrace();
			System.exit(0);
		}
	}
	static void update(int psg)
	{
		for(int i=0;i<queues.length;i++)
		{
			try 
			{
				queues[i].update(psg);

			}
			catch (NullPointerException e)
			{
				System.out.println("Failed in IOQueues update, i is " + i);
				System.exit(0);
			}
		}
	}
}
