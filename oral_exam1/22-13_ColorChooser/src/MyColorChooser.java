import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is the main class of MyColorChooser. It has 1 method with the constructor doing most of the work.
 * The constructor is what creates the GUI window. It first sets the layout of the GUI then initializes
 * the text fields, the sliders and the labels. It then adds all the individual components using
 * the Add method.
 */
public class MyColorChooser extends JFrame{
    /**
     * A new layout of type grid bag. It sets up how the Jframe will look and how components look on it.
     */
    private final GridBagLayout gridBagLayout = new GridBagLayout();
    /**
     * A set of constants that the layout understands. Will be used to format the layout.
     */
    private final GridBagConstraints constraints = new GridBagConstraints();
    /**
     * Value of red.
     */
    private int red=0;
    /**
     * Value of green.
     */
    private int green=0;
    /**
     * Value of blue.
     */
    private int blue=0;

    /**
     * This constructor is what creates the GUI window. It first sets the layout of the GUI then initializes
     * the text fields, the sliders and the labels. It then adds all the individual components using
     * the Add method.
     */
    public MyColorChooser() {
        super("Color Chooser");
        /*
         * The text field that gives the red value of RGB. Can input on it.
         */
        final JTextField rTextField = new JTextField();
        /*
         * The text field that gives the green value of RGB. Can input on it.
         */
        final JTextField gTextField = new JTextField();
        /*
         * The text field that gives the blue value of RGB. Can input on it.
         */
        final JTextField bTextField = new JTextField();
        /*
         * New custom panel to display colors.
         */
        final RectanglePanel myPanel = new RectanglePanel();
        /*
         * The slider that gives the red value of RGB.
         */
        final JSlider rSlider;
        /*
         * The text field that gives the green value of RGB. Can input on it.
         */
        final JSlider gSlider;
        /*
         * The text field that gives the blue value of RGB. Can input on it.
         */
        final JSlider bSlider;



        super.setLayout(gridBagLayout);

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

        final JLabel rLabel = new JLabel("RED");
        final JLabel gLabel = new JLabel("GREEN");
        final JLabel bLabel = new JLabel("BLUE");


        rSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                red = rSlider.getValue();
                myPanel.setColor(red, green, blue);
                rTextField.setText(Integer.toString(red));
            }
        });
        gSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                green = gSlider.getValue();
                myPanel.setColor(red, green, blue);
                gTextField.setText(Integer.toString(green));
            }
        });
        bSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                blue = bSlider.getValue();
                myPanel.setColor(red, green, blue);
                bTextField.setText(Integer.toString(blue));
            }
        });

        rTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rSlider.setValue(Integer.parseInt(rTextField.getText()));
            }
        });
        gTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gSlider.setValue(Integer.parseInt(gTextField.getText()));
            }
        });
        bTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bSlider.setValue(Integer.parseInt(bTextField.getText()));
            }
        });


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

    /**
     * Using polymorphism, this method takes in any component to add to the frame and adds it to the
     * layout at the row column specified with the width and height specified.
     * @param component Component to be added to the frame
     * @param row Row the component to be added at
     * @param column Column the component to be added at
     * @param width Width the of the component
     * @param height Height of the component
     */
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
}