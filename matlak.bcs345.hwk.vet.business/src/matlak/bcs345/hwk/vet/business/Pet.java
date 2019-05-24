package matlak.bcs345.hwk.vet.business;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Contains all the information needed for the Pets.
 * Also contains methods to read/write files. GetJSON return statements
 * and toString return statements. Get/sets and Constructors.
 * 
 * @author Ian Matlak
 * @version 1.0
 * @since 10/2/2018
 */
public class Pet {

	private String m_Name;
	private String m_Species;
	private String m_Gender;
	
	/**
	 *Default Constructor for Pets. Name/species/gender all empty when a new instance is created.
	 */
	public Pet() {
		m_Name = "";
		m_Species = "";
		m_Gender = "";
	}
	
	/**
	 * @param Name Species Gender
	 *Constructor for Pets. Name/species/gender with parameters to set then once an instance is created.
	 */
	public Pet(String Name,String Species,String Gender){
		m_Name = Name;
		m_Species = Species;
		m_Gender = Gender;
	}
	
	/**
	 * Get and set method for Name of pet.
	 * @param NewName
	 */
	public void setName(String NewName) {m_Name = NewName;}
	public String getName() {return m_Name;}
	
	/**
	 * Get and set method for Name of Species type.
	 * @param NewSpecies
	 */
	public void setSpecies(String NewSpecies) {m_Species = NewSpecies;}
	public String getSpecies() {return m_Species;}
	
	/**
	 * Get and set method for Name of gender type
	 * @param NewGender
	 */
	public void setGender(String NewGender) {m_Gender = NewGender;}
	public String getGender() {return m_Gender;}

	/**
	 * this read method uses Scanner to set name species and gender based on 
	 * data that is on each line of a file. goes through 3 lines only
	 * @param s
	 */
	public void Read(Scanner s) {
		//s = new Scanner("Pet.txt");
		setName(s.nextLine());
		setSpecies(s.nextLine());
		setGender(s.nextLine());
	}
	
	/**
	 * this Write method uses PrintStream to Get the name species and gender of the pet
	 * and outputs the data to where ever directed.
	 * @param ps
	 */
	public void Write(PrintStream ps) {
		//ps = new PrintStream();
		ps.printf("%s\n",getName());
		ps.printf("%s\n",getSpecies());
		ps.printf("%s\n",getGender());

		}
	
	/**
	 * GetJSON statement output data in a JSON format
	 * @return Json
	 */
	public String GetJSON()
    {
		String Json;
		Json = "{" + '"' + "name" + '"' + ": " + '"' + m_Name + '"' + ", " + '"' + "species" + '"' + ": " + '"' + m_Species + '"' + ", " + '"' + "gender" + '"' + ": " + '"' + m_Gender + '"' + "}";
		return Json;
    }
    
	/**
	 * toString method outputs data in a toString format.
	 */
	@Override
	public String toString() {
		String toString = null;
		toString = "Name: " + m_Name + "\n" + "Species: " + m_Species + "\n" + "Gender: " + m_Gender ;
		return toString;
	}
	
}
