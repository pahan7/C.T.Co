package java_school_task;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ProductFrame extends JFrame{
	 
	private JTextField productTextField;
	private JFormattedTextField priceField;
	private  JPanel enteredData;
	
	public ProductFrame(final Person person)
	{
		setTitle(person.getName());
		JPanel wholePanel = new JPanel();
		JPanel labelPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		enteredData = new JPanel();
		
		wholePanel.setLayout(new GridLayout(0,1));
		labelPanel.setLayout(new GridLayout(0,1));
		buttonPanel.setLayout(new GridLayout(0,2));
		enteredData.setLayout(new GridLayout(0,2));
		
		JLabel instructionLabel1 = new JLabel("Enter product and its price for " + person.getName() +" .");
		JLabel instructionLabel2 = new JLabel("Press 'ADD' to add another product or press 'finish' when done. ");
		JLabel emptySpace = new JLabel();
		JLabel productLabel = new JLabel("Product");
		JLabel priceLabel = new JLabel("Price");
		
		labelPanel.add(instructionLabel1);
		labelPanel.add(instructionLabel2);
		labelPanel.add(emptySpace);
		
		productTextField = new JTextField(20);
		NumberFormat amountFormat = NumberFormat.getNumberInstance();
		priceField = new JFormattedTextField(amountFormat);
		
		buttonPanel.add(productLabel);
		buttonPanel.add(productTextField);
		buttonPanel.add(priceLabel);
		buttonPanel.add(priceField);
		
		JButton addButton = new JButton("Add");
		
		addButton.addActionListener(new ActionListener(){
			
			private String productName;
			private double price;
			private int counter = 0;
				
			public void actionPerformed(ActionEvent event) {
				if (productTextField.getText()!=" " && ((Number) priceField.getValue())!= null)
				{
					productName = productTextField.getText();
					price =((Number) priceField.getValue()).doubleValue();
					person.addProduct(productName,price);
					productTextField.setText(" ");
					priceField.setValue(null);
					counter++;
					enteredData.add(new JLabel(counter +". " + productName));
					enteredData.add(new JLabel("$" + price));
					pack();
				}
			}
			
			
		});
		JButton finishButton = new JButton("Finish");
		finishButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent event) {
				dispose();
				
			}
			
			
		});
		
		buttonPanel.add(addButton);
		buttonPanel.add(finishButton);
		wholePanel.add(labelPanel);
		wholePanel.add(buttonPanel);
		wholePanel.add(enteredData);
		
		add(wholePanel);
		pack();
		
		
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
