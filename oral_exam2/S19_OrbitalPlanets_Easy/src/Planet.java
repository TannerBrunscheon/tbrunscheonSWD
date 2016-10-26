import javax.swing.*;
import java.math;
import java.math.MathContext;

/**
 * Created by tbrunscheon on 10/26/16.
 */
public class Planet extends SwingWorker<Integer,Double[]> {

    @Override
    public Integer doInBackground(){
        Double[] coords = new Double[2];
        coords[0] = 50+(100* Math.cos(time));
        coords[1] = 50+(100*Math.sin(time));
        publish(coords);
        return 1;
    }

    protected void process(Double[] publishedCoords){


    }
}
