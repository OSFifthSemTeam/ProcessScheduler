import java.util.ArrayList;

public class OutputTable {
	
	static ArrayList<Integer> output_times = new ArrayList<Integer>();
	
	public static void addNewOutputEntry(int time)
	{
		output_times.add(time);
	}
	
	public static void printOutputTable()
	{
		System.out.println("-----------------------------");
		int index=0;
		for(Integer curr_time:output_times)
		{
			System.out.println("Entry number : " + index + " Time : "+ curr_time);
			index+=1;
		}
		System.out.println("-----------------------------");
	}
	
	public static void removeFirstEntry()
	{
		output_times.remove(0);
	}
	
	public static Integer getNextOutputTime()
	{
		return output_times.get(0);
	}
	
	public static int getCurrentSize()
	{
		return output_times.size();
	}
	/*public static void main(String args[])
	{
		addNewOutputEntry(50);
		addNewOutputEntry(100);
		addNewOutputEntry(50000);
		addNewOutputEntry(1);
		printOutputTable();
	}*/
}
