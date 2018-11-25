import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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
	public JLabel diceImage;
	public int diceNumber;
	public ButtonGroup diceOptions;
	
	
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
		
		DiceRollAction throwAction = new DiceRollAction(p, size, in);
		throwDiceMenu.addActionListener(throwAction);
		
		diceImage = new JLabel();
		
		diceOptions =  new ButtonGroup();
		
		JRadioButton one = new JRadioButton("1", false);
		JRadioButton two = new JRadioButton("2", false);
		JRadioButton three = new JRadioButton("3", false);
		JRadioButton four = new JRadioButton("4", false);
		JRadioButton five = new JRadioButton("5", false);
		JRadioButton six = new JRadioButton("6", false);	
		
		diceOptions.add(one);
		diceOptions.add(two);
		diceOptions.add(three);
		diceOptions.add(four);
		diceOptions.add(five);
		diceOptions.add(six);
		
		p.add(one);
		size = one.getPreferredSize();
		one.setBounds(20 + in.left, 370 + in.top, size.width, size.height);
		
		p.add(two);
		size = two.getPreferredSize();
		two.setBounds(50 + in.left, 370 + in.top, size.width, size.height);
		
		p.add(three);
		size = three.getPreferredSize();
		three.setBounds(80 + in.left, 370 + in.top, size.width, size.height);
		
		p.add(four);
		size = four.getPreferredSize();
		four.setBounds(20 + in.left, 390 + in.top, size.width, size.height);
		
		p.add(five);
		size = five.getPreferredSize();
		five.setBounds(50 + in.left, 390 + in.top, size.width, size.height);
		
		p.add(six);
		size = six.getPreferredSize();
		six.setBounds(80 + in.left, 390 + in.top, size.width, size.height);
		
		DiceChooseAction oneAction = new DiceChooseAction(p, size, in, 1); 
		DiceChooseAction twoAction = new DiceChooseAction(p, size, in, 2);
		DiceChooseAction threeAction = new DiceChooseAction(p, size, in, 3);
		DiceChooseAction fourAction = new DiceChooseAction(p, size, in, 4);
		DiceChooseAction fiveAction = new DiceChooseAction(p, size, in, 5);
		DiceChooseAction sixAction = new DiceChooseAction(p, size, in, 6);
		
		one.addActionListener(oneAction);
		two.addActionListener(twoAction);
		three.addActionListener(threeAction);
		four.addActionListener(fourAction);
		five.addActionListener(fiveAction);
		six.addActionListener(sixAction);
		
	}
	
	public void paintDice(String name, JPanel p, Dimension size, Insets in) {
		
		Image image = Toolkit.getDefaultToolkit().getImage(name);
		
		ImageIcon img = new ImageIcon(image);
		
		diceImage.setIcon(img);
		p.add(diceImage);
		size = diceImage.getPreferredSize();
		diceImage.setBounds(22 + in.left, 260 + in.top, size.width, size.height);
		
	}
	
	public String setDiceName(int number) {
		
		String name = "";
		
		switch(number) {
		
			case 1:
				name = "src/img/Dado1.png";
				break;
			case 2:
				name = "src/img/Dado2.png";
				break;
			case 3:
				name = "src/img/Dado3.png";
				break;
			case 4:
				name = "src/img/Dado4.png";
				break;
			case 5:
				name = "src/img/Dado5.png";
				break;
			case 6:
				name = "src/img/Dado6.png";
				break;
		}
		
		return name;		
	}
	
	
	private class DiceRollAction implements ActionListener{
		
		public JPanel jp;
		public Dimension dsize;
		public Insets ins;
		
		public DiceRollAction(JPanel p, Dimension size, Insets in) {
			jp = p;
			dsize = size;
			ins = in;
		}
		
		public void actionPerformed(ActionEvent event) {
			
			diceOptions.clearSelection();
			
			diceNumber = (int) (Math.random() * 6) + 1;
			
			paintDice(setDiceName(diceNumber), jp, dsize, ins);
			
			repaint();
		}

	}
	
	private class DiceChooseAction implements ActionListener{
		
		public JPanel jp;
		public Dimension dsize;
		public Insets ins;
		
		public DiceChooseAction(JPanel p, Dimension size, Insets in, int number) {
			jp = p;
			dsize = size;
			ins = in;
			dNumber = number;
		}
		
		public void actionPerformed(ActionEvent event) {
			
			paintDice(setDiceName(dNumber), jp, dsize, ins);
			
			repaint();
		}
		
		private int dNumber;

	}
}


