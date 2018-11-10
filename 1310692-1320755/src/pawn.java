import java.awt.Color;

public class pawn {
	
	private Color pawnColor;
	private player pawnPlayer;
	private tile pawnTile;
	
	public pawn(Color c, player p, tile t)
	{
		pawnColor = c;
		pawnPlayer = p;
		pawnTile = t;
	}
	
	public Color getPawnColor()
	{
		return pawnColor;
	}
	
	public player getPawnPlayer()
	{
		return pawnPlayer;
	}
	
	public tile getPawnTile()
	{
		return pawnTile;
	}
}
