package lab7_file_io;

public class Interest_Rate {
	/* Program written by Tony Ma on 10/26/16
	 * This program will calculate the total balance after 5 years 
	 * for two people's balances with their interest rates */
	//instance variables
	private String name = ""; //name of person
	private double balance = 0; //current balance
	private double interestRate = 0.00; //interest rate

	//constructor method
	public Interest_Rate(String myName, double myBalance, double theInterestRate){
		this.name = myName;
		this.balance = myBalance;
		this.interestRate = theInterestRate; 	
	}
	//overload constructor 
	public Interest_Rate(){		
	}
	public String getName(){ //returns a string to get name
		return this.name;
	}
	public double getBalance(){//returns a double to get balance
		return this.balance;
	}
	public double getInterestRate(){//returns a double to get interest rate
		return this.interestRate;
	}
	public void setName(String newName){// changes the name object
		this.name = newName;
	}
	public void setBalance(double newBalance){// changes the balance object
		this.balance = newBalance;
	}
	public void setInterestRate(double newInterestRate){//changes the interest rate object
		this.interestRate = newInterestRate;
	}
	public String objectToLine() {
		String line = 
		String.format("%-19s",this.name) 
		+ String.format("%9.2f",this.balance) 
		+ String.format("%9.2f",this.interestRate);
		return line;
	}
	public String toString () {
		String msg = this.name + ", your curent balance is " + this.balance+
				" and your interest rate is: "+ this.interestRate; 
		return msg;
	}
	public void updateBalance(int years)//getting updated balance after 5 years
	{
		double dblBalance = this.balance;
		while ((years > 0) && (dblBalance > 0))
		{
			dblBalance = dblBalance * (1 + this.interestRate);
			years--; 
		}
		this.balance = dblBalance; //final balance
	} 


}//end of class
