import java.awt.Color;

public class tile {
	
	private int posX;
	private int posY;
	private Color tileColor;
	private pawn tilePawn;
	private int tileType;
	
	public tile(int x, int y)
	{
		posX = x;
		posY = y;
	}
	
	public tile(int x, int y, Color c)
	{
		posX = x;
		posY = y;
		tileColor = c;
	}
	
	public void setTileColor(Color c)
	{
		tileColor = c;
	}
	
	public void setTileColorName(String n)
	{
		tileColor = Color.getColor(n);
	}
	
	public void setTileType(int n)
	{
		/**
		 * Tipos:
		 * 0 - Casa comum
		 * 1 - Abrigo
		 * 2 - Casa inicial
		 * 3 - Barreira
		 * 4 - Casa de saída
		 * 5 - Casa final
		 */
		tileType = n;
	}
	
	public int getTileType(int n)
	{
		return tileType;
	}
	
	public int getPosX()
	{
		return posX;
	}
	
	public int getPosY()
	{
		return posY;
	}
	
	public double getCoordX()
	{
		return (double)posX*30.0;
	}
	
	public double getCoordY()
	{
		return (double)posY*30.0;
	}
	
	public Color getTileColor()
	{
		return tileColor;
	}
	
	public void setTilePawn(pawn p)
	{
		tilePawn = p;
	}
	
	public pawn getTilePawn()
	{
		return tilePawn;
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
