
 import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.text.Segment;


public class EatingPlant {
  
	static final int WIDTH = 500;
	static final int HEIGHT = 500;
	JFrame frame;
	GamePanel panel;
	 Pashooter head;
	 int peaX;
	 int peaY;

	 int hx = 250;
	 int hy = 250;
	 int direction = UP;
	 int food = 0;
	 boolean fail = false;
	 int nowx = 250;
	 int nowy = 250;
public void draw() {
    background(205,100,0);
    drawFood();
    drawSnake();
    eat();
    
}
EatingPlant() {
	frame = new JFrame();
	frame.setVisible(true);
	panel = new GamePanel();
	frame.add(panel);
	frame.addKeyListener(panel);
	
}
public static void main(String[] args) {
	EatingPlant eatingplant = new EatingPlant();
	eatingplant.setup();
}
public void setup() {
	head = new Peashooter(250, 250);
	frameRate(20);
	dropFood();
}

void drawFood() {
    // Draw the food
	Peashooter.rect(peaX, peaY, 10, 10);
	Peashooter.fill(160,0,0);
   
}
void drawSnake() {
    // Draw the head of the snake followed by its tail
	Peashooter.stroke(50, 255, 100);    	
	Peashooter.fill(200,0,100);
	Peashooter.rect(head.x,head.y,15,10);
	Peashooter.move();
}


	
void dropFood() {
    // Set the food in a new random location
    peaX = ((int)random(50)*10);
    peaY = ((int)random(50)*10);
}

private int random(int i) {
	// TODO Auto-generated method stub
	return 0;
}
void eat() {
    // When the snake eats the food, its tail should grow and more
    // food appearif (head.x == foodX && head.y == foodY) {
	
		if(peaY >= head.y && peaY <= head.y) {

	dropFood();
			
}
	
}



}