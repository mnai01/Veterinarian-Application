package matlak.bcs345.hwk.vet.presentation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;
import matlak.bcs345.hwk.vet.business.*;

/** 
 * Contains the main code that is testing all of the outside classes
 * Mostly new instances of classes, test variables, test if/else and 
 * testing return statements from methods in other classes are in this code.
 * 
 * @author Ian Matlak
 * @version 1.3
 * @since 12/12/2018
 */
public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		/*
		//creates instance of class
		Pet p = new Pet();
		
		//test variables for if/else test statements
		String testName = "yolo";
		String testSpecies = "dog";
		String testGender = "M";
		
		//sets the test variables
		p.setName(testName);
		p.setSpecies(testSpecies);
		p.setGender(testGender);

		//testing get/set
		if(testName == p.getName()) {
			System.out.println("Pet Get/Set Name: Pass");
		} else {
			System.out.println("Pet Get/Set Name: Failed");
		}
		
		if(testSpecies == p.getSpecies()) {
			System.out.println("Pet Get/Set Species: Pass");
		} else {
			System.out.println("Pet Get/Set Species: Failed");
		}
		
		if(testGender == p.getGender()) {
			System.out.println("Pet Get/Set Gender: Pass");
		} else {
			System.out.println("Pet Get/Set Gender: Failed");
		}

		//pet.txt has data on it for pet name/species/gender
		String inputfile = "Pet.txt";
		
		//creates and instance of scanner and reads pet.txt
		Scanner s = new Scanner(new FileReader(inputfile));
		
		//outputs pet.txt data onto outputpet.txt
		PrintStream ps = new PrintStream("outputpet.txt");
		
		//calls method read from p pet
		p.Read(s);
		//calls method write from p pet
		p.Write(ps);
		
		//creates instance of procedure
		Procedure pd = new Procedure();

		//test variables for if/else test statements
		String testNamePD = "swag";
		double TestPrice = 69.69;

		//sets the test variables
		pd.setName(testNamePD);
		pd.setPrice(TestPrice);
				
		//testing get/set
		if (testNamePD == pd.getName()) {
			System.out.println("Procedure Get/Set Name: Pass");
		}else {
			System.out.println("Procedure Get/Set Name: Failed");
		}
		
		if (TestPrice == pd.getPrice()) {
			System.out.println("Procedure Get/Set Price: Pass");
		}else {
			System.out.println("Procedure Get/Set Price: failed");
		}
		
		//procedure.txt has data on it for pet name/price
		inputfile = "Procedure.txt";
		
		//creates and instance of scanner and reads procedure.txt
		s = new Scanner(new FileReader(inputfile));
		
		//outputs procedure.txt data onto outputprocedure.txt
		ps = new PrintStream("outputprocedure.txt");
		
		//calls method read from p pet
		pd.Read(s);
		//calls method write from p pet
		pd.Write(ps);
		
		//prints json from pet
		System.out.printf("\n%s",p.GetJSON());
		//prints tostring from pet
		System.out.printf("\n\n%s\n",p.toString());
		
		//prints json from procedure
		System.out.printf("\n%s",pd.GetJSON());
		//prints tostring from procedure
		System.out.printf("\n\n%s",pd.toString());


		//creates instance and sets new constructor
		Pet pp = new Pet("Tom", "Reptile", "F");
		
		//prints new constructor from pet
		System.out.printf("\n\n%s",pp.getName());
		System.out.printf("\n%s",pp.getSpecies());
		System.out.printf("\n%s",pp.getGender());

		//creates instance and sets new constructor
		Procedure pdd = new Procedure("Bob", 10.57);
		
		//prints new constructor from pet
		System.out.printf("\n\n%s",pdd.getName());
		System.out.printf("\n%.2f",pdd.getPrice());


		String inputfile = "VisitProcedure.txt";

		//creates and instance of scanner and reads pet.txt
		Scanner s = new Scanner(new FileReader(inputfile));
		//outputs pet.txt data onto outputpet.txt
		PrintStream ps = new PrintStream("outputVisitProcedure.txt");
				
		
		VisitProcedure vp = new VisitProcedure();
		vp.Read(s);
		vp.Write(ps);
		System.out.printf("\n%s",vp.GetJSON());
		System.out.printf("\n\n%s",vp.toString());
	
		
		String inputfile = "Appointment.txt";
		Scanner s = new Scanner(new FileReader(inputfile));
		PrintStream ps = new PrintStream("outputAppointment.txt");

		
		
		Appointment ap = new Appointment();
		ap.Read(s);
		ap.Write(ps);
		System.out.printf("\n%s",ap.GetJSON());
		System.out.printf("\n\n%s",ap.toString());
		
		VisitProcedureConsoleUI vpui = new VisitProcedureConsoleUI();
		vpui.ShowUI();
		*/	

		
/*		String inputfile = "Visit.txt";
		Scanner s = new Scanner(new FileReader(inputfile));
		PrintStream ps = new PrintStream("outputVisit.txt");
		
		Visit v = new Visit();

		v.Read(s);
		v.Write(ps);
		v.Report(ps);
		System.out.printf(v.GetJSON());
		System.out.printf(v.toString());*/


		System.out.print("\n\nChoose UI\n");
		System.out.print("------------------\n");
		System.out.print("1 – VisitProcedureConsoleUI\n");
		System.out.print("2 – VisitConsoleUI\n");
		System.out.print("3 – VetGraphicalUI\n");
		System.out.print("4 – Exit\n");
		VisitProcedureConsoleUI vp = new VisitProcedureConsoleUI();
		VisitConsoleUI v = new VisitConsoleUI();
		VetGraphicalUI vgui = new VetGraphicalUI();
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter Choice: ");
		int cchoice = keyboard.nextInt();
		while(cchoice != 4) {
			switch(cchoice) {
			case 1:
				vp.ShowUI();
				System.out.print("\n\nChoose UI\n");
				System.out.print("------------------\n");
				System.out.print("1 – VisitProcedureConsoleUI\n");
				System.out.print("2 – VisitConsoleUI\n");
				System.out.print("3 – VetGraphicalUI\n");
				System.out.print("4 – Exit\n");
				System.out.println("Enter Choice: ");
				cchoice = keyboard.nextInt();
				break;
			case 2:
				v.ShowUI();
				System.out.print("\n\nChoose UI\n");
				System.out.print("------------------\n");
				System.out.print("1 – VisitProcedureConsoleUI\n");
				System.out.print("2 – VisitConsoleUI\n");
				System.out.print("3 – VetGraphicalUI\n");
				System.out.print("4 – Exit\n");
				System.out.println("Enter Choice: ");
				cchoice = keyboard.nextInt();
				break;
			case 3:
				vgui.ShowUI();
				System.out.println("Enter Choice: ");
				cchoice = keyboard.nextInt();
				break;
			case 4:
				break;
			default:
				System.out.print("\n\nChoose UI\n");
				System.out.print("------------------\n");
				System.out.print("1 – VisitProcedureConsoleUI\n");
				System.out.print("2 – VisitConsoleUI\n");
				System.out.print("3 – VetGraphicalUI\n");
				System.out.print("4 – Exit\n");
				System.out.println("Enter Choice: ");
				cchoice = keyboard.nextInt();
				
			}	
		}
		
		
		/*while(cchoice != 3) {
		if (cchoice == 1)
		{
				vp.ShowUI();	
				System.out.println("Enter Choice: ");
				cchoice = keyboard.nextInt();
		}else if(cchoice == 2) {
				v.ShowUI();
				System.out.println("Enter Choice: ");
				cchoice = keyboard.nextInt();
		}
		}*/
		
	}

}
