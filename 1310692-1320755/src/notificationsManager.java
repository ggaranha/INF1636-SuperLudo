public abstract class notificationsManager {
	
	protected game mainGame;
	
	public notificationsManager(game g)
	{
		mainGame = g;
	}
	
	public abstract void notify6RepeatMove();

	public abstract void notifyCaptureBonus();

	public abstract void notifyExitBonus();

	public abstract void notify3Consecutive6Penalty();

	public abstract void notifyError(String message);

	public abstract void notify6Becomes7Bonus();

	public abstract void notifyGameEnd(String[] positions);

	public abstract void notifyGameLoadingError();

	public abstract void notifyGameStart();

}
