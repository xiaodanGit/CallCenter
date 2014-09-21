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
	
	public void handleCall(Call call)
	{
		this.isAvailable = false;
		callQueue.offer(call);
		work();	
	}
	
	public void setNextLevelHandlers(List<CallHandler> nextLevelHandlers)
	{
		this.nextLevelHandlers = nextLevelHandlers;
	}
	
	private void handle(Call call) 
	{
		if(canHandle(call))
		{
			boolean done = false;
			if(done)
			{
				System.out.println("handle call " + call.toString());
			}
			else
			{
				call.setRank(Rank.getRankFromNumber(rank.getValue() + 1));
			}
		}
		else
		{
			CallHandler next = getAvailableNextLevelHandler();
			if(next == null)
			{
				callQueue.add(call);
			}
			else
			{
				next.handleCall(call);
			}
		}
		this.isAvailable = true;
		
	}
	
	private void work()
	{
		
		while(!callQueue.isEmpty())
		{
			Call cur = callQueue.poll();
			handle(cur);
		}
		
	}
	
	private boolean canHandle(Call call)
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
	
	private CallHandler getAvailableNextLevelHandler()
	{
		for(CallHandler handler:  nextLevelHandlers)
		{
			if(handler.isAvailable)
			{
				handler.setAvailable(false);
				return handler;
			}
		}
		return null;
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
