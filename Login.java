import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Login {

	private JFrame loginFrame;
	private JTextField pinText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Login window = new Login();
					window.loginFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		// Create an instance of the Customer class
		Customer cus1 = new Customer("Peter","90 Waterside Park","12/12/1990",1009,123);
		loginFrame = new JFrame();
		loginFrame.setTitle("Login");
		loginFrame.setBounds(100, 100, 447, 347);
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.getContentPane().setLayout(null);
		
		JLabel pinLabel = new JLabel("Enter your pin.");
		pinLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pinLabel.setFont(new Font("Verdana", Font.BOLD, 20));
		pinLabel.setBounds(121, 36, 196, 53);
		loginFrame.getContentPane().add(pinLabel);
		
		pinText = new JTextField();
		pinText.setHorizontalAlignment(SwingConstants.CENTER);
		pinText.setFont(new Font("Verdana", Font.BOLD, 12));
		pinText.setBounds(166, 106, 104, 31);
		loginFrame.getContentPane().add(pinText);
		pinText.setColumns(10);
		
		JLabel wrongLabel = new JLabel("");
		wrongLabel.setHorizontalAlignment(SwingConstants.CENTER);
		wrongLabel.setBounds(121, 148, 196, 47);
		loginFrame.getContentPane().add(wrongLabel);
		JButton login = new JButton("Login");
		login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int pin = Integer.parseInt(pinText.getText());
				 if (cus1.verifyPin(pin) == true)
				 {
					 ATMTest loggedIn = new ATMTest();
					 ATMTest.main(null);
					 loginFrame.setVisible(false);
				 }
				 else
				 {
					wrongLabel.setText("You entered the wrong pin."); 
				 }
				
			}
		});
		login.setFont(new Font("Verdana", Font.BOLD, 13));
		login.setBounds(166, 206, 104, 31);
		loginFrame.getContentPane().add(login);




	}
}
