import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.Timer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class GamePanel extends JPanel implements ActionListener, KeyListener {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	final int MENU = 0;
	Peashooter peashooter = new Peashooter(250, 750 , 50, 50);
	ObjectManager objectManager1= new ObjectManager(peashooter);
	final int GAME = 1;
	final int END = 2;
	Font titleFont;
	Font gameFont;
	Font gameInstructions;
	Timer frameDraw;
	Timer zombieSpawn;
ObjectManager objectManager= new ObjectManager(peashooter);
	GamePanel (){
		frameDraw = new Timer();
		
		if (needImage) {
		    loadImage ("Grass.png");
		}
		
		void drawGameState(Graphics g) {
			if (gotImage) {
				g.drawImage(image, WIDTH, HEIGHT, null);
			} else {
				g.setColor(Color.BLACK);
				g.fillRect(0, 0, ZombieShooter.WIDTH, ZombieShooter.HEIGHT);
			}
			
			objectManager.draw(g);
			
			//System.out.println("Rocket");
			
		}
		void drawMenuState(Graphics g) {
			g.setColor(Color.BLUE);
			g.fillRect(0, 0, ZombieShooter.WIDTH, ZombieShooter.HEIGHT);
			g.setColor(Color.YELLOW);
			g.setFont(titleFont);
			g.drawString("Hello neighbor, use peashoooter to fiht off the zombies", 150, 250);
			g.drawString("Press Enter to start", 50, 300);
			g.drawString("Press space for info", 50, 500);
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
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
}


