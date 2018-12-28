package lab9_Ma_Interfaces;

public class Interest_Rate implements Info_Displayable, Comparable{
	/* Program written by Tony Ma on 11/17/16
	 * This program will show the total balance and interest rate, will also sort by alphabetical order */
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
	public int compareTo(Object otherObject) {
		try {
			Interest_Rate firstRate = (Interest_Rate) otherObject;


			return this.name.compareTo(firstRate.getName());
		}
		catch (Exception e) {
			System.out.println("Interest Rate.compareTo() cannot cast "+
					otherObject.getClass() +" otherObject to Interest Rate.");
			return -99;
		}
	}

    public String getLine () {
    	String line = 		
    			// 19 characters, left justify, String. 
    			// Plus space (=20 characters in all).
    			String.format("%-19s",this.name) + " "
    			
    			// 14 characters (including decimal point), right justify, decimal
    			// Plus space (=15 characters in all).
    			 + String.format("%14.2f",this.balance) + " "
    			
    			// 19 characters, left justify, String 
     			// Plus space (=20 characters in all).
    			+ String.format("%14.2f", this.interestRate);
    	return line;
    }
    
    public String getHeading () {
    	String line = 		
    			// 19 characters, left justify, String. 
    			// Plus space (=20 characters in all).
    			String.format("%-19s","Name") + " "
    			
    			// 14 characters (including decimal point), right justify, decimal
    			// Plus space (=15 characters in all).
    			 + String.format("%14s","Balance") + " "
    			
    			// 19 characters, left justify, String 
     			// Plus space (=20 characters in all).
    			+ String.format("%14s","Interest Rate");
    	return line;
    }
}//end of class
