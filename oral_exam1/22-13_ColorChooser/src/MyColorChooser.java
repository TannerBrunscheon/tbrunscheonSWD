import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Tanner on 9/25/2016.
 */
public class MyColorChooser extends JFrame{
    /**
     * The text field that gives the red value of RGB. Can input on it.
     */
    private final JTextField rTextField = new JTextField();
    /**
     * The text field that gives the green value of RGB. Can input on it.
     */
    private final JTextField gTextField = new JTextField();
    /**
     * The text field that gives the blue value of RGB. Can input on it.
     */
    private final JTextField bTextField = new JTextField();
    /**
     * A new layout of type grid bag. It sets up how the Jframe will look and how components look on it.
     */
    private final GridBagLayout gridBagLayout = new GridBagLayout();
    /**
     * A set of constants that the layout understands. Will be used to format the layout.
     */
    private final GridBagConstraints constraints = new GridBagConstraints();
    /**
     * New custom panel to display colors.
     */
    private final RectanglePanel myPanel;
    /**
     * The slider that gives the red value of RGB.
     */
    private final JSlider rSlider;
    /**
     * The text field that gives the green value of RGB. Can input on it.
     */
    private final JSlider gSlider;
    /**
     * The text field that gives the bed value of RGB. Can input on it.
     */
    private final JSlider bSlider;
    private int red=0;
    private int green=0;
    private int blue=0;


    public MyColorChooser() {
        super("Color Chooser");

        super.setLayout(gridBagLayout);

        myPanel = new RectanglePanel();

        rTextField.setText("0");
        gTextField.setText("0");
        bTextField.setText("0");
        rSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 255, 0);
        rSlider.setMajorTickSpacing(8);
        rSlider.setPaintTicks(true);
        gSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 255, 0);
        gSlider.setMajorTickSpacing(8);
        gSlider.setPaintTicks(true);
        bSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 255, 0);
        bSlider.setMajorTickSpacing(8);
        bSlider.setPaintTicks(true);

        SliderHandler sliderHandler = new SliderHandler();
        TextHandler textHandler = new TextHandler();


        rSlider.addChangeListener(sliderHandler);
        gSlider.addChangeListener(sliderHandler);
        bSlider.addChangeListener(sliderHandler);

        rTextField.addActionListener(textHandler);
        gTextField.addActionListener(textHandler);
        bTextField.addActionListener(textHandler);

        final JLabel rLabel = new JLabel("RED");
        final JLabel gLabel = new JLabel("GREEN");
        final JLabel bLabel = new JLabel("BLUE");

        constraints.fill = GridBagConstraints.BOTH;

        this.add(rSlider, 2, 0, 2, 1);
        this.add(rTextField, 1, 1, 2, 1);
        this.add(rLabel, 0, 0, 2, 1);
        this.add(gSlider, 2, 2, 2, 1);
        this.add(gTextField, 1, 2, 2, 1);
        this.add(gLabel, 0, 2, 2, 1);
        this.add(bSlider, 5, 0, 2, 1);
        this.add(bTextField, 4, 0, 2, 1);
        this.add(bLabel, 3, 0, 2, 1);
        this.add(myPanel, 4, 2, 3, 2);

    }
    private void add(Component component, int row, int column, int width, int height){
        constraints.gridx=column;
        constraints.gridy=row;
        constraints.gridwidth=width;
        constraints.gridheight=height;
        constraints.weightx=.5;
        constraints.weighty=.5;
        gridBagLayout.setConstraints(component,constraints);
        add(component);
    }
    private class SliderHandler implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            if (e.getSource()== rSlider) {
                red = rSlider.getValue();
                myPanel.setColor(red, green, blue);
                rTextField.setText(Integer.toString(red));
            }
            else if (e.getSource()== gSlider) {
                green = gSlider.getValue();
                myPanel.setColor(red, green, blue);
                gTextField.setText(Integer.toString(green));
            }
            else if (e.getSource()== bSlider) {
                blue = bSlider.getValue();
                myPanel.setColor(red, green, blue);
                bTextField.setText(Integer.toString(blue));
            }
        }
    }
    private class TextHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()== rTextField) {
                rSlider.setValue(Integer.parseInt(rTextField.getText()));
            }
            else if(e.getSource()==gTextField){
                gSlider.setValue(Integer.parseInt(gTextField.getText()));
            }
            else if(e.getSource()==bTextField){
                bSlider.setValue(Integer.parseInt(bTextField.getText()));
            }
        }


    }

}