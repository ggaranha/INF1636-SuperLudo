import javax.swing.*;

import java.awt.*;


public class menu extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9195280542628481358L;
	
	public JButton newGameMenu;
	public JButton loadGameMenu;
	public JButton saveGameMenu;
	public JLabel currentPlayerText;
	public JButton throwDiceMenu;
	
	
	public menu(JPanel p)
	{
		Dimension size;
		Insets in = p.getInsets();
		
		newGameMenu = new JButton("Novo Jogo");
		p.add(newGameMenu);
		size = newGameMenu.getPreferredSize();
		newGameMenu.setBounds(25 + in.left, 25 + in.top, size.width, size.height);
		
		JButton loadGameMenu = new JButton("Carregar Jogo");
		p.add(loadGameMenu);
		size = loadGameMenu.getPreferredSize();
		loadGameMenu.setBounds(15 + in.left, 75 + in.top, size.width, size.height);
		
		JButton saveGameMenu = new JButton("Salvar Jogo");
		p.add(saveGameMenu);
		size = saveGameMenu.getPreferredSize();
		saveGameMenu.setBounds(25 + in.left, 125 + in.top, size.width, size.height);
		
		currentPlayerText = new JLabel("A Jogar:");
		p.add(currentPlayerText);
		size = currentPlayerText.getPreferredSize();
		currentPlayerText.setBounds(50 + in.left, 175 + in.top, size.width, size.height);
		
		throwDiceMenu = new JButton("Lançar Dado");
		p.add(throwDiceMenu);
		size = throwDiceMenu.getPreferredSize();
		throwDiceMenu.setBounds(20 + in.left, 225 + in.top, size.width, size.height);
	}
}
