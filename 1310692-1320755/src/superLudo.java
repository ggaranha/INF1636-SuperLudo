import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;

public class superLudo extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3411683330786988583L;
	
	
	private JPanel p;
	private game superLudoGame;
	private menu gameMenu;
	
	public superLudo(String s) {
		super(s);
		setSize(600,500);
		p = new JPanel();
		p.setLayout(new BorderLayout());
		p.setBackground(Color.WHITE);
		superLudoGame = new game(p);
		p.add(superLudoGame, BorderLayout.CENTER);
		gameMenu = new menu(p);
		getContentPane().add(p);
	}
	
	public static void main(String[] args)
	{
		superLudo s = new superLudo("SuperLudo");
		
		s.setVisible(true);
	}

}
