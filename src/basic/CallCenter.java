package basic;

import java.util.ArrayList;
import java.util.List;

public class CallCenter 
{
	private static final int NUM_OF_DIRECTOR = 2;
	private static final int NUM_OF_MANAGER = 4;
	private static final int NUM_OF_RESPONDENT = 10;
	private List<ArrayList<Employee>> employeeList;
	private static CallCenter center;
	
	
	private CallCenter()
	{
		this(NUM_OF_DIRECTOR, NUM_OF_MANAGER, NUM_OF_RESPONDENT);
	}
	
	private CallCenter(int numberOfDirector, int numberOfManager, int numberOfRespondent)
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

	public static CallCenter getInstance()
	{
		if(center == null)
		{
			center = new CallCenter();
		}
		return center;
	}

	
	

}
