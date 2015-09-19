import java.io.*;
import java.util.*;


public class ReadModelFiles 
{

	public static void ReadModels()
	{
		try
		{
			
			for(InputEntry ip: InputTable.ipTable)
			{
				String checker;
				String Ppath = ("C:\\zeeshan```\\");
				Ppath = Ppath.concat(ip.pname);
				Ppath = Ppath.concat(".txt");
				System.out.println("curr path is " + Ppath);
				File readModule = new File(Ppath);
				Scanner in = new Scanner(readModule);
				while(in.hasNext())
					
				{
					 checker = in.next();
					if(checker.equals("CPU"))
					{
						
						CpuSpec newCpuEntry = new CpuSpec();
						newCpuEntry.time_req = in.nextInt();
						in.next();
						newCpuEntry.mem_req = in.nextInt();
						ip.reqs.add(newCpuEntry);
						System.out.println("new line added in LL");
						System.out.println("time req " + newCpuEntry.time_req);
						System.out.println("mem req " + newCpuEntry.mem_req);
						System.out.println(in.hasNext());
						
											
						
					}
				
					else if(checker.equals("IO"))
					{
						
						IOSpec newIOEntry = new IOSpec();
						newIOEntry.io_module_num = in.nextInt();
						newIOEntry.time_req = in.nextInt();
						ip.reqs.add(newIOEntry);
						System.out.println("new line added in LL");
						System.out.println("io req " + newIOEntry.io_module_num);
						System.out.println("time req " + newIOEntry.time_req);
						
					}
				}
			
			}
		}
		catch (Exception e)
		{
			
		}
		
	}
}
