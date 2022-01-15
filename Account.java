/**
 * 
 */

/**
 * @author pmei8
 * The Account class has attributes such as account number, bank balance,
 * methods such as deposit, withdraw and modify.
 * 
 */
public class Account {
	
	Customer cus1 = new Customer("Peter","50 Water Way","01/22/1980",1,123);

	private int accNum;
	private double balance;
	
	public Account(int accNum, double balance) {
		this.accNum = accNum;
		this.balance = balance;
	}

	/**
	 * @return the accNum
	 */
	public int getAccNum() {
		return accNum;
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @param accNum the accNum to set
	 */
	public void setAccNum(int accNum) {
		this.accNum = accNum;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public double deposit(double amount)
	{
		this.balance = this.balance + amount;
		return this.balance;
	}
	
	public double withdraw(double amount)
	{
		this.balance = this.balance - amount;
		return this.balance;
	}

	
}
