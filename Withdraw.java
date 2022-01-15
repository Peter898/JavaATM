import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Withdraw {

	private JFrame withdrawFrame;
	private JTextField amountTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Withdraw window = new Withdraw();
					window.withdrawFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Withdraw() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//Create an instance of the Account class 
		Account acc1 = new Account(1001,1000);
		
		withdrawFrame = new JFrame();
		withdrawFrame.setTitle("Withdraw");
		withdrawFrame.setBounds(100, 100, 450, 300);
		withdrawFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		withdrawFrame.getContentPane().setLayout(null);
		
		JLabel withdrawLabel = new JLabel("Withdraw Amount");
		withdrawLabel.setHorizontalAlignment(SwingConstants.CENTER);
		withdrawLabel.setFont(new Font("Verdana", Font.BOLD, 20));
		withdrawLabel.setBounds(79, 30, 266, 54);
		withdrawFrame.getContentPane().add(withdrawLabel);
		
		amountTxt = new JTextField();
		amountTxt.setHorizontalAlignment(SwingConstants.CENTER);
		amountTxt.setFont(new Font("Verdana", Font.PLAIN, 16));
		amountTxt.setColumns(10);
		amountTxt.setBounds(100, 105, 227, 54);
		withdrawFrame.getContentPane().add(amountTxt);
		
		JButton withdrawBut = new JButton("Withdraw\r\n");
		withdrawBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try
			{
				double amount = Double.parseDouble(amountTxt.getText());
				//Pass the amount into the withdraw method in the Account class
				if (acc1.withdraw(amount) < 0)
				{
					JOptionPane.showMessageDialog(null, "You are trying to withdraw more than what you have. ",null, JOptionPane.WARNING_MESSAGE, null);

				}
				else
				{
					acc1.withdraw(amount);
				}
				//Return to the Account window
				AccountTest logged = new AccountTest();
				//Close the current frame
				withdrawFrame.setVisible(false);
				logged.main(null);
			}catch (NumberFormatException e1)
			{
				JOptionPane.showMessageDialog(null, "You tried to withdraw 0 dollars",null, JOptionPane.WARNING_MESSAGE, null);
			}	
		}
		});
		withdrawBut.setFont(new Font("Verdana", Font.BOLD, 18));
		withdrawBut.setBounds(130, 192, 148, 40);
		withdrawFrame.getContentPane().add(withdrawBut);
	}

}
