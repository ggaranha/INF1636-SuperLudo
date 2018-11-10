import java.awt.Color;

public class board {
	
	private tile[][] tileMap;
	
	public board()
	{
		tileMap = new tile[15][15];
		newBoard();
		
	}
	
	public tile getTile(int x, int y)
	{
		return tileMap[x][y];
	}
	
	private void newBoard()
	{
		int i,j;
		
		//initializing new board
		for(i=0;i<15;i++)
		{
			for(j=0;j<15;j++)
			{
				tileMap[i][j] = new tile(i,j, Color.WHITE);
				tileMap[i][j].setTileType(0);
			}
		}
		
		//setting colors for colored spaces
		for(i=0;i<6;i++)
		{
			for(j=0;j<6;j++)
			{
				tileMap[i][j].setTileColor(Color.RED);
				tileMap[i][j].setTileType(2);
			}
		}
		
		for(i=0;i<6;i++)
		{
			for(j=9;j<15;j++)
			{
				tileMap[i][j].setTileColor(Color.BLUE);
				tileMap[i][j].setTileType(2);
			}
		}
		
		for(i=9;i<15;i++)
		{
			for(j=0;j<6;j++)
			{
				tileMap[i][j].setTileColor(Color.GREEN);
				tileMap[i][j].setTileType(2);
			}
		}
		
		for(i=9;i<15;i++)
		{
			for(j=9;j<15;j++)
			{
				tileMap[i][j].setTileColor(Color.YELLOW);
				tileMap[i][j].setTileType(2);
			}
		}
		
		for(i=1;i<7;i++)
		{
			tileMap[i][7].setTileColor(Color.RED);
		}
		
		for(i=8;i<14;i++)
		{
			tileMap[i][7].setTileColor(Color.YELLOW);
		}
		
		for(j=1;j<7;j++)
		{
			tileMap[7][j].setTileColor(Color.GREEN);
		}
		
		for(j=8;j<14;j++)
		{
			tileMap[7][j].setTileColor(Color.BLUE);
		}
		
		//setting colors for additional special tiles(casas de saida e abrigos)
		tileMap[1][6].setTileColor(Color.RED);
		tileMap[1][6].setTileType(4);
		tileMap[8][1].setTileColor(Color.GREEN);
		tileMap[8][1].setTileType(4);
		tileMap[13][8].setTileColor(Color.YELLOW);
		tileMap[13][8].setTileType(4);
		tileMap[6][13].setTileColor(Color.BLUE);
		tileMap[6][13].setTileType(4);
		tileMap[8][13].setTileColor(Color.BLACK);
		tileMap[8][13].setTileType(1);
		tileMap[1][8].setTileColor(Color.BLACK);
		tileMap[1][8].setTileType(1);
		tileMap[13][6].setTileColor(Color.BLACK);
		tileMap[13][6].setTileType(1);
		tileMap[6][1].setTileColor(Color.BLACK);
		tileMap[6][1].setTileType(1);
		
	}
}
