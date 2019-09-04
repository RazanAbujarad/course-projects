package polifinance;
/** 
 * @author Shrey Mittal, Sachin Samarasinghe
 * @version 4
 * @since 2017-03-21
 * This class specifies an abstract data type of the name, district and political party of an MP with donor name, type and amount donated to the MP.
 */

public class DataT{
	/**
	 * These are field variables of the MP, Political Party, Electoral District, Donor's Type, Donor, non-monetary amount, and monetary amount  
	 */
	private String recipient;
	private String party;
	private String electoralDistrict;
	private String contributorType;
	private String contributor;
	private Double nm_amount;
	private Double m_amount;
	
	/**
	 * added by Sachin Samarasinghe: March 22, 2017
	 * Information representation of the donation
	 */
	private String infoRepresentation;
	private String strRepresentation;
	
	/**
	 * @brief This method constructs ADT
	 * @param r Name of MP
	 * @param p Political Party
	 * @param ed Electoral District
	 * @param ct Donor Type
	 * @param c Donor
	 * @param a monetary amount
	 * @param na non-monetary amount
	 */
	public DataT(String r, String p, String ed, String ct, String c, Double a, Double na){
		this.recipient = r;
		this.party = p;
		this.electoralDistrict = ed;
		this.contributorType = ct;
		this.contributor = c;
		this.m_amount = a;
		this.nm_amount = na;
		//Spacing changed by Shrey Mittal (2017-04-02)
		strRepresentation = String.format("%-50s %-50s %-70s %-70s %-70s %15.2f %15.2f", r, p, ed, ct, c, a, na);
		infoRepresentation = String.format("Recipient: %s%nParty: %s%n" + "Electoral District: %s%nContibution Type: %s%nContributor: %s%nMonetary Amount: %.2f%nNon-Monetary Amount: %.2f%n", r, p, ed, ct, c, a, na);
	}
	
	/**
	 * @brief This method accesses recipient
	 * @return Name of MP returned
	 */
	public String getRecipient(){
		return this.recipient;
	}
	
	/**
	 * @brief This method accesses party
	 * @return Name of party returned
	 */
	public String getParty(){
		return this.party;
	}
	
	/**
	 * @brief This method accesses Electoral District
	 * @return Name of district returned
	 */
	public String getElectoralDistrict(){
		return this.electoralDistrict;
	}
	
	/**
	 * @brief This method accesses contributor type
	 * @return Contributor type returned
	 */
	public String getContributorType(){
		return this.contributorType;
	}
	
	/**
	 * @brief This method accesses contributor
	 * @return Name of contributor returned
	 */
	public String getContributor(){
		return this.contributor;
	}
	
	/**
	 * @brief This method accesses monetary amount donated
	 * @return Monetary amount returned
	 */
	public Double getAmount(){
		return this.m_amount;
	}
	
	/**
	 * @brief This method accesses non-monetary amount donated
	 * @return Non-monetary amount returned
	 */
	public Double getNAmount(){
		return this.nm_amount;
	}
	
	
	public String toString(){
		return strRepresentation;
	}
	
	/**
	 * added by Sachin Samarasinghe: March 22, 2017
	 * @brief This method creates an informational representation of the ADT
	 * @return String representation of ADT returned
	 */
	public String info(){
		return infoRepresentation;
	}
}
