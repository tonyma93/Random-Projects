package lab7_file_io;
import java.io.PrintWriter;          

public class Ma_WriteMainOnly {

	public static void main (String [] args)
	{
		// Look for this file in the same folder as your project.
		// So (after running the program), you should see it under workspace/projectName.
		String fileName = "out.txt"; 
		
		try
		{
			PrintWriter outputStream = new PrintWriter (fileName);

			for (int count = 1 ; count <= 3 ; count++)
			{
				outputStream.println ("This is line " + count + ".");
			}
			
			// you have to close the file or the last parts of the data 
			// may not be saved to the file. 
			outputStream.close ();
			
			System.out.println ("Those lines were written to " + fileName + 
					" in your project's folder under Eclipse's workspace folder.");
			
		} // end try
		catch (Exception e)
		{
			System.out.println ("Exception encountered: " +e.getMessage());
		}
	} // end main method
} // end class
