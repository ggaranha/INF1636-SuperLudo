
public class player {
	
	private String playerName;
	private color playerColor;
	private pawn[] playerPawn;
	private tile playerExitTile;
	
	public player(String name, color color, tile exitTile)
	{
		int i;
		playerName = name;
		playerColor = color;
		playerExitTile = exitTile;
		
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
