package rules;

import gameInfo.pawn;
import gameInfo.tile;

public class capture {
	
	public capture() {
		
	}
	
	public static void returnPawnCapturedToBeginTile(pawn pawnCaptured) {
		
		tile beginTile = pawnCaptured.getPawnPlayer().getPlayerPawnBeginTile(0);
		
		tile refTile = pawnCaptured.getPawnTile();
		pawnCaptured.setPawnTile(beginTile);
		pawnCaptured.setPawnWalkCount(0);
		refTile.removeTilePawn(pawnCaptured.getPawnColor());
		
		beginTile.addTilePawn(pawnCaptured);
	}

}
