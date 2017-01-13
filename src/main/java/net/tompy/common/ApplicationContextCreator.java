/*---------------------------------------------------------------------
 * 
 * Copyright 2011 TransUnion LLC. All Rights Reserved.
 * 
 * No part of this work may be reproduced or distributed in any form or by any
 * means, electronic or otherwise, now known or hereafter developed, including,
 * but not limited to, the Internet, without the explicit prior written consent
 * from TransUnion LLC.
 * 
 * Requests for permission to reproduce or distribute any part of, or all of,
 * this work should be mailed to:
 * 
 * Law Department TransUnion 555 West Adams Chicago, Illinois 60661
 * www.transunion.com
 * 
 * ---------------------------------------------------------------------*/
package net.tompy.common;

import java.io.File;

import org.springframework.context.ApplicationContext;

public class ApplicationContextCreator 
{
	private static PropertyConfigurationManager propsManager;
	
	public static ApplicationContext createContext( String[] args ) throws CommonException
	{
		String propertiesFile = null;
		String[] commandLineArgs = null;
		
		if ( args.length > 0 )
		{
			propertiesFile = System.getenv( CommonConstants.PROP_HOME ) + File.separator + args[ 0 ];
			commandLineArgs = new String[ args.length - 1 ];
			System.arraycopy( args, 1, commandLineArgs, 0, args.length - 1 );
		}
		else
		{
			throw new CommonException( "Missing properties file in command line arguments list." );
		}
		
		return createContext( propertiesFile, commandLineArgs );
	}

	public static ApplicationContext createContext( String propertiesFile, String[] args ) throws CommonException
	{
		ArgumentListPropertyConfigurer.setProperties( propertiesFile, args );
		
		String springMain = ArgumentListPropertyConfigurer.getProperties().getProperty( CommonConstants.SPRING_MAIN ); 
		
		if ( null == springMain )
		{
			throw new CommonException( "No [" + CommonConstants.SPRING_MAIN + "] property" );
		}
		
		if ( null != propsManager )
		{
			ArgumentListPropertyConfigurer.setProps( propsManager.preContextCreation( ArgumentListPropertyConfigurer.getProperties() ) );
		}
		
		ApplicationContext returnContext = new CommonClassPathXmlApplicationContext( springMain ); 
		
		if ( null != propsManager )
		{
			ArgumentListPropertyConfigurer.setProps( propsManager.postContextCreation( ArgumentListPropertyConfigurer.getProperties() ) );
		}

		return returnContext;
	}
	
	public static void registerPropertyManager( PropertyConfigurationManager manager )
	{
		propsManager = manager;
	}
}
