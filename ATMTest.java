import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ATMTest {

	private JFrame atmFrame;
	private JTextField depositTxt;
	private JTextField withdrawTxt;
	private JTextField balTxT;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ATMTest window = new ATMTest();
					window.atmFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ATMTest() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//Create an instance of the Account class
		Account acc1 = new Account(1001,0);
		
		atmFrame = new JFrame();
		atmFrame.setTitle("ATM");
		atmFrame.setBounds(100, 100, 467, 382);
		atmFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		atmFrame.getContentPane().setLayout(null);
		
		JLabel balanceLabel = new JLabel("Balance");
		balanceLabel.setFont(new Font("Verdana", Font.BOLD, 16));
		balanceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		balanceLabel.setBounds(50, 75, 125, 30);
		atmFrame.getContentPane().add(balanceLabel);
		
		JButton depositBut = new JButton("Deposit");
		depositBut.setFont(new Font("Verdana", Font.BOLD, 16));
		depositBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//When we create an instance of the Account class, we pass in 0 dollars for the object. 
				//So the starting balance of the account is 0 dollars and using the deposit and withdraw
				//Using the toString method in the Double class, we can convert the amount we are depositing to a string
				balTxT.setText(Double.toString(acc1.getBalance()));
				double amount = Double.parseDouble(depositTxt.getText());
				
				acc1.deposit(amount);
				JOptionPane.showMessageDialog(null, "You have deposited your money.", null,JOptionPane.INFORMATION_MESSAGE);
				balTxT.setText(Double.toString(acc1.getBalance()));
				depositTxt.setText("0");
				
			}
		});
		depositBut.setBounds(50, 150,125,30);
		atmFrame.getContentPane().add(depositBut);
		
		JButton withdrawBut = new JButton("Withdraw");
		withdrawBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Before the button click, the amount is either 0 or a number if we used the deposit method
				//Then when we withdraw money, we use the withdraw method and use the balance the account has currently
				balTxT.setText(Double.toString(acc1.getBalance()));
				double amount = Double.parseDouble(withdrawTxt.getText());
				acc1.withdraw(amount);
				//Using an if statement make sure that the user is not withdrawing money that they don't have in their account
				if (acc1.getBalance()<0)
				{
					JOptionPane.showMessageDialog(null, "You don't have enough money in the account. ");
					acc1.setBalance(acc1.getBalance());
					withdrawTxt.setText("0");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Here is your money.", null,JOptionPane.INFORMATION_MESSAGE);
					balTxT.setText(Double.toString(acc1.getBalance()));
					depositTxt.setText("0");
				}
			}
		});
		withdrawBut.setFont(new Font("Verdana", Font.BOLD, 16));
		withdrawBut.setBounds(50, 225, 125, 30);
		atmFrame.getContentPane().add(withdrawBut);
		
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Thank you for visiting us. Have a nice day. ", null,JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);

			}
		});
		exitButton.setFont(new Font("Verdana", Font.BOLD, 16));
		exitButton.setBounds(50, 300, 125, 30);
		atmFrame.getContentPane().add(exitButton);
		
		depositTxt = new JTextField();
		depositTxt.setBounds(250, 150, 125, 30);
		atmFrame.getContentPane().add(depositTxt);
		depositTxt.setColumns(10);
		
		withdrawTxt = new JTextField();
		withdrawTxt.setColumns(10);
		withdrawTxt.setBounds(250, 225, 125, 30);
		atmFrame.getContentPane().add(withdrawTxt);
		
		JLabel titleLabel = new JLabel("Menu");
		titleLabel.setFont(new Font("Verdana", Font.BOLD, 20));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(68, 11, 271, 51);
		atmFrame.getContentPane().add(titleLabel);
		
		balTxT = new JTextField("0.0");
		balTxT.setBounds(250, 75, 125, 30);
		atmFrame.getContentPane().add(balTxT);
		balTxT.setColumns(10);
	}
}
