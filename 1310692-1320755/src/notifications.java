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
		notifyInfo("Jogo Iniciado", "Clique no dado para começar");
	}

	public void notifyGameEnd(String[] positions)
	{
		String message = "O jogador " + positions[0] + " venceu esta partida.\n2º lugar: " + positions[1]
				+ "\n3º lugar: " + positions[2] + "\n4º lugar: " + positions[3] + "\nObrigado por ludar.";

		notifyInfo("Fim de jogo", message);
	}

	public void notifyGameLoadingError()
	{
		notifyError("Erro ao carregar o jogo.");
	}

	public void notifyCaptureBonus()
	{
		notifyInfo("Atenção!", "Você capturou uma peça de outro jogador. Avance 20 casas com qualquer um de seus peões.");
	}
	
	public void notifyExitBonus()
	{
		notifyInfo("Atenção!", "Você chegou a casa de destino. Avance 10 casas com qualquer um de seus peões.");
	}
	
	public void notify3Consecutive6Penalty()
	{
		notifyInfo("Atenção!", "Você tirou 3 dados 6 consecutivos. Volte com o último peão movido para a casa inicial.");
	}

	public void notify6RepeatMove()
	{
		notifyInfo("Atenção!", "Você tirou um dado 6. Lance o dado novamente.");
	}

	public void notify6Becomes7Bonus() {
		notifyInfo("Atenção!", "Você tirou um dado 6. Como não há mais peças na sua casa inicial, você ganha um movimento extra!");
	}

}
