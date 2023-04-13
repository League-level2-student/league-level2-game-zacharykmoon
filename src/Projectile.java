import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Projectile extends GameObject{
public static BufferedImage image;
public static boolean needImage = true;
public static boolean gotImage = false;	
Projectile(int x, int y, int width, int height) {
	super(x,y, width, height);
	this.speed = 10;
	
	if (needImage) {
	    loadImage ("bullet.png");
	}
}
 
void update() {
	y-=10;
    super.update();

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

public static ObjectManager get(int i) {
	// TODO Auto-generated method stub
	return null;
}
}
