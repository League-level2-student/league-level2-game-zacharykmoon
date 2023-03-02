import processing.core.PApplet;

import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SpaceShooter {
	JFrame frame; 
	JPanel panel;
	public static final int WIDTH = 800;
	public static final int HEIGHT = 800; 

	public static void main(String[] args) {
		SpaceShooter spaceShooter = new SpaceShooter();
		spaceShooter.setup();
	}

	SpaceShooter(){
		JFrame frame = new JFrame();
		frame.setVisible(true);
		  JPanel  panel = new JPanel();
		frame.add(panel);
		frame.addKeyListener((KeyListener) panel);
	}
	
		void setup() {
			frame.setSize(WIDTH, HEIGHT);

			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
		
}
