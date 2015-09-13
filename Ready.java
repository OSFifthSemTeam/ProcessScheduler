package ProcessScheduler;
import java.util.Queue;
import java.util.LinkedList;
public class Ready {
	static Queue <ProcessTableEntry> ReadyProcs = new LinkedList<ProcessTableEntry>();
	static ProcessTableEntry running;
	
	static void enqueue(ProcessTableEntry proc)
	{
		ReadyProcs.add(proc);
	}
	
	static update(int psg)
	{
		PCB.entries.get(running.tableIndex).current_exec+=psg;
		PCB.addToQueue(running);
		running = ReadyProcs.remove();
		//changing the state of the guy after putting him to run
		PCB.entries.get(running.tableIndex).state=0;
	}
}
