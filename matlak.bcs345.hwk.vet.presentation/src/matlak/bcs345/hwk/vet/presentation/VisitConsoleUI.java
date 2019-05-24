package matlak.bcs345.hwk.vet.presentation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

import matlak.bcs345.hwk.vet.business.VisitProcedure;
import matlak.bcs345.hwk.vet.business.Procedure;
import matlak.bcs345.hwk.vet.business.Visit;

/**
 * This class is the UI that is displayed in the command prompt.
 * It gives the user 5 options to pick from.
 * 1. will read the data from a file
 * 2. will write the data from a file
 * 3. Show the name and price by index
 * 4. Show the highest about out of all procedures.
 * 5. Shows visit report on the screen
 * 6. Displays JSON
 * 7. Displays toString
 * 8. EXIT
 * @author Ian Matlak
 * @version 1.0
 * @since 11/02/2018
 */
public class VisitConsoleUI {
	
	/**
	 * Gives you 8 options to choose from
	 * read
	 * write
	 * display index
	 * show highest
	 * report on screen
	 * json
	 * tostring
	 * exit
	 */
	void ShowUI() {
		String inputfile;
		Scanner s=null;
		PrintStream ps=null;

		Visit v = new Visit();
		VisitProcedure vp = new VisitProcedure();


		System.out.print("\n\nVisit UI\n");
		System.out.print("------------------\n");
		System.out.print("1 – Read visit info from file\n");
		System.out.print("2 – Write visit into file\n");
		System.out.print("3 – Show visit procedure by index\n");
		System.out.print("4 – Show visit procedure with highest amount due\n");
		System.out.print("5 - Show visit report on screen\n");
		System.out.print("6 - Show visit as JSON string on screen\n");
		System.out.print("7 - Show visit toString on screen\n");
		System.out.print("8 - Exit\n");
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter Choice: ");
		int choice = keyboard.nextInt();
		//While if else statement used to go through all the options
		while (choice != 8) {
				if (choice == 1) {
						//asks user for file name then stores it in inputfile
						System.out.println("Enter file name: ");
						keyboard = new Scanner(System.in);
						inputfile = keyboard.nextLine();
						try {
							//stores inputfile in s makes it possible to read from file.txt
							s = new Scanner(new FileReader(inputfile));
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						}
						//reads the data from S
						v.Read(s);
				}else if(choice == 2) {
						//asks user for file name then stores it in inputfile
						String output;
						keyboard = new Scanner(System.in);
						System.out.println("Enter file name: ");
						output = keyboard.nextLine();
						try {
							ps = new PrintStream(output);
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						}
						
						//Wrtie data to the file.txt
						v.Write(ps);
				}else if(choice == 3) {
						//asks user to type in index
						int index;
						System.out.println("Enter a index: ");
						keyboard = new Scanner(System.in);
						try {
							
							index = keyboard.nextInt();
							v.GetByIndex(index);
							//System.out.printf("%s\n%.2f\n", p.getName(), p.getPrice());
							System.out.println(v.GetByIndex(index));

						}
						catch(ArrayIndexOutOfBoundsException ar){
							System.out.println("Exception Caught Array Out Of Bounds");
						}
				}else if(choice == 4) {	
						// outputs highest amount due
						System.out.println(v.GetHighestProcedureAmountDue());
				}else if(choice == 5) {	
						//Diplsays report on the screen
						v.Report(System.out);
				}else if(choice == 6) {	
						//prints JSON
						System.out.printf(v.GetJSON());
						}
				else if(choice == 7) {	
						//Prints toString
						System.out.printf(v.toString());
						}
				else { 
					System.out.print("Pick a valid option!");
					}
				System.out.print("\n\nVisit UI\n");
				System.out.print("------------------\n");
				System.out.print("1 – Read visit info from file\n");
				System.out.print("2 – Write visit into file\n");
				System.out.print("3 – Show visit procedure by index\n");
				System.out.print("4 – Show visit procedure with highest amount due\n");
				System.out.print("5 - Show visit report on screen\n");
				System.out.print("6 - Show visit as JSON string on screen\n");
				System.out.print("7 - Show visit toString on screen\n");
				System.out.print("8 - Exit\n");
				System.out.println("Enter Choice: ");
				keyboard = new Scanner(System.in);
				choice = keyboard.nextInt();
			}
		
		
	}
	
}