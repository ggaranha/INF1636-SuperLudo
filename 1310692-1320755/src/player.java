import java.awt.Color;

public class player {
	
	private String playerName;
	private Color playerColor;
	private pawn[] playerPawn;
	private tile playerExitTile;
	
	public player(String name, Color c, tile exitTile)
	{
		int i;
		playerName = name;
		playerColor = c;
		playerExitTile = exitTile;
		playerPawn = new pawn[4];
		
		for(i=0;i<4;i++)
		{
			playerPawn[i] = new pawn(playerColor, this);
		}
	}
	
	public boolean isPlayerPawn(pawn p)
	{
		if(p.getPawnPlayer() == this)
		{
			return true;
		}
		return false;
	}

}
