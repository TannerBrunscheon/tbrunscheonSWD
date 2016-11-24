import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Panel that contains the orbits
 */
public class StarPanel extends JPanel {
    private int planetX =-100;
    private int planetY =-100;

    /**
     * Creates a new planet class and starts the multithreading on it.
     */
    public StarPanel() {
        Planet planet1 = new Planet(this);
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(planet1);
    }

    /**
     * Paints the sun based on set coordinates and draws planet based on coordinates given it.
     * @param g System provided graphics
     */
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.yellow);
        g.fillOval(100,100,50,50);
        g.setColor(Color.green);
        g.fillOval(planetX,planetY,25,25);

    }

    /**
     * Change the X coord of the planet
     * @param planetX Coord to change X to.
     */
    public void setPlanetX(int planetX) {
        this.planetX = planetX;
    }
    /**
     * Change the Y coord of the planet
     * @param planetY Coord to change Y to.
     */
    public void setPlanetY(int planetY) {
        this.planetY = planetY;
    }
}
