
public class board {
	
	private tile[][] tileMap;
	
	public board()
	{
		newBoard();
		
		
	}
	
	private void newBoard()
	{
		int i,j;
		
		//initializing new board
		for(i=0;i<15;i++)
		{
			for(j=0;j<15;j++)
			{
				tileMap[i][j] = new tile(i,j, new color("white"));
			}
		}
		
		//setting colors for colored spaces
		for(i=0;i<6;i++)
		{
			for(j=0;j<6;j++)
			{
				tileMap[i][j].setTileColorName("blue");
			}
		}
		
		for(i=0;i<6;i++)
		{
			for(j=9;j<15;j++)
			{
				tileMap[i][j].setTileColorName("red");
			}
		}
		
		for(i=9;i<15;i++)
		{
			for(j=0;j<6;j++)
			{
				tileMap[i][j].setTileColorName("yellow");
			}
		}
		
		for(i=9;i<15;i++)
		{
			for(j=9;j<15;j++)
			{
				tileMap[i][j].setTileColorName("green");
			}
		}
		
		for(i=1;i<7;i++)
		{
			tileMap[i][7].setTileColorName("red");
		}
		
		for(i=8;i<14;i++)
		{
			tileMap[i][7].setTileColorName("yellow");
		}
		
		for(j=1;j<7;j++)
		{
			tileMap[7][j].setTileColorName("green");
		}
		
		for(j=8;j<14;j++)
		{
			tileMap[7][j].setTileColorName("blue");
		}
		
		//setting colors for additional special tiles(casas de saida e abrigos)
		tileMap[1][8].setTileColorName("red");
		tileMap[8][13].setTileColorName("green");
		tileMap[13][6].setTileColorName("yellow");
		tileMap[6][1].setTileColorName("blue");
		tileMap[8][1].setTileColorName("black");
		tileMap[1][6].setTileColorName("black");
		tileMap[13][8].setTileColorName("black");
		tileMap[6][13].setTileColorName("black");
		
	}

}
