import java.util.ArrayList;

public class PCB 
{
	static List<Process> entries;
	static int addNewEntry(InputEntry entry)
	{
		if (SystemConfig.max_procs>=entries.size())
			return -1;
		else 
		{
			Process proc = new Process(entry);
			entries.add(proc);
			entries.get(entries.size).tableIndex = entries.size;
			addtoQueue(proc);
			return 0;
		}
	}	

	static int addtoQueue(int index, int type)
	{
			if (type==0)
			{
			check=entries[i].chkforIO();
			MemQueue.updateCurrentFreeMem(entries[index].curr_mem,1);
			if (check==1)
				// we need to schedule the thing, so we check for memory
				current_spec = (CpuSpec) entries[index].specifications;
				if (MemQueue.current_free_memory>=current_spec.head.mem_req)
				{
					// we add to Ready queue
					entries.get(index).state=3;	
					Ready.enqueue(entries[index]);
				}
				else 
				{
					// we add to memory waiting
					entries.get(index).state=2;	
					MemQueue.enqueue(enqueue[index]);
				}
			}
			else if (type==1)
				Ready.enqueue(entries[index]);
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
