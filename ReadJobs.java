import java.io.File;

import java.util.Scanner;

public class ReadJobs
{
	

	public static void readJobFile(File jobfile)
	{
		try
		{
			
			Scanner in = new Scanner(jobfile);
			int total_jobs_submitted = 0;
			
			String checker;
			while(in.hasNext())
			{
				checker = in.next();
				if(checker.equals("SUBMIT_JOB"))
					System.out.println("The command encountered is " + checker);
				else
					System.out.println("The command encountered is " + checker);
			
				if(checker.equals("SUBMIT_JOB"))
				{
					//System.out.println("Reading this file");
					InputEntry newEntry = new InputEntry();
					newEntry.pname = in.next();
					newEntry.start_time = in.nextInt();
					InputTable.add(newEntry);
					System.out.println("Added one item");
					total_jobs_submitted+=1;
				}
				
				else if(checker.equals("PROCESS_TABLE"))
				{
					int output_time = in.nextInt();
					System.out.println(output_time);
					OutputTable.addNewOutputEntry(output_time);
				}
			}
			in.close();
			SystemConfig.total_jobs_submitted=total_jobs_submitted;
		}
		catch (Exception e)
		{
			System.out.println("Failed in adding items"+ e);
		}
		
	}
	
	
}
