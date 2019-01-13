package rendering;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.diceChooseAction;
import controller.diceRollAction;
import controller.gameSave;
import rules.game;
import utilities.utils;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;


public class menu extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9195280542628481358L;
	private static menu instance;
	
	private JPanel p;
	
	public JButton newGameMenu;
	public JButton loadGameMenu;
	public JButton saveGameMenu;
	public JLabel currentPlayerText;
	public JButton throwDiceMenu;
	public JLabel diceImage;
	public int diceNumber;
	public ButtonGroup diceOptions;
	public Insets in;
	public game mainGame;
	public JRadioButton one = new JRadioButton("1", false);
	public JRadioButton two = new JRadioButton("2", false);
	public JRadioButton three = new JRadioButton("3", false);
	public JRadioButton four = new JRadioButton("4", false);
	public JRadioButton five = new JRadioButton("5", false);
	public JRadioButton six = new JRadioButton("6", false);
	
	
	private menu()
	{
		super();
		
		p = new JPanel();
		p.setLayout(null);
		
		Dimension size;
		in = p.getInsets();
		mainGame = game.getInstance();
		
		newGameMenu = new JButton("Novo Jogo");
		p.add(newGameMenu);
		size = newGameMenu.getPreferredSize();
		newGameMenu.setBounds(25 + in.left, 25 + in.top, size.width, size.height);
		
		JButton loadGameMenu = new JButton("Carregar Jogo");
		p.add(loadGameMenu);
		size = loadGameMenu.getPreferredSize();
		loadGameMenu.setBounds(15 + in.left, 75 + in.top, size.width, size.height);
		loadGameMenu.addActionListener(loadGameListener);
		
		JButton saveGameMenu = new JButton("Salvar Jogo");
		p.add(saveGameMenu);
		size = saveGameMenu.getPreferredSize();
		saveGameMenu.setBounds(25 + in.left, 125 + in.top, size.width, size.height);
		saveGameMenu.addActionListener(saveGameListener);
		
		currentPlayerText = new JLabel("A Jogar:");
		p.add(currentPlayerText);
		size = currentPlayerText.getPreferredSize();
		currentPlayerText.setBounds(50 + in.left, 175 + in.top, size.width, size.height);
		
		throwDiceMenu = new JButton("Lançar Dado");
		p.add(throwDiceMenu);
		size = throwDiceMenu.getPreferredSize();
		throwDiceMenu.setBounds(20 + in.left, 225 + in.top, size.width, size.height);
					
		diceRollAction throwAction = diceRollAction.getInstance(p, size, in);
		throwDiceMenu.addActionListener(throwAction);
			
		diceManual(p, size, in);
		
	}
	
	public static menu getInstance() {
		if(instance == null) {
			instance = new menu();
		}
		
		return instance;
	}
	
	public static void setInstanceNull() {
		instance = null;
	}
	
	public JPanel getMenuPanel() {
		return p;
	}
	
	public void diceManual(JPanel p, Dimension size, Insets in) {
		diceImage = new JLabel();
		
		diceOptions =  new ButtonGroup();		
		
		diceOptions.add(one);
		diceOptions.add(two);
		diceOptions.add(three);
		diceOptions.add(four);
		diceOptions.add(five);
		diceOptions.add(six);
		
		p.add(one);
		size = one.getPreferredSize();
		one.setBounds(20 + in.left, 390 + in.top, size.width, size.height);
		
		p.add(two);
		size = two.getPreferredSize();
		two.setBounds(50 + in.left, 390 + in.top, size.width, size.height);
		
		p.add(three);
		size = three.getPreferredSize();
		three.setBounds(80 + in.left, 390 + in.top, size.width, size.height);
		
		p.add(four);
		size = four.getPreferredSize();
		four.setBounds(20 + in.left, 410 + in.top, size.width, size.height);
		
		p.add(five);
		size = five.getPreferredSize();
		five.setBounds(50 + in.left, 410 + in.top, size.width, size.height);
		
		p.add(six);
		size = six.getPreferredSize();
		six.setBounds(80 + in.left, 410 + in.top, size.width, size.height);
		
		diceChooseAction oneAction = new diceChooseAction(p, size, in, 1); 
		diceChooseAction twoAction = new diceChooseAction(p, size, in, 2);
		diceChooseAction threeAction = new diceChooseAction(p, size, in, 3);
		diceChooseAction fourAction = new diceChooseAction(p, size, in, 4);
		diceChooseAction fiveAction = new diceChooseAction(p, size, in, 5);
		diceChooseAction sixAction = new diceChooseAction(p, size, in, 6);
		
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
		diceImage.setBounds(22 + in.left, 270 + in.top, size.width, size.height);
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		Rectangle2D rect = new Rectangle2D.Double(12 + in.left, 250 + in.top, 320, 320);
		
		g2.setColor(Color.RED);		
		g2.fill(rect);
			
	}
	
	/**
	 * Defines what dialog appears when a map is loaded
	 * 
	 * @return Loaded map's GameMap or <b>null</b>
	 * @throws MapLoaderException
	 */
	public game showLoadMapDialog() throws Exception
	{
		JFileChooser chooser = new JFileChooser();
		//chooser.setCurrentDirectory(new File("./saves"));
		chooser.setFileFilter(new FileNameExtensionFilter("Apenas .ludosave", "ludosave"));
		int retorno = chooser.showOpenDialog(null);

		if (retorno == JFileChooser.APPROVE_OPTION)
		{
			return gameSave.loadFromFile(chooser.getSelectedFile());
		}

		return null;
	}
	
	/**
	 * Defines what happens when the "Carregar Jogo" button is presssed
	 */
	private ActionListener loadGameListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e)
		{
			try
			{
				game map = showLoadMapDialog();
				if (map != null)
				{
					mainGame = map;
				}
			} catch (Exception exception)
			{
				//Notifications.getInstance(null).notifyGameLoadingError();
			}
		}
	};
	
	/**
	 * Defines what happens when the "Salvar Jogo" button is presssed
	 */
	private ActionListener saveGameListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e)
		{
			try
			{
				JFileChooser chooser = new JFileChooser() {
					/**
					 * 
					 */
					private static final long serialVersionUID = -6647937141202512730L;

					@Override
					public void approveSelection()
					{
						File f = getSelectedFile();
						if (f.exists() && getDialogType() == SAVE_DIALOG)
						{							
							int result = JOptionPane.showConfirmDialog(this,
									"O arquivo já existe. Deseja sobrescrevê-lo?", "Arquivo já existe",
									JOptionPane.YES_NO_CANCEL_OPTION);
							switch (result)
							{
								case JOptionPane.YES_OPTION:
									super.approveSelection();
									return;
								case JOptionPane.NO_OPTION:
									return;
								case JOptionPane.CLOSED_OPTION:
									return;
								case JOptionPane.CANCEL_OPTION:
									cancelSelection();
									return;
							}
						}

						super.approveSelection();
					}
				};
				
				chooser.setCurrentDirectory(new File("./saves"));
				chooser.setFileFilter(new FileNameExtensionFilter(".ludosave", "ludosave"));
				int ret = chooser.showSaveDialog(null);

				if (ret == JFileChooser.APPROVE_OPTION)
				{
					File file = chooser.getSelectedFile();

					if (utils.getFileExtension(file.getName()).equalsIgnoreCase("ludosave"))
					{
						// filename is OK as-is
					}
					else
					{
						// append .ludosave
						file = new File(file.toString() + ".ludosave");

						file = new File(file.getParentFile(), utils.getFileBaseName(file.getName()) + ".ludosave");
					}

					try
					{
						gameSave.saveToFile(mainGame, file);
					} catch (IOException ex)
					{
						//Notifications.getInstance(null).notifyError(ex.getMessage());
						ex.printStackTrace();
					}
				}

			} catch (Exception ex)
			{
				ex.printStackTrace();
			}
		}
	};
}


