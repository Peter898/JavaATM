import java.util.Scanner;

/*
 * The ATM class uses inherits the Account class. 
 * Aside from the Account class attributes, the ATM has attributes
 * such as the transaction number and the date they made the transaction.
 * 
 * */
public class ATM extends Account{
	
	private int transactionID;
	private String date;
	
	public ATM(int accNum, double balance, int transactionID) {
		super(accNum, balance);
		// TODO Auto-generated constructor stub
		this.transactionID = transactionID;
	}

	/**
	 * @return the transactionID
	 */
	public int getTransactionID() {
		return transactionID;
	}



	/**
	 * @param transactionID the transactionID to set
	 */
	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}


	
	//The modify method allows the user to change information and access their account. 
	public void modify()
	{
		Account acc1 = new Account(cus1.getAccNum(),0);
		int choice = 0;
		double amount;
		Scanner kb = new Scanner(System.in);
		do {
			System.out.println("Select from one of the options.");
			System.out.println("1. Deposit.");
			System.out.println("2. Withdraw.");
			System.out.println("3. Check Balance");
			System.out.println("4.  Exit.");
			choice = kb.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("How much do you want to deposit?");
				amount = kb.nextDouble();
				acc1.deposit(amount);
				break;
			case 2:
				System.out.println("How much do you want to withdraw?");
				amount = kb.nextDouble();
				acc1.withdraw(amount);
				break;
			case 3:
				System.out.println("Here is your balance.");
				System.out.println("---------------------");
				System.out.println("Balance:" + acc1.getBalance());
				break;
			default:
					System.out.println("Exiting program.");
				
			}
			
		} while (choice!= 4);
		
	}
	

}
