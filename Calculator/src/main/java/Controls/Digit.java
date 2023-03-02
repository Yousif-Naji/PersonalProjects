package Controls;

import com.projects.calculator.CalculatorGUI;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Digit implements EventHandler<ActionEvent> {
    private Label display;
    private Button number;
    public Digit(Label display, Button number) {
        this.display = display;
        this.number = number;
    }
    @Override
    public void handle(ActionEvent event) {
        String current = this.display.getText();
        this.display.setText(current + this.number.getText());
    }
}
