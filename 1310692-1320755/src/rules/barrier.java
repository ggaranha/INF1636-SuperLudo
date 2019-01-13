package rules;

import gameInfo.tile;
import gameInfo.player;
import gameInfo.board;
import gameInfo.pawn;

import java.awt.Color;
import java.util.List;

public class barrier {
	
	public barrier() {
		
	}
	
	public static boolean hasBarrierOnTheWay(pawn pawn, int inicio, int fim){
		game mainGame = game.getInstance();
		int pawnXPath[] = null;
		int pawnYPath[] = null;
		
		if(pawn.getPawnColor() == Color.RED) {
			pawnXPath = pawn.redPawnXPath;
			pawnYPath = pawn.redPawnYPath;
		}else if(pawn.getPawnColor() == Color.GREEN) {
			pawnXPath = pawn.greenPawnXPath;
			pawnYPath = pawn.greenPawnYPath;
		}else if(pawn.getPawnColor() == Color.BLUE) {
			pawnXPath = pawn.bluePawnXPath;
			pawnYPath = pawn.bluePawnYPath;
		}else if(pawn.getPawnColor() == Color.YELLOW) {
			pawnXPath = pawn.yellowPawnXPath;
			pawnYPath = pawn.yellowPawnYPath;
		}
		
		if(inicio == 0) {
			inicio++;
		}
		
		for(int i = inicio; i <= fim; i++) {
			tile tRef = mainGame.getGameBoard().getTile(pawnXPath[i], pawnYPath[i]);
			
			if(tRef != null) {
				List<Color> colors = tRef.getPawnsColors();
				
				for(Color c : colors){
					if(tRef.getPawnCountByColor(c) > 1) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
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
