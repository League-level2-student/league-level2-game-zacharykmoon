import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
public class Alien extends GameObject{
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	Alien(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	this.speed =1;
	if (needImage) {
	     loadImage ("alien.png");
	} 
}
	private void loadImage(String string) {
		// TODO Auto-generated method stub
		
	}
}
