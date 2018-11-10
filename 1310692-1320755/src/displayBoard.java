/**

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class displayBoard{
	
	public displayBoard()
	{
		
	}
	
	public void paintBoard(Graphics2D g, board b)
	{
		int i,j;
		tile refTile;
		for(i=0;i<15;i++)
		{
			for(j=0;j<15;j++)
			{
				refTile= b.getTile(i, j);
				g.setColor(Color.GREEN);
				g.draw(new Rectangle2D.Double(refTile.getCoordX(), refTile.getCoordY(), 30, 30));
			}
		}
	}
	
}

*/
