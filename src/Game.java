import java.awt.Point;

public class Game {

	public Player black=new Player(SpaceType.BLACK),white=new Player(SpaceType.WHITE);
	public Player currentPlayer=white;
	public Player opponent=black;
	public Board gameBoard;
	public Point checkPointer;
	public Point prevPointer;
	Game(int boardSize)
	{
		gameBoard=new Board(boardSize);
	}
	
	public void switchPlayer() {
		Player temp=currentPlayer;
		currentPlayer=opponent;
		opponent=temp;
	}
	
	/**
	 * check() runs in a clockwise direction going from inwards to outwards, going until it finds two color changes (B>W>B)
	 * see Check diagram.png for details
	 */
	
	public void check() {
		checkPointer=gameBoard.findPiece(currentPlayer.getPlacement());
		int colorCounter=0;
		boolean keepChecking=true;
		int hourHand=0;
		while(keepChecking)
		{	
			prevPointer=checkPointer;
			switch(hourHand)
			{
			case 0:	
				checkPointer.y++;
				break;
			case 1:
				checkPointer.y++;
				checkPointer.x++;
				break;
			case 2:
				checkPointer.x++;
				break;
			case 3:
				checkPointer.y--;
				checkPointer.x++;
				break;
			case 4:
				checkPointer.y--;
				break;
			case 5:
				checkPointer.y--;
				checkPointer.x--;
				break;
			case 6:
				checkPointer.x--;
				break;
			case 7:
				checkPointer.y++;
				checkPointer.x--;
				break;
			default: 
				keepChecking=false;
			}
			if(gameBoard.getType(checkPointer).equals(SpaceType.EMPTY)||checkPointer.getX()>gameBoard.getLenHgt()||checkPointer.getY()>gameBoard.getLenHgt()){
				checkPointer=gameBoard.findPiece(currentPlayer.getPlacement());
				hourHand++;
				colorCounter=0;
			}
			else if(gameBoard.getType(prevPointer)!=gameBoard.getType(checkPointer)){
				colorCounter++;
			}
			if(colorCounter>=2)
			{
				flip(hourHand);
			}
		}
	}
	
	public void flip(int hourHand)
	{
		switch(hourHand)
		{
			case 0:	
				checkPointer.y++;
				break;
			case 1:
				checkPointer.y++;
				checkPointer.x++;
				break;
			case 2:
				checkPointer.x++;
				break;
			case 3:
				checkPointer.y--;
				checkPointer.x++;
				break;
			case 4:
				checkPointer.y--;
				break;
			case 5:
				checkPointer.y--;
				checkPointer.x--;
				break;
			case 6:
				checkPointer.x--;
				break;
			case 7:
				checkPointer.y++;
				checkPointer.x--;
				break;
		}
		gameBoard.setType(checkPointer, currentPlayer.type);
	}
}
