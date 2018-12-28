package lab5_objects;

public class Interest_Rate {
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
	public String toString () {
		String msg = this.name + ", your curent balance is " + this.balance+
				" and your interest rate is: "+ this.interestRate; 
		return msg;
	}
	public String prettyString () {
		String msg = this.name + 
				", your balance will be " +String.format("%-,12.2f",this.balance)+
				" and your interest rate is " + this.interestRate;
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
