import java.util.*;
import java.io.*;

public class InputEntry 
{
	String pname;
	int start_time;
	LinkedList<RunSpec> reqs = new LinkedList<RunSpec>(); 
	int exists;

	void add_cpuSpec(int time, int mem)
	{
		RunSpec obj = new CpuSpec(time, mem);
		reqs.add(obj);
	}


	void add_IOspec(int num, int time)
	{	
		RunSpec obj = new IOSpec(num, time);
		reqs.add(obj);
	}
		
	
}
