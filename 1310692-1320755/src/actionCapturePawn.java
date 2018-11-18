
public class actionCapturePawn extends action{
	
	player playerCapturedRef;
	pawn capturerPawnRef;
	pawn capturedPawnRef;
	tile tileCapturedRef;

	public actionCapturePawn(pawn capturerPawn, pawn capturedPawn, actionListener listener)
			throws Exception
	{
		super(listener);
		
		capturerPawnRef = capturerPawn;
		capturedPawnRef = capturedPawn;
		playerCapturedRef = capturedPawnRef.getPawnPlayer();
		tileCapturedRef = capturedPawn.getPawnTile();
	}

	@Override
	public void execute() throws Exception
	{
		tile beginRef;
		
		tileCapturedRef.removeTilePawn();
		tileCapturedRef.setTilePawn(capturedPawnRef);
		
		for(int i=0;i<4;i++)
		{
			beginRef = playerCapturedRef.getPlayerPawnBeginTile(i);
			if(beginRef.isTileEmpty())
			{
				beginRef.setTilePawn(capturedPawnRef);
				break;
			}
		}
		
		actionManager.getInstance().resetActions();
	}

}
