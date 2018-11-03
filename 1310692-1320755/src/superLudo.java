import javax.swing.*;

public class superLudo extends JFrame{
	JPanel p;
	
	public superLudo(String s) {
		super(s);
		setSize(600,450);
		p = new JPanel();
		getContentPane().add(p);
	}
	
	public static void main(String[] args)
	{
		superLudo s = new superLudo("SuperLudo");
		
		s.setVisible(true);
	}

}
