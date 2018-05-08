
public class Player {
	
	public SpaceType type;
	private int score=2;
	private boolean movePoss=true;
	private Piece placement;
	
	
	public Player(SpaceType type)
	{
		this.type=type;
	}
	public int getScore() {
		return score;
	}
	
	public Piece getPlacement()
	{
	return placement;	
	}
	
	public void placePiece(int xCoord, int yCoord)
	{
		placement=new Piece(Piece.type, xCoord, yCoord);
	}
	
	
	
}
