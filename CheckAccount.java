import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CheckAccount {

	private JFrame checkframe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckAccount window = new CheckAccount();
					window.checkframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CheckAccount() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//Create an instance of the Account class
		Account acc1 = new Account(1001,0);

		checkframe = new JFrame();
		checkframe.setBounds(100, 100, 450, 300);
		checkframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		checkframe.getContentPane().setLayout(null);
		
		JLabel balLabel = new JLabel("Balance");
		balLabel.setHorizontalAlignment(SwingConstants.CENTER);
		balLabel.setFont(new Font("Verdana", Font.BOLD, 20));
		balLabel.setBounds(114, 45, 186, 52);
		checkframe.getContentPane().add(balLabel);
		
		JButton backBut = new JButton("Back");
		backBut.setFont(new Font("Verdana", Font.BOLD, 14));
		backBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Go back to the main page
				AccountTest account = new AccountTest();
				account.main(null);
				//Close the current window
				checkframe.setVisible(false);
			}
		});
		backBut.setBounds(169, 216, 89, 23);
		checkframe.getContentPane().add(backBut);
		
		JLabel showAccount = new JLabel("");
		showAccount.setFont(new Font("Verdana", Font.BOLD, 14));
		showAccount.setBounds(64, 107, 314, 80);
		checkframe.getContentPane().add(showAccount);
		
		/*
		 * Show the account information
		 * using the accessors and mutators, get the account information
		 * then cast it to a string so that it can be shown in the label
		 */
		
	}

}
