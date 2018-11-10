import java.awt.Graphics2D;
import java.awt.geom.*;

public class displayPawns {
	
	public static void paintPawns(Graphics2D g2d, board b, player[] p)
	{
		int i, j;
		tile refTile;
		
		for(i=0;i<4;i++)
		{
			g2d.setColor(p[i].getPlayerColor());			
			for(j=0;j<4;j++)
			{
				refTile = p[i].getPlayerPawn(j).getPawnTile();
				g2d.fill(new Ellipse2D.Double(refTile.getCoordX() + 7.5, refTile.getCoordY() + 7.5, 15, 15));
			}
		}
	}

}
