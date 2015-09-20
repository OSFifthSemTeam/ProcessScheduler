import java.io.File;

import java.util.Scanner;

public class ReadJobs
{
	

	public static void readJobFile()
	{
		try
		{
			
			File jobfile = new File ("/home/yasu/OS/Assignment/ProcessScheduler/Inputs/sample1/test1.job");// change the path
			Scanner in = new Scanner(jobfile);
			
			String checker;
			while(in.hasNext())
			{
				checker = in.next();
				if(checker.equals("SUBMIT_JOB"))
					System.out.println("The command encountered is " + checker);
				else
					System.out.println("The command encountered is " + in.nextLine());
			
				if(checker.equals("SUBMIT_JOB"))
				{
					//System.out.println("Reading this file");
					InputEntry newEntry = new InputEntry();
					newEntry.pname = in.next();
					newEntry.start_time = in.nextInt();
					InputTable.add(newEntry);
					System.out.println("Added one item");
				}
				
				else if(checker.equals("PRINT PROCESS_TABLE"))
				{}
			}
			in.close();
		}
		catch (Exception e)
		{
			System.out.println("Failed in adding items"+ e);
		}
		
	}
	
	
}
