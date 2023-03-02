package Controls;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class OperatorControl implements EventHandler<ActionEvent> {
    private Label display;
    private Button operator;
    public OperatorControl(Label display, Button operator) {
        this.display = display;
        this.operator = operator;
    }
    @Override
    public void handle(ActionEvent event) {
        String current = this.display.getText();
        this.display.setText(current + " " + this.operator.getText() + " ");
    }
}
