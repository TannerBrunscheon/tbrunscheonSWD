import javax.swing.*;
import java.util.List;

/**
 * Created by tbrunscheon on 10/26/16.
 */
public class Planet extends SwingWorker<Void,Double[]> {
    private final StarPanel fullPanel;
    /**
     * Constructor that allows the editing of the panel with the planet
     * @param fullPanel The panel that will be fed the values.
     */
    public Planet(StarPanel fullPanel) {
        this.fullPanel = fullPanel;

    }

    /**
     * Overwritten doInBackground function that calculates X and Y values for a circle in an infinite loop
     * @return It returns nothing
     */

    @Override
    public Void doInBackground() {
        while (true) {
            for (double time = 0; time <= 2 * Math.PI; time = time + .01) {
                //Set up the array for the coords.One for X value one for Y
                Double[] coords = new Double[2];
                //Do the math on the X and Y values
                coords[0] = 112.5 + (100 * Math.cos(time));
                coords[1] = 112.5 + (100 * Math.sin(time));
                //Sleep the thread this slows the orbit
                try {
                    Thread.sleep(15);

                } catch (InterruptedException exception) {
                    Thread.currentThread().interrupt();
                }
                //Send out calculated coords
                publish(coords);
            }
        }
    }

    /**
     * Changes the values of cooridinte in the main class
     * @param publishedCoords Coordinates published in the doInBackground method
     */
    @Override
    protected void process(List<Double[]> publishedCoords){
        //Change the X and Y values and redraw the planet.
        fullPanel.setPlanetX(publishedCoords.get(0)[0].intValue());
        fullPanel.setPlanetY(publishedCoords.get(0)[1].intValue());
        fullPanel.repaint();
    }

}
