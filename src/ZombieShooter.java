

 
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ZombieShooter {
	 
	static final int WIDTH = 500;
	static final int HEIGHT = 500;
	JFrame frame;
GamePanel panel;

	
	public static void main(String[] args) {
		ZombieShooter zombieshooter = new ZombieShooter();
		zombieshooter.setup();
		
	}
	ZombieShooter() {
		frame = new JFrame();
		frame.setVisible(true);
		panel = new GamePanel();
		frame.add(panel);
		frame.addKeyListener(panel);
		
	}
		 
		


	


	 


	public  void setup(){
	 
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		   
		}




}

	
	