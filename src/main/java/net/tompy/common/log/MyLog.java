package net.tompy.common.log;

import net.tompy.common.CommonClassPathXmlApplicationContext;
import net.tompy.common.CommonConstants;
import net.tompy.common.CommonException;

import org.springframework.context.ApplicationContext;

public class MyLog
{
	private static Log log = null;
	
	public static Log getLog()
	{
//		try
//		{
			//ApplicationContext ctx = ApplicationContextCreator.createContext( new String[] { "spring_common_log.xml" } );
			ApplicationContext ctx = new CommonClassPathXmlApplicationContext( CommonConstants.LOG_SPRING );
			LogFactory factory = (LogFactory)ctx.getBean( CommonConstants.LOG_BEAN );
			log = factory.createLog();
//		}
//		catch ( CommonException ce )
//		{
//			if ( null == log )
//			{
//				log = new LogBasicImpl();
//			}
//		}
		
		return log;
	}
	
	public static Log getLog( String contextName ) throws CommonException
	{
		//ApplicationContext ctx = ApplicationContextCreator.createContext( new String[] { contextName } );
		ApplicationContext ctx = new CommonClassPathXmlApplicationContext( contextName );
		LogFactory factory = (LogFactory)ctx.getBean( CommonConstants.LOG_BEAN );
		log = factory.createLog();
		
		return log;
	}
}
