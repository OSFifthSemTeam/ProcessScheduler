import java.util.*;
import java.io.*;

public class ConfigInput
{
	void readSysConfig()
	{	
		try
		{
			File ipfile = new File("C:\\zeeshan```\\ipfile.txt");
			Scanner in = new Scanner(ipfile);
			while(in.hasNext())
			{
				SystemConfig.max_proc = in.nextInt();
				SystemConfig.psg = in.nextInt();
				SystemConfig.numIO = in.nextInt();
				SystemConfig.memory = in.nextInt();
			}
			in.close();
		}
		catch (Exception e)
		{
			System.out.println("Exception while reading input to sysconfig");
		}
		
	
	}
}


