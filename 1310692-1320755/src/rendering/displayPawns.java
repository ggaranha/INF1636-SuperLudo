package rendering;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.*;

import gameInfo.tile;
import rules.game;
import gameInfo.board;

public class displayPawns {
	
	public static void paintPawns(Graphics2D g2d, game g)
	{
		int i, j;
		tile refTile;
		
		board b=g.getGameBoard();
		
		for(i=0;i<15;i++)
		{
			for(j=0;j<15;j++)
			{
				refTile = b.getTile(i, j);
				
				if(refTile.isTileEmpty())
				{
					continue;
				}
				
				if(refTile.getTilePawnCount() == 1)
				{
					g2d.setColor(refTile.getTileSinglePawn().getPawnColor());
					g2d.fill(new Ellipse2D.Double(refTile.getCoordX() + 7.5, refTile.getCoordY() + 7.5, 15, 15));
					g2d.setColor(Color.BLACK);
					g2d.draw(new Ellipse2D.Double(refTile.getCoordX() + 7.5, refTile.getCoordY() + 7.5, 15, 15));
				}
				
				else if(refTile.getPawnsColors().size() == 1)
				{
					g2d.setColor(refTile.getPawnsColors().get(0));
					g2d.fill(new Ellipse2D.Double(refTile.getCoordX() + 2.0, refTile.getCoordY() + 2.0, 26, 26));
					g2d.setColor(Color.WHITE);
					g2d.fill(new Ellipse2D.Double(refTile.getCoordX() + 4.0, refTile.getCoordY() + 4.0, 22, 22));
					g2d.setColor(refTile.getPawnsColors().get(0));
					g2d.fill(new Ellipse2D.Double(refTile.getCoordX() + 7.5, refTile.getCoordY() + 7.5, 15, 15));
					g2d.setColor(Color.BLACK);
					g2d.draw(new Ellipse2D.Double(refTile.getCoordX() + 2.0, refTile.getCoordY() + 2.0, 26, 26));
					
				}
				else
				{
					g2d.setColor(refTile.getPawnsColors().get(1));
					g2d.fill(new Ellipse2D.Double(refTile.getCoordX() + 4.0, refTile.getCoordY() + 4.0, 22, 22));
					g2d.setColor(refTile.getPawnsColors().get(0));
					g2d.fill(new Ellipse2D.Double(refTile.getCoordX() + 7.5, refTile.getCoordY() + 7.5, 15, 15));
					g2d.setColor(Color.BLACK);
					g2d.draw(new Ellipse2D.Double(refTile.getCoordX() + 4.0, refTile.getCoordY() + 4.0, 22, 22));
				}
			}
		}		
	}

}
