

public class actionRollDice extends action{
	
	private dice diceRef;
	
	public actionRollDice(actionListener actionListener, dice d) throws Exception
	{
		super(actionListener);
		
		diceRef=d;
	}

	@Override
	public void execute()
	{
		actionManager.getInstance().resetActions();
		
		diceRef.roll();
	}

}
