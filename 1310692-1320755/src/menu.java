import javax.swing.*;
import java.awt.*;


public class menu extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9195280542628481358L;
	
	private JButton throwDiceMenu;
	
	public menu(JPanel p)
	{
		JButton newGameMenu = new JButton("Novo Jogo");
		p.add(newGameMenu, BorderLayout.EAST);
		JButton loadGameMenu = new JButton("Carregar Jogo");
		p.add(loadGameMenu, BorderLayout.EAST);
		JButton saveGameMenu = new JButton("Salvar");
		p.add(saveGameMenu, BorderLayout.EAST);
		JLabel currentPlayerText = new JLabel("A Jogar:");
		p.add(currentPlayerText, BorderLayout.EAST);
	}
}
