import java.net.URL;
import java.applet.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class dice extends Applet{
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
		BufferedImage img = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
		Image img1 = null;
		Graphics g = img.getGraphics();
		URL url1 = getCodeBase();
		
		valueDice = (int) (Math.random() * 6) + 1;
		valueDice = 1;
		
		switch(valueDice) {
			
		case 1:
			img1 = getImage(url1, "img/Dado1.png");
		}
		
		g.drawImage(img1, 60, 120, null);
		
		return valueDice;
	}
	
}
