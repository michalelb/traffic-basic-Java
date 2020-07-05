import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Road extends JPanel {
	
	final int LANE_HEIGHT = 100;
	final int ROAD_WIDTH = 1000;
	ArrayList<Turtle> cars = new ArrayList<Turtle>();
	
	public Road() {
		super();
	}
	
	public void addCar(Turtle t) {
		cars.add(t);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 250, this.getWidth(), LANE_HEIGHT);
	
		// Draw cars
		for (int a = 0; a < cars.size(); a++) {
			cars.get(a).paintMe(g);
		}

	}
	
	public void step() {
		for (int a = 0; a < cars.size(); a++) {
			Turtle t = cars.get(a);
			t.setX(t.getX() + t.getSpeed());
			if (t.getX() > ROAD_WIDTH) {
				t.setX(0);
			}
			/*
			if (collision(t.getX() + t.getSpeed(), t) == false) { // there's no collision
				t.setX(t.getX() + t.getSpeed());
				if (t.getX() > ROAD_WIDTH) {
					if (collision(0, t) == false) {
						t.setX(0);
					}
				}
			}
			else { // car ahead!
				
			}
			*/
		}
	}
	
	/*
	public boolean collision(int x, Turtle t) {
		for (int a = 0; a < cars.size(); a++) {
			Turtle s = cars.get(a);
			if (s.equals(t) == false) { // if I'm not checking myself
				if (x < s.getX() + s.getWidth() && // my left side is left of his right side
						x + t.getWidth() > t.getX()) { // my right side is right of his left side
					return true;
				}
			}
		}
		return false;
	}
	*/
	
}