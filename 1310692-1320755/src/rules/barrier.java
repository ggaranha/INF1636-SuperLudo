package rules;

import gameInfo.tile;
import gameInfo.player;
import gameInfo.board;

public class barrier {
	
	public static boolean opponentHasBarrierAt(player currentPlayer, board b, int x, int y)
	{
		tile tileRef = b.getTile(x, y);
		
		if (tileRef.getTileType() == 1)
		{
			return false;
		}

		if (tileRef.getTilePawnCount() > 1 && tileRef.getPawnsColors().get(0) != currentPlayer.getPlayerColor())
		{
			return true;
		}

		return false;
	}

	public static boolean currentPlayerHasBarrierAt(player currentPlayer, board b, int x, int y)
	{
		tile tileRef = b.getTile(x, y);
		
		if (tileRef.getTileType() == 1)
		{
			return false;
		}

		if (tileRef.getPawnCountByColor(currentPlayer.getPlayerColor()) > 1)
		{
			return true;
		}

		return false;
	}
	
	public static boolean currentPlayerHasBarrier(board b, player currentPlayer)
	{
		int i, j;
		
		for(i = 0; i <15; i++)
		{
			for(j=0; j < 15; j++)
			{
				if(currentPlayerHasBarrierAt(currentPlayer, b, i, j))
				{
					return true;
				}
			}
			
		}
		
		return false;
	}

}
