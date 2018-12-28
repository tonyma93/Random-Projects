package lab9_Ma_Interfaces;

public class School implements Info_Displayable, Comparable{
	/* Program written by Tony Ma on 11/17/16
	 * This program will show the students name,grade
	 * and year. Will also sort by alphabetical order */
	private String name = ""; //name of person
	private double grade = 0;
	private double year = 0;

	//constructor method
	public School (String myName, double myGrade, double myYear){
		this.name = myName;
		this.grade= myGrade;
		this.year = myYear; 	
	}
	//overload constructor 
	public School(){		
	}
	public String getName(){ //returns a string to get name
		return this.name;
	}
	public double getGrade(){//returns a double to get balance
		return this.grade;
	}
	public double getYear(){//returns a double to get interest rate
		return this.year;
	}
	public void setName(String newName){// changes the name object
		this.name = newName;
	}
	public void setGrade(double newGrade){// changes the balance object
		this.year = newGrade;
	}
	public void setInterestRate(double newYear){//changes the interest rate object
		this.year = newYear;
	}
	 
	public int compareTo(Object otherObject) {
		try {
			School firstRate = (School)otherObject;
			
			return this.name.compareTo(firstRate.getName());
		}
		catch (Exception e) {
			System.out.println("School List.compareTo() cannot cast "+
					otherObject.getClass() +" otherObject to School List.");
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
    			 + String.format("%14.2f",this.grade) + " "
     			// 14 characters (including decimal point), right justify, decimal
     			// Plus space (=15 characters in all).
    			+ String.format("%14.2f",this.year)  + " ";
    	return line;
    }
    
    public String getHeading () {
    	String line = 		
    			// 19 characters, left justify, String. 
    			// Plus space (=20 characters in all).
    			String.format("%-19s","Name") + " "
    			
    			// 14 characters (including decimal point), right justify, decimal
    			// Plus space (=15 characters in all).
    			 + String.format("%14s","Grade") + " "
    			
     			// 14 characters (including decimal point), right justify, decimal
     			// Plus space (=15 characters in all).
    			+ String.format("%14s","Year");
    	return line;
    }
}//end of class