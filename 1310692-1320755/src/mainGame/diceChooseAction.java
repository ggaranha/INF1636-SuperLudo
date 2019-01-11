package mainGame;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class diceChooseAction implements ActionListener {

	private JPanel jp;
	private Dimension dsize;
	private Insets ins;
	private menu menuGame;
	private int dNumber;
	
	public diceChooseAction(JPanel p, Dimension size, Insets in, int number, menu m) {
		jp = p;
		dsize = size;
		ins = in;
		menuGame = m;
		dNumber = number;		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		menuGame.paintDice(menuGame.setDice(dNumber), jp, dsize, ins);
		
		menuGame.repaint();
	}
}
