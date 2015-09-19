import java.util.ArrayList;

public class IOQueues {
	static IOModuleEntry queues[] = new IoModuleEntry[SystemConfig.numIO];
	
	static void addNewProc(Process proc)
	{
		IOSpec curriospec = (IOSpec)proc.specifications.head;
		queues[curriospec.io_module_num].addNewProcess(proc);
	}
	static void update(int psg)
	{
		for(int i=0;i<queues.length;i++)
			queues[i].update(psg);
	}
}
