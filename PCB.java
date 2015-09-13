import java.util.ArrayList;

public class PCB 
{
	static List<Process> entries;
	static int addNewEntry(InputEntry entry)
	{
		if (SystemConfig.max_procs>==entries.size())
			return -1
		else 
		{
			Process proc = new Process(entry.start_time,entry.total_exec_time[],entry.io_module_num[],entry.io_module_time[],entry.mem_req[]);
			entries.add(proc);
			entries.get(entries.size).tableIndex = entries.size;
			addtoQueue(proc);
			return 0;
		}
	}	

	
