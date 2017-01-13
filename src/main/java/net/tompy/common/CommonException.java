package net.tompy.common;

public class CommonException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int status;
	
	public void print()
	{
		System.err.print( "-----Application Informatoin-----" );
		System.err.println( getStatus() );
		System.err.println( getMessage() );
		System.err.println( "-----System Information-----" );
		printStackTrace();
	}

	public CommonException( String msg )
	{
		super( msg );
		status = CommonConstants.EXCEPTION_FAILURE;
	}
	
	public CommonException( Exception e )
	{
		super( e );
		status = CommonConstants.EXCEPTION_FAILURE;
	}
	
	public CommonException ( String msg, int status )
	{
		super( msg );
		this.status = status;
	}
	
	public CommonException( Exception e, int status )
	{
		super( e );
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
