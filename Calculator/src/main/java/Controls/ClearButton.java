package Controls;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

public class ClearButton implements EventHandler<ActionEvent> {
    private Label display;
    public ClearButton(Label display) {
        this.display = display;
    }
    @Override
    public void handle(ActionEvent event) {
        this.display.setText("");
    }
}
