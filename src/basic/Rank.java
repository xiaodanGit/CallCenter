package basic;

public enum Rank 
{
	respondent(0), manager(1), director(2);
	int value;
	
	Rank(int value)
	{
		this.value = value;
	}
	
	public int getValue()
	{
		return value;
	}

}
