package net.tompy.common.log;

public class LogFactory 
{
	private Log logger;
	
	public Log createLog()
	{
		return logger;
	}

	public void setLogger(Log logger) {
		this.logger = logger;
	}
}
