public class IOSpec extends RunSpec 
{

	

	int time_req;
	int io_module_num;
	
	public IOSpec(int time, int module) 
	{
		// TODO Auto-generated constructor stub
		super(1);
		time_req=time;
		io_module_num=module;
	}
	
	public IOSpec()
	{
		super(1);
		time_req=-1;
		io_module_num=-1;
	}
	
	@Override
	public String toString() {
		return "IOSpec [time_req=" + time_req + ", io_module_num="
				+ io_module_num + "]";
	}

}