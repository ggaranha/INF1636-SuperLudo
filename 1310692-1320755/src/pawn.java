import java.awt.Color;

public class pawn {
	
	private Color pawnColor;
	private player pawnPlayer;
	
	public pawn(Color c, player p)
	{
		pawnColor = c;
		pawnPlayer = p;
	}
	
	public Color getPawnColor()
	{
		return pawnColor;
	}
	
	public player getPawnPlayer()
	{
		return pawnPlayer;
	}
}
