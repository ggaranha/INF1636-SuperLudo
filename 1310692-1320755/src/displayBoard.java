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
		
		paintExitHouse(g2d, b);
		
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
	
	private static void paintExitHouse(Graphics2D g2d, board b)
	{
		int xMiddle;
		int yMiddle;
		tile refTile;
		
		refTile= b.getTile(7, 7);
		xMiddle = (int)refTile.getCoordX() + 15;
		yMiddle = (int)refTile.getCoordY() + 15;
		
		int redPointsX[] = {(int)b.getTile(6, 6).getCoordX(), (int)b.getTile(6, 9).getCoordX(), xMiddle};
		int redPointsY[] = {(int)b.getTile(6, 6).getCoordY(), (int)b.getTile(6, 9).getCoordY(), yMiddle};
		
		int bluePointsX[] = {(int)b.getTile(6, 9).getCoordX(), (int)b.getTile(9, 9).getCoordX(), xMiddle};
		int bluePointsY[] = {(int)b.getTile(6, 9).getCoordY(), (int)b.getTile(9, 9).getCoordY(), yMiddle};
		
		int greenPointsX[] = {(int)b.getTile(6, 6).getCoordX(), (int)b.getTile(9, 6).getCoordX(), xMiddle};
		int greenPointsY[] = {(int)b.getTile(6, 6).getCoordY(), (int)b.getTile(9, 6).getCoordY(), yMiddle};
		
		int yellowPointsX[] = {(int)b.getTile(9, 6).getCoordX(), (int)b.getTile(9, 9).getCoordX(), xMiddle};
		int yellowPointsY[] = {(int)b.getTile(9, 6).getCoordY(), (int)b.getTile(9, 9).getCoordY(), yMiddle};
		
		g2d.setColor(Color.RED);
		g2d.fillPolygon(redPointsX, redPointsY, 3);
		g2d.setColor(Color.BLUE);
		g2d.fillPolygon(bluePointsX, bluePointsY, 3);
		g2d.setColor(Color.GREEN);
		g2d.fillPolygon(greenPointsX, greenPointsY, 3);
		g2d.setColor(Color.YELLOW);
		g2d.fillPolygon(yellowPointsX, yellowPointsY, 3);
		
		g2d.setColor(Color.BLACK);
		g2d.drawPolygon(redPointsX, redPointsY, 3);
		g2d.drawPolygon(bluePointsX, bluePointsY, 3);
		g2d.drawPolygon(greenPointsX, greenPointsY, 3);
		g2d.drawPolygon(yellowPointsX, yellowPointsY, 3);
		
	}
	
}
