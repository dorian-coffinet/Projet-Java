import java.util.Random;

public class UnPoint{
	private int x;
	private int y;
	

	public UnPoint(int dx, int dy){
		x = dx;
		y = dy;
	}
	public UnPoint(){
		Random r = new Random();
		x=r.nextInt(301);
		y=r.nextInt(301);
	 }


	public double distance(UnPoint p2){
	int distanceX;
	int distanceY;
	distanceX = (x - p2.x);
	distanceY = (y - p2.y);
	distanceX *= distanceX;
	distanceY *= distanceY;
	return (Math.sqrt(distanceX + distanceY));
	}
	


	public int rendreX(){
		return x;
	}
	

	public int rendreY(){
		return y;
	}
	

	public void translation(int dx, int dy){
		x+=dx;
		y+=dy;
	}
}