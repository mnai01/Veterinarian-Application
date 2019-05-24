package matlak.bcs345.hwk.vet.business;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Contains all the information needed for the procedures.
 * Also contains methods to read/write files. GetJSON return statements
 * and toString return statements. Get/sets and Constructors.
 * 
 * 
 * @author Ian Matlak
 * @version 1.0
 * @since 10/2/2018
 *
 */
public class Procedure {
	private String m_Name;
	private double m_Price;
	
	/**
	 *Default Constructor for Procedure. Name/price all empty when a new instance is created.
	 */
	public Procedure(){
		m_Name = "";
		m_Price = 0.0;	
		}
	
	/**
	 * @param Name "Name of procedure"
	 * @param Price "Price of procedure"
	 *Constructor for procedures. Name/price with parameters to set then once an instance is created.
	 */
	public Procedure(String Name, double Price){
		m_Name = Name;
		m_Price = Price;
	}
	
	/**
	 * set/get method for name of procedures
	 * @param NewName holds name passed in set method
	 */
	public void setName(String NewName){m_Name = NewName;}
	public String getName() {return m_Name;}
	
	/**
	 * set/get method for price of procedures
	 * @param NewPrice price name passed in set method
	 */
	public void setPrice(double NewPrice){m_Price = NewPrice;}
	public double getPrice() {return m_Price;}

	/**
	 * this Write method uses PrintStream to Get the name and price of the procedure
	 * and outputs the data to where ever directed.
	 * @param ps
	 */
	public void Write(PrintStream ps) {
		ps.printf("%s\n",getName());
		ps.printf("%.2f",getPrice());
		}
	
	/**
	 * this read method uses Scanner to set name and price based on 
	 * data that is on each line of a file. goes through 2 lines only
	 * @param s
	 */
	public void Read(Scanner s) {
		setName(s.nextLine());
		setPrice(s.nextDouble());
	}
	
	/**
	 * GetJSON statement output data in a JSON format
	 * @return Json
	 */
	public String GetJSON()
    {
		String Json;
		Json = "{" + '"' + "name" + '"' + ": " + '"' + m_Name + '"' + ", " + '"' + "price" + '"' + ": " + m_Price + "}";
		return Json;
    }
	
	/**
	 * toString method outputs data in a toString format.
	 */
	@Override
	public String toString() {
		String toString = null;
		toString = "Name: " + m_Name + "\n" + "Price: " + "$" + m_Price + "0";
		return toString;
	}
	
	
}
