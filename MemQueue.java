import java.util.LinkedList;


public class MemQueue {

		static LinkedList <Process> waiting = new LinkedList<Process>();
		static int current_free_memory;
		static 
		{
			current_free_memory=SystemConfig.memory;
		}
		
		static void enqueue(Process proc)
		{
			waiting.addLast(proc);
		}
		
		static void update(){
						
			for(Process proc : waiting)
			{
				CpuSpec currcpuspec = (CpuSpec)proc.specifications.getFirst();
				if(current_free_memory>currcpuspec.mem_req)
				{
					waiting.remove(proc);
					PCB.addtoQueue(proc.tableIndex,0);
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
