//LAYOUT!!!!!!!!!!!!!!!!!!!!!!!!

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.border.*;

		//grid of buttons
		//button to start game
		//add action listener that generates new move (move icon and and opens new board tile), if check first for rolleddice
		//display of score and person's name
		//if actionlistener detects that current tile + rolled dice > last tile, moves to last tile
		//at last tile, open new graduation last square jframe and displays if graduate or not

public class Board extends JFrame {
  
	private int currentSquare;
	private Player player;
	private ArrayList<Event> events;
	private BoardTile currentTile;
	private JPanel mainPanel;
	private JLabel labelh = new JLabel();
	private JLabel labela = new JLabel();
	private JLabel labelt = new JLabel();
	private JLabel labelm = new JLabel();
	private JLabel labeltile = new JLabel();
	
  	public Board(Player p, ArrayList<Event> e) {
  		player = p;
  		events = e;
  		currentSquare = 0;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildWindow();
		setVisible(true);
		buildInstructions();
		//MISC OTHER CONSTRUCTION!!!!!!!!!!!!!!!!!!!!!!!
	}
	//J.Wu identified error in taking out setVisible

	private void buildInstructions() {
		JFrame frame = new JFrame();
		JPanel main = new JPanel();
		JLabel label1 = new JLabel("Welcome to your senior year at MSJHS.");
		JLabel label2 = new JLabel("Get through the year, while gathering");
		JLabel label3 = new JLabel("as many $$$, happiness, and academic");
		JLabel label4 = new JLabel("points as you can, without getting too");
		JLabel label5 = new JLabel("many tardies. Are you ready?");

		main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
		main.setBorder(BorderFactory.createLineBorder(Color.black));
		main.add(label1);
		main.add(label2);
		main.add(label3);
		main.add(label4);
		main.add(label5);
		frame.setSize(300,180);
		frame.add(main);
		frame.setVisible(true);
		frame.setTitle("Instructions");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	//Jerry Wu helped debugging: changing main to mainPanel

	private void buildWindow() {
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.setBorder(new EmptyBorder(new Insets(40, 40, 40, 40)));
		add(mainPanel);
		JPanel top = new JPanel();
		top.setLayout(new BoxLayout(top, BoxLayout.X_AXIS));
		labelh.setText(":) - " + player.getHappiness());
		labela.setText("academics - " + player.getAcademics());
		labelt.setText("tardies - " + player.getTardies());
		labelm.setText("$$$ - " + player.getMoney());
		top.add(labelh);
		top.add(Box.createRigidArea(new Dimension(5, 0)));
		top.add(labela);
		top.add(Box.createRigidArea(new Dimension(5, 0)));
		top.add(labelm);
		top.add(Box.createRigidArea(new Dimension(5, 0)));
		top.add(labelt);
		top.add(Box.createRigidArea(new Dimension(10, 0)));
		JButton rollDice = new JButton("Roll Dice");
		rollDice.addActionListener(new rollListener());
		top.add(rollDice);
		JPanel gridPanel = new JPanel();
		gridPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        gridPanel.setLayout(new GridLayout(6, 6, 5, 5));
        String[][] buttons = new String[6][6];
        int count = 1;
        for (int i = 0; i < 6; i++) {
        	for (int j = 0; j < 6; j++) {
        		if(i % 2 == 0) {
        			buttons[i][j] = Integer.toString(count);
        		} else {
        			buttons[i][5-j] = Integer.toString(count);
        		}
        		count++;
        	}
        }
        for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
        	/* for (int j = 0; j < 6; j++) { */
        		gridPanel.add(new JButton(buttons[i][j]));
			}
        }
        mainPanel.add(top);
        mainPanel.add(gridPanel);
		mainPanel.add(new JLabel("Player " + player.getName()));
		if (currentSquare != -1){
			labeltile.setText("You are at square #" + (currentSquare));
		} else {
			labeltile.setText("You are at square #36");
		}
		mainPanel.add(labeltile);
		//grid of buttons
		//button to roll dice
		//display score and name
		//title
		setTitle("Senioritis: the Game");
		setSize(800, 600);
		setLocationRelativeTo(null);
	}

	private void lastSquare() {
		currentSquare = -1;
 		LastSquare tile = new LastSquare (player);
	}

	private void update() {
		labelh.setText(":) - " + player.getHappiness());
		labela.setText("academics - " + player.getAcademics());
		labelt.setText("tardies - " + player.getTardies());
		labelm.setText("$$$ - " + player.getMoney());
		if (currentSquare != -1){
			labeltile.setText("You are at square #" + (currentSquare));
		} else {
			labeltile.setText("You are at square #36");
		}
	}
	
	private class rollListener implements ActionListener {

		private int currentRoll;

		public void move() {
			
			//create boardtile with given number
			currentSquare += currentRoll;
			currentTile = new BoardTile(currentSquare, events, player);
			
		}

		public int rollDice(){
			currentRoll =((int) (Math.random()*4)) + 1;
			return currentRoll;
		}

		public void actionPerformed(ActionEvent e) {
			update();
			mainPanel.revalidate();
			if (currentSquare == -1) {
				lastSquare();
 			} else if (rollDice() + currentSquare < 36) {
				move();
			} else {
				lastSquare();
			}
		}
	}
}
