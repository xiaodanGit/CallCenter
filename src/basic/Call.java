package basic;

public class Call 
{
	Rank rank;
	String caller;
	
	public Call(String caller)
	{
		this.caller = caller;
		this.rank = Rank.respondent;
	}
	
	public void setRank(Rank rank)
	{
		this.rank = rank;
	}
	
	public Rank getRank()
	{
		return rank;
	}

}
