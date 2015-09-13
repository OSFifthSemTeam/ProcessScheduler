package ProcessScheduler;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Iterator;

public class MemQueue {

		static LinkedList <ProcessTableEntry> waiting = new LinkedList<Process>();
		static int current_free_memory;
		
		static void enqueue(ProcessTableEntry proc)
		{
			waiting.addLast(proc);
		}
		
		static void update(){
						
			for(ProcessTableEntry proc : waiting)
			{
				if(current_free_memory>proc.mem_req[proc.cpuIndex])
				{
					waiting.remove(proc);
					PCB.addToQueue(proc.tableIndex,0);
					updateCurrentFreeMem(proc.mem_req[proc.cpuIndex],-1);
					break;
				}
			}
		}
		
		static void updateCurrentFreeMem(int size,int incr)
		{
			if(incr==1)
				current_free)memory+=size;
			else if(incr==-1)
				current_free_memory-=size;
			else
				System.out.print("Increment Error");
		}
}
