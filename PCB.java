import java.util.*;

public class PCB 
{
	static List<Process> entries = new ArrayList<Process>();
	static int numDone;
	static 
	{
		numDone=0;
	}
	static int addNewEntry(InputEntry entry)
	{
		if (SystemConfig.max_proc<=entries.size())
		{
			System.out.println("Adding Failed, max_proc " + SystemConfig.max_proc + " current_size : " + entries.size());
			return -1;
		}
		else 
		{
			Process proc = new Process(entry);
			entries.add(proc);
			entries.get(entries.size()-1).tableIndex = entries.size()-1;
			System.out.println("Before adding to queue");
			proc.printDetails();
			addtoQueue(proc.tableIndex,0);
			proc.printDetails();
			return 0;
		}
	}	

	static void addtoQueue(int index, int type)
	{
		System.out.println("In addtoQueue for index " + index + " type " + type);
		// there are 2 possibilities here
		/*
		the thing finished it's current specification and needs to move to the next specification
		the thing hasnt finished it's current specification 
		*/
		/* checking if it finished it's current specification */
		Process current = entries.get(index);
		if (current.specifications.getFirst().type==0) // this means it's in CPU
		{
			CpuSpec currcpu = (CpuSpec) current.specifications.getFirst();
			/* checking if the current specification is done */
			if (current.current_exec>=currcpu.time_req)
			{
				current.current_exec=0;
				current.specifications.remove(0);
				MemQueue.updateCurrentFreeMem(entries.get(index).curr_mem,1);
				/* check if there is any I/O required */
				int check=entries.get(index).checkforIO();
				if (check!=0 && current.specifications.size()!=0)
				{
					System.out.println("There was no IO required for index " + index);
					// we need to schedule the thing, so we check for memory
					CpuSpec current_spec = (CpuSpec)entries.get(index).specifications.element();
					if (MemQueue.current_free_memory>=current_spec.mem_req)
					{
						System.out.println("There was free memory, so we put it in Ready queue");
						// we add to Ready queue
						entries.get(index).state=3;	
						Ready.enqueue(entries.get(index));
					}
					else 
					{
						System.out.println("There was no free memory, so we put it in memory queue");
						// we add to memory waiting
						entries.get(index).state=2;	
						MemQueue.enqueue(entries.get(index));
					}
				}
			}
			/* if the current specification isnt done */
			else 
			{
				Ready.enqueue(current);	
			}
		}
		else if (current.specifications.getFirst().type==1) // this means it's in I/O
		{
			IOSpec currio= (IOSpec) current.specifications.getFirst();
			/* checking if the current specification is done */
			if (current.current_exec>=currio.time_req)
			{
				current.current_exec=0;
				current.specifications.remove(0);
				MemQueue.updateCurrentFreeMem(entries.get(index).curr_mem,1);
				/* check if there is any I/O required */
				int check=entries.get(index).checkforIO();
				if (check!=0 && current.specifications.size()!=0)
				{
					System.out.println("There was no IO required for index " + index);
					// we need to schedule the thing, so we check for memory
					CpuSpec current_spec = (CpuSpec)entries.get(index).specifications.element();
					if (MemQueue.current_free_memory>=current_spec.mem_req)
					{
						System.out.println("There was free memory, so we put it in Ready queue");
						// we add to Ready queue
						entries.get(index).state=3;	
						Ready.enqueue(entries.get(index));
					}
					else 
					{
						System.out.println("There was no free memory, so we put it in memory queue");
						// we add to memory waiting
						entries.get(index).state=2;	
						MemQueue.enqueue(entries.get(index));
					}
				}
			}
		}

	}

	static void removeDoneProcesses()
	{
		if(entries.size()==0)
			return;
		
		System.out.println("Checking for done processes and removing");
		for (Iterator<Process> iterator = entries.iterator(); iterator.hasNext();) 
		{
		    Process proc = iterator.next();
		    if (proc.state==-1) 
		    {
		       	numDone+=1;
		    	iterator.remove();
		        System.out.println("Process Removed : Process entries size = "+entries.size());
		        System.out.println("Number of procs complete : " + numDone);
		    }
		
		for(Process proc1:entries)
			proc1.tableIndex=entries.indexOf(proc1);
				    
		}		
	}

	static void printProcessTable()
	{
		for(Process proc:entries){
			proc.printDetailsforProcTable();
		}
		
	}

}
