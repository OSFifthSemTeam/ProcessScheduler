import java.util.*;

public class PCB 
{
	static List<Process> entries = new ArrayList<Process>();
	static int addNewEntry(InputEntry entry)
	{
		if (SystemConfig.max_proc>=entries.size())
			return -1;
		else 
		{
			Process proc = new Process(entry);
			entries.add(proc);
			entries.get(entries.size()).tableIndex = entries.size();
			addtoQueue(proc.tableIndex,0);
			return 0;
		}
	}	

	static void addtoQueue(int index, int type)
	{
			CpuSpec current_spec;
			if (type==0)
			{
				int check=entries.get(index).checkforIO();
				MemQueue.updateCurrentFreeMem(entries.get(index).curr_mem,1);
				if (check==1)
				{
				// we need to schedule the thing, so we check for memory
					current_spec = (CpuSpec)entries.get(index).specifications.element();
					if (MemQueue.current_free_memory>=current_spec.mem_req)
					{
						// we add to Ready queue
						entries.get(index).state=3;	
						Ready.enqueue(entries.get(index));
					}
					else 
					{
						// we add to memory waiting
						entries.get(index).state=2;	
						MemQueue.enqueue(entries.get(index));
					}
				}
			}
			else if (type==1)
				Ready.enqueue(entries.get(index));
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
