

/*
 * The Customer class is used to store the customers banking information.
 * Such as name, address, date of birth, account number, and pin.
 * */

public class Customer {
	
	private String name;
	private String address;
	private String dob;
	private int accNum;
	private int pin;
	
	public Customer(String name, String address, String dob, int accNum, int pin) {
		this.name = name;
		this.address = address;
		this.dob = dob;
		this.accNum = accNum;
		this.pin = pin;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @return the dob
	 */
	public String getDob() {
		return dob;
	}

	/**
	 * @return the accNum
	 */
	public int getAccNum() {
		return accNum;
	}

	/**
	 * @return the pin
	 */
	public int getPin() {
		return pin;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @param dob the dob to set
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}

	/**
	 * @param accNum the accNum to set
	 */
	public void setAccNum(int accNum) {
		this.accNum = accNum;
	}

	/**
	 * @param pin the pin to set
	 */
	public void setPin(int pin) {
		this.pin = pin;
	}
	
	//The verifyPin method is used to check the pin the user enters
	public boolean verifyPin(int pin)
	{
		boolean check = true;
	
		// Using an if statement check the pin to what is stored in memory
		if (pin == getPin())
		{
			check = true;		
		}
		else
		{
			check  = false;
		}
	
		return check;
	}
	
}
