import java.util.Queue;
import java.util.LinkedList;
public class Ready {
	static Queue <Process> ReadyProcs = new LinkedList<Process>();
	static Process running;
	
	static void enqueue(Process proc)
	{
		proc.state=3;
		ReadyProcs.add(proc);
		CpuSpec spec_head = (CpuSpec)proc.specifications.element();
		proc.curr_mem = spec_head.mem_req;
		MemQueue.updateCurrentFreeMem(proc.curr_mem, -1);
	}
	
	static void update(int psg)
	{
		System.out.println("Came to update the Ready Queue");	
		if (running!=null)
		{
			PCB.entries.get(running.tableIndex).current_exec+=psg;
			System.out.println("Current_exec after incrementing" + PCB.entries.get(running.tableIndex).current_exec);
			if (PCB.entries.get(running.tableIndex).current_exec!=running.current_exec)
				System.out.println("INCREMENT DID NOT WORK!!");
			else 
				System.out.println("running.current_exec " + running.current_exec + " from pcb " + PCB.entries.get(running.tableIndex).current_exec);
			PCB.addtoQueue(running.tableIndex,0);
			System.out.println("After incrementing the current_exec of running process and adding it to the queue");
			running.printDetails();
		}
		try
		{	
			running = ReadyProcs.remove();
			//changing the state of the guy after putting him to run
			PCB.entries.get(running.tableIndex).state=0;
		}
		catch (Exception e)
		{
			System.out.println("There is no Running Process");	
		}
	}
}
