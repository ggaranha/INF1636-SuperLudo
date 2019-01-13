package rules;

import java.awt.Color;

import gameInfo.dice;
import gameInfo.pawn;
import gameInfo.player;
import gameInfo.tile;
import rendering.gamePanel;

public class moves {
	
	public moves() {
		
	}

	public boolean verifyDiceNumber() {
		
		int diceNumber = dice.getInstance().getValueDice();
		
		switch(diceNumber) {
			case 5:
				return diceRules.dice5();
			case 6:
				return diceRules.dice6();
		}
		
		return false;
	}
	
	public void verifyPawns() {
		game mainGame = game.getInstance();
		boolean dice6 = (dice.getInstance().getValueDice() == 6);
		
		if(mainGame.getCurrentPlayer().getNumberPawnOnBeginTile() == 3) {
			pawn pRef = mainGame.getCurrentPlayer().getPlayerPawn(0);
						
			if(dice6 && dice.getInstance().getConsecutive6() == 2) {
				
				pawn oldPawn = new pawn(pRef.getPawnColor(), pRef.getPawnPlayer(), pRef.getPawnTile());
				facade.getInstance().pawn6Start = oldPawn;
			}
			
			moves.movesPawn(pRef,dice.getInstance().getValueDice());
			
			if(dice6 && dice.getInstance().getConsecutive6() == 2) {
				
				facade.getInstance().pawn6End = pRef;
			}
			
			if(!dice6) {
				changeTurn();
			}else {
				diceRules.setDiceEnable(true);
			}
		}else if(mainGame.getCurrentPlayer().getNumberPawnOnBeginTile() == 4) {
			changeTurn();
		}
	}
	
	public static void changeTurn() {
		game mainGame = game.getInstance();
		mainGame.nextPlayer();
		moves.startPlayer();
		diceRules.setDiceEnable(true);
	}
	
	public static void startPlayer() {
		
		game mainGame = game.getInstance();
		player play = mainGame.getCurrentPlayer();
				
		if(!play.isPlayerStart()) {
			
			pawn p = play.getPlayerPawn(0);
			movesPawn(p, 1);
			
			play.playerStarted();
		}		
	}
	
	public void firstStartPlayer(player current) {
				
		if(!current.isPlayerStart()) {
			
			pawn p = current.getPlayerPawn(0);
			p.getPawnTile().removeTilePawn(current.getPlayerColor());
			p.setPawnWalkCount(p.getPawnWalkCount()+1);
			
			tile newTilePawn = current.getPlayerExitTile();
			newTilePawn.addTilePawn(p);
			p.setPawnTile(newTilePawn);
			
			current.playerStarted();
		}	
	}
	
	public static void movesPawn(pawn p, int walkMoves) {
		game mainGame = game.getInstance();
		
		int pawnX = 0;
		int pawnY = 0;
		int walks = p.getPawnWalkCount()+walkMoves;
		
		if(walks <= 57) {
		
			if(!barrier.hasBarrierOnTheWay(p, p.getPawnWalkCount(), p.getPawnWalkCount() + walkMoves)) {
							
					if(p.getPawnColor() == Color.RED) {
						pawnX = p.redPawnXPath[walks];
						pawnY = p.redPawnYPath[walks];
					}else if(p.getPawnColor() == Color.GREEN) {
						pawnX = p.greenPawnXPath[walks];
						pawnY = p.greenPawnYPath[walks];
					}else if(p.getPawnColor() == Color.YELLOW) {
						pawnX = p.yellowPawnXPath[walks];
						pawnY = p.yellowPawnYPath[walks];
					}else if(p.getPawnColor() == Color.BLUE) {
						pawnX = p.bluePawnXPath[walks];
						pawnY = p.bluePawnYPath[walks];
					}
					
					tile newTilePawn = mainGame.getGameBoard().getTile(pawnX, pawnY);
					
					if(canMove(p, newTilePawn)) {
						p.getPawnTile().removeTilePawn(mainGame.getCurrentPlayer().getPlayerColor());
						p.setPawnWalkCount(p.getPawnWalkCount()+walkMoves);
						newTilePawn.addTilePawn(p);
						p.setPawnTile(newTilePawn);
						gamePanel.getInstance().refresh();
					}
			}
		}
		
	}
	
	public static boolean canMove(pawn pawnToMove, tile destinyTile) {
		game mainGame = game.getInstance();
		
		if(destinyTile.isTileEmpty()) {
			return true;
		}else {
			tile exitTile = mainGame.getCurrentPlayer().getPlayerExitTile();
			
			if(destinyTile.getTileType() == 5) {
				if(destinyTile.getPosX() == exitTile.getPosX() && destinyTile.getPosY() == exitTile.getPosY()) {
					if(destinyTile.getTilePawnCount() == 1) {
						return true;
					}else {
						return false;
					}					
				}else {
					return false;
				}
				
			}else if(destinyTile.getTileType() == 1) {
				if((destinyTile.getTilePawnCount() == 1) && (destinyTile.getTileSinglePawn().getPawnColor() != pawnToMove.getPawnColor())) {
					return true;
				}else {
					return false;
				}	
			}else {
				capture.returnPawnCapturedToBeginTile(destinyTile.getTileSinglePawn());
				return true;
			}			
		}		
	}
}
