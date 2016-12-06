import javax.swing.*;

/**
 * Driver file that sets up the GUI
 */
public class OrbitDriver {
    public static void main(String[] args) {
        OrbitFrame orbitFrame = new OrbitFrame();
        orbitFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        orbitFrame.setSize(300,300);
        orbitFrame.setVisible(true);
    }
}
