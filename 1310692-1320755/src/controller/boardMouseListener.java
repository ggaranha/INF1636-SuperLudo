package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import gameInfo.dice;
import gameInfo.pawn;
import gameInfo.tile;
import rules.facade;
import rules.game;

public class boardMouseListener implements MouseListener {
	
	private game mainGame;
	private tile refTile;
	
	public boardMouseListener() {
		mainGame = game.getInstance();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int x = (int) (e.getX() / 30);
		int y = (int) (e.getY() / 30);

		try {
			refTile = mainGame.getGameBoard().getTile(x, y);
			
			pawn refPawn = refTile.removeTilePawn(mainGame.getCurrentPlayer().getPlayerColor());
			refTile.addTilePawn(refPawn);
			
			facade.getInstance().movePawns(refPawn, dice.getInstance().getValueDice());
			
		} catch (Exception ex) {

		}
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
