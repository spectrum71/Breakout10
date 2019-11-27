import java.awt.Color;
import java.awt.Graphics;

public class Brick extends Sprite {
	
	private static final int BRICK_WIDTH = 40;
	private static final int BRICK_HEIGHT = 10;
	private static final Color[] colorIndicator = {Color.RED, 
													Color.ORANGE, 
													Color.YELLOW};
	private int toughness;
	
	public Brick(int x, int y, int toughness) {
		super(x,y,BRICK_WIDTH,BRICK_HEIGHT);
		if (toughness <= 0 || toughness > 3) 
			throw new IllegalArgumentException("Set toughness from 1 to 3");
		this.toughness = toughness;
	}

	@Override
	public void drawSprite(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(colorIndicator[toughness-1]);
		g.drawRect(getX(), getY(), BRICK_WIDTH, BRICK_HEIGHT);
		g.fillRect(getX(), getY(), BRICK_WIDTH, BRICK_HEIGHT);
	}
	
	public void hit() {
		toughness -= 1;
	}
	
	public boolean isDestroyed() {
		return toughness <= 0;
	}

}
