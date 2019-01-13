package rendering;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import gameInfo.tile;
import controller.boardMouseListener;
import rules.game;

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
	private tile refTile;
	
	private gamePanel()
	{
		super();

		setBackground(Color.white);
		setForeground(Color.white);

		mainGame = game.getInstance();
		
		mainGame.addObserver(this);
		this.addMouseListener(new boardMouseListener());
	}
	
	public static gamePanel getInstance() {
		if(instance == null) {
			instance = new gamePanel();
		}
		
		return instance;
	}
	
	public static void setInstanceNull() {
		instance = null;
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
