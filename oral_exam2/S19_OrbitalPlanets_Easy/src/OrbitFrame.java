import javax.swing.*;

/**
 * Simple frame that holds the star panel that holds the panet.
 */
public class OrbitFrame extends JFrame{
    /**
     * Panel to add to the mostly empty frame.
     */
    StarPanel starPanel = new StarPanel();

    /**
     * Adds a starPanel to the frame
     */
    public OrbitFrame(){
        super("Orbiting");
        add(starPanel);
    }

}
