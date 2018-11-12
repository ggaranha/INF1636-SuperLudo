import java.awt.*;
import java.awt.geom.*;

public class displayBoard{
	
	public static void paintBoard(Graphics2D g2d, board b)
	{
		int i,j;
		tile refTile;
		for(i=0;i<15;i++)
		{
			for(j=0;j<15;j++)
			{
				refTile= b.getTile(i, j);
				g2d.setColor(refTile.getTileColor());
				g2d.setBackground(refTile.getTileColor());
				g2d.fill(new Rectangle2D.Double(refTile.getCoordX(), refTile.getCoordY(), 30, 30));
				//g2d.setColor(Color.BLACK);
				//g2d.draw(new Rectangle2D.Double(refTile.getCoordX(), refTile.getCoordY(), 30, 30));
				
			}
		}
		
		for(i=6;i<9;i++)
		{
			for(j=0;j<15;j++)
			{
				refTile= b.getTile(i, j);
				g2d.setColor(Color.BLACK);
				g2d.draw(new Rectangle2D.Double(refTile.getCoordX(), refTile.getCoordY(), 30, 30));
			}
		}
		
		for(i=0;i<15;i++)
		{
			for(j=6;j<9;j++)
			{
				refTile= b.getTile(i, j);
				g2d.setColor(Color.BLACK);
				g2d.draw(new Rectangle2D.Double(refTile.getCoordX(), refTile.getCoordY(), 30, 30));
			}
		}
		
		refTile= b.getTile(0, 0);
		g2d.draw(new Rectangle2D.Double(refTile.getCoordX(), refTile.getCoordY(), 180, 180));
		refTile= b.getTile(0, 9);
		g2d.draw(new Rectangle2D.Double(refTile.getCoordX(), refTile.getCoordY(), 180, 180));
		refTile= b.getTile(9, 0);
		g2d.draw(new Rectangle2D.Double(refTile.getCoordX(), refTile.getCoordY(), 180, 180));
		refTile= b.getTile(9, 9);
		g2d.draw(new Rectangle2D.Double(refTile.getCoordX(), refTile.getCoordY(), 180, 180));
		
		paintHouseCircles(g2d, b, 0, 0);
		paintHouseCircles(g2d, b, 0, 9);
		paintHouseCircles(g2d, b, 9, 0);
		paintHouseCircles(g2d, b, 9, 9);
		
		/**for(i=6;i<9;i++)
		{
			for(j=0;j<15;j++)
			{
				refTile= b.getTile(i, j);
				g2d.setColor(Color.BLACK);
				g2d.draw(new Rectangle2D.Double(refTile.getCoordX(), refTile.getCoordY(), 30, 30));
			}
		}
		
		for(i=0;i<15;i++)
		{
			for(j=6;j<9;j++)
			{
				refTile= b.getTile(i, j);
				g2d.setColor(Color.BLACK);
				g2d.draw(new Rectangle2D.Double(refTile.getCoordX(), refTile.getCoordY(), 30, 30));
			}
		}
		
		refTile= b.getTile(0, 0);
		g2d.draw(new Rectangle2D.Double(refTile.getCoordX(), refTile.getCoordY(), 180, 180));
		refTile= b.getTile(0, 9);
		g2d.draw(new Rectangle2D.Double(refTile.getCoordX(), refTile.getCoordY(), 180, 180));
		refTile= b.getTile(9, 0);
		g2d.draw(new Rectangle2D.Double(refTile.getCoordX(), refTile.getCoordY(), 180, 180));
		refTile= b.getTile(9, 9);
		g2d.draw(new Rectangle2D.Double(refTile.getCoordX(), refTile.getCoordY(), 180, 180));
		*/
	}
	
	private static void paintHouseCircles(Graphics2D g2d, board b, int x, int y)
	{
		tile refTile;
		g2d.setColor(Color.WHITE);
		refTile= b.getTile(x+1, y+1);
		g2d.fill(new Ellipse2D.Double(refTile.getCoordX(), refTile.getCoordY(), 30, 30));
		refTile= b.getTile(x+4, y+1);
		g2d.fill(new Ellipse2D.Double(refTile.getCoordX(), refTile.getCoordY(), 30, 30));
		refTile= b.getTile(x+1, y+4);
		g2d.fill(new Ellipse2D.Double(refTile.getCoordX(), refTile.getCoordY(), 30, 30));
		refTile= b.getTile(x+4, y+4);
		g2d.fill(new Ellipse2D.Double(refTile.getCoordX(), refTile.getCoordY(), 30, 30));
		g2d.setColor(Color.BLACK);
		refTile= b.getTile(x+1, y+1);
		g2d.draw(new Ellipse2D.Double(refTile.getCoordX(), refTile.getCoordY(), 30, 30));
		refTile= b.getTile(x+4, y+1);
		g2d.draw(new Ellipse2D.Double(refTile.getCoordX(), refTile.getCoordY(), 30, 30));
		refTile= b.getTile(x+1, y+4);
		g2d.draw(new Ellipse2D.Double(refTile.getCoordX(), refTile.getCoordY(), 30, 30));
		refTile= b.getTile(x+4, y+4);
		g2d.draw(new Ellipse2D.Double(refTile.getCoordX(), refTile.getCoordY(), 30, 30));
	}
	
}
