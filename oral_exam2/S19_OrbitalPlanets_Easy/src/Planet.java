import javax.swing.*;
import java.util.List;

/**
 * Created by tbrunscheon on 10/26/16.
 */
public class Planet extends SwingWorker<Integer,Double[]> {
    private final StarPanel fulLPanel;
    private int timearound = 0;
    public Planet(StarPanel fulLPanel) {
        this.fulLPanel = fulLPanel;

    }

    @Override
    public Integer doInBackground() {
        while (true) {
            for (double time = 0; time <= 2 * Math.PI; time = time + .01) {
                Double[] coords = new Double[2];
                coords[0] = 112.5 + (100 * Math.cos(time));
                coords[1] = 112.5 + (100 * Math.sin(time));
                try {
                    Thread.sleep(15);

                } catch (InterruptedException exception) {
                    Thread.currentThread().interrupt();
                }
                publish(coords);
            }
        }
    }

    @Override
    protected void process(List<Double[]> publishedCoords){
        fulLPanel.setPlanetX(publishedCoords.get(0)[0].intValue());
        fulLPanel.setPlanetY(publishedCoords.get(0)[1].intValue());
        timearound++;
        fulLPanel.repaint();
    }

}
