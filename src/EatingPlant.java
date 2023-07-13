
 import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.text.Segment;


public class EatingPlant {
  
	public EatingPlant() {
		JFrame frame =  new JFrame();
		GamePanel gamepanel = new GamePanel();
		frame.add(gamepanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("SNAKINGCODING");
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);
	}

public static void main(String[] args) {
	new EatingPlant();
}
}
