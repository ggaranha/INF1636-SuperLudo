public class gameControl
{

	private game mainGame;
	
	
	private notificationsManager notifManager;

	public gameControl(game g, notificationsManager nm)
	{
		mainGame = g;
		notifManager = nm;
	}
}

	/**private actionListener diceActionListener = new actionListener() {

		@Override
		public void onActionExecuted(boolean capturedPawn)
		{
			System.out.println("Dice rolled");

			int diceValue = mainGame.getGameDice().getValueDice();
			player currentPlayer = mainGame.getCurrentPlayer();
			mainGame.setCurrentAction(action.SELECTPAWN); //Dado já foi rolado

			// Se obtiver um 6 pela terceira vez consecutiva, o último de seus
			// peões que foi movimentado voltará para a casa inicial. No caso do
			// último peão movimentado já ter chegado até uma das casas da reta
			// final, ele permanecerá em sua posição, não retornado à casa
			// inicial.
			if (diceValue == 6 && Dice.getConsecutive6() == 3)
			{
				try {
					if (hasMove(diceValue, currentPlayer))
					{
						notificationManager.notify3Consecutive6Penalty();
						removeLastMovedPawn();
					}
				} catch (Exception e) {
					notificationManager.notifyError("Erro ao retornar peão para casa inicial: " + e.getMessage());
				}

				board.nextPlayer();
				setPlayerDice();
				board.setCurrentAction(Action.ROLLDICE);
				
				board.setChanged();
				board.notifyObservers();
				
				return;
			}

			try {
				if (hasMove(diceValue, currentPlayer))
				{
					setPlayerMoves(diceValue, currentPlayer);
				}
				else
				{
					if (diceValue != 6)
					{
						board.nextPlayer();
					}
					else
					{
						notificationManager.notify6RepeatMove();
					}
					
					board.setCurrentAction(Action.ROLLDICE);
					setPlayerDice();
				}
			} catch (Exception e) {
				notifManager.notifyError("Erro ao definir jogadas: " + e.getMessage());
			}
			
			mainGame.setChanged();
			mainGame.notifyObservers();
		}
	};
	
}*/
