
public class Process 
{
	int pid;
	int tableIndex;
	int io_module_num[];
	int io_module_time[];
	int io_module_current_exec; // amount of time it spent in the module
	int mem_req[];
	int state;
	int cpuIndex; // this talks about which index of mem_req and total_time_req we should consider 	
	int ioIndex; // this will be the index of which io_module_time and io_module_num to consider for io_module_current_exec to compare with
	int current_exec;
	int total_time_req[];

	void Process()
	{
		// this should be done by the Input guys
	}

	void checkforIO()
	{	   	
		if (current_exec>=total_time_req[cpuIndex])
		{
			current_exec=0;
			cpuIndex++;
			if (ioIndex==io_module_num.length)
			{
				// this means the process is complete
				state=-1;
			}
			else 
				IOQueues.addNewProc(this);
		}
	}

}
