import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PaddleController implements KeyListener {
	private Paddle paddle;
	
	public PaddleController(Paddle paddle) {
		this.paddle = paddle;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		paddle.keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		paddle.keyReleased(e);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// do nothing
		
	}

}
