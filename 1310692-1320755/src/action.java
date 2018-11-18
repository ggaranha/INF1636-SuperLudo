public abstract class action implements Iaction{
	
	private actionListener listener;

	protected boolean capturedPawn = false;

	public action(actionListener listener) throws Exception
	{
		if (listener == null)
		{
			throw new Exception("ActionListener cannot be null.");
		}
		
		this.listener = listener;
	}

	protected void onActionExecuted()
	{
		listener.onActionExecuted(capturedPawn);
	}

}
