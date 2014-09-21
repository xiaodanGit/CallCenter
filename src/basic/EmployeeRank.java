package basic;

public enum EmployeeRank 
{
	respondent(0), manager(1), director(2);
	int value;
	
	EmployeeRank(int value)
	{
		this.value = value;
	}
	
	public int getValue()
	{
		return value;
	}

}
