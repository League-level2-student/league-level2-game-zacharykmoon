 

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SpaceShooter implements KeyListener {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	static final int WIDTH = 500;
	static final int HEIGHT = 500;
	JFrame frame = new JFrame();
 JPanel panel = new JPanel();
	JLabel label   = new JLabel();
	
	public static void main(String[] args) {
		SpaceShooter spaceShooter = new SpaceShooter();
		spaceShooter.setup();
		
	}
	

	 


	public  void setup(){
			frame.setVisible(true);
		frame.add(panel);
		frame.addKeyListener(this);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		    loadImage ("Grass.png");
		}
	
	




	 


	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}


	

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
		

}