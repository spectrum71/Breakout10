import javax.swing.JFrame;

public class Game extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Game() {
		super("Breakout 1.0");
		setTitle("Breakout 1.0");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		add(new Board());
        validate();
        pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Game();
	}
}
