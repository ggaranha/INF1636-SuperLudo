import java.awt.Color;

public class player {
	
	private String playerName;
	private Color playerColor;
	private pawn[] playerPawn;
	private tile playerExitTile;
	private tile[] playerPawnBeginTile;
	
	public player(String name, Color c, board b, tile exitTile, int x, int y)
	{
		playerName = name;
		playerColor = c;
		playerExitTile = exitTile;
		playerPawn = new pawn[4];
		playerPawnBeginTile = new tile[4];
		
		playerPawn[0] = new pawn(playerColor, this, b.getTile(x + 1, y + 1));
		playerPawnBeginTile[0] = b.getTile(x + 1, y + 1);
		b.getTile(x + 1, y + 1).addTilePawn(playerPawn[0]);
		playerPawn[1] = new pawn(playerColor, this, b.getTile(x + 4, y + 1));
		playerPawnBeginTile[1] = b.getTile(x + 4, y + 1);
		b.getTile(x + 4, y + 1).addTilePawn(playerPawn[1]);
		playerPawn[2] = new pawn(playerColor, this, b.getTile(x + 1, y + 4));
		playerPawnBeginTile[2] = b.getTile(x + 1, y + 4);
		b.getTile(x + 1, y + 4).addTilePawn(playerPawn[2]);
		playerPawn[3] = new pawn(playerColor, this, b.getTile(x + 4, y + 4));
		playerPawnBeginTile[3] = b.getTile(x + 4, y + 4);
		b.getTile(x + 4, y + 4).addTilePawn(playerPawn[3]);
	}
	
	public boolean isPlayerPawn(pawn p)
	{
		if(p.getPawnPlayer() == this)
		{
			return true;
		}
		return false;
	}
	
	public boolean isPlayerBeginTile(tile t)
	{
		for(int i=0; i< 4; i++)
		{
			if(playerPawnBeginTile[i].equals(t))
			{
				return true;
			}
		}
		return false;
	}
	
	public pawn getPawnOnBeginTile()
	{
		if(playerExitTile.isTileEmpty())
		{
			return null;
		}
		
		for(int i=0; i<4; i++)
		{
			if(this.isPlayerBeginTile(this.getPlayerPawn(i).getPawnTile()))
			{
				return this.getPlayerPawn(i);
			}
		}
		
		return null;
	}
	
	public pawn getPlayerPawn(int n)
	{
		return playerPawn[n];
	}
	
	public tile getPlayerExitTile()
	{
		return playerExitTile;
	}
	
	public tile getPlayerPawnBeginTile(int n)
	{
		return playerPawnBeginTile[n];
	}
	
	public Color getPlayerColor()
	{
		return playerColor;
	}

}
