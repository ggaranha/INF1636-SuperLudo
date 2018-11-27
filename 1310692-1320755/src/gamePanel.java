import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;

import java.util.List;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class gamePanel extends JPanel implements Observer{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7879897766817219004L;

	private static gamePanel instance = null;
	
	private game mainGame;
	
	private tile refTile;
	private pawn refPawn;
	
	public gamePanel(game g)
	{
		super();
		
		instance = this;

		setBackground(Color.white);
		setForeground(Color.white);

		mainGame = g;
		mainGame.addObserver(this);

		this.addMouseListener(new boardMouseListener(notifications.getInstance(mainGame)));
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setBackground(Color.WHITE);
		
		displayBoard.paintBoard(g2d, mainGame.getGameBoard());
		
		displayPawns.paintPawns(g2d, mainGame.getGameBoard(), mainGame.getGamePlayers());
		
		if(refTile != null)
		{
			g2d.setColor(Color.BLACK);
			g2d.draw(new Rectangle2D.Double(refTile.getCoordX(), refTile.getCoordY(), 30, 30));
		}
		
		
	}
	
	private class boardMouseListener implements MouseListener {
		
		
		public boardMouseListener(notificationsManager nManager)
		{
			
		}

		@Override
		public void mouseClicked(MouseEvent e)
		{
			
		}

		@Override
		public void mouseEntered(MouseEvent e)
		{

		}

		@Override
		public void mouseExited(MouseEvent e)
		{

		}

		@Override
		public void mousePressed(MouseEvent e)
		{

		}

		@Override
		public void mouseReleased(MouseEvent e)
		{
			int x = (int) (e.getX() / 30);
			int y = (int) (e.getY() / 30);

			try {
				refTile = mainGame.getGameBoard().getTile(x, y);
				
			} catch (Exception ex) {

			}
			
			refresh();
		}
	}
	
	/**private void teleport()
	{
		if(refPawn==null)
		{
			if(refTile.)
		}
	}*/
	
	private void refresh() {
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
			notifications.getInstance(null).notifyError(e.getMessage());
		}
	}
	

	@Override
	public void update(Observable o, Object arg) {
		refresh();
	}

}
