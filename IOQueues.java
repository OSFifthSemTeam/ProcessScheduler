import java.util.ArrayList;

public class IOQueues {
	static IOModuleEntry queues[] = new IOModuleEntry[SystemConfig.numIO];
	
	static void addNewProc(Process proc)
	{
		IOSpec curriospec = (IOSpec)proc.specifications.getFirst();
		queues[curriospec.io_module_num].addNewProcess(proc);
	}
	static void update(int psg)
	{
		for(int i=0;i<queues.length;i++)
			queues[i].update(psg);
	}
}
