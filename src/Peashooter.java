
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Peashooter {
	private int xCoor,  yCoor, width, height;, 
	public Peashooter(int xCoor, int yCoor , int width,int height, int tileSize) {
		this.xCoor = xCoor;
		this.yCoor = yCoor;
		width = tileSize;
		height = tileSize;
	}
public void tick() {
	
}
public void draw(Graphics g){
	g.setColor(Color.YELLOW);
	g.fillRect(xCoor * width, yCoor* height,width,height);
}

public int getxCoor() {
	return xCoor;
}
public void setxCoor(int xCoor) {
	this.xCoor = xCoor;
}
public int y() {
	return yCoor;
}
public void setyCoor(int yCoor) {
	this.yCoor = yCoor;
}
}