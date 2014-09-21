package basic;

import java.util.ArrayList;
import java.util.List;


public class CallHandler 
{
	
	private List<ArrayList<Employee>> employeeList;
	private static CallHandler handler;
	
	private static final int NUM_OF_DIRECTOR = 2;
	private static final int NUM_OF_MANAGER = 4;
	private static final int NUM_OF_RESPONDENT = 10;
	
	private CallHandler()
	{
		this(NUM_OF_DIRECTOR, NUM_OF_MANAGER, NUM_OF_RESPONDENT);
	}
	
	private CallHandler(int numberOfDirector, int numberOfManager, int numberOfRespondent)
	{
		employeeList = new ArrayList<ArrayList<Employee>>();
		for(int i = 0; i < numberOfDirector; i ++)
		{
			employeeList.get(Rank.director.value).add(new Director());
		}
		for(int i = 0; i < numberOfManager; i ++)
		{
			employeeList.get(Rank.manager.value).add(new Manager());
		}
		for(int i = 0; i < numberOfRespondent; i ++)
		{
			employeeList.get(Rank.respondent.value).add(new Respondent());
		}
	}
	
	public static CallHandler getInstance()
	{
		if(handler == null)
		{
			handler = new CallHandler();
		}
		return handler;
	}
	
	public void handle(String caller)
	{
		Call call = new Call(caller);
	}
	
	public Employee getAvailableEmployee(Call call)
	{
		int rank = call.getRank().getValue();
		ArrayList<Employee> 
	}
	
}
