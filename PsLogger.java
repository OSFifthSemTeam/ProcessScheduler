
import java.io.*;


public class PsLogger 
{

	static File opfile = new File("C:\\zeeshan```\\op.txt");
	
	
	public static void printMethod(String str)
	{
		try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(opfile, true)))) 
		{
			out.println(str);
			//more code
		//more code
		}
		catch (IOException e)
		{
			//exception handling left as an exercise for the reader
		}
	}
}
