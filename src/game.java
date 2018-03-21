
public class Game {

	public Player black,white;
	public Player currentPlayer=white;
	public Player opponent=black;
	public Board gameBoard;
	Game(int boardSize)
	{
		gameBoard=new Board(boardSize);
	}
	public void switchPlayer() {
		Player temp=currentPlayer;
		currentPlayer=opponent;
		opponent=temp;
	}
	
	public void check() {
		for()
		{
			game
		}
	}
	
	
}
