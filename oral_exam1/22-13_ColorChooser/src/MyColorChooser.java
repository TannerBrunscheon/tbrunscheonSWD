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
    private final GridBagLayout layout = new GridBagLayout();
    private final GridBagConstraints constraints = new GridBagConstraints();
    private final RectanglePanel myPanel;
    private final JSlider rSlider;
    private final JSlider gSlider;
    private final JSlider bSlider;
    private int red=0;
    private int green=0;
    private int blue=0;
    private final JLabel rLabel = new JLabel("RED");
    private final JLabel gLabel = new JLabel("GREEN");
    private final JLabel bLabel = new JLabel("BLUE");


    public MyColorChooser() {
        super("Color Chooser");
        super.setLayout(layout);

        myPanel = new RectanglePanel();

        rTextField.setText("0");
        gTextField.setText("0");
        bTextField.setText("0");

        rSlider = new JSlider(SwingConstants.HORIZONTAL,0,255,0);
        rSlider.setMajorTickSpacing(8);
        rSlider.setPaintTicks(true);

        gSlider = new JSlider(SwingConstants.HORIZONTAL,0,255,0);
        gSlider.setMajorTickSpacing(8);
        gSlider.setPaintTicks(true);

        bSlider = new JSlider(SwingConstants.HORIZONTAL,0,255,0);
        bSlider.setMajorTickSpacing(8);
        bSlider.setPaintTicks(true);


        //TODO Implement Actual Listners from class
        rSlider.addChangeListener(
                new ChangeListener()
                {
                    @Override
                    public void stateChanged(ChangeEvent e) {
                        red = rSlider.getValue();
                        myPanel.setColor(red,green,blue);
                        rTextField.setText(Integer.toString(red));
                    }
                }
        );
        gSlider.addChangeListener(
                new ChangeListener()
                {
                    @Override
                    public void stateChanged(ChangeEvent e) {
                        green = gSlider.getValue();
                        myPanel.setColor(red,green,blue);
                        gTextField.setText(Integer.toString(green));
                    }
                }
        );
        bSlider.addChangeListener(
                new ChangeListener()
                {
                    @Override
                    public void stateChanged(ChangeEvent e) {
                        blue = bSlider.getValue();
                        myPanel.setColor(red,green,blue);
                        bTextField.setText(Integer.toString(blue));
                    }
                }
        );
        rTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                red = Integer.parseInt(rTextField.getText());
                rSlider.setValue(red);
            }
        });
        gTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                green = Integer.parseInt(gTextField.getText());
                gSlider.setValue(green);
            }
        });
        bTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                blue = Integer.parseInt(bTextField.getText());
                bSlider.setValue(blue);
            }
        });


        constraints.fill = GridBagConstraints.BOTH;

        this.addComponent(rSlider,2,0,2,1);
        this.addComponent(rTextField,1,1,2,1);
        this.addComponent(rLabel,0,0,2,1);
        this.addComponent(gSlider,2,2,2,1);
        this.addComponent(gTextField,1,2,2,1);
        this.addComponent(gLabel,0,2,2,1);
        this.addComponent(bSlider,5,0,2,1);
        this.addComponent(bTextField,4,0,2,1);
        this.addComponent(bLabel,3,0,2,1);
        this.addComponent(myPanel,4,2,3,2);


    }

    //Compied from
    private void addComponent(JSlider slider, int row, int column, int width, int height){
        constraints.gridx=column;
        constraints.gridy=row;
        constraints.gridwidth=width;
        constraints.gridheight=height;
        constraints.weightx=.5;
        constraints.weighty=.5;
        layout.setConstraints(slider,constraints);
        add(slider);
    }
    private void addComponent(RectanglePanel panel, int row, int column, int width, int height){
        constraints.gridx=column;
        constraints.gridy=row;
        constraints.gridwidth=width;
        constraints.gridheight=height;
        constraints.weightx=.5;
        constraints.weighty=.5;
        layout.setConstraints(panel,constraints);
        add(panel);
    }
    private void addComponent(JTextField textField, int row, int column, int width, int height){
        constraints.gridx=column;
        constraints.gridy=row;
        constraints.gridwidth=width;
        constraints.gridheight=height;
        constraints.weightx=.5;
        constraints.weighty=.5;
        layout.setConstraints(textField,constraints);
        add(textField);
    }
    private void addComponent(JLabel label, int row, int column, int width, int height){
        constraints.gridx=column;
        constraints.gridy=row;
        constraints.gridwidth=width;
        constraints.gridheight=height;
        constraints.weightx=.5;
        constraints.weighty=.5;
        layout.setConstraints(label,constraints);
        add(label);
    }
}
