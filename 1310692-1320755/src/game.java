import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class game extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2821674216135980312L;
	
	private board gameBoard;
	private dice gameDice;
	private player gamePlayers[];
	
	
	public game(JPanel j)
	{
		gameBoard = new board();
		gameDice = new dice();
		j.setLayout(new BorderLayout());
		gamePlayers = new player[4];
		gamePlayers[0] = new player("Vermelho", Color.RED, gameBoard.getTile(1, 6));
		gamePlayers[1] = new player("Verde", Color.GREEN, gameBoard.getTile(8, 1));
		gamePlayers[2] = new player("Azul", Color.BLUE, gameBoard.getTile(6, 13));
		gamePlayers[3] = new player("Amarelo", Color.YELLOW, gameBoard.getTile(13, 8));
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setBackground(Color.WHITE);
		
		int i,j;
		tile refTile;
		for(i=0;i<15;i++)
		{
			for(j=0;j<15;j++)
			{
				refTile= gameBoard.getTile(i, j);
				g2d.setColor(refTile.getTileColor());
				g2d.setBackground(refTile.getTileColor());
				g2d.fill(new Rectangle2D.Double(refTile.getCoordX(), refTile.getCoordY(), 30, 30));
				g2d.setColor(Color.BLACK);
				g2d.draw(new Rectangle2D.Double(refTile.getCoordX(), refTile.getCoordY(), 30, 30));
			}
		}
		
		/**for(i=6;i<9;i++)
		{
			for(j=0;j<15;j++)
			{
				refTile= gameBoard.getTile(i, j);
				g2d.setColor(Color.BLACK);
				g2d.draw(new Rectangle2D.Double(refTile.getCoordX(), refTile.getCoordY(), 30, 30));
			}
		}
		
		for(i=0;i<15;i++)
		{
			for(j=6;j<9;j++)
			{
				refTile= gameBoard.getTile(i, j);
				g2d.setColor(Color.BLACK);
				g2d.draw(new Rectangle2D.Double(refTile.getCoordX(), refTile.getCoordY(), 30, 30));
			}
		}*/
	}
	
}
