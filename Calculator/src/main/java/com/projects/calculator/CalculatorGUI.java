package com.projects.calculator;

import Controls.EqualControl;
import Controls.OperatorControl;
import Controls.ClearButton;
import Controls.Digit;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CalculatorGUI extends Application {
    private GridPane calculator;
    private Label calculatorDisplay;
    private Button negative;
    private Button zero;
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button clear;
    private Button add;
    private Button subtract;
    private Button multiply;
    private Button divide;
    private Button decimal;
    private Button percentage;
    private Button equals;
    @Override
    public void start(Stage mainStage) {
        this.calculatorDisplay = new Label("");
        this.calculator = new GridPane();
        this.calculator.setMaxHeight(Double.POSITIVE_INFINITY);
        this.calculator.setMaxWidth(Double.POSITIVE_INFINITY);
        //this.makeDefaultCalculator();
        this.setButtons();
        this.setCalculator();
        this.labelProperties();
        this.setStage(mainStage);
    }
    private void setStage(Stage mainStage) {
        Scene mainScene = new Scene(this.calculator);
        mainStage.setTitle("Calculator");
        mainStage.setScene(mainScene);
        mainStage.show();
    }
    private void setButtons() {
        this.negative = new Button("-");
        this.negative.setOnAction(new Digit(this.calculatorDisplay, this.negative));
        this.zero = new Button("0");
        this.zero.setOnAction(new Digit(this.calculatorDisplay, this.zero));
        this.one = new Button("1");
        this.one.setOnAction(new Digit(this.calculatorDisplay, this.one));
        this.two = new Button("2");
        this.two.setOnAction(new Digit(this.calculatorDisplay, this.two));
        this.three = new Button("3");
        this.three.setOnAction(new Digit(this.calculatorDisplay, this.three));
        this.four = new Button("4");
        this.four.setOnAction(new Digit(this.calculatorDisplay, this.four));
        this.five = new Button("5");
        this.five.setOnAction(new Digit(this.calculatorDisplay, this.five));
        this.six = new Button("6");
        this.six.setOnAction(new Digit(this.calculatorDisplay, this.six));
        this.seven = new Button("7");
        this.seven.setOnAction(new Digit(this.calculatorDisplay, this.seven));
        this.eight = new Button("8");
        this.eight.setOnAction(new Digit(this.calculatorDisplay, this.eight));
        this.nine = new Button("9");
        this.nine.setOnAction(new Digit(this.calculatorDisplay, this.nine));
        this.clear = new Button("AC");
        this.clear.setOnAction(new ClearButton(this.calculatorDisplay));
        this.add = new Button("+");
        this.add.setOnAction(new OperatorControl(this.calculatorDisplay, this.add));
        this.subtract = new Button("-");
        this.subtract.setOnAction(new OperatorControl(this.calculatorDisplay, this.subtract));
        this.multiply = new Button("x");
        this.multiply.setOnAction(new OperatorControl(this.calculatorDisplay, this.multiply));
        this.divide = new Button("/");
        this.divide.setOnAction(new OperatorControl(this.calculatorDisplay, this.divide));
        this.decimal = new Button(".");
        this.decimal.setOnAction(new Digit(this.calculatorDisplay, this.decimal));
        this.percentage = new Button("%");
        this.percentage.setOnAction(new OperatorControl(this.calculatorDisplay, this.percentage));
        this.equals = new Button("=");
        this.equals.setOnAction(new EqualControl(this.calculatorDisplay));
        Button[] buttons = {this.negative, this.zero, this.one, this.two, this.three, this.four, this.five, this.six, this.seven, this.eight, this.nine, this.add, this.subtract, this.multiply, this.decimal, this.equals, this.percentage, this.divide, this.clear};
        for (int i = 0; i < buttons.length; i++) {
            this.buttonProperties(buttons[i]);
        }
    }
    private void makeDefaultCalculator() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                Button placeHolder = new Button("D");
                this.calculator.add(placeHolder, i, j);
            }
        }
    }
    private void setCalculator() {
        this.calculator.add(this.calculatorDisplay, 0, 0, 4, 1);
        this.calculator.add(this.clear, 0, 1);
        this.calculator.add(this.negative, 1, 1);
        this.calculator.add(this.percentage, 2, 1);
        this.calculator.add(this.divide, 3, 1);
        this.calculator.add(this.one, 0, 2);
        this.calculator.add(this.two, 1, 2);
        this.calculator.add(this.three, 2, 2);
        this.calculator.add(this.multiply, 3, 2);
        this.calculator.add(this.four, 0, 3);
        this.calculator.add(this.five, 1, 3);
        this.calculator.add(this.six, 2, 3);
        this.calculator.add(this.subtract, 3, 3);
        this.calculator.add(this.seven, 0, 4);
        this.calculator.add(this.eight, 1, 4);
        this.calculator.add(this.nine, 2, 4);
        this.calculator.add(this.add, 3, 4);
        this.calculator.add(this.zero, 0, 5, 2, 1);
        this.calculator.add(this.decimal, 2, 5);
        this.calculator.add(this.equals, 3, 5);
    }
    private void buttonProperties(Button button) {
        button.setMaxWidth(Double.POSITIVE_INFINITY);
        button.setMaxHeight(Double.POSITIVE_INFINITY);
        button.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        button.setTextFill(Color.DARKGRAY);
        button.setBorder(new Border(new BorderStroke(Color.MAROON, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THIN)));
        button.setPrefSize(80, 80);
    }
    private void labelProperties() {
        this.calculatorDisplay.setFont(new Font("Xenara", 20));
        this.calculatorDisplay.setMaxWidth(Double.POSITIVE_INFINITY);
        this.calculatorDisplay.setPrefSize(80, 80);
        this.calculatorDisplay.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        this.calculatorDisplay.setTextFill(Color.WHITESMOKE);
        this.calculatorDisplay.setBorder(new Border(new BorderStroke(Color.MAROON, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THIN)));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
