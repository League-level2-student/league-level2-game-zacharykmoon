import java.awt.Graphics;

import javax.swing.text.html.StyleSheet;

public class Projectile extends Piranha {
private double x;
private double y;
BufferedImage image;


public  Projectile(double x, double y, Game game  ) {
	this.x = x;
	this.y = y;
	SpriteSheet ss = new SpriteSheet(game.getSpriteSheet());
	image = ss.grabImage(1,2,2,32);
}
 public void tick() {
	 y -=10;
 }
 public void draw(Graphics g) {
 g.drawImage(image, (int) x, (int) y, null);
}
}