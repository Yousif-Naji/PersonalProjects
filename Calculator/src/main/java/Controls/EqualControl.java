package Controls;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

public class EqualControl implements EventHandler<ActionEvent> {
    private Label display;
    public EqualControl(Label display) {
        this.display = display;
    }
    @Override
    public void handle(ActionEvent event) {
        String operation = this.display.getText();
        String[] parts = operation.split(" ");
        try {
            if (parts[1].equals("+") || parts[1].equals("-") || parts[1].equals("x") || parts[1].equals("/") || parts[1].equals("%")) {
                try {
                    Double valueOne = Double.valueOf(parts[0]);
                    Double valueTwo = Double.valueOf(parts[2]);
                    if (parts[1].equals("+")) {
                        this.display.setText(Double.toString(valueOne + valueTwo));
                    } else if (parts[1].equals("-")) {
                        this.display.setText(Double.toString(valueOne - valueTwo));
                    } else if (parts[1].equals("x")) {
                        this.display.setText(Double.toString(valueOne * valueTwo));
                    } else if (parts[1].equals("/")) {
                        this.display.setText(Double.toString(valueOne / valueTwo));
                    } else if (parts[1].equals("%")) {
                        this.display.setText(Double.toString(valueOne % valueTwo));
                    }
                } catch (Exception e) {
                    this.display.setText("Syntax Error, clear calculator.");
                }
            } else {
                this.display.setText("Error");
            }
        } catch (Exception e) {
            this.display.setText("Error encountered.");
        }
    }
}
