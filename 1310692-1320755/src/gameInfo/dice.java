package gameInfo;

public class dice{
	
	private static dice instance;
	
	private int valueDice;
	private int consecutive6 = 0;
	private boolean enable = true;
	
	private dice()
	{
	}
	
	public static dice getInstance() {
		if(instance == null) {
			instance = new dice();
		}
		
		return instance;
	}
	
	public static void setInstanceNull() {
		instance = null;
	}
		
	public void setEnable(boolean e) {
		enable = e;
	}
	
	public boolean isEnable() {
		return enable;
	}
	
	public void setValueDice(int i)
	{
		if(i>0 || i<7)
		{
			valueDice=i;
		}
		else
		{
			valueDice = 1;
		}
	}
	
	public int getValueDice()
	{
		return valueDice;
	}
	
	public int getConsecutive6()
	{
		return consecutive6;
	}
	
	public void resetConsecutive6()
	{
		consecutive6 = 0;
	}
	
	public void setConsecutive6(int value)
	{
		consecutive6 = value;
	}
	
	public int roll() {
		
		valueDice = (int) (Math.random() * 6) + 1;
		
		if (valueDice == 6) {
			consecutive6++;
		}else {
			consecutive6 = 0;
		}
		
		return valueDice;
	}
	
}
