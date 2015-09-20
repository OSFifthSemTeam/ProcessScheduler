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
		if (specifications.size()==0)
		{
			MemQueue.updateCurrentFreeMem(curr_mem, 1);
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

	void printDetails()
	{
		System.out.println("-----------------------------------------------------------");
		System.out.println("PID - " + pid + " index " + tableIndex + " state " + state);
		System.out.println("Specifications");
		for(RunSpec i: specifications)
		{
			System.out.println(i.type + " - " + i);
		}
		System.out.println("curr_exec " + current_exec + " curr_mem " + curr_mem);
		System.out.println("-----------------------------------------------------------");
	}
	
	void printDetailsforProcTable()
	{
		CpuSpec current_cpu_spec;
		IOSpec current_io_spec;
		
		System.out.println("-----------------------------------------------------------");
		System.out.println("PID - " + pid + " index " + tableIndex + " state " + state);
		System.out.println("Current Specifications ");
		int current_type = specifications.element().type;
		if(current_type==0){
			current_cpu_spec = (CpuSpec)specifications.element();
			System.out.println(current_cpu_spec.toString());
		}
		else if(current_type==1){
			current_io_spec = (IOSpec)specifications.element();
			System.out.println(current_io_spec.toString());
		}
		System.out.println("curr_exec " + current_exec + " curr_mem " + curr_mem);
		System.out.println("-----------------------------------------------------------");
	}
}
