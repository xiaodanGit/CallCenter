package basic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class CallHandler 
{
	List<CallHandler> nextLevelHandlers;
	Rank rank;
	boolean isAvailable;
	Queue<Call> callQueue;
	
	CallHandler()
	{
		rank = Rank.handler;
		isAvailable = true;
		callQueue = new LinkedList<Call>();
	}
	
	public void handle(Call call) throws NoHandlerAvailableException
	{
		this.isAvailable = false;
		if(canHandle(call))
		{
			System.out.println("handle call " + call.toString());
		}
		else
		{
			getAvailableNextLevelHandler().handle(call);
		}
		this.isAvailable = true;
	}
	
	public boolean canHandle(Call call)
	{
		if(rank.getValue() < call.getRank().getValue())
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	private CallHandler getAvailableNextLevelHandler() throws NoHandlerAvailableException
	{
		for(CallHandler handler:  nextLevelHandlers)
		{
			if(handler.isAvailable)
			{
				handler.setAvailable(false);
				return handler;
			}
		}
		throw new NoHandlerAvailableException();
	}
	
	public void setAvailable(boolean available)
	{
		this.isAvailable = available;
	}
	
	public boolean isAvailable()
	{
		return this.isAvailable;
	}
	
	
}
