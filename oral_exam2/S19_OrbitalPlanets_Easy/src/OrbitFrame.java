import javax.swing.*;

/**
 * Created by tbrunscheon on 10/26/16.
 */
public class OrbitFrame extends JFrame{
    StarPanel starPanel = new StarPanel();
    public OrbitFrame(){
        super("Orbiting");
        add(starPanel);
    }

}
