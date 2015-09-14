
public class Process 
{
	int pid;
	int tableIndex;
	int state;
	int current_exec;
	LinkedList<RunSpec> specifications;
	void Process(InputEntry entry)
	{
		pid=0;
		state=-2;
		current_exec=0;
		specifications = entry.specifications;
	}

	void checkforIO()
	{	   	
		current_exec=0
		specifications=specifications.getNext()
		if (specifications==null)
			state=-1
			return -1
		else if (specifications.head.type==1)
			IOQueues.addnewProc(this)
			return 0
		else 
			return 1
	}

}
