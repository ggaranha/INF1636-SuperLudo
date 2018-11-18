import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class gamePanel extends JPanel{
	
	private game mainGame;
	
	public gamePanel(game g)
	{
		mainGame = g;
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setBackground(Color.WHITE);
		
		displayBoard.paintBoard(g2d, mainGame.getGameBoard());
		
		displayPawns.paintPawns(g2d, mainGame.getGameBoard(), mainGame.getGamePlayers());
		
		
	}

}
