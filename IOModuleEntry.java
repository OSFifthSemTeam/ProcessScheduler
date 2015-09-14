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
		waiting.element().io_module_current_exec+=granularity;
		if(waiting.element().io_module_current_exec>=waiting.element().io_module_time[waiting.element().ioIndex])
		{
			Process proc = waiting.remove();
			proc.ioIndex++;
			PCB.addtoQueue(proc.tableIndex,1);
		}
	}
}
