import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.Font.*;
import java.awt.*;

public class GameScreen extends JPanel implements ActionListener, KeyListener {
	private pongmain test;
	int y = 260;
	int xVel = 0;
	int yVel = 0;
	int ballY = 275;
	Timer t;
	boolean right = true;
	boolean left = false;
	boolean up = false;
	boolean down = true;
	boolean keyPress = false;
	int score = 0;
	int lastyVel = 300;
	int rand = 2;
	int randCount = 0;
	int paddleVel = 0;

	public GameScreen(pongmain game) {
		t = new Timer(5, this);
		int width = 800;
		int height = 600;
		this.setBackground(Color.black);
		this.setLayout(null);
		this.setFocusable(true);
		this.requestFocus();
		addKeyListener(this);
		test = game;

	}

	public boolean isFocusTraversable() {
		return true;
	}

	public void paintComponent(Graphics g) {
		this.requestFocus();
		super.paintComponent(g);
		g.setColor(new Color(0, 128, 0));
		g.setFont(new Font("Arial", Font.PLAIN, 20));
		g.drawString("Score: " + score, 670, 50);
		test.setScore(score);
		for (int i = 0; i < 15; i++) {
			g.fillRect(399, 39 * i, 2, 17);
		}
		g.fillRect(8, y, 5, 60);
		if (right) {
			g.fillRect(780, ballY - 30 + yVel, 5, 60);
			lastyVel = ballY - 30 + yVel;
		} else if (left) {
			g.fillRect(780, lastyVel, 5, 60);
		}
		if (right && xVel >= 760) {
			right = false;
			left = true;
			xVel = 0;
			randCount++;
			if (randCount % 6 == 0) {
				rand++;
			}
		}
		if (left && (775 + xVel <= 11) && ((ballY + yVel >= y) && (ballY + yVel <= y + 60))) {
			score++;
			right = true;
			left = false;
			xVel = 0;
			randCount++;
			if (randCount % 6 == 0) {
				rand++;
			}
		} else if (left && (775 + xVel <= 11) && (!((ballY + yVel >= y) && (ballY + yVel <= y + 60)))) {
			test.goToEnd();
		}
		if (up && ballY + yVel < 0) {
			ballY = 0;
			up = false;
			down = true;
			yVel = 0;
		}
		if (down && ballY + yVel > 560) {
			ballY = 560;
			up = true;
			down = false;
			yVel = 0;
		}

		if (right)
			g.fillOval(11 + xVel, ballY + yVel, 8, 8);
		if (left)
			g.fillOval(775 + xVel, ballY + yVel, 8, 8);
		test.setScore(score);
		t.start();
	}

	public void keyPressed(KeyEvent a) {
		this.requestFocus();
		int code = a.getKeyCode();
		if (code == KeyEvent.VK_UP) {
			paddleVel = -3;
			keyPress = true;
		}
		if (code == KeyEvent.VK_DOWN) {
			paddleVel = 3;
			keyPress = true;
		}
		if (y < 0)
			y = 0;
		if (y > 503)
			y = 502;
		repaint();
	}

	public void keyReleased(KeyEvent a) {
		this.requestFocus();
		this.requestFocus();
		int code = a.getKeyCode();
		if (code == KeyEvent.VK_UP) {
			paddleVel = 0;
			keyPress = false;
		}
		if (code == KeyEvent.VK_DOWN) {
			paddleVel = 0;
			keyPress = false;
		}
		if (y < 0)
			y = 0;
		if (y > 503)
			y = 502;
	}

	public void keyTyped(KeyEvent a) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (right)
			xVel += rand;
		if (left)
			xVel -= rand;
		if (y < 0)
			y = 0;
		else if (y > 503)
			y = 502;

		else if (keyPress)
			y += paddleVel;

		if (up)
			yVel -= rand;
		if (down)
			yVel += rand;
		repaint();

	}
}