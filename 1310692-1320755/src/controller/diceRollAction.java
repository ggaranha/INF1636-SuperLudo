package controller;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import rendering.menu;
import rules.facade;

public class diceRollAction implements ActionListener {

	private static diceRollAction instance;
	private JPanel jp;
	private Dimension dsize;
	private Insets ins;
	
	private diceRollAction(JPanel p, Dimension size, Insets in) {
		jp = p;
		dsize = size;
		ins = in;
	}
	
	public static diceRollAction getInstance(JPanel p, Dimension size, Insets in) {
		if(instance == null) {
			instance = new diceRollAction(p, size, in);
		}
		
		return instance;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
		facade f = facade.getInstance();
		
		menu menuGame = menu.getInstance();
		
		menuGame.diceOptions.clearSelection();
				
		menuGame.paintDice(f.setDice(7), jp, dsize, ins); // 7 é para ser número aleatório
		
		menuGame.repaint();
		
		f.verifyPawnAvaiableMoves();
	}

}
