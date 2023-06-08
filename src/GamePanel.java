
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



public class GamePanel extends JPanel implements ActionListener, KeyListener {
	
	private static final long serialVersionUID = 1L;
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	final int MENU = 0;
	
	int currentState = MENU;
	ObjectManager manager= new ObjectManager();
	final int GAME = 1;
	final int END = 2;
	Font titleFont;
	Font gameFont;
	Font gameInstructions;

	Timer zombieSpawn;

	Timer frameDraw;
	void updateMenuState() {}
	void updateGameState() {
		manager.update();
		if(manager.peashooter.active==false) {
			currentState=END;
		}
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
	GamePanel (){
		titleFont = new Font("Arial", Font.PLAIN, 48);
		gameFont = new Font("Arial", Font.PLAIN, 10);
		gameInstructions = new Font("Arial", Font.PLAIN, 28);
		// frameDraw = new Timer(1000/60, this);
		frameDraw = new Timer(1000 / 60, this);
		frameDraw = new Timer(1000/6,this);
		frameDraw.start();
	
		if (needImage) {
		    loadImage("grass.png");
		}
	}
	    
	
	
		void startGame() {
		    zombieSpawn = new Timer(1000/6, this);
		    zombieSpawn.start();
		}

void endGame() {
	zombieSpawn.stop();
}
		
		
		void updateEndState() {}
		void drawGameState(Graphics g) {
			if (gotImage) {
				g.drawImage(image, ZombieShooter.WIDTH, ZombieShooter.HEIGHT, null);
			} else {
				g.setColor(Color.BLACK);
				g.fillRect(0, 0, ZombieShooter.WIDTH, ZombieShooter.HEIGHT);
			}
			
			manager.draw(g);
			
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
			g.drawString("You kill "+ manager.getScore() +" many enimies", 50, 300);
			g.drawString("Press ENTER to restart", 50, 400);
		}
		


		
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			System.out.println("Before " + currentState);
			if(e.getKeyCode()==KeyEvent.VK_ENTER) {
				if(currentState == END) {
					zombieSpawn.stop();
manager.peashooter = new Peashooter(250, 750, 50, 50);
					manager = new ObjectManager();
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
			
			manager.addProjectile(manager.peashooter.getProjectile());	
		
		}
		if(e.getKeyCode()==KeyEvent.VK_UP) {
			System.out.println("UP");
			manager.peashooter.up();
		}
		 
		 
		if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			System.out.println("DOWN");
			manager.peashooter.down();
		}	 
			if(e.getKeyCode()==KeyEvent.VK_LEFT) {
				System.out.println("LEFT");
				manager.peashooter.left();
		}
			if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
				System.out.println("RIGHT");
				manager.peashooter.right();
		}
		if(manager.peashooter.x>450) {
			manager.peashooter.x=450;
		}
		if(manager.peashooter.x<0) {
manager.peashooter.x=0; 
		}
		if(manager.peashooter.y>750) {
			manager.peashooter.y=750;
		}
		if(manager.peashooter.y<0) {
manager.peashooter.y=800;
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


