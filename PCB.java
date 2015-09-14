

import java.util.ArrayList;

public class PCB 
{
	static List<Process> entries;
	static int addNewEntry(InputEntry entry)
	{
		if (SystemConfig.max_procs>==entries.size())
			return -1;
		else 
		{
			Process proc = new Process(entry.start_time,entry.total_exec_time[],entry.io_module_num[],entry.io_module_time[],entry.mem_req[]);
			entries.add(proc);
			entries.get(entries.size).tableIndex = entries.size;
			addtoQueue(proc);
			return 0;
		}
	}	

	static int addtoQueue(int index, int type)
	{
			if (type==0)
				entries[i].chkforIO();
			else if (type==1)
			{
				// we need to schedule the thing, so we check for memory
				if (Memory.current_free_memory>=entries.get(index).mem_req[entries.get(index).cpuIndex])
				{
					// we add to Ready queue
					entries.get(index).state=3;	
					Ready.enqueue(entries[index]);
				}
				else 
				{
					// we add to memory waiting
					entries.get(index).state=2;	
					Memory.enqueue(enqueue[index]);
				}
			}
	}

	static void removeDoneProcesses()
	{
		for (Process p: entries)
		{
			if (p.state==-1)
				entries.remove(p);
		}
	}

	static void printProcessTable()
	{
		//TODO
	}

}
