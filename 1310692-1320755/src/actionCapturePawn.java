
public class actionCapturePawn extends action{
	
	player playerCapturedRef;
	pawn capturerPawnRef;
	pawn capturedPawnRef;

	public actionCapturePawn(pawn capturerPawn, pawn capturedPawn, actionListener listener)
			throws Exception
	{
		super(listener);
		
		capturerPawnRef = capturerPawn;
		capturedPawnRef = capturedPawn;
		playerCapturedRef = capturedPawnRef.getPawnPlayer();
	}

	@Override
	public void execute() throws Exception
	{
		actionManager.getInstance().resetActions();
	}

}
