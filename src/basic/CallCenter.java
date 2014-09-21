package basic;

import java.util.ArrayList;
import java.util.List;

public class CallCenter 
{
	private static final int NUM_OF_DIRECTOR = 2;
	private static final int NUM_OF_MANAGER = 4;
	private static final int NUM_OF_RESPONDENT = 10;
	private List<ArrayList<CallHandler>> handlerList;
	private CallHandler superHandler;
	private static CallCenter center;
	
	
	private CallCenter()
	{
		this(NUM_OF_DIRECTOR, NUM_OF_MANAGER, NUM_OF_RESPONDENT);
	}
	
	private CallCenter(int numberOfDirector, int numberOfManager, int numberOfRespondent)
	{
		superHandler = new CallHandler();
		handlerList = new ArrayList<ArrayList<CallHandler>>();
		for(int i = 0; i < numberOfDirector; i ++)
		{
			handlerList.get(Rank.director.value).add(new Director());
		}
		for(int i = 0; i < numberOfManager; i ++)
		{
			handlerList.get(Rank.manager.value).add(new Manager());
		}
		for(int i = 0; i < numberOfRespondent; i ++)
		{
			handlerList.get(Rank.respondent.value).add(new Respondent());
		}
		
		//set the chain relationship
		superHandler.setNextLevelHandlers(handlerList.get(0));
		for(CallHandler cur : handlerList.get(Rank.respondent.value))
		{
			cur.setNextLevelHandlers(handlerList.get(Rank.manager.value));
		}
		for(CallHandler cur : handlerList.get(Rank.manager.value))
		{
			cur.setNextLevelHandlers(handlerList.get(Rank.director.value));
		}
		
	}

	public static CallCenter getInstance()
	{
		if(center == null)
		{
			center = new CallCenter();
		}
		return center;
	}	
	
	public void handle(String caller)
	{
		Call call = new Call(caller);
		
	}

}
