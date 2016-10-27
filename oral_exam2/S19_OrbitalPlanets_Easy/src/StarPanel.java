import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by tbrunscheon on 10/26/16.
 */
public class StarPanel extends JPanel {
    private int planetX =-100;
    private int planetY =-100;


    public StarPanel() {
        Planet planet1 = new Planet(this);
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(planet1);
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.yellow);
        g.fillOval(100,100,50,50);
        g.setColor(Color.green);
        g.fillOval(planetX,planetY,25,25);

    }

    public void setPlanetX(int planetX) {
        this.planetX = planetX;
    }

    public void setPlanetY(int planetY) {
        this.planetY = planetY;
    }
}
