import java.util.*;

public class Process 
{
	static int glob_pid=0;
	int pid;
	int tableIndex;
	int state;
	int current_exec;
	int curr_mem;
	LinkedList<RunSpec> specifications;
	public Process(InputEntry entry)
	{
		pid=Process.glob_pid++;
		state=-2;
		current_exec=0;
		specifications = entry.reqs;
	}

	int checkforIO()
	{	   	
		current_exec=0;
		specifications.remove(0);
		if (specifications==null)
		{
			state=-1;
			return -1;
		}
		else if (specifications.getFirst().type==1)
		{
			System.out.println("Adding " + pid + " to an IOQueue");
			IOQueues.addNewProc(this);
			return 0;
		}
		else 
			return 1;
	}

}
