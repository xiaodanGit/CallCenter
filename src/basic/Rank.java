package basic;

public enum Rank 
{
	handler(-1), respondent(0), manager(1), director(2);
	int value;
	
	Rank(int value)
	{
		this.value = value;
	}
	
	public int getValue()
	{
		return value;
	}
	
	public static Rank getRankFromNumber(int num)
	{
		if(num == -1)
		{
			return Rank.handler;
		}
		else if(num == 0)
		{
			return Rank.respondent;
		}
		else if(num == 1)
		{
			return Rank.manager;
		}
		else
		{
			return Rank.director;
		}
	}

}
