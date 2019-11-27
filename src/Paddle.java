import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Paddle extends Sprite {
	
	private static final int PADDLE_WIDTH = 75;
	private static final int PADDLE_HEIGHT = 10;
	private int boardWidth;
	private int dx;
	
	public Paddle(int x, int y, int boardWidth) {
		super(x,y,PADDLE_WIDTH,PADDLE_HEIGHT);
		this.boardWidth = boardWidth;
		dx = 0;
	}
	
	void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) dx = -1;
        else if (key == KeyEvent.VK_RIGHT) dx = 1;
    }

    void keyReleased(KeyEvent e) {

    	int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) dx = 0;
        else if (key == KeyEvent.VK_RIGHT) dx = 0;
    }
	
	public void move() {
		setX(getX()+dx);
		if(getX()<=0) setX(0);
		else if(getX()>=boardWidth - PADDLE_WIDTH) setX(boardWidth - PADDLE_WIDTH);
	}

	@Override
	public void drawSprite(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLUE);
		g.drawRect(getX(), getY(), PADDLE_WIDTH, PADDLE_HEIGHT);
		g.fillRect(getX(), getY(), PADDLE_WIDTH, PADDLE_HEIGHT);
	}

}
