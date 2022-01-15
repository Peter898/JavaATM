import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Deposit {

	private JFrame depFrame;
	private JTextField amountTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deposit window = new Deposit();
					window.depFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Deposit() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//Create an instance of the Account class 
		Account acc1 = new Account(1001,0);

		depFrame = new JFrame();
		depFrame.setTitle("Deposit\r\n");
		depFrame.setBounds(100, 100, 450, 300);
		depFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		depFrame.getContentPane().setLayout(null);
		
		JLabel titleLabel = new JLabel("Deposit Amount");
		titleLabel.setFont(new Font("Verdana", Font.BOLD, 20));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(79, 30, 266, 54);
		depFrame.getContentPane().add(titleLabel);
		
		amountTxt = new JTextField();
		amountTxt.setFont(new Font("Verdana", Font.PLAIN, 16));
		amountTxt.setHorizontalAlignment(SwingConstants.CENTER);
		amountTxt.setBounds(100, 109, 227, 54);
		depFrame.getContentPane().add(amountTxt);
		amountTxt.setColumns(10);
		
		JButton depositBut = new JButton("Deposit");
		depositBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double amount = Double.parseDouble(amountTxt.getText());
				acc1.deposit(amount);
				//After the transaction is done, call the Account Test class again
				AccountTest logged = new AccountTest();
				logged.main(null);
				//Close the previous frame
				depFrame.setVisible(false);
				
			}
		});
		depositBut.setFont(new Font("Verdana", Font.BOLD, 18));
		depositBut.setBounds(137, 199, 148, 40);
		depFrame.getContentPane().add(depositBut);
	}

}
