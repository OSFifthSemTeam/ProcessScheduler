import java.util.ArrayList;

public class IOQueues {
	static IOModuleEntry queues[] = new IoModuleEntry[SystemConfig.numIO];
	
	static void addNewProc(Process proc)
	{
		queues[proc.io_module_num[proc.ioIndex]].addNewProcess(proc);
	}
	static void update(int psg)
	{
		for(int i=0;i<queues.length;i++)
			queues[i].update(psg);
	}
}
