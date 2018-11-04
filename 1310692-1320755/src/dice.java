
public class dice {
	private int valueDice;
	
	public dice()
	{
		valueDice = 1;
	}
	
	public void setValueDice(int i)
	{
		if(i>0 || i<7)
		{
			valueDice=1;
		}
		else
		{
			
		}
	}
	
	public int getValueDice()
	{
		return valueDice;
	}
	
	public int roll() {
		valueDice = (int) (Math.random() * 6) + 1;
		return valueDice;
	}
	
}
