import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Traffic implements ActionListener, Runnable {
	
	JFrame frame = new JFrame("Traffic Basic Model");
	Road road = new Road();
	
	// South container
	JButton start = new JButton("Start");
	JButton stop = new JButton("Stop");
	JButton setup = new JButton("Setup");
	Container south = new Container();	
	
	boolean running = false;
	
	public Traffic() {
		frame.setSize(800, 600);
		frame.setLayout(new BorderLayout());
		frame.add(road, BorderLayout.CENTER);
		
		south.setLayout(new GridLayout(1, 3));
		south.add(setup);
		setup.addActionListener(this);
		south.add(start);
		start.addActionListener(this);
		south.add(stop);
		stop.addActionListener(this);
		frame.add(south, BorderLayout.SOUTH);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		frame.repaint();
	}

	public static void main(String[] args) {
		new Traffic();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource().equals(start)) {
			if (running == false) {
				running = true;
				Thread t = new Thread(this);
				t.start();
			}
		}
		if (event.getSource().equals(stop)) {
			running = false;
		}
		if (event.getSource().equals(setup)) {
			Turtle turtle = new Turtle(0, 290); // All vehicles should start from the center of panel height
			road.addCar(turtle);
			/*
			for (int x = 0; x < road.ROAD_WIDTH; x = x + 50) {
				turtle.setX(x);
				if (road.collision(x, turtle) == false) {
					frame.repaint();
					return;
				}
			}
			*/
		}
	}

	@Override
	public void run() {
		while (running == true) {
			road.step();
			frame.repaint();
			try {
				Thread.sleep(100);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

}
