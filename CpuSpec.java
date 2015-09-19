public class CpuSpec extends RunSpec 
{

	int time_req;
	int mem_req;
	
	public CpuSpec(int time, int mem) 
	{
		// TODO Auto-generated constructor stub
		super(0);
		time_req=time;
		mem_req=mem;
	}
		
	public CpuSpec()
	{
		super(0);
		time_req=-1;
		mem_req=-1;
	}

	@Override
	public String toString() {
		return "CpuSpec [time_req=" + time_req + ", mem_req=" + mem_req + "]";
	}
	

}