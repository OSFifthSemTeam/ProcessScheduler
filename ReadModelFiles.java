import java.io.*;
import java.util.*;


public class ReadModelFiles 
{

	public static void ReadModels(String inputPpath)
	{
		try
		{
			
			for(InputEntry ip: InputTable.ipTable)
			{
				String checker;
				String Ppath = inputPpath;
				
				Ppath = Ppath.concat(ip.pname);
				Ppath = Ppath.concat(".model");
				System.out.println();
				System.out.println("curr path is " + Ppath);
				File readModule = new File(Ppath);
				Scanner in = new Scanner(readModule);
				while(in.hasNext())
					
				{
					 checker = in.next();
					if(checker.equals("cpu"))
					{
											
						int time_req = in.nextInt();
						in.next();
						int mem_req = in.nextInt();
						ip.add_cpuSpec(time_req, mem_req);
						System.out.println("new line added in LL as a CpuSpec");
						System.out.println("Does the Model file have any more lines? -  " + in.hasNext());
																	
						
					}
				
					else if(checker.equals("io"))
					{
						
						int io_module_num = in.nextInt();
						int time_req = in.nextInt();
						ip.add_IOspec(time_req,io_module_num );
						
						System.out.println("new line added in LL as an IOSpec");
						System.out.println("Does the Model file have any more lines? -  " + in.hasNext());
						
					}
				}
				in.close();
				System.out.println("---------------------------------");
				
			}
			
		}
		catch (Exception e)
		{
			System.out.println("Error while reading model files");
		}
		
	}
}
