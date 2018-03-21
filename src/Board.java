public class Board {

	private int size;
	private int lenHgt;
	private SpaceType[][] Values;
	
	Board(int size) {
		this.size=size;
		this.lenHgt=(int) Math.sqrt(size);
		this.Values=new SpaceType[lenHgt][lenHgt];
		//Setting all board spaces to empty
		for(int yIterator=0;yIterator<Values.length;yIterator++) {
			for(int xIterator=0;xIterator<Values.length;xIterator++) {
				Values[yIterator][xIterator]=Piece.type.EMPTY;
			}
		}
		//Setting starting pieces
		Values[lenHgt/2-1][lenHgt/2-1]=Piece.type.WHITE;
		Values[lenHgt/2][lenHgt/2]=Piece.type.BLACK;
		Values[lenHgt/2-1][lenHgt/2]=Piece.type.WHITE;
		Values[lenHgt/2][lenHgt/2-1]=Piece.type.BLACK;
	}
	
	public SpaceType findIndex(int x,int y)
	{
	return Values[y][x];
	}
	
	public int[] findPiece(Piece piece)
	{
		return piece.getCoord();
	}
	public String toString()
	{
		StringBuilder build=new StringBuilder();
		for(int yIterator=0;yIterator<Values.length;yIterator++) {
			for(int xIterator=0;xIterator<Values.length;xIterator++) {
				switch(Values[yIterator][xIterator]) {
				case EMPTY: build.append('E');
				break;
				case BLACK: build.append('B');
				break;
				case WHITE: build.append('W');
				break; 
				default: build.append('X');
				break;
				}
				build.append("\t");
			}
			build.append("\n");
		}
		
		return build.toString();
	}
	
}
