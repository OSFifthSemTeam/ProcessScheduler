import java.util.LinkedList;
import java.util.Queue;

public class IOModuleEntry {
	static Queue<Process> done = new LinkedList<Process>();
	static Queue<Process> waiting = new LinkedList<Process>();
	
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
		waiting.element().current_exec+=granularity;
		IOSpec curriospec = (IOSpec)waiting.element().specifications.getFirst();
		if(waiting.element().current_exec>=curriospec.time_req)
		{
			Process proc = waiting.remove();
			proc.specifications.remove(0);
			PCB.addtoQueue(proc.tableIndex,1);
		}
	}
}
