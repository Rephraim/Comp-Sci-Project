import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BoardTile extends JFrame {
	private JButton option1;
	private JButton option2;
	private JButton option3;
	private Option d1;
	private Option d2;
	private Option d3;
	private int tilenumber;
	private Event event;
	
	private Player player;

  	public BoardTile(int tileNumber, ArrayList<Event> list, Player p) {
		event = list.get(tileNumber);
		player = p;
		d1 = event.getChoiceA();
		d2 = event.getChoiceB();
		d3 = event.getChoiceC();
		super ("Square" + tilenumber);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildWindow();
		setVisible(true);
	}

	private void buildWindow() {
		JPanel mainPanel = new JPanel();
		JLabel description = new JLabel(event.getDescrip());
		JLabel a = new JLabel(d1.getDescrip);
		JLabel b = new JLabel(d2.getDescrip);
		JLabel c = new JLabel(d3.getDescrip);
		option1 = new JButton("A");
		option1.addActionListener(new abuttonListener);
		option2 = new JButton("B");
		option1.addActionListener(new bbuttonListener);
		option3 = new JButton("C");
		option1.addActionListener(new cbuttonListener);
		mainPanel.add(description);
		mainPanel.add(a);
		mainPanel.add(b);
		mainPanel.add(c);
		mainPanel.add(option1);
		mainPanel.add(option2);
		mainPanel.add(option3);

		add(MainPanel);
	}

	private class abuttonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			p.changeTardies(d1.getChangeT());
			p.changeMoney(d1.getChangeM());
			p.changeHappiness(d1.getChangeH());
			p.changeAcademics(d1.getChangeA());
			JOptionPane.showMessageDialog(frame,"This is your updated score: \n" + "Tardies: " + p.getTardies() + "\n" + "Money:" + p.getMoney() + "\n" + "Happiness:" + p.getHappiness() + "\n" + "Academics: " + p.getAcademics(), "Option A", JOptionPane.PLAIN_MESSAGE);
		}
	}
	
}
