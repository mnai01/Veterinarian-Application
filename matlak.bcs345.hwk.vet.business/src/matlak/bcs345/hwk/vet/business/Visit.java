package matlak.bcs345.hwk.vet.business;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Uses the information from Appointment and VisitProcedure
 * to output it in varius methods. VisitProcedure data will
 * not be stored in an array.
 * 
 * @author Ian Matlak
 * @version 1.1
 * @since 12/12/2018
 */


/*Good job overall.

Write. Should write out the number of VisitProcedures to the output file just before writing the VisitProcedure data.

toString. Missing some data. Does not write out the veterinarian name or the appointment data.

Note: GetHighestProcedureAmount. It works for the way it is coded. If the default values inside a VisitProcedure were changed to something other than 0 there could be a problem. Here is line 337 in Visit.java which initializes the highest VisitProcedure:
VisitProcedure vp = new VisitProcedure();
Do this instead:s
VisitProcedure vp = VisitProcedure[0]; // Set to the first element of the array
Did not take off points for this.*/


public class Visit {

	private String Veterinarian;
	private Appointment Appointment;
	private VisitProcedure VisitProcedure[];
	private int numOfProcedures; ///////ADDED FOR VETAPPLICATION

	/**
	 * Get and Set methods for numOfProcedures
	 * @return numOfProcedures
	 */
	public int getNumOfProcedures() {return numOfProcedures;} ///////ADDED FOR VETAPPLICATION
	public void setNumOfProcedures(int numOfProcedures) {this.numOfProcedures = numOfProcedures;} ///////ADDED FOR VETAPPLICATION But not being used


	/**
	 * Get and Set methods for Veterinarian
	 * @return Veterinarian
	 */
	public String getVeterinarian() {return Veterinarian;}
	public void setVeterinarian(String NewVeterinarian) {Veterinarian = NewVeterinarian;}

	/**
	 * Get and Set methods for Appointment
	 * @return Appointment
	 */
	public Appointment getAppointment() {return Appointment;}
	public void setAppointment(Appointment NewAppointment) {Appointment = NewAppointment;}

	
	/**
	 * Get and Set methods for VisitProcedure
	 * @return VisitProcedure
	 */
	public VisitProcedure[] getVisitProcedure() {return VisitProcedure;}
	public void setVisitProcedure(VisitProcedure[] NewVisitProcedure) {VisitProcedure = VisitProcedure;}

	/**
	 * Default Constructor which allocates memory for appointment and visitprocuedure in an array
	 */
	public Visit(){
		Veterinarian = "none";
		Appointment = new Appointment();
		VisitProcedure = new VisitProcedure[4];
		VisitProcedure[0] = new VisitProcedure();
		VisitProcedure[1] = new VisitProcedure();
		VisitProcedure[2] = new VisitProcedure();
		VisitProcedure[3] = new VisitProcedure();
	}

	/**
	 * Reads the data in while using the read method in appointment class
	 * and while using the read method in Visitprocedure
	 * for VisitProcedure it uses a for loop to go through the array indexes
	 * @param s
	 */
	//had to make num of NumOfProcedures outside to pass the variable
	
	public void Read(Scanner s) {
		setVeterinarian(s.nextLine());
		Appointment.Read(s);
		numOfProcedures = s.nextInt();//you can use setnumofprocedures instead for better code practice
		VisitProcedure = new VisitProcedure[numOfProcedures];
        for(int i = 0; i < VisitProcedure.length; i++) {
            VisitProcedure[i] = new VisitProcedure();
            s.nextLine();
            VisitProcedure[i].Read(s);
        }

		/*
		setVeterinarian(s.nextLine());
		Appointment.setMonth(s.nextInt());
		Appointment.setDay(s.nextInt());
		Appointment.setYear(s.nextInt());
		s.nextLine();
		Appointment.Pet.setName(s.nextLine());
		Appointment.Pet.setSpecies(s.nextLine());
		Appointment.Pet.setGender(s.nextLine());
		int v = s.nextInt(); //VisitProcedure[0].Pr Number of Procedures NEEDED*
				
		for(int i = 0; i <= 3; i++) {
			//VisitProcedure VisitProcedure[] = new VisitProcedure[4];
			VisitProcedure[i].Procedure.setName(s.nextLine());
			s.nextLine();
			VisitProcedure[i].Procedure.setPrice(s.nextDouble());
			VisitProcedure[i].setQuanity(s.nextInt());
			VisitProcedure[i].setIsCoveredByInsurance(s.nextBoolean());
			VisitProcedure[i].setPctCovered(s.nextDouble());
		}
*/
	}
/**
 * Writes to ps using the write method in appointment and VisitProcedure
 * for VisitProcedure it uses a for loop to go through the array indexes
 * @param ps
 */
	public void Write(PrintStream ps) {
		ps.printf("%s\n",getVeterinarian());
		Appointment.Write(ps);
		ps.println(numOfProcedures);
		//NEED PROCEDURE NUMBERS
		for(int i = 0; i < VisitProcedure.length; i++) {
			VisitProcedure[i].Write(ps);
		}

		/*
		ps.printf("%s\n",getVeterinarian());
		ps.printf("%s\n",Appointment.getMonth());
		ps.printf("%s\n",Appointment.getDay());
		ps.printf("%s\n",Appointment.getYear());
		ps.printf("%s\n",Appointment.Pet.getName());
		ps.printf("%s\n",Appointment.Pet.getSpecies());
		ps.printf("%s\n",Appointment.Pet.getGender());
		
	  	for(int i = 0; i <= 3; i++) {
			ps.printf("\n",VisitProcedure[i].Procedure.getName());
			ps.printf("\n",VisitProcedure[i].Procedure.getPrice());
			ps.printf("\n",VisitProcedure[i].getQuanity());
			ps.printf("\n",VisitProcedure[i].getIsCoveredByInsurance());
			ps.printf("\n",VisitProcedure[i].getPctCovered());
		}

		*/
		
	}
	
	/**
	 * outputs formatted strings for a report to be made while using data from VisitProcudure and appointment
	 * displays it to PS
	 * @param ps
	 */
	public void Report(PrintStream ps) {
		
    	ps.printf("\nPet Veterinarian Visit Report %n");
    	ps.printf("------------------------------ %n");
    	ps.printf("Veterinarian: %s%n", getVeterinarian());
    	ps.printf("%-12s","Date");
    	if (Appointment.getMonth()<10) {
    		ps.printf(": 0%d/", Appointment.getMonth());
    	}
    	else {
    		ps.printf(": %d/", Appointment.getMonth());

    	}
    	if (Appointment.getDay()<10) {
    		ps.printf("0%d/", Appointment.getDay());
    	}
    	else {
        	ps.printf("%d/", Appointment.getDay());

    	}
    	ps.printf("%d\n\n", Appointment.getYear());
    	
    	ps.printf("%-11s", "Pet Name");
		ps.printf(": %s%n", Appointment.Pet.getName());
    	ps.printf("%-11s", "Pet Species");
		ps.printf(": %s%n",Appointment.Pet.getSpecies());
    	ps.printf("%-11s", "Pet Gender");
		ps.printf(": %s%n%n",Appointment.Pet.getGender());
		ps.printf("Procedures %n%n");
		
		//int prodecures NEEDED
		
		ps.printf("%-29s","Name");
		ps.printf("%-7s","Price");
		ps.printf("%-7s","Qty");
		ps.printf("%-9s","Amount");
		ps.printf("%-12s","Is Covered");
		ps.printf("%-14s","Pct Covered");
		ps.printf("%-17s","Amount Covered");
		ps.printf("Amount Due\n");
    	
		ps.printf("%-29s","----");
		ps.printf("%-7s","-----");
		ps.printf("%-7s","---");
		ps.printf("%-9s","-------");
		ps.printf("%-12s","----------");
		ps.printf("%-14s","-----------");
		ps.printf("%-17s","--------------");
		ps.printf("----------\n");


		for(int i = 0; i < VisitProcedure.length; i++) {
			ps.printf("%-28s", VisitProcedure[i].getProcedure().getName());
			ps.printf("%6.2f", VisitProcedure[i].getProcedure().getPrice());
			ps.printf("%5.0f", VisitProcedure[i].getQuanity());
			ps.printf("%11.2f", VisitProcedure[i].CalculateProcedureAmount() );
			ps.printf("%12s", VisitProcedure[i].getIsCoveredByInsurance());
			ps.printf("%13.2f", VisitProcedure[i].getPctCovered());
			ps.printf("%17.2f", VisitProcedure[i].CalculateProcedureCovered());
			ps.printf("%13.2f%n", VisitProcedure[i].CalculateProcedureAmountDue() );
		}
		
		ps.printf("%-29s","----");
		ps.printf("%-7s","-----");
		ps.printf("%-7s","---");
		ps.printf("%-9s","-------");
		ps.printf("%-12s","----------");
		ps.printf("%-14s","-----------");
		ps.printf("%-17s","--------------");
		ps.printf("----------\n");

    
		double amt = 0;
		double cov = 0;
		double due = 0;

        for(int i = 0; i < VisitProcedure.length; i++) {
            amt += VisitProcedure[i].CalculateProcedureAmount();                
            cov += VisitProcedure[i].CalculateProcedureCovered();
            due += VisitProcedure[i].CalculateProcedureAmountDue();
        }	
        
		ps.printf("%-29s","Total");		
        ps.printf("%21.2f", amt);
        ps.printf("%42.2f",cov);
        ps.printf("%13.2f",due);
	}
	
	/**
	 * This method uses a for loop to display information from Appointment and VisitProcedures array.
	 * It displays it in a json format and then returns it.
	 * @return Json
	 */
	public String GetJSON() {
		String Jsonarraytemp = null;
		String Jsonarray = "";
		for(int i = 0; i < VisitProcedure.length ; i++) {
		  if (i !=VisitProcedure.length- 1){
			Jsonarraytemp = 
			"\n" + "\t" + "{" +
			"\n" + "\t\t" + '"' + "procedure" + '"' + " : " + 
			"\n" + "\t\t" + "{" + 
			"\n" + "\t\t\t" + '"' + "name" + '"' + " : " + '"' + VisitProcedure[i].getProcedure().getName() + '"' + "," +
			"\n" + "\t\t\t" + '"' + "price" + '"' + " : " + VisitProcedure[i].getProcedure().getPrice() +
			"\n" + "\t\t" + "}" + "," +
			"\n" + "\t\t" + '"' + "quantity" + '"' + " : " + VisitProcedure[i].getQuanity() + "," +
			"\n" + "\t\t" + '"' + "isCoveredByInsurance" +  '"' + " : " + VisitProcedure[i].getIsCoveredByInsurance() + "," +
			"\n" + "\t\t" + '"' + "pctCovered" + '"' + " : " + VisitProcedure[i].getPctCovered() +
			"\n" + "\t" + "}" + ",";
			Jsonarray += Jsonarraytemp;
			}else{
			Jsonarraytemp = 
			"\n" + "\t" + "{" +
			"\n" + "\t\t" + '"' + "procedure" + '"' + " : " + 
			"\n" + "\t\t" + "{" + 
			"\n" + "\t\t\t" + '"' + "name" + '"' + " : " + '"' + VisitProcedure[i].getProcedure().getName() + '"' + "," +
			"\n" + "\t\t\t" + '"' + "price" + '"' + " : " + VisitProcedure[i].getProcedure().getPrice() +
			"\n" + "\t\t" + "}" + "," +
			"\n" + "\t\t" + '"' + "quantity" + '"' + " : " + VisitProcedure[i].getQuanity() + "," +
			"\n" + "\t\t" + '"' + "isCoveredByInsurance" +  '"' + " : " + VisitProcedure[i].getIsCoveredByInsurance() + "," +
			"\n" + "\t\t" + '"' + "pctCovered" + '"' + " : " + VisitProcedure[i].getPctCovered() +
			"\n" + "\t" + "}";
			Jsonarray += Jsonarraytemp;
			}
		}
		
		String Json;
		Json = "{" + 
		"\n" + "\t" + '"' + "veterinarian" + '"' + " : " + '"' + getVeterinarian() + '"' + "," +
		"\n" + "\t" + '"' + "appointment" + '"' + " : " + //empty
		
		"\n" + "\t" + "{" + 
		"\n" + "\t\t" + '"' + "month" + '"' + " : " + Appointment.getMonth() + "," +
		"\n" + "\t\t" + '"' + "day" + '"' + " : " + Appointment.getDay() + "," +
		"\n" + "\t\t" + '"' + "year" + '"' + " : " + Appointment.getYear() + "," +
		"\n" + "\t\t" + '"' + "pet" + '"' + " : " +

		"\n" + "\t\t" + "{" + 
		"\n" + "\t\t\t" + '"' + "name" + '"'+ " : " + '"' + Appointment.Pet.getName() + '"' + "," +
		"\n" + "\t\t\t" + '"' + "species" + '"' + " : " + '"' + Appointment.Pet.getSpecies() + '"' + "," +
		"\n" + "\t\t\t" + '"' + "gender" + '"'+ " : " + '"' + Appointment.Pet.getGender() + '"' +

		"\n" + "\t\t" + "}" +
		"\n" + "\t" + "}" + "," +
		"\n" + "\t" + '"' + "visitProcedure" + '"' + " :" +
		"\n" + "\t" + "[" + Jsonarray + 
		"\n" + "\t" +"]" +	
		"\n" + "}" + "\n";
		return Json;
	}
	
	
	/**
	 * toString method outputs data from appointment and VisitProcedures array in a toString format.
	 */
	@Override
	public String toString() {
		String toStringtemp;
		String toString = "";
		toStringtemp = "Veterinarian" + ": " + getVeterinarian() +
				"\n" + "Date" + ": " + Appointment.getMonth() + "/" + Appointment.getDay() + "/" + Appointment.getYear() +
				"\n" + "Name" + ": " + Appointment.Pet.getName() +
				"\n" + "Species" + ": " + Appointment.Pet.getSpecies() +
				"\n" + "Gender" + ": " + Appointment.Pet.getGender();
		toString += toStringtemp;
		
		for(int i = 0; i < VisitProcedure.length; i++) {
			toStringtemp = 	"\n\n" +"Name" + ": " + VisitProcedure[i].Procedure.getName() +
					"\n" + "Price" + ": " + "$" + VisitProcedure[i].Procedure.getPrice() + "0" +
					"\n" + "Quantity" + ": " + VisitProcedure[i].getQuanity() +
					"\n" + "Is Covered By Insurance" + ": " + VisitProcedure[i].getIsCoveredByInsurance() +
					"\n" + "Pct Covered" + ": " + VisitProcedure[i].getPctCovered();
			toString += toStringtemp;
		}
		return toString;
	}
	
/*	public Procedure GetByIndex(int index)throws ArrayIndexOutOfBoundsException {
        Procedure p;
        if (index < 0 || index > 1 - VisitProcedure.length) {
            p = VisitProcedure[index].getProcedure();
            return p;    
        }
        else{
            ArrayIndexOutOfBoundsException ar;
            ar = new ArrayIndexOutOfBoundsException(); 
            throw ar;
            //throw new ArrayIndexOutOfBoundsException();

        }
    }*/
	
	/**
	 * Method to Return data at specific index
	 * @param index
	 * @return p
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public VisitProcedure GetByIndex(int index)throws ArrayIndexOutOfBoundsException {
		VisitProcedure p;
		if (index < 0 || index > VisitProcedure.length - 1) {
			ArrayIndexOutOfBoundsException ar;
			ar = new ArrayIndexOutOfBoundsException();
			throw ar;
		}
		else{
			p = VisitProcedure[index];
			return p;
			//throw new ArrayIndexOutOfBoundsException();
		}
	}

	/**
	 * This method uses an instance of VisitProcedure and compares the amountsdue to see which
	 * one is the highest then returns it in vp 
	 * @return vp
	 */
	public VisitProcedure GetHighestProcedureAmountDue() {
		
		//VisitProcedure vp = new VisitProcedure();
		VisitProcedure vp = VisitProcedure[0];
		
		for(int i = 0; i < VisitProcedure.length; i++) {
			if(VisitProcedure[i].CalculateProcedureAmountDue() > vp.CalculateProcedureAmountDue())
			{
				vp = VisitProcedure[i];
			}
		}
		return vp;
	}
	
	/**
	 * method to get total Amount of Procedures
	 * @return amt
	 */
	public double amt() {
		double amt = 0;
	    for(int i = 0; i < VisitProcedure.length; i++) {
	            amt += VisitProcedure[i].CalculateProcedureAmount();
	    }
		return amt;
	}
	
	/**
	 * method to get total Amount of Procedures Covered
	 * @return cov
	 */
	public double cov() {
		double cov = 0;
	    for(int i = 0; i < VisitProcedure.length; i++) {
	            cov += VisitProcedure[i].CalculateProcedureCovered();
	    }
		return cov;
	}
	
	/**
	 * method to get total Amount due after coverage is taken from the cost
	 * @return due
	 */
	public double due() {
		double due = 0;
	    for(int i = 0; i < VisitProcedure.length; i++) {
	        	due += VisitProcedure[i].CalculateProcedureAmountDue();
	    }
		return due;
	}
	
}
