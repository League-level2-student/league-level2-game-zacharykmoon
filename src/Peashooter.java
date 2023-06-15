
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Peashooter extends GameObject{
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	
	Peashooter(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub 
		if (needImage) {
		    loadImage ("peashooter.png");
		}
		speed = 30;
	}
public void draw(Graphics g) { 
	if (gotImage) {
		g.drawImage(image, x, y, width, height, null);
	} else {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}

}
		
public void right() {
	x+=speed;
}
public void left() {
	x-=speed;
}
public void up() {
	y-=speed;
}
public void down() {
	y+=speed;
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
public static void stroke(int i, int j, int k) {
	// TODO Auto-generated method stub
	
}
public static void rect(int x, int y, int i, int j) {
	// TODO Auto-generated method stub
	
}
public static void fill(int i, int j, int k) {
	// TODO Auto-generated method stub
	
}
public static void move() {
	// TODO Auto-generated method stub
	
}
public static void size(int i, int j) {
	// TODO Auto-generated method stub
	
}

}