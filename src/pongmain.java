import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class pongmain extends JFrame implements KeyListener {
	IntroScreen p;
	GameScreen g;
	InstructionsScreen i;
	int score;

	public pongmain() {
		super("pong");
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		p = new IntroScreen(this);
		g = new GameScreen(this);
		i = new InstructionsScreen(this);
		this.setMinimumSize(new Dimension(800, 600));
		this.setResizable(false);
		setContentPane(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		next();
	}

	public GameScreen getGame() {
		return g;
	}
	public void setScore(int s) {
		score = s;
	}

	public void next() {
		p.checkNextScreen(this);
		
	}

	public static void main(String[] args) {
		pongmain pong = new pongmain();
	}
	public void goToEnd() {
		this.getContentPane().removeAll();
		this.setContentPane(new EndScreen(this,score));
		this.revalidate();
	}
	public void goToInstructions() {
		this.getContentPane().removeAll();
		this.setContentPane(i);
		this.revalidate();
	}

	public void goToGame(GameScreen g) {
		this.getContentPane().removeAll();
		this.setContentPane(g);
		this.revalidate();
	}

	public void keyPressed(KeyEvent arg0) {

	}

	public void keyReleased(KeyEvent arg0) {

	}

	public void keyTyped(KeyEvent arg0) {
		
	}

}
