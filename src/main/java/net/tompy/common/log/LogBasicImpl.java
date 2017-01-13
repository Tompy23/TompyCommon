package net.tompy.common.log;

import net.tompy.common.CommonConstants;

public class LogBasicImpl implements Log 
{
	public void info( String info )
	{
		System.out.println( info + CommonConstants.LINE_END );
	}
}
