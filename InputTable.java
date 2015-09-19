import java.util.*;

public class InputTable 
{
	public static ArrayList<InputEntry> ipTable = new ArrayList<InputEntry>();

	public static void add(InputEntry newEntry) {
		ipTable.add(newEntry);
		
	}
	public static void display()
	{
		for(InputEntry ip: ipTable)
		{
			System.out.println(ip.pname);
			System.out.println(ip.start_time);
			System.out.println("printed one item");
		}
	}
	
	public static void checkfornewprocess(int current_time)
	{
		for(InputEntry ip: ipTable){
			if(ip.start_time<=current_time && ip.exists==0)
			{
				int success = PCB.addNewEntry(ip);
				if(success==0)
					ip.exists=1;
			}
		}
	}
	
}
