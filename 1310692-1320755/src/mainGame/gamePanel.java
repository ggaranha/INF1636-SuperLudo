package mainGame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import gameInfo.tile;

import rendering.displayBoard;
import rendering.displayPawns;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class gamePanel extends JPanel implements Observer{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7879897766817219004L;

	private static gamePanel instance = null;
	
	private game mainGame;
	private menu menuGame;
	private tile refTile;
	
	public gamePanel(game g, menu m)
	{
		super();
		
		instance = this;

		setBackground(Color.white);
		setForeground(Color.white);

		mainGame = g;
		menuGame = m;
		
		mainGame.addObserver(this);
		this.addMouseListener(boardMouseListener.getInstance(mainGame, menuGame, refTile, instance));
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setBackground(Color.WHITE);
		
		displayBoard.paintBoard(g2d, mainGame);	
		displayPawns.paintPawns(g2d, mainGame);
		
		if(refTile != null)
		{
			g2d.setColor(Color.ORANGE);
			g2d.draw(new Rectangle2D.Double(refTile.getCoordX(), refTile.getCoordY(), 30, 30));
		}
		
		
	}
	
	public void refresh() {
		try {
			if (instance != null)
			{
				instance.repaint();
			}
			else
			{
				throw new Exception("Erro ao renderizar mapa");
			}
		} catch (Exception e) {
		}
	}
	
	@Override
	public void update(Observable o, Object arg) {
		refresh();
	}
}
