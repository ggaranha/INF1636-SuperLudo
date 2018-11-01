
public class tile {
	
	private int posX;
	private int posY;
	private color tileColor;
	private pawn tilePawn;
	
	public tile(int x, int y)
	{
		posX = x;
		posY = y;
	}
	
	public tile(int x, int y, color c)
	{
		posX = x;
		posY = y;
		tileColor = c;
	}
	
	public void setTileColor(color c)
	{
		tileColor = c;
	}
	
	public void setTileColorName(String n)
	{
		tileColor = new color(n);
	}
	
	public int getPosX()
	{
		return posX;
	}
	
	public int getPosY()
	{
		return posY;
	}
	
	public color getTileColor()
	{
		return tileColor;
	}
	
	public boolean isTileEmpty()
	{
		if(tilePawn == null)
		{
			return true;
		}
		return false;
	}

}
