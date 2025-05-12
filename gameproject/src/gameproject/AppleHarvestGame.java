package gameproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class AppleHarvestGame extends JFrame {
   
	 static Random rand = new Random();
	
	private final int gridSize = 6;
    private final int cellSize = 500 / gridSize; // Adjust size based on the frame size
    private final int totalCells = gridSize * gridSize;
    private static int amountApple = rand.nextInt(36);
    private final int maxPoints = amountApple*100;
    private final int appleValue = 100;
    private int score = 0;
    private int timeLimit = questions.points*3;
    private ArrayList<Point> apples;
    private Point handPosition;
    private JLabel scoreLabel;
    private JLabel timerLabel;
   

    public AppleHarvestGame() {
        setTitle("Apple Harvest Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(gridSize * cellSize, gridSize * cellSize + 70); // Adjust for button panel height
        setResizable(false);
        setLayout(new BorderLayout());
		setLocationRelativeTo(null);


        JPanel buttonPanel = new JPanel(new GridLayout(1, 4));
        add(buttonPanel, BorderLayout.SOUTH);

        JButton upButton = new JButton("Up");
        upButton.addActionListener(this::moveUp);
        buttonPanel.add(upButton);

        JButton leftButton = new JButton("Left");
        leftButton.addActionListener(this::moveLeft);
        buttonPanel.add(leftButton);

        JButton rightButton = new JButton("Right");
        rightButton.addActionListener(this::moveRight);
        buttonPanel.add(rightButton);

        JButton downButton = new JButton("Down");
        downButton.addActionListener(this::moveDown);
        buttonPanel.add(downButton);

        JPanel infoPanel = new JPanel();
        scoreLabel = new JLabel("Score: " + score);
        timerLabel = new JLabel("Time Left: " + timeLimit);
        infoPanel.add(scoreLabel);
        infoPanel.add(timerLabel);
        add(infoPanel, BorderLayout.NORTH);

        handPosition = new Point(0, 0);
        apples = new ArrayList<>();
        generateApples();

        Timer gameTimer = new Timer(1000, e -> {
            timeLimit--;
            timerLabel.setText("Time Left: " + timeLimit);
            if (timeLimit <= 0 || maxPoints==score) endGame();
        });
        gameTimer.start();
    }

    private void generateApples() {
        
    	   ArrayList<Point> usedCells = new ArrayList<>();
    	    
    	    for (int i = 0; i < amountApple; i++) {
    	        int x, y;
    	        Point newApple;
    	        do {
    	            x = rand.nextInt(gridSize);
    	            y = rand.nextInt(gridSize);
    	            newApple = new Point(x, y);
    	        } while (usedCells.contains(newApple)); // Check if the cell is already used
    	        
    	        apples.add(newApple);
    	        usedCells.add(newApple);
    	    }
    }

    private void checkCollisions() {
        for (int i = 0; i < apples.size(); i++) {
            Point apple = apples.get(i);
            if (handPosition.equals(apple)) {
                apples.remove(i);
                score += appleValue;
                score = Math.min(score, maxPoints);
                scoreLabel.setText("Score: " + score);
                i--;
            }
        }
    }

    private void endGame() {
        JOptionPane.showMessageDialog(this, "Game Over! Final Score: " + score);
        System.exit(0);
    }

    private void moveUp(ActionEvent e) {
        if (handPosition.y > 0) {
            handPosition.y--;
            checkCollisions();
            repaint();
        }
    }

    private void moveDown(ActionEvent e) {
        if (handPosition.y < gridSize - 1) {
            handPosition.y++;
            checkCollisions();
            repaint();
        }
    }

    private void moveLeft(ActionEvent e) {
        if (handPosition.x > 0) {
            handPosition.x--;
            checkCollisions();
            repaint();
        }
    }

    private void moveRight(ActionEvent e) {
        if (handPosition.x < gridSize - 1) {
            handPosition.x++;
            checkCollisions();
            repaint();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                g.setColor(Color.BLACK);
                g.drawRect(i * cellSize, j * cellSize, cellSize, cellSize);

                if (apples.contains(new Point(i, j))) {
                    g.setColor(Color.RED);
                    g.fillOval(i * cellSize, j * cellSize, cellSize, cellSize);
                }
            }
        }

        g.setColor(Color.BLUE);
        g.fillOval(handPosition.x * cellSize, handPosition.y * cellSize, cellSize, cellSize);
    }


}