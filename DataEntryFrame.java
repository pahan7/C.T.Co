package java_school_task;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DataEntryFrame extends JFrame {

	private ArrayList<Person> people;
	
	public DataEntryFrame ()
	{
		setTitle("Enter Data");
		JPanel wholePanel = new JPanel();
		JPanel labelPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		wholePanel.setLayout(new GridLayout(0,1));
		labelPanel.setLayout(new GridLayout(0,1));
		buttonPanel.setLayout(new GridLayout(0,2));
		
		JLabel explainLabel1 = new JLabel("Enter persons name and press enter to proceed with products.");
		JLabel explainLabel2 = new JLabel("If you are done with entering data, press finish");
		JLabel emptySpaceLabel = new JLabel(" ");
		labelPanel.add(explainLabel1);
		labelPanel.add(explainLabel2);
		labelPanel.add(emptySpaceLabel);
		
		JLabel nameLabel = new JLabel("Enter name: ");
		final JTextField nameTextField = new JTextField(20);
		
		people = new ArrayList<Person>();
		
		buttonPanel.add(nameLabel);
		buttonPanel.add(nameTextField);
				
		JButton enterButton = new JButton("Enter");
		enterButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				String name = nameTextField.getText();
				Person person = new Person(name);
				people.add(person);
				nameTextField.setText("");
				new ProductFrame(person);
			}
			
		});
		
		
		JButton finishButton = new JButton("Finish");
		finishButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent event) {
				new ResultFrame(people);
				dispose();
				
			}
			
			
		});
		
		buttonPanel.add(enterButton);
		buttonPanel.add(finishButton);
		
		
		wholePanel.add(labelPanel);
		wholePanel.add(buttonPanel);
		
		add(wholePanel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
