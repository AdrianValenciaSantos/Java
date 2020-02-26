import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Main {
	
	public static double checkInput(String text) {
		try {
			double test = Double.parseDouble(text);
			if(test >= 0) {
				return test;
			}
			else {
				return -1;
			}
		}
		catch(Exception e) {
			return -1;
		}
	}
	
	public static void main(String[] args) {
				
		Classes[] classes = {new Classes("Programming"), new Classes("Art"), new Classes("Science"), new Classes("Math"), new Classes("History")};
		
		JFrame GUI = new JFrame();
		GUI.setTitle("Grade Program");
		GUI.setSize(500, 500);
		GUI.setLocationRelativeTo(null);
		
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		
		DefaultListModel<String> listModel2 = new DefaultListModel<String>();
		JList scores = new JList(listModel2);
		scores.disable();
		scores.setBounds(270, 100, 200, 250);
		panel.add(scores);
		
		
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		JList classNames = new JList(listModel);
		classNames.setBounds(30, 100, 200, 250);
		classNames.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub
				
				int selectedIndex = classNames.getSelectedIndex();
				if(classNames.getValueIsAdjusting()) {
					System.out.println(selectedIndex);
					listModel2.clear();
					for(int i = 0; i < classes[selectedIndex].getScores().size(); i++) {
						listModel2.addElement(classes[selectedIndex].getScores().get(i) + "");
					}
				}
			}
			
		});
		panel.add(classNames);
		
		
		// Put classes into list
		for(int i = 0; i < classes.length; i++) {
			listModel.addElement(classes[i].getName());
		}
		
		
		JTextField scoresText = new JTextField();
		scoresText.setBounds(270, 80, 120, 20);
		panel.add(scoresText);
		
		
		JButton scoresBtn = new JButton();
		scoresBtn.setText("Add");
		scoresBtn.setBounds(392, 80, 78, 20);
		scoresBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int selectedIndex = classNames.getSelectedIndex();
				if(selectedIndex != -1) {
					double isValid = checkInput(scoresText.getText());
					if(isValid != -1) {
						listModel2.addElement(scoresText.getText());
						classes[selectedIndex].addGrade(isValid);
						scoresText.setText("");
					}
				}
				
			}
			
		});
		panel.add(scoresBtn);
		
		
		JButton calcBtn = new JButton();
		calcBtn.setText("Calculate");
		calcBtn.setBounds(200, 400, 100, 20);
		calcBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int selectedIndex = classNames.getSelectedIndex();
				if(selectedIndex != -1) {
					String output = "";
					if(classes[selectedIndex].getMax() == -1) {
						output += "Max: N/A\n\n";
					}
					else {
						output += "Max: " + classes[selectedIndex].getMax() + "\n\n";
					}
					if(classes[selectedIndex].getMax() == -1) {
						output += "Min: N/A\n\n";
					}
					else {
						output += "Min: " + classes[selectedIndex].getMin() + "\n\n";
					}
					output += "Average: " + classes[selectedIndex].getAverage() + "\n\n";
					output += "Scores: " + classes[selectedIndex].getGrades() + "\n\n";
					JOptionPane.showMessageDialog(GUI, output, "Grade Program", JOptionPane.PLAIN_MESSAGE);
				}
			}
			
		});
		panel.add(calcBtn);
		
		JButton clrBtn = new JButton();
		clrBtn.setText("Clear");
		clrBtn.setBounds(50, 400, 100, 20);
		clrBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int selectedIndex = classNames.getSelectedIndex();
				if(selectedIndex != -1) {
					classes[selectedIndex].clearGrades();
					listModel2.clear();
				}
			}
			
			
		});
		panel.add(clrBtn);
		
		
		JButton exit = new JButton();
		exit.setText("Exit");
		exit.setBounds(350, 400, 100, 20);
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
			
		});
		panel.add(exit);
		
		
		GUI.add(panel);
		GUI.setVisible(true);
		GUI.setResizable(false);
		
	}
	
	
}
