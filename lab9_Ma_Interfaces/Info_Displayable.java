package lab9_Ma_Interfaces;

public interface Info_Displayable {
	
    /* Returns a String that contains all the values of the properties of the object, 
     * each value in a formatted (fixed width), nice for reporting. **/
    public String getLine ();
    
    /* Returns a String that contains column headings for all the properties of the object, 
     * each heading formatted (the same width as the property for which it is column heading). **/
    public String getHeading ();    
}
