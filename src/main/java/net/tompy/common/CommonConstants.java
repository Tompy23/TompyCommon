package net.tompy.common;

public class CommonConstants 
{
	// Startup
	public static String PROP_HOME = "PROP_HOME";
	public static String COMMAND_LINE = "COMMAND_LINE";
	public static String SPRING_MAIN = "spring.main";
	public static String MAIN_PROCESS = "main.process";

	
	// Exception Status
	public static int EXCEPTION_FAILURE = 5;
	public static int RETURN_SUCCESS = 0;
	
	// Java
	public static String LINE_END = System.getProperty( "line.separator" );
	
	// Logging
	public static String LOG_BEAN = "commonLog";
	public static String LOG_SPRING = "spring_common_log.xml";
}
