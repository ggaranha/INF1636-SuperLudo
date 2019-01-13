package controller;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import rendering.menu;
import rules.facade;

public class diceChooseAction implements ActionListener {

	private JPanel jp;
	private Dimension dsize;
	private Insets ins;
	private int dNumber;
	
	public diceChooseAction(JPanel p, Dimension size, Insets in, int number) {
		jp = p;
		dsize = size;
		ins = in;
		dNumber = number;		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		facade f = facade.getInstance();
		
		menu menuGame = menu.getInstance();
		menuGame.paintDice(f.setDice(dNumber), jp, dsize, ins);
		
		menuGame.repaint();
		
		f.verifyPawnAvaiableMoves();
	}
}
