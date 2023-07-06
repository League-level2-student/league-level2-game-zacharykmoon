import java.awt.Color;
import java.awt.Graphics;

public class Apple {
		private int xCoor,  yCoor, width, height;
		public Apple(int xCoor, int yCoor , int width,int height, int tileSize) {
			this.xCoor = xCoor;
			this.yCoor = yCoor;
			width = tileSize;
			height = tileSize;
		}
	public Apple(int xCoor2, int yCoor2, int i) {
			// TODO Auto-generated constructor stub
		}
	public void tick() {
		
	}
	public void draw(Graphics g){
		g.setColor(Color.RED );
		g.fillRect(xCoor * width, yCoor* height,width,height);
	}

}
