package lab9_Ma_Interfaces;

public class Ma_Interface_Tester2 {
	/* Program written by Tony Ma on 11/17/16
	 * This program will report and sort the lists of Interest Rate and School Lists*/
	public static void main(String[] args) {
		Interest_Rate[] Interest_Rate_List = null; 


		report (">> Interest Rate List Before Sort <<", Interest_Rate_List); 
		sort(Interest_Rate_List);
		report(">> Interest Rate List After Sort<<", Interest_Rate_List);
		School[] schoolList = {}; 		

		report (">> School List Before Sort <<", schoolList); 
		sort(schoolList);
		report (">> School List After Sort <<", schoolList);

	}
	public static void report (String reportList, Info_Displayable[] list) {
		System.out.println();
		System.out.println(reportList);
		if (list == null) {
			System.out.println("Null list");
		}
		else if (list.length==0){
			System.out.println("Empty List");
		}
		else if (list.length > 0) {
			System.out.println(list[0].getHeading());
			for (int i = 0; i < list.length; i++) {
				System.out.println(list[i].getLine());}
		}
		System.out.println();
	}
	public static void sort(Comparable[] list) {
		if (list == null) {
			System.out.println("Null list");}
		else if(list.length == 0){
			System.out.println("Empty List");
		}
		else if (list.length > 0){
		for (int i = 0; i < list.length-1; i++) {

			// find smallest name within i..end of list
			int smallNameSpot = i;
			for (int j = i+1; j < list.length; j++) {
				if (list[j].compareTo(list[smallNameSpot])<0) {
					smallNameSpot = j;
				}
			}

			Comparable tempList = list[i];
			list[i]=list[smallNameSpot];
			list[smallNameSpot]=tempList;		
		}
	}
}
}