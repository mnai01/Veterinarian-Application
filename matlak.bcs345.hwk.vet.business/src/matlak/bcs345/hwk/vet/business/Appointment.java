package matlak.bcs345.hwk.vet.business;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Contains all the information needed for the Appointments.
 * Also contains read/write files. GetJSON return statements
 * and toString return statements. Get/sets and Constructors.
 * 
 * @author Ian Matlak
 * @version 1.1
 * @since 12/12/2018
 */
public class Appointment {
	
	private int m_Month;
	private int m_Day;
	private int m_Year;
	protected Pet Pet;
	
	/**
	 *Default Constructor for Appointments. month/day/year/pet all empty when a new instance is created.
	 */
	public Appointment(){
		m_Month = 0;
		m_Day = 0;
		m_Year = 0;
		Pet = new Pet();
	}
	
	/**
	 * Method to return PET
	 */
	public Pet getpet() {return Pet;} //******************ADDED FOR VETAPPLICATION
	
	/**
	 * Get and set method for Name of month.
	 * @param NewMonth
	 */
	public int getMonth() {return m_Month;}
	public void setMonth(int NewMonth) {m_Month = NewMonth;}
	
	/**
	 * Get and set method for Day
	 * @param NewDay
	 */
	public int getDay() {return m_Day;}
	public void setDay(int NewDay) {m_Day = NewDay;}
	
	/**
	 * Get and set method for Name of year.
	 * @param NewYear
	 */
	public int getYear() {return m_Year;}
	public void setYear(int NewYear) {m_Year = NewYear;}
	
	/**
	 * this read method uses Scanner to set month, day, year, name, species, gender based on 
	 * data that is on each line of a file.
	 * @param s
	 */
	public void Read(Scanner s) {
		setMonth(s.nextInt());
		setDay(s.nextInt());
		setYear(s.nextInt());
		s.nextLine();
		Pet.setName(s.nextLine());
		Pet.setSpecies(s.nextLine());
		Pet.setGender(s.nextLine());
	}
	
	/**
	 * this Write method uses PrintStream to Get the name species and gender of the pet
	 * and outputs the data to where ever directed.
	 * @param ps
	 */
	public void Write(PrintStream ps) {
		ps.printf("%s\n",getMonth());
		ps.printf("%s\n",getDay());
		ps.printf("%s\n",getYear());
		ps.printf("%s\n",Pet.getName());
		ps.printf("%s\n",Pet.getSpecies());
		ps.printf("%s\n",Pet.getGender());

		}
	
	/**
	 * GetJSON statement output data in a JSON format
	 * @return Json
	 */
	public String GetJSON() {
		String Json;
		Json = "\n{" + 
		"\n" + "\t" + '"' + "month" + '"' + " : " + getMonth() + "," +
		"\n" + "\t" + '"' + "day" +  '"' + " : " + getDay() + "," +
		"\n" + "\t" + '"' + "year" + '"' + " : " + getYear() + "," +
		"\n" + "\t" + '"' + "pet" + '"' + " : " +
		"\n" + "\t" + "{" +
		"\n" + "\t\t" + '"' + "name" + '"' + " : " + Pet.getName() + "," +
		"\n" + "\t\t" + '"' + "species" + '"' + " : " + Pet.getSpecies() + "," +
		"\n" + "\t\t" + '"' + "gender" + '"' + " : " + Pet.getGender() + "," +
		"\n" + "\t\t" + "}" +
		"\n" + "\t" + "}";
		return Json;
	}
	
	/**
	 * toString method outputs data in a toString format.
	 */
	public String toString() {
		String toString;
		toString = 	"Date" + ": " + getMonth() + "/" + getDay() + "/" + getYear() +
					"\n" + "Name" + ": " + Pet.getName() + 
					"\n" + "Species" + ": " + Pet.getSpecies() +
					"\n" + "Gender" + ": " + Pet.getGender() ;
		return toString;	
	}
	
	
}
