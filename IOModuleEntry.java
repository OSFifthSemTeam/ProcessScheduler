import java.util.LinkedList;
import java.util.Queue;

public class IOModuleEntry {
	Queue<Process> waiting ;
	int made;
	IOModuleEntry()
	{
		System.out.println("Allocating waiting queue in IOModuleEntry");
		waiting = new LinkedList<Process>();
		made=1;	
	}
	
	void addNewProcess(Process new_proc)
	{
		waiting.add(new_proc);
	}
	Process procWaitingHead()
	{
		return waiting.element();
	}
	void update(int granularity)
	{
		try 
		{
			if (waiting.size()!=0)
			{
				waiting.element().current_exec+=granularity;
				IOSpec curriospec = (IOSpec)waiting.element().specifications.getFirst();
				if(waiting.element().current_exec>=curriospec.time_req)
				{
					Process proc = waiting.remove();
					proc.specifications.remove(0);
					if (proc.specifications.getFirst()==null)
					{
						System.out.println(proc.pid + " finished ");
						proc.state=-1;
					}
					PCB.addtoQueue(proc.tableIndex,1);
				}
			}
			else 
			{
			}
		}
		catch(Exception e)
		{	
			System.out.println("Something went wrong in update in IOModuleEntry");
			e.printStackTrace();
			System.exit(0);
		}
	}
}
