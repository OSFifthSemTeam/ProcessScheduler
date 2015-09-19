import java.util.*;

public class Process 
{
	int pid;
	int tableIndex;
	int state;
	int current_exec;
	int curr_mem;
	LinkedList<RunSpec> specifications;
	void Process(InputEntry entry)
	{
		pid=0;
		state=-2;
		current_exec=0;
		specifications = entry.specifications;
	}

	int checkforIO()
	{	   	
		current_exec=0;
		specifications=specifications.remove(0);
		if (specifications==null)
		{
			state=-1;
			return -1;
		}
		else if (specifications.getFirst().type==1)
		{
			IOQueues.addnewProc(this);
			return 0;
		}
		else 
			return 1;
	}

}
