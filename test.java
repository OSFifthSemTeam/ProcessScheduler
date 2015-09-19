public class test 
{
	public static void main(String[] args) 
	{
		ConfigInput newconf = new ConfigInput();
		newconf.readSysConfig();
//		ReadJobs jobread = new ReadJobs();
		ReadJobs.readJobFile();
		System.out.println(SystemConfig.max_proc);
		System.out.println(SystemConfig.psg);
		System.out.println(SystemConfig.numIO);
		System.out.println(SystemConfig.memory);
		InputTable.display();
		
		
	}

}
