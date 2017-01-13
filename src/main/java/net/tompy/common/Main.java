package net.tompy.common;

import org.springframework.context.ApplicationContext;



public class Main 
{

	/**
	 * @param args
	 */
	public static void main( String[] args ) 
	{
		Main m = new Main();
		m.process( args );
	}

	public int process( String[] args )
	{
		int exitStatus = 0;

		try
		{
			ApplicationContext ctx = ApplicationContextCreator.createContext( args );
			
			CommonProcess mainProcess = (CommonProcess)ctx.getBean( ArgumentListPropertyConfigurer.getProperties().getProperty( CommonConstants.MAIN_PROCESS ) );
			
			// Reconstruct command line and add to properties
			StringBuilder commandLine = new StringBuilder();
			for ( int i = 0; i < args.length; i++ )
			{
				commandLine.append( args[ i ] );
				commandLine.append( " " );
			}
			ArgumentListPropertyConfigurer.getProperties().put( CommonConstants.COMMAND_LINE, commandLine.toString() );
			
			exitStatus = mainProcess.process( ctx, ArgumentListPropertyConfigurer.getProperties() );
		}
		catch ( CommonException c3be )
		{
			c3be.printStackTrace();
			exitStatus = c3be.getStatus();
		}
		catch ( Exception e )
		{
			e.printStackTrace();
			exitStatus = CommonConstants.EXCEPTION_FAILURE;
		}

		return exitStatus;
	}
}
