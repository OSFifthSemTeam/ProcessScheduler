package ProcessScheduler;
import java.util.LinkedList;
import java.util.Queue;

public class IOModuleEntry {
	static Queue<ProcessTableEntry> done = new LinkedList<ProcessTableEntry>();
	static Queue<ProcessTableEntry> waiting = new LinkedList<ProcessTableEntry>();
	
	void addNewProcess(ProcessTableEntry new_proc)
	{
		waiting.add(new_proc);
	}
	ProcessTableEntry procWaitingHead()
	{
		return waiting.element();
	}
	void update(int granularity)
	{
		waiting.element().io_module_current_exec+=granularity;
		if(waiting.element().io_module_current_exec>=waiting.element().io_module_time)
		{
			ProcessTableEntry proc = waiting.remove();
			proc.ioIndex++;
			PCB.addToQueue(proc.tableIndex,1);
		}
	}
}
