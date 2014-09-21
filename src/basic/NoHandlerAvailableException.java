package basic;

public class NoHandlerAvailableException extends Exception 
{
	
	public NoHandlerAvailableException()
	{
		super("no available handler please wait in queue");
	}

}
