import java.io.File;
import java.util.Scanner;

public class ReadJobs
{
	public static void readJobFile()
	{
		try
		{
			
			File jobfile = new File("C:\\zeeshan```\\jobfile.txt"); // change the path
			Scanner in = new Scanner(jobfile);
			//System.out.println("Reading this file");
			while(in.hasNext())
			{
			//	System.out.println("Reading this file");
				if(in.next().equals("SUBMIT"))
				{
					//System.out.println("Reading this file");
					InputEntry newEntry = new InputEntry();
					newEntry.pname = in.next();
					newEntry.start_time = in.nextInt();
					InputTable.add(newEntry);
					System.out.println("Added one item");
				}
			}
			in.close();
		}
		catch (Exception e)
		{
			System.out.println("Error reading from job file.Failed in adding items"+ e);
		}
		
	}
	
	
}