package basic;


public class Director extends Employee {

	public Director() 
	{
		this.rank = Rank.director;
	}

	@Override
	public void escalateCall() 
	{
		return;

	}

}
