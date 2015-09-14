import java.io.File;
import java.util.ArrayList;
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
		}
		catch (Exception e)
		{
			System.out.println("Failed in adding items"+ e);
		}
		
	}
	
	
}