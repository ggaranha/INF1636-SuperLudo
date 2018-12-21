package gameInfo;
import java.awt.Color;
import java.util.*;

public class tile {
	
	private int posX;
	private int posY;
	private Color tileColor;
	private ArrayList<pawn> tilePawns;
	private int tileType;
	
	public tile(int x, int y)
	{
		posX = x;
		posY = y;
		tilePawns = new ArrayList();
	}
	
	public tile(int x, int y, Color c)
	{
		posX = x;
		posY = y;
		tileColor = c;
		tilePawns = new ArrayList();
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
		 * 3 - Reta final
		 * 4 - Barreira
		 * 5 - Casa de saída
		 * 6 - Casa final
		 * 7 - Casa indisponível
		 */
		tileType = n;
	}
	
	public int getTileType()
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
	
	public void addTilePawn(pawn p)
	{
		tilePawns.add(p);
		p.setPawnTile(this);
	}
	
	public pawn removeTilePawn(Color c)
	{
		for (int i = 0; i < tilePawns.size(); i++)
		{
			pawn pawnRef = tilePawns.get(i);

			if (pawnRef.getPawnColor() == c)
			{
				tilePawns.remove(pawnRef);
				return pawnRef;
			}
		}
		
		return null;
	}
	
	public pawn removeTilePawn(pawn p)
	{
		for (int i = 0; i < tilePawns.size(); i++)
		{
			pawn pawnRef = tilePawns.get(i);

			if (pawnRef == p)
			{
				tilePawns.remove(pawnRef);
				return pawnRef;
			}
		}
		
		return null;
	}
	
	public int getPawnCountByColor(Color c)
	{
		int count = 0;

		for (int i = 0; i < tilePawns.size(); i++)
		{
			if (tilePawns.get(i).getPawnColor() == c)
			{
				count++;
			}
		}

		return count;
	}
	
	public pawn getTileSinglePawn()
	{
		if(tilePawns.size() == 1)
		{
			return tilePawns.get(0);
		}
		
		return null;
	}
	
	public int getTilePawnCount()
	{
		return tilePawns.size();
	}
	
	public boolean isTileEmpty()
	{
		if(tilePawns.isEmpty())
		{
			return true;
		}
		return false;
	}
	
	public List<Color> getPawnsColors()
	{
		List<Color> colors = new ArrayList<Color>();

		tilePawns.forEach(pawnRef ->
		{
			Color c = pawnRef.getPawnColor();

			if (!colors.contains(c))
			{
				colors.add(c);
			}
		});

		return colors;
	}
}
