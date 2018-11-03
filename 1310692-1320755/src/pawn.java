
public class pawn {
	
	private color pawnColor;
	private player pawnPlayer;
	
	public pawn(color c, player p)
	{
		pawnColor = c;
		pawnPlayer = p;
	}
	
	public color getPawnColor()
	{
		return pawnColor;
	}
	
	public player getPawnPlayer()
	{
		return pawnPlayer;
	}
}
