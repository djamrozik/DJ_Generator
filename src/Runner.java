import java.util.Scanner;


public class Runner {

	static Scanner scan = new Scanner(System.in);
	static int size = 0;
	static String[] names = new String[size];
	static int[][] checked = new int [0][0];
	
	public static void main(String[] args) {
		
		System.out.println("Enter the name/initials of the brothers (Enter \"DONE\" to complete the list");
		
		int a = -1;
		for(int i = 0; i != a; i++){
			String name = scan.nextLine();
			if(!name.equalsIgnoreCase("DONE")){
				//I could use an ArrayList, but fuck it
				//
				//increment the size
				size++;
				//create a old array, create a new array of correct size
				String[] oldNames = names;
				names = new String[size];
				//copy 
				for(int j = 0; j < oldNames.length; j++){
					names[j] = oldNames[j];
				}
				//add newest String values
				names[size - 1] = name;
			} else {
				i = -2;
			}
		}// end of for loop
		
		//as of 10/20/2014 8:29 PM all names are being saved correctly, don't fuck with the code
		//System.out.println("\nNumber of names: " + names.length);
		//Type an 'X' or 'x' where you want a job done
		
		//                                 j 2   6  10  14  18
		String a1 = "Wipe down blocks:     $[o] [o] [x] [o] [o]";
		String a2 = "Vacuum couches:       $[o] [o] [x] [x] [o]";
		String a3 = "Wipe off tables:      $[x] [o] [x] [o] [o]";
		String a4 = "Sweep and mop floors: $[o] [x] [o] [o] [o]";
		
		String[] list = new String[]{a1, a2, a3, a4};
		
		//this 2D array will hold the value of -1 if there is no job in that location
		//will hold 1 is there is
		//the dimensions of the 2D array are self explanatory
		checked = new int[list.length][5];
		
		//set each value of checked to -1
		for(int i = 0; i < checked.length; i++){
			for(int j = 0; j < checked[0].length; j++){
				
				checked[i][j] = -1;
				
			}
		}
		
		for (int i = 0; i < list.length; i++){
			
			//make a character string of that line
			char[] listLine = list[i].toCharArray();
			
			//look for the '$' character
			for(int j = 0; j < listLine.length; j++){
				
				if(listLine[j] == '$'){
					//check out the indexes
					//depending on which one, put 1 for the checked 2d array
					if(listLine[j+2] == 'x'){
						checked[i][0] = 1;
					} 
					if(listLine[j+6] == 'x'){
						checked[i][1] = 1;
					}
					if(listLine[j+10] == 'x'){
						checked[i][2] = 1;
					}
					if(listLine[j+14] == 'x'){
						checked[i][3] = 1;
					}
					if(listLine[j+18] == 'x'){
						checked[i][4] = 1;
					}
				}
				
			}//end of listLine for loop
			
		}// end of list for loop
		
		//as of 10/20/2014 9:15PM it is registering 1's and -1's. Don't fuck with the code
		RandomName rand = new RandomName(names);
		
		//Now we can print out who gets what to do:
		System.out.println("Wipe down blocks...     :     $[" + rand.getName(checked[0][0])+ "] [" + rand.getName(checked[0][1]) + "] [" + rand.getName(checked[0][2]) + "] [" + rand.getName(checked[0][3]) + "] [" + rand.getName(checked[0][4]) +"]");
		System.out.println("Vacuum couches...       :     $[" + rand.getName(checked[1][0])+ "] [" + rand.getName(checked[1][1]) + "] [" + rand.getName(checked[1][2]) + "] [" + rand.getName(checked[1][3]) + "] [" + rand.getName(checked[1][4]) +"]");
		System.out.println("Wipe off tables...      :     $[" + rand.getName(checked[2][0])+ "] [" + rand.getName(checked[2][1]) + "] [" + rand.getName(checked[2][2]) + "] [" + rand.getName(checked[2][3]) + "] [" + rand.getName(checked[2][4]) +"]");
		System.out.println("Sweep and mop floors... :     $[" + rand.getName(checked[3][0])+ "] [" + rand.getName(checked[3][1]) + "] [" + rand.getName(checked[3][2]) + "] [" + rand.getName(checked[3][3]) + "] [" + rand.getName(checked[3][4]) +"]");
		
	}

}
