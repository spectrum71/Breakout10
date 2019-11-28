import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Sprite {
	private static final int BALL_DIAMETER = 8;
	private int dx;
	private int dy;
	private int boardWidth;
	
	public Ball(int x, int y, int boardWidth) {
		super(x,y,BALL_DIAMETER,BALL_DIAMETER);
		// random direction on x
		dx = Math.random() > 0.5 ? 1 : -1;
		
		// always move up on y
		dy = -1;
		this.boardWidth = boardWidth;
	}

	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}

	@Override
	public void drawSprite(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLACK);
		g.fillOval(getX(), getY(), BALL_DIAMETER, BALL_DIAMETER);
	}
	
	public void move() {
		setX(getX()+dx);
		setY(getY()+dy);
		if(getX()<=0) dx = 1;
		else if(getX()>=boardWidth - BALL_DIAMETER) dx = -1;
		
		if(getY()<=0) dy = 1;
	}
	
	public void horizontalBounce() {
		dy *= -1;
	}
	
	public void verticalBounce() {
		dx *= -1;
	}

}
