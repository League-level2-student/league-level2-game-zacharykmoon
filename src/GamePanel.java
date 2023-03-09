import java.util.Timer;

}
public class GamePanel {
	GamePanel (){
		frameDraw = new Timer(1000/60, this);
		frameDraw.start();
		if (needImage) {
		    loadImage ("Grass.png");
		}
}
}
