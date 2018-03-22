import java.awt.Point;

public class Piece {

	//I used the SpaceType class so many damn times that it just made sense to have a global (public static) variable...
	public static SpaceType type;
	private int coordX;
	private int coordY;
	private boolean isTrapped=false;
	
	Piece(SpaceType type, int coorX, int coordY)
	{
		this.coordX=coordX;
		this.coordY=coordY;
		this.type=type;
	}
	
	public Point getCoord() {
		Point coord=new Point(coordX,coordY);
		return coord;
	}
	
	public SpaceType getType() {
		return type;
	}
	
	public void setType(SpaceType type) {
		this.type = type;
	}
}
