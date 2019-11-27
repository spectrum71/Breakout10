import javax.swing.JLabel;

public class Status extends JLabel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int counter = 0;
    public Status()
    {
        super();
        counter = 0;
        setText("Bouncy Points: " + counter + " points");
    }
    public void advanceCounter()
    {
        counter++;
        setText("Bouncy Points: " + counter + " points");
    }
    public void resetCounter()
    {
        counter = 0;
        setText("Bouncy Points: " + counter + " points");
    }
}
