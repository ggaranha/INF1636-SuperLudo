import java.awt.Color;

public class actionMoveTileToTile extends action{
	
	private game mainGame;
	private tile fromTile;
	private tile toTile;
	private int toTileType;
	private pawn fromTilePawn;
	private boolean shouldRemoveOpponent;

	public actionMoveTileToTile(game g, tile ft, tile tt, int ttType, boolean rm, actionListener ac) throws Exception
	{
		super(ac);
		mainGame = g;
		fromTile = ft;
		fromTilePawn = fromTile.getTilePawn();
		toTile = tt;
		toTileType = ttType;
		shouldRemoveOpponent = rm;
	}
	
	@Override
	public void execute() throws Exception
	{	
		actionManager.getInstance().resetActions();

		Color c = mainGame.getCurrentPlayer().getPlayerColor();
		fromTile.removeTilePawn();

		if (!toTile.isTileEmpty() && shouldRemoveOpponent)
		{
			pawn toTilePawn = toTile.getTilePawn();
			
			if(toTilePawn.getPawnColor() != c)
			{
				player toTilePawnPlayer = toTilePawn.getPawnPlayer();
				tile beginRef;
				
				for(int i=0;i<4;i++)
				{
					beginRef = toTilePawnPlayer.getPlayerPawnBeginTile(i);
					if(beginRef.isTileEmpty())
					{
						beginRef.setTilePawn(toTilePawn);
						break;
					}
				}
				
				
			}

			// Remove opponent pawn
			super.capturedPawn = true;
		}
		
		toTile.setTilePawn(fromTilePawn);
		
		

		//gameControl.lastMovedPawnPosition = toSquarePosition;
		//gameControl.lastMovedPawnDestinationType = SquareType.TRACKSQUARE;
	}

}
