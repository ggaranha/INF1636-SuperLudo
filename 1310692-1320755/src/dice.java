import java.net.URL;
import java.applet.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class dice{
	private int valueDice;
	
	private int consecutive6 = 0;
	
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
			valueDice = i;
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
		
		if (valueDice == 6)
			consecutive6++;
		
		return valueDice;
	}
	
}
