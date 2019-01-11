package mainGame;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import gameInfo.pawn;
import gameInfo.player;
import gameInfo.tile;

public class boardMouseListener implements MouseListener {
	
	private static boardMouseListener instance;
	
	private game mainGame;
	private tile refTile;
	private pawn refPawn;
	private menu menuGame;
	private gamePanel panel;
	
	private boardMouseListener(game g, menu m, tile t, gamePanel p) {
		mainGame = g;
		menuGame = m;
		refTile = t;
		panel = p;
	}
	
	public static boardMouseListener getInstance(game g, menu m, tile t, gamePanel p) {
		if(instance == null) {
			instance = new boardMouseListener(g, m, t, p);
		}
		
		return instance;
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		int x = (int) (e.getX() / 30);
		int y = (int) (e.getY() / 30);

		try {
			refTile = mainGame.getGameBoard().getTile(x, y);
			boolean ok = true;
			
			boolean dice5 = (mainGame.getGameDice().getValueDice() == 5);
			boolean pawnInStart = (mainGame.getCurrentPlayer().getPawnOnBeginTile() != null);
			
			System.out.printf("x: %d, y: %d \n", refTile.getPosX(), refTile.getPosY());
							
			if(dice5 && pawnInStart && mainGame.getGameDice().isEnable()) {
				refPawn = refTile.removeTilePawn(mainGame.getCurrentPlayer().getPlayerColor());
				
				if(refPawn.getPawnWalkCount() != 0) {
					ok = false;
					refTile.addTilePawn(refPawn);
				}else {
					refTile.addTilePawn(refPawn);
				}
				
			}else if(!refTile.isTileEmpty() && !mainGame.getGameDice().isEnable() && ok) {
				
				refPawn = refTile.removeTilePawn(mainGame.getCurrentPlayer().getPlayerColor());
				
				if(!(refPawn.getPawnWalkCount() == 0 && mainGame.getGameDice().getValueDice() != 5)) {

					System.out.printf("Pawn: x: %d, y: %d, Qtd Walk: %d \n", refPawn.getPawnTile().getPosX(), refPawn.getPawnTile().getPosY(), refPawn.getPawnWalkCount());
					
					if(refPawn.getPawnWalkCount() == 0) {
						refPawn.setPawnWalkCount(1);
					}else {
						refPawn.setPawnWalkCount(refPawn.getPawnWalkCount() + mainGame.getGameDice().getValueDice());
					}
					System.out.printf("Dice: %d, New Qtd Walk: %d \n", mainGame.getGameDice().getValueDice(), refPawn.getPawnWalkCount());
					
					int pawnX = 0;
					int pawnY = 0;
					
					if(refPawn.getPawnColor() == Color.RED) {
						pawnX = refPawn.redPawnXPath[refPawn.getPawnWalkCount()];
						pawnY = refPawn.redPawnYPath[refPawn.getPawnWalkCount()];
					}else if(refPawn.getPawnColor() == Color.GREEN) {
						pawnX = refPawn.greenPawnXPath[refPawn.getPawnWalkCount()];
						pawnY = refPawn.greenPawnYPath[refPawn.getPawnWalkCount()];
					}else if(refPawn.getPawnColor() == Color.YELLOW) {
						pawnX = refPawn.yellowPawnXPath[refPawn.getPawnWalkCount()];
						pawnY = refPawn.yellowPawnYPath[refPawn.getPawnWalkCount()];
					}else if(refPawn.getPawnColor() == Color.BLUE) {
						pawnX = refPawn.bluePawnXPath[refPawn.getPawnWalkCount()];
						pawnY = refPawn.bluePawnYPath[refPawn.getPawnWalkCount()];
					}
					
				
					tile newTilePawn = mainGame.getGameBoard().getTile(pawnX, pawnY);
					newTilePawn.addTilePawn(refPawn);
					refPawn.setPawnTile(newTilePawn);
					if(mainGame.getGameDice().getValueDice() != 6 || mainGame.getGameDice().getConsecutive6() == 3)
					{
						mainGame.getGameDice().setConsecutive6(0);
						mainGame.nextPlayer();
					}
					menuGame.setDiceEnable(true);
					player play = mainGame.getCurrentPlayer();
					
					if(!play.isPlayerStart()) {
						pawn p = play.getPlayerPawn(0);
						p.getPawnTile().removeTilePawn(p);
						
						pawnX = 0;
						pawnY = 0;
						
						if(p.getPawnColor() == Color.RED) {
							pawnX = p.redPawnXPath[1];
							pawnY = p.redPawnYPath[1];
						}else if(p.getPawnColor() == Color.GREEN) {
							pawnX = p.greenPawnXPath[1];
							pawnY = p.greenPawnYPath[1];
						}else if(p.getPawnColor() == Color.YELLOW) {
							pawnX = p.yellowPawnXPath[1];
							pawnY = p.yellowPawnYPath[1];
						}else if(p.getPawnColor() == Color.BLUE) {
							pawnX = p.bluePawnXPath[1];
							pawnY = p.bluePawnYPath[1];
						}
						
						p.setPawnWalkCount(1);
						mainGame.getGameBoard().getTile(pawnX, pawnY).addTilePawn(p);
						
						play.playerStarted();
					}
					
					System.out.printf("New Tile: Tile: x: %d, y: %d  /  Pawn: x: %d, y: %d \n", newTilePawn.getPosX(), newTilePawn.getPosY(), refPawn.getPawnTile().getPosX(), refPawn.getPawnTile().getPosY());
				}else {
					refTile.addTilePawn(refPawn);
				}
			}
			
		} catch (Exception ex) {

		}
		
		panel.refresh();

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
}
