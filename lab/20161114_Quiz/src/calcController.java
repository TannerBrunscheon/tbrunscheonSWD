import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.math.BigDecimal;

/**
 * Created by tbrunscheon on 11/14/16.
 */
public class calcController {
    @FXML
    private TextField calulatorText;

    @FXML
    private Button equalButton;

    private void onePressed(ActionEvent event){
        calulatorText.setText(calulatorText.getText()+'1');
    }
    private void twoPressed(ActionEvent event){

        calulatorText.setText(calulatorText.getText()+'2');

    }
    private void threePressed(ActionEvent event){
        calulatorText.setText(calulatorText.getText()+'3');

    }
    private void fourPressed(ActionEvent event){
        calulatorText.setText(calulatorText.getText()+'4');

    }
    private void fivePressed(ActionEvent event){
        calulatorText.setText(calulatorText.getText()+'5');


    }
    private void sixPressed(ActionEvent event){
        calulatorText.setText(calulatorText.getText()+'6');

    }
    private void sevenPressed(ActionEvent event){
        calulatorText.setText(calulatorText.getText()+'7');

    }
    private void eightPressed(ActionEvent event){
        calulatorText.setText(calulatorText.getText()+'8');


    }
    private void ninePressed(ActionEvent event){
        calulatorText.setText(calulatorText.getText()+'9');


    }
    private void zeroPressed(ActionEvent event){
        calulatorText.setText(calulatorText.getText()+'0');


    }
    private void addPressed(ActionEvent event){
        BigDecimal var1 = BigDecimal.valueOf(Double.parseDouble(calulatorText.getText()));
        calulatorText.setText("0");
        equalButton.setOnAction(event1 -> {
            BigDecimal var2 = BigDecimal.valueOf(Double.parseDouble(calulatorText.getText()));
            BigDecimal varFinal = var1.add(var2);
            calulatorText.setText(varFinal.toString());
        });

    }
    private void subtractPressed(ActionEvent event){
        BigDecimal var1 = BigDecimal.valueOf(Double.parseDouble(calulatorText.getText()));
        calulatorText.setText("0");
        equalButton.setOnAction(event1 -> {
            BigDecimal var2 = BigDecimal.valueOf(Double.parseDouble(calulatorText.getText()));
            BigDecimal varFinal = var1.subtract(var2);
            calulatorText.setText(varFinal.toString());
        });
    }
    private void multiplyPressed(ActionEvent event){
        BigDecimal var1 = BigDecimal.valueOf(Double.parseDouble(calulatorText.getText()));
        calulatorText.setText("0");
        equalButton.setOnAction(event1 -> {
            BigDecimal var2 = BigDecimal.valueOf(Double.parseDouble(calulatorText.getText()));
            BigDecimal varFinal = var1.multiply(var2);
            calulatorText.setText(varFinal.toString());
        });


    }
    private void dividePressed(ActionEvent event){
        BigDecimal var1 = BigDecimal.valueOf(Double.parseDouble(calulatorText.getText()));
        calulatorText.setText("0");
        equalButton.setOnAction(event1 -> {
            BigDecimal var2 = BigDecimal.valueOf(Double.parseDouble(calulatorText.getText()));
            BigDecimal varFinal = var1.divide(var2);
            calulatorText.setText(varFinal.toString());
        });

    }
    private void clearPressed(ActionEvent event){
        calulatorText.setText("0");
    }


}
