import javax.swing.*;
import java.awt.*;

public class game extends JPanel{
	menu gameMenu;
	displayBoard gameDisplayBoard;
	board gameBoard;
	dice gameDice;
	player gamePlayers[];
	
	
	public game(JPanel j)
	{
		gameBoard = new board();
		j.setLayout(new BorderLayout());
		gameMenu = new menu(j);
	}
	
}
