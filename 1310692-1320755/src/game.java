import javax.swing.*;


import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.Observable;

public class game extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2821674216135980312L;
	
	private board gameBoard;
	private dice gameDice;
	private player gamePlayers[];
	private player currentPlayer;
	
	
	public game()
	{
		gameBoard = new board();
		gameDice = new dice();
		
		gamePlayers = new player[4];
		gamePlayers[0] = new player("Vermelho", Color.RED, gameBoard, gameBoard.getTile(1, 6), 0, 0);
		gamePlayers[1] = new player("Verde", Color.GREEN, gameBoard, gameBoard.getTile(8, 1), 9, 0);
		gamePlayers[2] = new player("Amarelo", Color.YELLOW, gameBoard, gameBoard.getTile(13, 8), 9, 9);
		gamePlayers[3] = new player("Azul", Color.BLUE, gameBoard, gameBoard.getTile(6, 13), 0, 9);
		
		currentPlayer = gamePlayers[0];
	}
	
	public void nextPlayer()
	{
		int i = 0;
		
		while(!currentPlayer.equals(gamePlayers[i]))
		{
			i++;
		}
		
		if(i==3)
		{
			currentPlayer = gamePlayers[0];
		}
		else
		{
			currentPlayer = gamePlayers[i+1];
		}
	}
	
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setBackground(Color.WHITE);
		
		displayBoard.paintBoard(g2d, gameBoard);
		
		displayPawns.paintPawns(g2d, gameBoard, gamePlayers);
		
		
	}
	
	
}
