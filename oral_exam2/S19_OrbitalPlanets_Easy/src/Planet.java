import javax.swing.*;
import java.util.List;

/**
 * Created by tbrunscheon on 10/26/16.
 */
public class Planet extends SwingWorker<Integer,Double[]> {
    private final StarPanel fullPanel;
    private int timearound = 0;
    public Planet(StarPanel fullPanel) {
        this.fullPanel = fullPanel;

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
        fullPanel.setPlanetX(publishedCoords.get(0)[0].intValue());
        fullPanel.setPlanetY(publishedCoords.get(0)[1].intValue());
        timearound++;
        fullPanel.repaint();
    }

}
