import javax.swing.JLabel;

public class Status extends JLabel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int counter = 0;
	private boolean victory = false;
    public Status()
    {
        super();
        counter = 0;
        setText("SCORE: " + counter);
    }
    public void advanceCounter()
    {
        counter++;
        setText("SCORE: " + counter);
    }
    
    public void resetCounter()
    {
        counter = 0;
        setText("SCORE: " + counter);
    }
    
    public void victory() {
    	victory = true;
    }
    
    public void finished() {
    	if (victory) setText("Victory! FINAL SCORE: " + counter);
    	else setText("Game Over. FINAL SCORE: " + counter);
    }
}
