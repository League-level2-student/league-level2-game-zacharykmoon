import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;


import javax.imageio.ImageIO;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;



@SuppressWarnings("serial")
public class GamePanel extends JPanel implements ActionListener, KeyListener {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	final int MENU = 0;
	Peashooter peashooter = new Peashooter(250, 750 , 50, 50);
	ObjectManager objectManager= new ObjectManager(peashooter);
	final int GAME = 1;
	final int END = 2;
	Font titleFont;
	Font gameFont;
	Font gameInstructions;
	Timer frameDraw;
	Timer zombieSpawn;

	GamePanel (){
		frameDraw = new Timer(1000/6,this);
		frameDraw.start();
	
		if (needImage) {
		    loadImage("Grasslawn.png");
		}
	}
	    
		int currentState = MENU;
	
		void startGame() {
		    zombieSpawn = new Timer(1000/6,this);
		    zombieSpawn.start();
		}


		void updateMenuState() {}
		void updateGameState() {
			objectManager.update();
			if(peashooter.active==false) {
				currentState=END;
			}
		}
		
		void updateEndState() {}
		void drawGameState(Graphics g) {
			if (gotImage) {
				g.drawImage(image, ZombieShooter.WIDTH, ZombieShooter.HEIGHT, null);
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
			g.drawString("Hello neighbor, use peashoooter to fight off the zombies", 150, 250);
			g.drawString("Press Enter to start", 50, 300);
			g.drawString("Press space for info", 50, 500);
		}
		void drawEndState(Graphics g) {
			g.setColor(Color.RED);
			g.fillRect(0, 0, ZombieShooter.WIDTH, ZombieShooter.HEIGHT);
			g.setColor(Color.YELLOW);
			g.setFont(titleFont);
			g.drawString("Game Over", 150, 250);
			g.drawString("You kill "+ objectManager.getScore() +" many enimies", 50, 300);
			g.drawString("Press ENTER to restart", 50, 400);
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
			System.out.println("Before " + currentState);
			if(e.getKeyCode()==KeyEvent.VK_ENTER) {
				if(currentState == END) {
					zombieSpawn.stop();
peashooter = new Peashooter(250, 750, 50, 50);
					objectManager = new ObjectManager(peashooter);
					currentState = MENU;
					}
				else {
					currentState++;
				}
				if(currentState == GAME) {
					startGame();
				}
			}
		
		
		if(e.getKeyCode()==KeyEvent.VK_SPACE && currentState == MENU) {
			JOptionPane.showMessageDialog(null, "Use WASD to move and press space to fire");
		}
		
		if(e.getKeyCode()==KeyEvent.VK_SPACE) {
			if(currentState == GAME) {
			objectManager.addProjectile(peashooter.getProjectile());	
		}
		}
		if(e.getKeyCode()==KeyEvent.VK_UP) {
			System.out.println("UP");
			peashooter.up();
		}
		 
		 
		if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			System.out.println("DOWN");
			peashooter.down();
		}
		if(peashooter.x>450) {
			peashooter.x=450;
		}
		if(peashooter.x<0) {
peashooter.x=0; 
		}
		if(peashooter.y>750) {
			peashooter.y=750;
		}
		if(peashooter.y<0) {
peashooter.y=800;
		}
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
			if(currentState == MENU) {
				updateMenuState();
			}
			else if(currentState == GAME) {
				updateGameState();
			}
			else if(currentState == END) {
				updateEndState();
			}
			//System.out.println("action");
			repaint();
		
		}
	 
		public void paintComponent (Graphics g) {
			if(currentState == MENU){
			    drawMenuState(g);
			}else if(currentState == GAME){
			    drawGameState(g);
			}else if(currentState == END){
			    drawEndState(g);
			}
			
		}
}


