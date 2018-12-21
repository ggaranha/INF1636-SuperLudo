package rules;

import mainGame.game;
import gameInfo.dice;
import gameInfo.tile;
import gameInfo.pawn;

public class diceRules {
	
	static boolean pawnChanged;
	
	public diceRules()
	{
		
	}
	
	public static boolean diceMovement(game mainGame, dice gameDice)
	{
		pawnChanged = autoMovement(mainGame, gameDice.getValueDice());
		
		return pawnChanged;
	}
	
	private static boolean autoMovement(game mainGame, int diceValue)
	{
		pawn pRef;
		tile tRef;
		
		if(diceValue==5)
		{
			pRef = mainGame.getCurrentPlayer().getPawnOnBeginTile();
			
			if(pRef != null)
			{	
				tRef = mainGame.getCurrentPlayer().getPlayerExitTile();
				tRef.addTilePawn(pRef);
				return true;
			}
		}
		
		return false;
	}

}
