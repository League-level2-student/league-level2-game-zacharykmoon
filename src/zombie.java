
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class zombie extends GameObject {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	zombie(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	this.speed =1;
	if (needImage) {
	    loadImage ("zombie.png");
	} 
	}    
  

void update()	 {
	y+=1;
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
}
