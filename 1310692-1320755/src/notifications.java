import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class notifications extends notificationsManager{
	
	public notifications(game g) {
		super(g);
	}

	private static notifications instance = null;
	
	public static notificationsManager getInstance(game g)
	{
		if(instance == null)
		{
			instance = new notifications(g);
		}
		
		return instance;
	}
	
	private void notify(String title, String message, int type)
	{
		if(mainGame != null)
		{
			mainGame.setChanged();
			mainGame.notifyObservers();
		}
		
		JOptionPane.showMessageDialog(new JFrame(), message, title, type);
	}
	
	private void notifyInfo(String title, String message)
	{
		notify(title, message, JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void notifyError(String message)
	{
		notify("Erro", message, JOptionPane.ERROR_MESSAGE);
	}
	
	public void notifyGameStart()
	{
		notifyInfo("Jogo Iniciado", "Clique no dado para come�ar");
	}

	public void notifyGameEnd(String[] positions)
	{
		String message = "O jogador " + positions[0] + " venceu esta partida.\n2� lugar: " + positions[1]
				+ "\n3� lugar: " + positions[2] + "\n4� lugar: " + positions[3] + "\nObrigado por ludar.";

		notifyInfo("Fim de jogo", message);
	}

	public void notifyGameLoadingError()
	{
		notifyError("Erro ao carregar o jogo.");
	}

	public void notifyCaptureBonus()
	{
		notifyInfo("Aten��o!", "Voc� capturou uma pe�a de outro jogador. Avance 20 casas com qualquer um de seus pe�es.");
	}
	
	public void notifyExitBonus()
	{
		notifyInfo("Aten��o!", "Voc� chegou a casa de destino. Avance 10 casas com qualquer um de seus pe�es.");
	}
	
	public void notify3Consecutive6Penalty()
	{
		notifyInfo("Aten��o!", "Voc� tirou 3 dados 6 consecutivos. Volte com o �ltimo pe�o movido para a casa inicial.");
	}

	public void notify6RepeatMove()
	{
		notifyInfo("Aten��o!", "Voc� tirou um dado 6. Lance o dado novamente.");
	}

	public void notify6Becomes7Bonus() {
		notifyInfo("Aten��o!", "Voc� tirou um dado 6. Como n�o h� mais pe�as na sua casa inicial, voc� ganha um movimento extra!");
	}

}
