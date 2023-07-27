package Snake;

import javax.swing.JFrame; //this line imports the JPanel class from the Swing package

public class GameFrame extends JFrame{ //The GameFrame class extends the JFrame class, so it can use the methods it contains

	GameFrame(){ //constructor to create a new frame and declaring the GamePanel() class
			
		this.add(new GamePanel()); //'this' keyword is used to refer to the current method or constructor without having to create a seperate object for it
		this.setTitle("Snake");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closes the window when the user clicks on the cross button
		this.setResizable(false); //fixes the window/frame size
		this.pack(); //this methods sets the frame such that all its contents are at their preferred size or bigger than their preferred size
		this.setVisible(true);
		this.setLocationRelativeTo(null); //this locates the window or the frame at the centre of the screen
		
	}
}