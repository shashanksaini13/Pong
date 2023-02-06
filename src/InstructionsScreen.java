import javax.swing.*; 
import java.io.File;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.event.*;

import javax.imageio.ImageIO;
public class InstructionsScreen extends JPanel implements ActionListener{
	private pongmain game;
	JButton back;
	String get; 
	public InstructionsScreen(pongmain game) {
		int width = 800;
		int height = 600;
		this.setBackground(Color.black); 
		this.setLayout(null);
		back = new JButton ("Play");
		back.setActionCommand("B");
		back.addActionListener(this);
		back.setBackground(new Color (0,128,0));
		back.setForeground(Color.BLACK);
		back.setSize((int) (width*.3), (int) (height*.12));
		back.setLocation((int) (width*.35), (int)(height*.51));
		back.setFont(new Font ("Arial", Font.PLAIN, (int)(height/17)));
		back.setActionCommand("B");
		back.addActionListener(this);
		this.add(back);
		this.game = game;
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(new Color (0,128,0));
		g.setFont(new Font("Arial",Font.PLAIN, 19));
		g.drawString("Move your paddle with the up and down arrow, and keep hitting the ball with it.", 100, 200);
	}
	public void actionPerformed (ActionEvent event) {
		get = event.getActionCommand();
		checkNextScreen(game);
	}
	public void checkNextScreen(pongmain game) {
			if(get == "B") {
				game.goToGame(game.getGame());
			}
	}

}
