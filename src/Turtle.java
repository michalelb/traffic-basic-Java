import java.awt.Color;
import java.awt.Graphics;

public class Turtle {
	
	int x;
	int y;
	int width = 40;
	int height = 20;
	int speed = 12;
	
	public Turtle(int newx, int newy) {
		x = newx;
		y = newy;
	}
	
	/* 
	 * All vehicles have the same features. There's a limit to number of vehicles, considering panel width.
	 * One vehicle will be chosen randomly, and will be painted red.
	*/
	
	public void paintMe(Graphics g) { 
		 g.setColor(Color.RED);
		 g.fillRect(x, y, width, height);
		 
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int newx) {
		x = newx;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public int getWidth() {
		return width;
	}

}
