package java_school_task;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ResultFrame extends JFrame{

	
	
	public ResultFrame(ArrayList<Person> people)
	{
		setTitle("Results");
		JPanel wholePanel = new JPanel();
		JPanel totalExpensesPanel = new JPanel();
		JPanel transactionsToBePaidPanel = new JPanel();
		wholePanel.setLayout(new GridLayout(0,1));
		totalExpensesPanel.setLayout(new GridLayout(0,2));
		transactionsToBePaidPanel.setLayout(new GridLayout(0,1));
		totalExpensesPanel.add(new JLabel("Total Spendings per person"));
		totalExpensesPanel.add(new JLabel(" "));
		
		double totalSpendings =0;
			
		for (int i=0;i<people.size();i++){
			totalExpensesPanel.add(new JLabel(people.get(i).getName()));
			totalExpensesPanel.add(new JLabel("   $" + people.get(i).getTotalPrice()));
			//totalExpensesPanel.add(new JLabel(" "));
			totalSpendings+=people.get(i).getTotalPrice();
		}
		
		double perPerson=totalSpendings/people.size();
		
		
		totalExpensesPanel.add(new JLabel(" "));
		totalExpensesPanel.add(new JLabel(" "));
		for (int y=0;y<people.size();y++)
		{
				
			for (int i = 0; i<people.size();i++)
			{
				
				if (people.get(i).getDifference(perPerson)>0)
				{
					for (int n = 0; n < people.size();n++)
					{
						
						if (!people.get(i).equals(people.get(n)) && people.get(n).getTotalPrice()!=perPerson)
						{

							if (Math.abs(people.get(i).getDifference(perPerson))==Math.abs(people.get(n).getDifference(perPerson))) {
								transactionsToBePaidPanel.add(new JLabel(people.get(n).getName() + "->" + people.get(i).getName() + ": " + Math.abs(people.get(n).getDifference(perPerson))));
								people.get(i).setTotalPrice(perPerson);
								people.get(n).setTotalPrice(perPerson);
								break;
							}
							
							else if (Math.abs(people.get(i).getDifference(perPerson))>Math.abs(people.get(n).getDifference(perPerson)))
							{
								transactionsToBePaidPanel.add(new JLabel(people.get(n).getName() + "->" + people.get(i).getName() + ": " + Math.abs(people.get(n).getDifference(perPerson))));
								people.get(i).updateTotalPrice(Math.abs(people.get(n).getDifference(perPerson)));
								people.get(n).setTotalPrice(perPerson);
								break;
							}
							
							else if (Math.abs(people.get(i).getDifference(perPerson))<Math.abs(people.get(n).getDifference(perPerson)))
							{
								transactionsToBePaidPanel.add(new JLabel(people.get(n).getName() + "->" + people.get(i).getName() + ": " + Math.abs(people.get(i).getDifference(perPerson))));
								people.get(n).updateTotalPrice(-Math.abs(people.get(i).getDifference(perPerson)));
								people.get(i).setTotalPrice(perPerson);
								break;
							}
						}
					}
				}
				
				
			}
			
		}
		for (int i =0;i<people.size();i++)
		{
			System.out.println(people.get(i).getTotalPrice());
		}
		
		wholePanel.add(totalExpensesPanel);
		wholePanel.add(transactionsToBePaidPanel);
		add(wholePanel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

