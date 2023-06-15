import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Peashooter peashooter;
	Random rand = new Random();
	
	
	int score = 0;
	Random ran = new Random();

	ObjectManager() { 
		 
		peashooter   = new Peashooter(50,50,50,50);
	   
		}
	int getScore() {
		return score;
	}
	

	
	
	


	

	void draw(Graphics g) {
		peashooter.draw(g);
		
		
	}
	
	
	

	
		
	

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
