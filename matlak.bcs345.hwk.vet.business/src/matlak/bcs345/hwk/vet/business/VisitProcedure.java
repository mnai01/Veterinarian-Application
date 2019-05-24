package matlak.bcs345.hwk.vet.business;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Contains all the information needed for the VisitProcedure.
 * Also contains read/write files. getJSON return statements
 * and toString return statements. get/sets and Constructors.
 * and Calc methods.
 * 
 * @author Ian Matlak
 * @version 1.1
 * @since 12/12/2018
 */
public class VisitProcedure {
	
	protected Procedure Procedure;
	private double m_Quanity;
	private boolean m_IsCoveredByInsurance;
	private double m_PctCovered;
	
	/**
	 *Default Constructor for Appointments. quantity/IsCoveredByInsurance/PercentCovered/Procedure all empty when a new instance is created.
	 */
	public VisitProcedure(){
		m_Quanity = 0.0;
		m_IsCoveredByInsurance = false;
		m_PctCovered = 0.0;
		Procedure = new Procedure();
	}
	
	public Procedure getProcedure() {return Procedure;}
	public void setProcedure(Procedure NewProcedure){Procedure = NewProcedure;}
	

	/**
	 * get and set method for Quantity.
	 * @param NewQuanity
	 */
	public double getQuanity() {return m_Quanity;}
	public void setQuanity(double NewQuanity) {m_Quanity = NewQuanity;}

	/**
	 * get and set method for m_IsCoveredByInsurance.
	 * @param NewIsCoveredByInsurance
	 */
	public boolean getIsCoveredByInsurance() {return m_IsCoveredByInsurance;}
	public void setIsCoveredByInsurance(boolean NewIsCoveredByInsurance) {m_IsCoveredByInsurance = NewIsCoveredByInsurance;}

	/**
	 * get and set method for m_PctCovered.
	 * @param NewPctCovered
	 */
	public double getPctCovered() {return m_PctCovered;}
	public void setPctCovered(double NewPctCovered) {m_PctCovered = NewPctCovered;}
	
	/**
	 * This method is used to find the price of the procudure multipled by the quantitiy.
	 * @return ProcedureAmount
	 */
	public double CalculateProcedureAmount() {
		double ProcedureAmount;
		ProcedureAmount = Procedure.getPrice() * getQuanity();
		return ProcedureAmount;
	}
	
	/**
	 * This method is used to find the price of how much the insurance covers. If the insurance doesnt
	 * cover anything then it returns 0.
	 * @return ProcedureCovered
	 */
	public double CalculateProcedureCovered() {
		double ProcedureCovered;
		if (getIsCoveredByInsurance() == true) {
			ProcedureCovered = CalculateProcedureAmount() * getPctCovered();
			return ProcedureCovered;
		} else {
			return 0;
		}
	}
	
	/**
	 * This method is used to find the total price with the insurance calculated into it if any excisted.
	 * @return Amountdue
	 */
	public double CalculateProcedureAmountDue() {
		double Amountdue = 0;
		Amountdue = getQuanity() * Procedure.getPrice() - CalculateProcedureCovered();
		return Amountdue;
	}
	
	/**
	 * this read method uses Scanner to set name, price, quantity, insurance covered, percent covered based on 
	 * data that is on each line of a file.
	 * @param s
	 */
	public void Read(Scanner s) {
		Procedure.setName(s.nextLine());
		Procedure.setPrice(s.nextDouble());
		setQuanity(s.nextDouble());
		setIsCoveredByInsurance(s.nextBoolean());
		setPctCovered(s.nextDouble());
	}
	
	
	/**
	 * this Write method uses PrintStream to get the name price quantity, if insurance covered and percentage covered
	 * and outputs the data to where ever directed.
	 * @param ps
	 */
	public void Write(PrintStream ps) {
		ps.printf("%s\n",Procedure.getName());
		ps.printf("%.2f\n",Procedure.getPrice());
		ps.printf("%s\n",getQuanity());
		ps.printf("%s\n",getIsCoveredByInsurance());
		ps.printf("%s\n",getPctCovered());
		}
	
	/**
	 * getJSON statement output data in a JSON format
	 * @return VPJson
	 */
	public String getJSON() {
		String VPJson;
		VPJson = "\n{" + 
		"\n" + "\t" + '"' + "Procedure" + '"' + " : " + 
		"\n" + "\t" + "{" + 
		"\n" + "\t\t" + '"' + "name" + '"' + " : " + '"' + Procedure.getName() + '"' + "," +
		"\n" + "\t\t" + '"' + "price" + '"' + " : " + Procedure.getPrice() +
		"\n" + "\t" + "}" + "," +
		"\n" + "\t" + '"' + "quantity" + '"' + " : " + getQuanity() + "," +
		"\n" + "\t" + '"' + "isCoveredByInsurance" +  '"' + " : " + getIsCoveredByInsurance() + "," +
		"\n" + "\t" + '"' + "pctCovered" + '"' + " : " + getPctCovered() +
		"\n" + "}";
		return VPJson;
	}
	
	/**
	 * toString method outputs data in a toString format.
	 */
	public String toString() {
		String toString;
		toString = 	"Name" + ": " + Procedure.getName() +
					"\n" + "Price" + ": " + "$" + Procedure.getPrice() + "0" +
					"\n" + "Quantity" + ": " + getQuanity() +
					"\n" + "Is Covered By Insurance" + ": " + getIsCoveredByInsurance() +
					"\n" + "Pct Covered" + ": " + getPctCovered() +
					"\n";
		return toString;
		
	}
	
	

}
