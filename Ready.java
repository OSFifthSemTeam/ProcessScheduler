
import java.util.Queue;
import java.util.LinkedList;
public class Ready {
	static Queue <Process> ReadyProcs = new LinkedList<Process>();
	static Process running;
	
	static void enqueue(Process proc)
	{
		ReadyProcs.add(proc);
	}
	
	static void update(int psg)
	{
		PCB.entries.get(running.tableIndex).current_exec+=psg;
		PCB.addtoQueue(running);
		running = ReadyProcs.remove();
		//changing the state of the guy after putting him to run
		PCB.entries[running.tableIndex].state=0;
	}
}
