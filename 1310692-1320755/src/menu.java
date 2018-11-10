import javax.swing.*;
import java.awt.*;


public class menu extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9195280542628481358L;
	
	
	private JButton newGameMenu;
	private JButton loadGameMenu;
	private JButton saveGameMenu;
	private JLabel currentPlayerText;
	private JButton throwDiceMenu;
	
	public menu(JPanel p)
	{
		newGameMenu = new JButton("Novo Jogo");
		p.add(newGameMenu, BorderLayout.EAST);
		loadGameMenu = new JButton("Carregar Jogo");
		p.add(loadGameMenu, BorderLayout.EAST);
		saveGameMenu = new JButton("Salvar");
		p.add(saveGameMenu, BorderLayout.EAST);
		currentPlayerText = new JLabel("A Jogar:");
		p.add(currentPlayerText, BorderLayout.EAST);
	}
}
