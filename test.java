import java.io.File;




public class test 
{
	public static void main(String[] args) 
	{
		File ipfile = new File("Z:\\OS assignment progs\\Assignment 2\\Sample inputs\\simulator_config"); //Sysconfig file
		File jobfile = new File ("Z:\\OS assignment progs\\Assignment 2\\Sample inputs\\sample1\\test1.job");// Job file
		String Ppath = ("Z:\\OS assignment progs\\Assignment 2\\Sample inputs\\sample1\\"); //Path for model file directory
		
		
		System.out.println("Starts here...");
		System.out.println("---------------------------------");
		//ConfigInput newconf = new ConfigInput();
		ConfigInput.readSysConfig(ipfile);
		
		ReadJobs.readJobFile(jobfile);
		System.out.println("Printing Output Table");
		OutputTable.printOutputTable();
		System.out.println("---------------------------------");
		
		ReadModelFiles.ReadModels(Ppath);
		System.out.println("---------------------------------");
		System.out.println("max proc = " + SystemConfig.max_proc);
		System.out.println("PSG = " + SystemConfig.PSG);
		System.out.println("numIO = " + SystemConfig.numIO);
		System.out.println("memory = " + SystemConfig.memory);
		System.out.println("Total jobs = "+ SystemConfig.total_jobs_submitted);
		System.out.println("---------------------------------");
		InputTable.display();
		
		
	}

}
