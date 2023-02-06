import javax.swing.*; 
import java.io.File;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.event.*;
import javax.swing.Timer;
import javax.imageio.ImageIO;
public class EndScreen extends JPanel implements ActionListener{
	private pongmain test;
	private JButton playButton; private JButton instructionsButton;
	String get;
	int scoreF;
	public EndScreen (pongmain game, int score) {
		int width = 800;
		int height = 600;
		this.setBackground(Color.black); 
		this.setLayout(null);
		playButton = new JButton ("Play Again");
		playButton.setActionCommand("P");
		playButton.addActionListener(this);
		playButton.setBackground(new Color (0,128,0));
		playButton.setForeground(Color.BLACK);
		playButton.setSize((int) (width*.3), (int) (height*.12));
		playButton.setLocation((int) (width*.35), (int)(height*.51));
		playButton.setFont(new Font ("Arial", Font.PLAIN, (int)(height/17)));
		this.add(playButton);
		test = game;
		scoreF = score;
	}
	public void paintComponent (Graphics g) {
		super.paintComponent(g);
		g.setColor(new Color (0,128,0));
		g.setFont(new Font("Arial", Font.PLAIN, 50));
		g.drawString("Game Over. Score: " + scoreF, 170, 200);
	}
	public void actionPerformed (ActionEvent event) {
		get = event.getActionCommand();
		checkNextScreen(test);
	}
	public void checkNextScreen(pongmain game) {
			if(get == "P") {
				game.goToGame(new GameScreen(game));
			}
	}
}