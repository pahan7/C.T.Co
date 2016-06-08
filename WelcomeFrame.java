package java_school_task;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class WelcomeFrame extends JFrame {

	private JPanel wholePanel;
	
	public WelcomeFrame()
	{
		
		setTitle("Each Person Price Calculator");
		wholePanel = new JPanel();
		wholePanel.setLayout(new GridLayout(0,1));
				
		JLabel welcomeLabel = new JLabel("Welcome to Calculator!");
		welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 26));
	
		JLabel continueLabel = new JLabel("Press Continue in order to start.");
		continueLabel.setFont(new Font("Arial", Font.PLAIN, 20 ));
				
		JButton continueButton = new JButton("Continue");
		continueButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent event) {
				dispose();
				new DataEntryFrame();
			}
			
		});
		
				
		wholePanel.add(welcomeLabel);
		wholePanel.add(continueLabel);
		wholePanel.add(continueButton);
		add(wholePanel);
		
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
}
