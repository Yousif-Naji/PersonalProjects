package TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 * GUI for tic-tac-toe game application using Swing framework
 * @author Yousif Naji
 */
public class GUI implements ActionListener {
    private JFrame frame;
    private JPanel panel;
    private JLabel player;
    private JLabel computer;
    private JButton reset;
    private int playerCount = 1;
    private int computerCount = 1;
    private JButton firstB;
    private JButton secondB;
    private JButton thirdB;
    private JButton fourthB;
    private JButton fifthB;
    private JButton sixthB;
    private JButton seventhB;
    private JButton eightB;
    private JButton ninthB;
    private boolean gameDrawn = true;
    public GUI() {
        this.setPanel();
        this.setLabels();
        this.gameRepresentaion();
        this.setFrame();
        this.setIcon();
        this.resetButton();
        this.frame.setVisible(true);
    }
    private void setIcon() {
        java.net.URL url = ClassLoader.getSystemResource("TicTacToe/img.png");
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.createImage(url);
        this.frame.setIconImage(img);

    }
    private void gameRepresentaion() {
        this.firstB = new JButton();
        this.firstB.setBackground(Color.black);
        this.firstB.setForeground(Color.red);
        this.firstB.setFont(new Font("Arial", Font.PLAIN, 60));
        this.panel.add(this.firstB);
        this.firstB.addActionListener(this);
        this.secondB = new JButton();
        this.secondB.setBackground(Color.black);
        this.secondB.setForeground(Color.red);
        this.secondB.setFont(new Font("Arial", Font.PLAIN, 60));
        this.panel.add(secondB);
        this.secondB.addActionListener(this);
        this.thirdB = new JButton();
        this.thirdB.setBackground(Color.black);
        this.thirdB.setForeground(Color.red);
        this.thirdB.setFont(new Font("Arial", Font.PLAIN, 60));
        this.panel.add(thirdB);
        this.thirdB.addActionListener(this);
        this.panel.add(this.computer);
        this.fourthB = new JButton();
        this.fourthB.setBackground(Color.black);
        this.fourthB.setForeground(Color.red);
        this.fourthB.setFont(new Font("Arial", Font.PLAIN, 60));
        this.panel.add(fourthB);
        this.fourthB.addActionListener(this);
        this.fifthB = new JButton();
        this.fifthB.setBackground(Color.black);
        this.fifthB.setForeground(Color.red);
        this.fifthB.setFont(new Font("Arial", Font.PLAIN, 60));
        this.panel.add(fifthB);
        this.fifthB.addActionListener(this);
        this.sixthB = new JButton();
        this.sixthB.setBackground(Color.black);
        this.sixthB.setForeground(Color.red);
        this.sixthB.setFont(new Font("Arial", Font.PLAIN, 60));
        this.panel.add(sixthB);
        this.sixthB.addActionListener(this);
        this.panel.add(player);
        this.seventhB = new JButton();
        this.seventhB.setBackground(Color.black);
        this.seventhB.setForeground(Color.red);
        this.seventhB.setFont(new Font("Arial", Font.PLAIN, 60));
        this.panel.add(seventhB);
        this.seventhB.addActionListener(this);
        this.eightB = new JButton();
        this.eightB.setBackground(Color.black);
        this.eightB.setForeground(Color.red);
        this.eightB.setFont(new Font("Arial", Font.PLAIN, 60));
        this.panel.add(eightB);
        this.eightB.addActionListener(this);
        this.ninthB = new JButton();
        this.ninthB.setBackground(Color.black);
        this.ninthB.setForeground(Color.red);
        this.ninthB.setFont(new Font("Arial", Font.PLAIN, 60));
        this.panel.add(ninthB);
        this.ninthB.addActionListener(this);
    }
    private void setLabels() {
        this.player = new JLabel("You: 0", SwingConstants.CENTER);
        this.player.setForeground(Color.blue);
        this.player.setFont(new Font("Arial", Font.PLAIN, 20));
        this.computer = new JLabel("Computer: 0", SwingConstants.CENTER);
        this.computer.setForeground(Color.blue);
        this.computer.setFont(new Font("Arial", Font.PLAIN, 20));
    }
    private void setFrame() {
        this.frame = new JFrame();
        this.frame.setSize(720, 720);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setTitle("TicTacToe");
        this.frame.setResizable(false);
        this.frame.add(this.panel);
        ImageIcon image = new ImageIcon("TicTacToe/img.png");
        this.frame.setIconImage(image.getImage());
        this.frame.getContentPane().setBackground(Color.DARK_GRAY);
        this.frame.setLayout(null);
    }

    private void setPanel() {
        this.panel = new JPanel();
        this.panel.setLayout(new GridLayout(3, 4));
        this.panel.setBackground(Color.DARK_GRAY);
        this.panel.setSize(720, 720);
    }

    private void resetButton() {
        this.reset = new JButton();
        this.reset.setBackground(Color.DARK_GRAY);
        this.reset.setForeground(Color.blue);
        this.reset.setText("Reset Game");
        this.reset.setFont(new Font("Aerial", Font.PLAIN, 20));
        this.reset.addActionListener(this);
        this.panel.add(this.reset);
    }
    private void resetGUI() {
        this.firstB.setText("");
        this.secondB.setText("");
        this.thirdB.setText("");
        this.fourthB.setText("");
        this.fifthB.setText("");
        this.sixthB.setText("");
        this.seventhB.setText("");
        this.eightB.setText("");
        this.ninthB.setText("");
    }
    private void gameDraw() {
        TicTacToe.xoGame.getGrid().resetGame();
        this.resetGUI();
        TicTacToe.xoGame.resetBoard();
        showMessageDialog(null, "Game is Drawn.");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == reset) {
            TicTacToe.xoGame.getGrid().resetGame();
            this.resetGUI();
            TicTacToe.xoGame.resetBoard();
            showMessageDialog(null, "Resetting Game.");
            return;
        } else if (e.getSource() == firstB) {
            TicTacToe.xoGame.makeMove(0, 0);
            this.firstB.setText(Character.toString(TicTacToe.gameBoard[0][0]));
        } else if (e.getSource() == secondB) {
            TicTacToe.xoGame.makeMove(0, 1);
            this.secondB.setText(Character.toString(TicTacToe.gameBoard[0][1]));
        } else if (e.getSource() == thirdB) {
            TicTacToe.xoGame.makeMove(0, 2);
            this.thirdB.setText(Character.toString(TicTacToe.gameBoard[0][2]));
        } else if (e.getSource() == fourthB) {
            TicTacToe.xoGame.makeMove(1, 0);
            this.fourthB.setText(Character.toString(TicTacToe.gameBoard[1][0]));
        } else if (e.getSource() == fifthB) {
            TicTacToe.xoGame.makeMove(1, 1);
            this.fifthB.setText(Character.toString(TicTacToe.gameBoard[1][1]));
        } else if (e.getSource() == sixthB) {
            TicTacToe.xoGame.makeMove(1, 2);
            this.sixthB.setText(Character.toString(TicTacToe.gameBoard[1][2]));
        } else if (e.getSource() == seventhB) {
            TicTacToe.xoGame.makeMove(2, 0);
            this.seventhB.setText(Character.toString(TicTacToe.gameBoard[2][0]));
        } else if (e.getSource() == eightB) {
            TicTacToe.xoGame.makeMove(2, 1);
            this.eightB.setText(Character.toString(TicTacToe.gameBoard[2][1]));
        } else if (e.getSource() == ninthB) {
            TicTacToe.xoGame.makeMove(2, 2);
            this.ninthB.setText(Character.toString(TicTacToe.gameBoard[2][2]));
        }
        int outcome = TicTacToe.xoGame.getGrid().isGameOver();
        if (outcome == 1) {
            this.player.setText("You: " + this.playerCount);
            this.playerCount++;
            this.resetGUI();
            TicTacToe.xoGame.resetBoard();
            TicTacToe.xoGame.getGrid().resetGame();
            showMessageDialog(null, "Player has won! Resetting game.");
        } else if (outcome == 2) {
            this.computer.setText("Computer: " + this.computerCount);
            this.computerCount++;
            showMessageDialog(null, "Computer has won! Resetting game.");
            this.resetGUI();
            TicTacToe.xoGame.resetBoard();
            TicTacToe.xoGame.getGrid().resetGame();
        }
        for (int i = 0; i < TicTacToe.xoGame.getGrid().getGameGrid().length; i++) {
            for (int j = 0; j < TicTacToe.xoGame.getGrid().getGameGrid()[i].length; j++) {
                if (TicTacToe.xoGame.getGrid().getGameGrid()[i][j] == 0) {
                    this.gameDrawn = false;
                    break;
                }
            }
        }
        if (this.gameDrawn) {
            this.gameDraw();
        } else {
            this.gameDrawn = true;
        }
    }
}
