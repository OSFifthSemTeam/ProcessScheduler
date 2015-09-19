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
			String extractor,extracted;
			while(in.hasNext())
			{
				
				/***********************************************************************
				 * Sir has given config Input with the variable name and an equal to sign.
				 * Extracting only the numerical part from it and assigning to the variables here.
				 * But while printing, printing syso("lalal = " + variable) so dont worry about
				 * me extracting more than needed from sir's input file.
				 ***********************************************************************/
				
				extractor = in.nextLine();
				//System.out.println(extractor);
				extracted = extractor.substring((extractor.indexOf('=')+1),extractor.length());
				//System.out.println(extracted);
				SystemConfig.max_proc = Integer.parseInt(extracted);
				
				extractor = in.nextLine();		
				extracted = extractor.substring((extractor.indexOf('=')+1),extractor.length());
				SystemConfig.PSG = Integer.parseInt(extracted);
				
				extractor = in.nextLine();	
				extracted = extractor.substring((extractor.indexOf('=')+1),extractor.length());
				SystemConfig.numIO = Integer.parseInt(extracted);
				
				extractor = in.nextLine();	
				extracted = extractor.substring((extractor.indexOf('=')+1),extractor.length());
				SystemConfig.memory = Integer.parseInt(extracted);
			}
			in.close();
		}
		catch (Exception e)
		{
			System.out.println("Exception while reading input to sysconfig");
		}
		
	
	}
}


