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
    private final JTextField rTextField = new JTextField();
    private final JTextField gTextField = new JTextField();
    private final JTextField bTextField = new JTextField();
    private final GridBagLayout gridBagLayout = new GridBagLayout();
    private final GridBagConstraints constraints = new GridBagConstraints();
    private final RectanglePanel myPanel;
    private final JSlider rSlider;
    private final JSlider gSlider;
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
    private void add(JSlider slider, int row, int column, int width, int height){
        constraints.gridx=column;
        constraints.gridy=row;
        constraints.gridwidth=width;
        constraints.gridheight=height;
        constraints.weightx=.5;
        constraints.weighty=.5;
        gridBagLayout.setConstraints(slider,constraints);
        add(slider);
    }
    private void add(RectanglePanel panel, int row, int column, int width, int height){
        constraints.gridx=column;
        constraints.gridy=row;
        constraints.gridwidth=width;
        constraints.gridheight=height;
        constraints.weightx=.5;
        constraints.weighty=.5;
        gridBagLayout.setConstraints(panel,constraints);
        add(panel);
    }
    private void add(JTextField textField, int row, int column, int width, int height){
        constraints.gridx=column;
        constraints.gridy=row;
        constraints.gridwidth=width;
        constraints.gridheight=height;
        constraints.weightx=.5;
        constraints.weighty=.5;
        gridBagLayout.setConstraints(textField,constraints);
        add(textField);
    }
    private void add(JLabel label, int row, int column, int width, int height){
        constraints.gridx=column;
        constraints.gridy=row;
        constraints.gridwidth=width;
        constraints.gridheight=height;
        constraints.weightx=.5;
        constraints.weighty=.5;
        gridBagLayout.setConstraints(label,constraints);
        add(label);
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