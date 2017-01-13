package net.tompy.common.log;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.Date;

import net.tompy.common.CommonConstants;

public class LogFileImpl implements Log
{
	private String filename;
	
	public void init()
	{
		try
		{
			OutputStream file = new FileOutputStream( filename );
			file.write( ( "Log open: " + new Timestamp( new Date().getTime() ) + CommonConstants.LINE_END ).getBytes() );
			file.close();
		}
		catch( FileNotFoundException fnfe )
		{
			fnfe.printStackTrace();
			System.exit( CommonConstants.EXCEPTION_FAILURE );
		}
		catch( IOException ioe )
		{
			ioe.printStackTrace();
			System.exit( CommonConstants.EXCEPTION_FAILURE );
		}		
	}
	
	@Override
	public void info(String info) 
	{
		try
		{
			OutputStream file = new FileOutputStream( filename, true );
			file.write( ( info + CommonConstants.LINE_END ).getBytes() );
			file.close();
		}
		catch( FileNotFoundException fnfe )
		{
			fnfe.printStackTrace();
			System.exit( CommonConstants.EXCEPTION_FAILURE );
		}
		catch( IOException ioe )
		{
			ioe.printStackTrace();
			System.exit( CommonConstants.EXCEPTION_FAILURE );
		}
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

}
