import javax.swing.*;
import java.awt.*;


public class menu{
	JButton newGameMenu;
	JButton loadGameMenu;
	JButton saveGameMenu;
	JLabel currentPlayerText;
	JButton throwDiceMenu;
	
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
