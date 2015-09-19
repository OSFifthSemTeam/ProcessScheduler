


public class test 
{
	public static void main(String[] args) 
	{
		System.out.println("Starts here...");
		System.out.println("---------------------------------");
		ConfigInput newconf = new ConfigInput();
		newconf.readSysConfig();
		ReadJobs.readJobFile();
		System.out.println("---------------------------------");
		ReadModelFiles.ReadModels();
		System.out.println("---------------------------------");
		System.out.println("max proc = " + SystemConfig.max_proc);
		System.out.println("PSG = " + SystemConfig.PSG);
		System.out.println("numIO = " + SystemConfig.numIO);
		System.out.println("memory = " + SystemConfig.memory);
		System.out.println("---------------------------------");
		InputTable.display();
		
		
	}

}
