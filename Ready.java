import java.util.Queue;
import java.util.LinkedList;
public class Ready {
	static Queue <Process> ReadyProcs = new LinkedList<Process>();
	static Process running;
	
	static void enqueue(Process proc)
	{
		ReadyProcs.add(proc);
		CpuSpec spec_head = (CpuSpec)proc.specifications.element();
		proc.curr_mem = spec_head.mem_req;
		MemQueue.updateCurrentFreeMem(proc.curr_mem, -1);
	}
	
	static void update(int psg)
	{
		PCB.entries.get(running.tableIndex).current_exec+=psg;
		PCB.addtoQueue(running.tableIndex,0);
		running = ReadyProcs.remove();
		//changing the state of the guy after putting him to run
		PCB.entries.get(running.tableIndex).state=0;
	}
}
