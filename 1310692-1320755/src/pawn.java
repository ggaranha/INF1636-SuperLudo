import java.awt.Color;

public class pawn {
	
	private Color pawnColor;
	private player pawnPlayer;
	private tile pawnTile;
	private int pawnWalkCount;
	
	public int[] redPawnXPath = {-1,1,2,3,4,5,6,6,6,6,6,6,7,8,8,8,8,8,8,9,10,11,12,13,14,14,14,13,12,11,10,9,8,8,8,8,8,8,7,6,6,6,6,6,6,5,4,3,2,1,0,0,1,2,3,4,5,6};
	public int[] redPawnYPath = {-1,6,6,6,6,6,5,4,3,2,1,0,0,0,1,2,3,4,5,6,6,6,6,6,6,7,8,8,8,8,8,8,9,10,11,12,13,14,14,14,13,12,11,10,9,8,8,8,8,8,8,7,7,7,7,7,7,7};
	
	public int[] greenPawnXPath = {-1,8,8,8,8,8,9,10,11,12,13,14,14,14,13,12,11,10,9,8,8,8,8,8,8,7,6,6,6,6,6,6,5,4,3,2,1,0,0,0,1,2,3,4,5,6,6,6,6,6,6,7,7,7,7,7,7,7};
	public int[] greenPawnYPath = {-1,1,2,3,4,5,6,6,6,6,6,6,7,8,8,8,8,8,8,9,10,11,12,13,14,14,14,13,12,11,10,9,8,8,8,8,8,8,7,6,6,6,6,6,6,5,4,3,2,1,0,0,1,2,3,4,5,6};
	
	public int[] yellowPawnXPath = {-1,13,12,11,10,9,8,8,8,8,8,8,7,6,6,6,6,6,6,5,4,3,2,1,0,0,0,1,2,3,4,5,6,6,6,6,6,6,7,8,8,8,8,8,8,9,10,11,12,13,14,14,13,12,11,10,9,8};
	public int[] yellowPawnYPath = {-1,8,8,8,8,8,9,10,11,12,13,14,14,14,13,12,11,10,9,8,8,8,8,8,8,7,6,6,6,6,6,6,5,4,3,2,1,0,0,0,1,2,3,4,5,6,6,6,6,6,6,7,7,7,7,7,7,7};
	
	public int[] bluePawnXPath = {-1,6,6,6,6,6,5,4,3,2,1,0,0,0,1,2,3,4,5,6,6,6,6,6,6,7,8,8,8,8,8,8,9,10,11,12,13,14,14,14,13,12,11,10,9,8,8,8,8,8,8,7,7,7,7,7,7,7};
	public int[] bluePawnYPath = {-1,13,12,11,10,9,8,8,8,8,8,8,7,6,6,6,6,6,6,5,4,3,2,1,0,0,0,1,2,3,4,5,6,6,6,6,6,6,7,8,8,8,8,8,8,9,10,11,12,13,14,14,14,13,12,11,10,9,8};
	
	public pawn()
	{
		
	}
	
	public pawn(Color c, player p, tile t)
	{
		pawnColor = c;
		pawnPlayer = p;
		pawnTile = t;
		pawnWalkCount = 0;
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
	
	public int getPawnWalkCount()
	{
		return pawnWalkCount;
	}
	
	public void setPawnWalkCount(int walk)
	{
		pawnWalkCount = walk;
	}
	
	public void setPawnTile(tile t)
	{
		pawnTile = t;
	}
}
