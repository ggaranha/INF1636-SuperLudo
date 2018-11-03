import javax.swing.*;
import java.awt.*;

public class game extends JPanel{
	menu gameMenu;
	displayBoard gameDisplayBoard;
	board gameBoard;
	player gamePlayers[];
	
	
	public game(JPanel j)
	{
		j.setLayout(new BorderLayout());
		gameMenu = new menu(j);
	}
	
}
