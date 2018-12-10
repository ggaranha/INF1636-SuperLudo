import java.awt.Color;
import java.util.Observable;

public class game extends Observable{
	/**
	 * 
	 */

	private board gameBoard;
	private dice gameDice;
	private player gamePlayers[];
	private player currentPlayer;
	
	public game()
	{
		resetGame();
	}
	
	public game(board b, player[] gp, dice d, int pIndex)
	{
		gameBoard = b;
		gameDice = d;
		
		gamePlayers = gp;
		
		currentPlayer = gamePlayers[pIndex];
	}
	
	public void resetGame()
	{
		gameBoard = new board();
		gameDice = new dice();
		
		gamePlayers = new player[4];
		gamePlayers[0] = new player("Vermelho", Color.RED, gameBoard, gameBoard.getTile(1, 6), 0, 0);
		gamePlayers[1] = new player("Verde", Color.GREEN, gameBoard, gameBoard.getTile(8, 1), 9, 0);
		gamePlayers[2] = new player("Amarelo", Color.YELLOW, gameBoard, gameBoard.getTile(13, 8), 9, 9);
		gamePlayers[3] = new player("Azul", Color.BLUE, gameBoard, gameBoard.getTile(6, 13), 0, 9);
		
		currentPlayer = gamePlayers[0];
		
		int pawnX = 0;
		int pawnY = 0;
		
		pawn p = currentPlayer.getPlayerPawn(0);
		
		if(currentPlayer.getPlayerColor() == Color.RED) {
			pawnX = p.redPawnXPath[1];
			pawnY = p.redPawnYPath[1];
		}else if(currentPlayer.getPlayerColor() == Color.GREEN) {
			pawnX = p.greenPawnXPath[1];
			pawnY = p.greenPawnYPath[1];
		}else if(currentPlayer.getPlayerColor() == Color.YELLOW) {
			pawnX = p.yellowPawnXPath[1];
			pawnY = p.yellowPawnYPath[1];
		}else if(currentPlayer.getPlayerColor() == Color.BLUE) {
			pawnX = p.bluePawnXPath[1];
			pawnY = p.bluePawnYPath[1];
		}
		
		p.setPawnWalkCount(1);
		
		p.getPawnTile().removeTilePawn(p);
		gameBoard.getTile(pawnX, pawnY).addTilePawn(p);
		currentPlayer.playerStarted();
	}
	
	public board getGameBoard()
	{
		return gameBoard;
	}
	
	public dice getGameDice()
	{
		return gameDice;
	}
	
	public player getCurrentPlayer()
	{
		return currentPlayer;
	}
	
	public player getPlayerByIndex(int i)
	{
		return gamePlayers[i];
	}
	
	public player[] getGamePlayers()
	{
		return gamePlayers;
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
	
	public int getPlayerIndex()
	{
		for(int i=0;i<4;i++)
		{
			if(currentPlayer==gamePlayers[i])
			{
				return i;
			}
		}
		
		return -1;
		
	}
	
	public int getColorIndex(Color c)
	{
		for(int i=0;i<4;i++)
		{
			if(c==gamePlayers[i].getPlayerColor())
			{
				return i;
			}
		}
		
		return -1;
		
	}
	
	public void setChanged()
	{
		super.setChanged();
	}
	
}
