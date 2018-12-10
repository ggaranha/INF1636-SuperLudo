import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;


import javax.swing.*;

public class superLudo extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3411683330786988583L;
	
	
	private JPanel boardPanel;
	private gamePanel gPanel;
	private JPanel menuPanel;
	private static game superLudoGame;
	private gameControl gc;
	private menu gameMenu;
	
	private ActionListener newGameListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			superLudoGame = new game();
			menuPanel = new JPanel();
			menuPanel.setLayout(null);
			gameMenu = new menu(menuPanel, superLudoGame);
			gPanel = new gamePanel(superLudoGame, gameMenu);
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
		superLudoGame = new game();
		menuPanel = new JPanel();
		menuPanel.setLayout(null);
		gameMenu = new menu(menuPanel, superLudoGame);
		gPanel = new gamePanel(superLudoGame, gameMenu);
		boardPanel.add(gPanel);
		
		
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
		
		/*/////////// START SET GAME ////////// */
		/*Color colors[] = {new Color() , new Color("red"), new Color("yellow"), new Color("green")};
		Player[] players = new Player[4];
		Pawn[] pawns = new Pawn[16];
		
		for(int i = 0; i < colors.length; i++ ) {
			players[i] = new Player(colors[i].getColor(), colors[i]);
			
			for(int j = 0; j < 4; j++) {
				pawns[j] = new Pawn(colors[i], players[i]);
			}
		}	*/
		
		/*/////////// END SET GAME ////////// */
		
		/*/////////// START DICE ROLLING ////////// */
	
        
        /*/////////// END DICE ROLLING /////////// */
        
        /*//////////  START CHOOSE PAWN /////////  */
        
        
        /*//////////  END CHOOSE PAWN //////////  */

	}

}
