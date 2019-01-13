package rules;

import gameInfo.dice;
import gameInfo.pawn;
import gameInfo.player;

public class facade {
	
	private static facade instance;
	
	private diceRules diceR;
	private moves move;
	public pawn pawn6Start;
	public pawn pawn6End;
	
	private facade() {
		diceR = new diceRules();
		move = new moves();
	}
	
	public static facade getInstance() {
		if(instance == null) {
			instance = new facade();
		}
		
		return instance;
	}
	
	public int rollDice() {
		return diceR.rollDice();
	}
	
	public String setDice(int number) {
		return diceR.setDice(number);
	}
	
	public void firstStartPlayer(player current) {
		move.firstStartPlayer(current);
	}
	
	public void movePawns(pawn p, int walkMoves) {
		dice d = dice.getInstance();
		
		if(d.getValueDice() == 6) {
			if(d.getConsecutive6() == 2) {
				pawn6Start = new pawn(p.getPawnColor(),p.getPawnPlayer(),p.getPawnTile());
				moves.movesPawn(p, walkMoves);
				pawn6End = p;
				
				diceRules.setDiceEnable(true);
				return;
			}
			moves.movesPawn(p, walkMoves);
			diceRules.setDiceEnable(true);
			return;
		}
		
		moves.movesPawn(p, walkMoves);
		moves.changeTurn();		
	}
	
	public void verifyPawnAvaiableMoves() {
		
		if(!move.verifyDiceNumber()) {
			move.verifyPawns();
		}
	}

}
