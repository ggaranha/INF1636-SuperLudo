package rules;

import rendering.gamePanel;
import rendering.menu;
import gameInfo.dice;
import gameInfo.tile;
import gameInfo.pawn;

public class diceRules {
	
	public diceRules()
	{
		
	}
	
	public int rollDice() {
		
		return dice.getInstance().getValueDice();
	}
	
	public static boolean dice5() {
		game mainGame = game.getInstance();
		
		pawn pRef;
		tile tRef;
		
		pRef = mainGame.getCurrentPlayer().getPawnOnBeginTile();
		
		if(pRef != null)
		{	
			tRef = mainGame.getCurrentPlayer().getPlayerExitTile();
			
			if(tRef.isTileEmpty()) {
			
				moves.movesPawn(pRef,1);
				
			}else {
				if(mainGame.getCurrentPlayer().getNumberPawnOnBeginTile() == 3) {
					pRef = tRef.removeTilePawn(mainGame.getCurrentPlayer().getPlayerColor());
					tRef.addTilePawn(pRef);
					moves.movesPawn(pRef,5);
				}else {
					return false;
				}
			}
			
			moves.changeTurn();
			return true;
		}
		
		return false;
	}
	
	public static boolean dice6() {
		game mainGame = game.getInstance();
		facade f = facade.getInstance();
		
		pawn pRef;
		tile tRef;
		
		if(dice.getInstance().getConsecutive6() == 3) {
			tRef = f.pawn6Start.getPawnTile();
			
			pRef = f.pawn6End.getPawnTile().removeTilePawn(mainGame.getCurrentPlayer().getPlayerColor());
						
			tRef.addTilePawn(pRef);
			pRef.setPawnTile(tRef);
			pRef.setPawnWalkCount(pRef.getPawnWalkCount()-6);
			
			gamePanel.getInstance().refresh();
			
			moves.changeTurn();
			f.pawn6Start = null;
			f.pawn6End = null;
			dice.getInstance().setConsecutive6(0);
			return true;
		}
		
		return false;		
	}
	
	public static void setDiceEnable(boolean e) {
		
		menu menuGame = menu.getInstance();
		
		menuGame.throwDiceMenu.setEnabled(e);
		menuGame.one.setEnabled(e);
		menuGame.two.setEnabled(e);
		menuGame.three.setEnabled(e);
		menuGame.four.setEnabled(e);
		menuGame.five.setEnabled(e);
		menuGame.six.setEnabled(e);
		
		dice.getInstance().setEnable(e);
	}
	
	public String setDice(int number) {
		
		if(number == 7) {
			number = (int) (Math.random() * 6) + 1;
		}
		String name = "";
		game mainGame = game.getInstance();
		
		mainGame.getGameDice().setValueDice(number);
		if(number == 6)
		{
			mainGame.getGameDice().setConsecutive6(mainGame.getGameDice().getConsecutive6() + 1);
		}
		else
		{
			mainGame.getGameDice().setConsecutive6(0);
		}
		setDiceEnable(false);
				
		switch(number) {
		
			case 1:
				name = "src/img/Dado1.png";
				break;
			case 2:
				name = "src/img/Dado2.png";
				break;
			case 3:
				name = "src/img/Dado3.png";
				break;
			case 4:
				name = "src/img/Dado4.png";
				break;
			case 5:
				name = "src/img/Dado5.png";
				break;
			case 6:
				name = "src/img/Dado6.png";
				break;
		}
		
		return name;		
	}

	
	public static boolean autoMovement()
	{
		game mainGame = game.getInstance();
		int diceValue = dice.getInstance().getValueDice();
		
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
