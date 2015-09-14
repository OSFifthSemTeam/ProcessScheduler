import java.util.*;

public class InputTable 
{
	public static ArrayList<InputEntry> ipTable = new ArrayList<InputEntry>();

	public static void add(InputEntry newEntry) {
		// TODO Auto-generated method stub
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
	
}
