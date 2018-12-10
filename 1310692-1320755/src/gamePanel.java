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

public class gamePanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7879897766817219004L;

	private static gamePanel instance = null;
	
	private game mainGame;
	
	private menu menuGame;
	
	private tile refTile;
	private pawn refPawn;
	
	public gamePanel(game g, menu m)
	{
		super();
		
		instance = this;

		setBackground(Color.white);
		setForeground(Color.white);

		mainGame = g;
		menuGame = m;

		this.addMouseListener(new boardMouseListener());
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
			g2d.setColor(Color.ORANGE);
			g2d.draw(new Rectangle2D.Double(refTile.getCoordX(), refTile.getCoordY(), 30, 30));
		}
		
		
	}
	
	private class boardMouseListener implements MouseListener {
		
		
		public boardMouseListener()
		{
			
		}

		@Override
		public void mouseClicked(MouseEvent e)
		{
			int x = (int) (e.getX() / 30);
			int y = (int) (e.getY() / 30);

			try {
				refTile = mainGame.getGameBoard().getTile(x, y);
				
				System.out.printf("x: %d, y: %d \n", refTile.getPosX(), refTile.getPosY());
				
				
				if(!refTile.isTileEmpty() && !mainGame.getGameDice().isEnable()) {
					
					refPawn = refTile.removeTilePawn(mainGame.getCurrentPlayer().getPlayerColor());
					
					System.out.printf("Pawn: x: %d, y: %d, Qtd Walk: %d \n", refPawn.getPawnTile().getPosX(), refPawn.getPawnTile().getPosY(), refPawn.getPawnWalkCount());
							
					refPawn.setPawnWalkCount(refPawn.getPawnWalkCount() + mainGame.getGameDice().getValueDice());
					
					System.out.printf("Dice: %d, New Qtd Walk: %d \n", mainGame.getGameDice().getValueDice(), refPawn.getPawnWalkCount());
					
					int pawnX = 0;
					int pawnY = 0;
					
					if(refPawn.getPawnColor() == Color.RED) {
						pawnX = refPawn.redPawnXPath[refPawn.getPawnWalkCount()];
						pawnY = refPawn.redPawnYPath[refPawn.getPawnWalkCount()];
					}else if(refPawn.getPawnColor() == Color.GREEN) {
						pawnX = refPawn.greenPawnXPath[refPawn.getPawnWalkCount()];
						pawnY = refPawn.greenPawnYPath[refPawn.getPawnWalkCount()];
					}else if(refPawn.getPawnColor() == Color.YELLOW) {
						pawnX = refPawn.yellowPawnXPath[refPawn.getPawnWalkCount()];
						pawnY = refPawn.yellowPawnYPath[refPawn.getPawnWalkCount()];
					}else if(refPawn.getPawnColor() == Color.BLUE) {
						pawnX = refPawn.bluePawnXPath[refPawn.getPawnWalkCount()];
						pawnY = refPawn.bluePawnYPath[refPawn.getPawnWalkCount()];
					}
					
				
					tile newTilePawn = mainGame.getGameBoard().getTile(pawnX, pawnY);
					newTilePawn.addTilePawn(refPawn);
					refPawn.setPawnTile(newTilePawn);
					
					menuGame.setDiceEnable(true);
					
					mainGame.nextPlayer();
					
					System.out.printf("New Tile: Tile: x: %d, y: %d  /  Pawn: x: %d, y: %d \n", newTilePawn.getPosX(), newTilePawn.getPosY(), refPawn.getPawnTile().getPosX(), refPawn.getPawnTile().getPosY());
				}
				
			} catch (Exception ex) {

			}
			
			refresh();
			
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
			
		}
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
		}
	}

}
