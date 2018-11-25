import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
		
		
	}
	
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
