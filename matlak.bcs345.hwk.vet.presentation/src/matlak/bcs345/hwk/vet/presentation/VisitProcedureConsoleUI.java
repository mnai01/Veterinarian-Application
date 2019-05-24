package matlak.bcs345.hwk.vet.presentation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

import matlak.bcs345.hwk.vet.business.VisitProcedure;

/**
 * This class is the UI that is displayed in the command prompt.
 * It gives the user 5 options to pick from.
 * 1. will read the data from a file
 * 2. will write the data from a file
 * 3. displays tostring
 * 4. displays json
 * 5. exit
 * @author Ian Matlak
 * @version 1.0
 * @since 10/21/2018
 *
 */
public class VisitProcedureConsoleUI {
	
/**
	 * It gives the user 5 options to pick from.
	 * 1. will read the data from a file
	 * 2. will write the data from a file
	 * 3. displays tostring
	 * 4. displays json
	 * 5. exit
	 */
	void ShowUI() {
		String inputfile;
		Scanner s=null;
		PrintStream ps=null;

		VisitProcedure vp = new VisitProcedure();
		
		//Format UI
		System.out.print("\n\nVisit Procedure UI\n");
		System.out.print("------------------\n");
		System.out.print("1 – Read visit procedure from file\n");
		System.out.print("2 – Write visit procedure to file\n");
		System.out.print("3 – Show visit procedure data with descriptive text on screen\n");
		System.out.print("4 – Show visit procedure JSON on screen\n");
		System.out.print("5 - Exit\n");
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter Choice: ");
		int choice = keyboard.nextInt();
		while (choice != 5) 
		{
			switch (choice) {
				case 1:
					//asks user for file name then stores it in inputfile
					System.out.println("Enter file name: ");
					keyboard = new Scanner(System.in);
					inputfile = keyboard.nextLine();
					try {
						//stores inputfile in s makes it possible to read from file.txt
						s = new Scanner(new FileReader(inputfile));
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//reads the data from S
					vp.Read(s);
					break;
					
				case 2:
					//get output name from 
					String output;
					keyboard = new Scanner(System.in);
					System.out.println("Enter file name: ");
					output = keyboard.nextLine();
					try {
						ps = new PrintStream(output);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					//Wrtie data to the file.txt
					vp.Write(ps);
					break;

				case 3:
					//Displays toString
					System.out.printf("\n\n%s",vp.toString());
					break;

				case 4:
					//display json
					System.out.printf("\n%s",vp.getJSON());
					break;

				case 5:
					//exits out of switch and ends program
					System.exit(1);
					break;
				
				default:
					System.out.print("Pick a valid option!");

			}
			System.out.print("\n\nVisit Procedure UI\n");
			System.out.print("------------------\n");
			System.out.print("1 – Read visit procedure from file\n");
			System.out.print("2 – Write visit procedure to file\n");
			System.out.print("3 – Show visit procedure data with descriptive text on screen\n");
			System.out.print("4 – Show visit procedure JSON on screen\n");
			System.out.print("5 - Exit\n");
			System.out.println("Enter Choice: ");
			keyboard = new Scanner(System.in);
			choice = keyboard.nextInt();
		}
	}
}
