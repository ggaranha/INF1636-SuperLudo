
public class actionMoveFromBeginToExitTile extends action{
	
	player playerRef;
	pawn pawnRef;
	tile beginTileRef;

	public actionMoveFromBeginToExitTile(player p, actionListener listener)
			throws Exception
	{
		super(listener);
		playerRef = p;
		
		for(int i=0; i<4; i++)
		{
			if(playerRef.isPlayerBeginTile(playerRef.getPlayerPawn(i).getPawnTile()))
			{
				pawnRef = playerRef.getPlayerPawn(i);
				beginTileRef = pawnRef.getPawnTile();
				return;
			}
		}
	}

	@Override
	public void execute() throws Exception
	{
		actionManager.getInstance().resetActions();
		
		playerRef.getPlayerExitTile().setTilePawn(pawnRef);
		beginTileRef.removeTilePawn();
	}

}
