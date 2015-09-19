package ProcessScheduler;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Iterator;

public class MemQueue {

		static LinkedList <Process> waiting = new LinkedList<Process>();
		static int current_free_memory;
		
		static void enqueue(Process proc)
		{
			waiting.addLast(proc);
		}
		
		static void update(){
						
			for(Process proc : waiting)
			{
				CPUSpec currcpuspec = (CPUSpec)proc.specifications.head;
				if(current_free_memory>currcpuspec.mem_req)
				{
					waiting.remove(proc);
					PCB.addToQueue(proc.tableIndex,0);
					updateCurrentFreeMem(currcpuspec.mem_req,-1);
					break;
				}
			}
		}
		
		static void updateCurrentFreeMem(int size,int incr)
		{
			if(incr==1)
				current_free_memory+=size;
			else if(incr==-1)
				current_free_memory-=size;
			else
				System.out.print("Increment Error");
		}
}
