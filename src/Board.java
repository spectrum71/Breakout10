import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int BOARD_WIDTH = 300;
	private static final int BOARD_HEIGHT = 400;
	private Ball ball;
	private Paddle paddle;
	private PaddleController controller;
	private Timer timer;
	private Brick[] bricks;
	private Status scoreboard;
	
	public Board() {
		scoreboard = new Status();
		initTimer();
		createComponents();
		setFocusable(true);
		setLayout(new BorderLayout());
        add("North", scoreboard);
		setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
        timer.start();
	}
	
	public void createComponents() {
		ball = new Ball(150, 252, BOARD_WIDTH);
		paddle = new Paddle(130, 360, BOARD_WIDTH);
		controller = new PaddleController(paddle);
		addKeyListener(controller);
		createBricks();
	}
	
	public void createBricks() {
		int initX = 5;
		int gapX = 45;
		int initY = 40;
		int gapY = 15;
		int brickRows = 5;
		int brickCols = 6;
		bricks = new Brick[brickRows*brickCols];
		int k = 0;
		for (int i=0; i<brickRows; i++) {
			for (int j=0; j<brickCols; j++) {
				int toughness = (int)(Math.random()*3) + 1;
				bricks[k] = new Brick(j*gapX + initX, i*gapY + initY, toughness);
				k++;
			}
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawObjects(g);
	}
	
	public void drawObjects(Graphics g) {
		ball.drawSprite(g);
		paddle.drawSprite(g);
		for (Brick brick: bricks) {
			if (!brick.isDestroyed()) brick.drawSprite(g);
		}
	}
	
	public void initTimer() {
		timer = new Timer(10, this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		doGameCycle();
	}
	
	public void doGameCycle() {
		ball.move();
		paddle.move();
		checkBricks();
		checkCollisions();
		repaint();
	}
	
	public void checkBricks() {
		boolean allDestroyed = true;
		for (Brick brick: bricks) {
			if (!brick.isDestroyed()) allDestroyed = false;
		}
		if (allDestroyed) {
			scoreboard.victory();
			stopGame();
		}
	}
	public void checkCollisions() {
		checkFallBall();
		checkBrickHit();
		checkPaddleHit();
	}
	
	public void checkFallBall() {
		if (ball.getCollisionArea().getMaxY() > BOARD_HEIGHT) stopGame();
	}
	
	public void checkBrickHit() {
		for (Brick brick: bricks) {
			if(ball.getCollisionArea().intersects(brick.getCollisionArea())) {
				int ballLeft = (int) ball.getCollisionArea().getMinX();
                int ballRight = (int) ball.getCollisionArea().getMaxX();
                int ballBottom = (int) ball.getCollisionArea().getMaxY();
                int ballTop = (int) ball.getCollisionArea().getMinY();
                
                if (!brick.isDestroyed()) {
                	scoreboard.advanceCounter();
                	if (brick.getCollisionArea().contains(ballLeft - 1, ballTop + 1) ||
                			brick.getCollisionArea().contains(ballRight + 1, ballTop + 1)) {
                		ball.verticalBounce();
                		
                	} 
                	
                	else if (brick.getCollisionArea().contains(ballLeft + 1, ballTop - 1) ||
                			brick.getCollisionArea().contains(ballLeft + 1, ballBottom + 1)) {
                		ball.horizontalBounce();
                		
                	}
                	brick.hit();
                }
			}
		}
	}
	
	public void checkPaddleHit() {
		if(ball.getCollisionArea().intersects(paddle.getCollisionArea())) {
			ball.horizontalBounce();
		}
	}
	
	public void stopGame() {
		scoreboard.finished();
		timer.stop();
	}
}
