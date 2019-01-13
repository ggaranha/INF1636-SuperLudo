package rendering;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

import rules.game;

public class superLudo extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3411683330786988583L;	
	
	private JPanel boardPanel;
	private gamePanel gPanel;
	private JPanel menuPanel;
	private menu gameMenu;
	
	private ActionListener newGameListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			game.setInstanceNull();
			menu.setInstanceNull();
			gameMenu = menu.getInstance();
			gamePanel.setInstanceNull();
			gPanel = gamePanel.getInstance();
			boardPanel.add(gPanel);
		}
	};
	
	public superLudo(String s) {
		super(s);
		setSize(630,500);
		setLayout(null);
		boardPanel = new JPanel();
		boardPanel.setLayout(new BorderLayout());
		boardPanel.setBackground(Color.WHITE);
		gameMenu = menu.getInstance();
		gPanel = gamePanel.getInstance();
		boardPanel.add(gPanel);
		
		menuPanel = gameMenu.getMenuPanel();
		
		gameMenu.newGameMenu.addActionListener(newGameListener);
		
		getContentPane().add(menuPanel);
		menuPanel.setBounds(460, 0, 170, 500);
		getContentPane().add(boardPanel);
		boardPanel.setBounds(0, 0, 460, 500);
	}
	
	public static void main(String[] args)
	{
		superLudo s = new superLudo("SuperLudo");
		s.setVisible(true);
	}

}
