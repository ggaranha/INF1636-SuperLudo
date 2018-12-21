package mainGame;
import java.io.File;
import java.awt.*;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import gameInfo.board;
import gameInfo.dice;
import gameInfo.pawn;
import gameInfo.player;
import gameInfo.tile;

public class gameSave {
	
	// TODO - Add support to saving/loading during bonus actions (+10 / +20 after entering pocket and capturing opponent)
		public static game loadFromFile(File file) throws Exception
		{
			Scanner scannerFile = new Scanner(file);
			String[] saveFile = null;

			try
			{
				String line = scannerFile.nextLine();
				if(!scannerFile.hasNextLine())
				{
					saveFile = line.split("\n");
				}
				else
				{
					List<String> save = new LinkedList<String>();
					save.add(line);
					
					while(scannerFile.hasNext())
					{
						line = scannerFile.nextLine();
						save.add(line);
					}
					
					saveFile = save.toArray(new String[0]);
				}
			} catch (Exception e) 
			{
				throw e;
			} finally
			{
				scannerFile.close();
			}

			String parser;
			int line = 0;

			int currentPlayerIndex;
			//action currentAction;
			int currentDice, consecutive6;
			board gameBoard = new board();
			dice gameDice = new dice();
			
			player [] gamePlayers = new player[4];
			gamePlayers[0] = new player("Vermelho", Color.RED, gameBoard, gameBoard.getTile(1, 6), 0, 0);
			gamePlayers[1] = new player("Verde", Color.GREEN, gameBoard, gameBoard.getTile(8, 1), 9, 0);
			gamePlayers[2] = new player("Amarelo", Color.YELLOW, gameBoard, gameBoard.getTile(13, 8), 9, 9);
			gamePlayers[3] = new player("Azul", Color.BLUE, gameBoard, gameBoard.getTile(6, 13), 0, 9);

			// Reading Current Player
			parser = saveFile[line];
			parser = parser.substring(10);

			currentPlayerIndex = Integer.valueOf(parser);

			/** // Reading Current Action
			line++;
			parser = saveFile[line];
			parser = parser.substring(10);
				
			currentAction = action.valueOf(parser);
			*/
			
			// Reading Current Dice
			line++;
			parser = saveFile[line];
			parser = parser.substring(8);
			
			currentDice = Integer.valueOf(parser);
			
			// Reading Current Consecutive 6's
			line++;
			parser = saveFile[line];
			parser = parser.substring(13);

			consecutive6 = Integer.valueOf(parser);

			// Reading Tile Positions and Allocating Pawns
			line++;
			parser = saveFile[line];

			while (parser.contains("TILE"))
			{
				// tilePosX is always between = and &
				int tilePosX = Integer.valueOf(parser.substring(parser.indexOf("=") + 1, parser.indexOf("&")));

				// removing the first part of the parser string
				parser = parser.substring(parser.indexOf("&") + 1);
				
				// tilePosY is always between = and &
				int tilePosY = Integer.valueOf(parser.substring(parser.indexOf("=") + 1, parser.indexOf("&")));

				// removing the first part of the parser string
				parser = parser.substring(parser.indexOf("&") + 1);

				int color = Integer.valueOf(parser.substring(parser.indexOf("=") + 1, parser.indexOf("&")));
				int count = Integer.valueOf(parser.substring(parser.lastIndexOf("=") + 1));
				
				tile tileRef = gameBoard.getTile(tilePosX, tilePosY);
				player playerRef = gamePlayers[color];
				pawn pawnRef = new pawn();

				for (int i = 0; i < count; i++)
				{
					
					for(int j=0; j<4; j++)
					{
						if(playerRef.isPlayerBeginTile(playerRef.getPlayerPawn(j).getPawnTile()))
						{
							pawnRef = playerRef.getPlayerPawn(j);
							break;
						}
					}
					
					tileRef.addTilePawn(pawnRef);
				}

				line++;
				parser = saveFile[line];
			}
			parser = "END OF FILE";

			gameDice.setValueDice(currentDice);
			gameDice.setConsecutive6(consecutive6);
			return new game(gameBoard, gamePlayers, gameDice, currentPlayerIndex);
		}

		public static void saveToFile(game g, File file) throws Exception
		{
			StringBuilder saveString = new StringBuilder();

			saveString.append("CURPLAYER=" + g.getPlayerIndex());
			//saveString.append("\nCURACTION=" + g.getCurrentAction());
			saveString.append("\nCURDICE=" + g.getGameDice().getValueDice());
			saveString.append("\nCONSECUTIVE6=" + g.getGameDice().getConsecutive6());

			for (int i = 0; i < 15; i++)
			{
				for (int j = 0; j < 15; j++)
				{
					tile tileRef = g.getGameBoard().getTile(i, j);
					List<Color> colors = tileRef.getPawnsColors();
					String posX = String.valueOf(i);
					String posY = String.valueOf(j);
					
					colors.forEach(color ->
					{
						saveString.append("\nTILEPOSITIONX=" + posX + "&TILEPOSITIONY=" + posY + "&COLOR=" + g.getColorIndex(color) + "&COUNT="
								+ tileRef.getPawnCountByColor(color));
					});
					
				}
			}

			PrintWriter fileOut = new PrintWriter(file);

			fileOut.write(saveString.toString());
			fileOut.close();
		}

}
