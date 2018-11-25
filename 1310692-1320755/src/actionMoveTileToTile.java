/**import java.util.List;

public class actionMoveTileToTile extends action{
	
	private game mainGame;
	private tile fromTile;
	private tile toTile;
	private int toTileType;
	private boolean shouldRemoveOpponent;

	public actionMoveTileToTile(game g, tile ft, tile tt, int ttType, boolean rm, actionListener ac) throws Exception
	{
		super(ac);
		mainGame = g;
		fromTile = ft;
		toTile = tt;
		toTileType = ttType;
		shouldRemoveOpponent = rm;
	}
	
	@Override
	public void execute() throws Exception
	{
		actionManager.getInstance().resetActions();

		PlayerColor color = mainGame.getCurrentPlayer();

		if (toTile.getPawnCount() > 0 && shouldRemoveOpponent)
		{
			List<PlayerColor> colors = toSquare.getPawnsColors();

			// Opponent in destination, must capture it
			if (colors.get(0) != color)
			{
				PlayerColor opponentColor = colors.get(0);

				// Adds pawn to opponent's yard
				board.getYard(opponentColor).addPawn();

				// Remove opponent pawn
				super.capturedPawn = true;
				toSquare.removePawn(opponentColor);
			}
		}
		
		

		toTile.addPawn(color);

		GameControl.lastMovedPawnPosition = toSquarePosition;
		GameControl.lastMovedPawnDestinationType = SquareType.TRACKSQUARE;

		fromSquare.removePawn(color);
	}

}*/
