import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AccountTest {

	private JFrame menuFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					AccountTest window = new AccountTest();
					window.menuFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AccountTest() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//Create an instance of the Account class 
		//This instance is not shared with all the classes; therefore each class has to call the Account
		//class and create the instance
		Account acc1 = new Account(1001,0);
		
		menuFrame = new JFrame();
		menuFrame.setTitle("Menu");
		menuFrame.setBounds(100, 100, 525, 330);
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuFrame.getContentPane().setLayout(null);
		
		JLabel titleLabel = new JLabel("Select one of the options");
		titleLabel.setFont(new Font("Verdana", Font.BOLD, 20));
		titleLabel.setBounds(107, 40, 291, 34);
		menuFrame.getContentPane().add(titleLabel);
		
		JButton depositBut = new JButton("Deposit\r\n");
		depositBut.setFont(new Font("Verdana", Font.BOLD, 16));
		depositBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Run the Deposit class
				Deposit dep = new Deposit();
				dep.main(null);
				//Close the current window
				menuFrame.setVisible(false);
			}
		});
		depositBut.setBounds(83, 118, 130, 49);
		menuFrame.getContentPane().add(depositBut);
		
		JButton withdrawBut = new JButton("Withdraw");
		withdrawBut.setFont(new Font("Verdana", Font.BOLD, 16));
		withdrawBut.setBounds(282, 117, 130, 50);
		withdrawBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Run the Deposit class
				Withdraw withdraw = new Withdraw();
				withdraw.main(null);
				//Close the current window
				menuFrame.setVisible(false);
			}
		});
		menuFrame.getContentPane().add(withdrawBut);
		
		JButton checkBut = new JButton("Check \r\nBalance");
		checkBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Runs the CheckAccount class
				CheckAccount check = new CheckAccount();
				check.main(null);
				//Close the current window
				menuFrame.setVisible(false);
			}
		});
		checkBut.setFont(new Font("Verdana", Font.BOLD, 12));
		checkBut.setBounds(83, 194, 132, 52);
		menuFrame.getContentPane().add(checkBut);
		
		JButton exitBtn = new JButton("Exit");
		exitBtn.setFont(new Font("Verdana", Font.BOLD, 16));
		exitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Close the resourses
				System.exit(0);
			}
		});
		exitBtn.setBounds(282, 193, 130, 50);
		menuFrame.getContentPane().add(exitBtn);
	}

}
