//LAYOUT!!!!!!!!!!!!!!!!!!!!!!!!

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
		//grid of buttons
		//button to start game
		//add action listener that generates new move (move icon and and opens new board tile), if check first for rolleddice
		//display of score and person's name
		//if actionlistener detects that current tile + rolled dice > last tile, moves to last tile
		//at last tile, open new graduation last square jframe and displays if graduate or not
		
public class Board extends JFrame() {
  
	private int currentSquare;
	private Player player;
	private ArrayList<Event> events;

  	public Board(Player p, ArrayList<Event> e) {
  		player = p;
  		events = e;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildWindow();
		setVisible(true);
		//MISC OTHER CONSTRUCTION!!!!!!!!!!!!!!!!!!!!!!!
	}
	
	public int rollDice(){
		return (int)Math.random()*4 + 1;
	}

	private void buildWindow() {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(basic, BoxLayout.Y_AXIS));
		add(mainPanel);
		JPanel top = new JPanel();
		
		JPanel gridPanel = new JPanel();
		gridPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        	gridPanel.setLayout(new GridLayout(6, 6, 5, 5));
        	String[][] buttons = new String[6][6];
        	int count = 1;
        	for (int i = 0; i < 6; i++) {
        		for (int j = 0; j < 6; j++) {
        			if(i % 2 == 0) {
        				buttons[i][j] == count;
        			} else {
        				buttons[i][5-j] == count;
        			}
        			count++;
        		}
        	}
        	for (int i = 0; i < 6; i++) {
        		for (int j = 0; j < 6; j++) {
        			gridPanel.add(new JButton(buttons[i][j]));
        		}
        	}
        	mainPanel.add(gridPanel);
		//grid of buttons
		//button to roll dice
		//display score and name
		//title
		
	}

	private void move() {
		//create boardtile with given number
	}
	
	private void lastSquare() {
		//pop up new lastSquare jframe
		//which displays everything
		//end game?
	}
	
	private class rollListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (rollDice() + currentSquare < 36) {
				move();
			} else {
				lastSquare();
			}
		}
	}
