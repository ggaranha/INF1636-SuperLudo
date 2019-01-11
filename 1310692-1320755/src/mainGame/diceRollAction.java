package mainGame;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class diceRollAction implements ActionListener {

	private static diceRollAction instance;
	private JPanel jp;
	private Dimension dsize;
	private Insets ins;
	private menu menuGame;
	
	private diceRollAction(JPanel p, Dimension size, Insets in, menu m) {
		jp = p;
		dsize = size;
		ins = in;
		menuGame = m;
	}
	
	public static diceRollAction getInstance(JPanel p, Dimension size, Insets in, menu m) {
		if(instance == null) {
			instance = new diceRollAction(p, size, in, m);
		}
		
		return instance;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		menuGame.diceOptions.clearSelection();
		
		menuGame.diceNumber = (int) (Math.random() * 6) + 1;
		
		menuGame.paintDice(menuGame.setDice(menuGame.diceNumber), jp, dsize, ins);
		
		menuGame.repaint();
	}

}
