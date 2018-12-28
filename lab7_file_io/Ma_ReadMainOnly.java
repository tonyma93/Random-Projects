package lab7_file_io;
//These needed for reading
import java.util.Scanner;
import java.io.File;

public class Ma_ReadMainOnly{

	public static void main (String [] args)
	{
		// Look for this file in the same folder as your project.
		// So (after running the program), you should see it under workspace/projectName.
		String line = "";
		String fileName = "out.txt";
		System.out.println ("The file " + fileName + " contains the following lines:");
		try
		{
			Scanner inputStream = new Scanner (new File (fileName));

			while (inputStream.hasNextLine ())
			{
				line = inputStream.nextLine();
				System.out.println (line);
			}
			inputStream.close ();
		}
		catch (Exception e)
		{
			System.out.println ("Exception encountered: " +e.getMessage());
		}
	}
}


