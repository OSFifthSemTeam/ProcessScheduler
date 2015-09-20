
import java.io.*;

/*	Use PsLogger.printMethod(*your string*); to print to the file instead of the console.

*/
public class PsLogger 
{

	static File opfile = new File("C:\\zeeshan```\\op.txt");
	
	
	public static void printMethod(String str)
	{
		try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(opfile, true)))) 
		{
			out.println(str);
		}
		catch (IOException e)
		{
			System.out.println("Error while accessing file");
		}
	}
}
