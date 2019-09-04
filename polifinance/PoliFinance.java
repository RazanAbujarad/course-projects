/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polifinance;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Shrey Mittal
 * @version 3
 * @since 2017-04-02
 */
public class PoliFinance {
	/**
	 * DataT arrays. dataList holds parsed values; parsing happens once.
	 */
	private static DataT[] dataList = DataParser.parse("/Users/RazanAbujarad/eclipse-workspace/polifinance/src/ContributionsToCandidate1993-1999.csv");
	static int n = dataList.length;
	private static DataT[] sortedByElecDist;
	private static DataT[] sortedByContributor;
	private static DataT[] sortedByParty;
	private static DataT[] sortedByMAmount;
	private static DataT[] sortedByNMAmount;
	private static DataT[] sortedByRecipient;
	private static DataT[] sortedByContributorType;
	
	/**
	 * @brief Method sorts by electoral district and updates associated array
	 * @throws InvalidCategoryException
	 */
	private static void sortElectoralDistrict() throws InvalidCategoryException{
		try{
			sortedByElecDist = new DataT[n];
			System.arraycopy(dataList, 0, sortedByElecDist, 0, n);
			Sort.sort(sortedByElecDist, "electoralDistrict");
		}
		catch(InvalidCategoryException e){
			System.err.println("Invalid Category Selection!");
		}
		
	}
	
	/**
	 * @brief Method sorts by contributor and updates associated array
	 * @throws InvalidCategoryException
	 */
	private static void sortContributor() throws InvalidCategoryException{
		try{
			sortedByContributor = new DataT[n];
			System.arraycopy(dataList, 0, sortedByContributor, 0, n);
			Sort.sort(sortedByContributor, "contributor");
		}
		catch(InvalidCategoryException e){
			System.err.println("Invalid Category Selection!");
		}
		
	}
	
	/**
	 * @brief Method sorts by party and updates associated array
	 * @throws InvalidCategoryException
	 */
	private static void sortParty() throws InvalidCategoryException{
		try{
			sortedByParty = new DataT[n]; 
			System.arraycopy(dataList, 0, sortedByParty, 0, n);
			Sort.sort(sortedByParty, "party");
		}
		catch(InvalidCategoryException e){
			System.err.println("Invalid Category Selection!");
		}
		
	}
	
	/**
	 * @brief Method sorts by monetary amount donated and updates associated array
	 * @throws InvalidCategoryException
	 */
	private static void sortMAmount() throws InvalidCategoryException{
		try{
			sortedByMAmount = new DataT[n];
			System.arraycopy(dataList, 0, sortedByMAmount, 0, n);
			Sort.sort(sortedByMAmount, "m_amount");
		}
		catch(InvalidCategoryException e){
			System.err.println("Invalid Category Selection!");
		}
		
	}
	
	/**
	 * @brief Method sorts by non monetary amount donated and updates associated array
	 * @throws InvalidCategoryException
	 */
	private static void sortNMAmount() throws InvalidCategoryException{
		try{
			sortedByNMAmount = new DataT[n];
			System.arraycopy(dataList, 0, sortedByNMAmount, 0, n);
			Sort.sort(sortedByNMAmount, "nm_amount");
		}
		catch(InvalidCategoryException e){
			System.err.println("Invalid Category Selection!");
		}
		
		
	}
	
	/**
	 * @brief Method sorts by recipient and updates associated array
	 * @throws InvalidCategoryException
	 */
	private static void sortRecipient() throws InvalidCategoryException{
		try{
			sortedByRecipient = new DataT[n];
			System.arraycopy(dataList, 0, sortedByRecipient, 0, n);
			Sort.sort(sortedByRecipient, "recipient");
		}
		catch(InvalidCategoryException e){
			System.err.println("Invalid Category Selection!");
		}
		
	}
	
	/**
	 * @brief Method sorts by contributor's type and updates associated array
	 * @throws InvalidCategoryException
	 */
	private static void sortContributorType() throws InvalidCategoryException{
		
		try{
			sortedByContributorType = new DataT[n];
			System.arraycopy(dataList, 0, sortedByContributorType, 0, n);
			Sort.sort(sortedByContributorType, "contributorType");
		}
		catch(InvalidCategoryException e){
			System.err.println("Invalid Category Selection!");
		}
		
	}
	
	/**
	 * @brief returns original parsed array
	 * @return dataList returned
	 */
	public static DataT[] unsorted(){
		return dataList;
	}
	
	/**
	 * @brief Method returns sorted array of electoral districts if ready otherwise calls the associated sort method
	 * @return DataT array of sorted values returned
	 * @throws InvalidCategoryException
	 */
	public static DataT[] getSortedElectoralDistrict() {
		try{
			if (sortedByElecDist != null){
				return sortedByElecDist;
			}
			sortElectoralDistrict();
			return sortedByElecDist;
		}
		catch(InvalidCategoryException e){
			System.err.println("Invalid Category Selection!");
			return null;
		}
		
		
	}
	
	/**
	 * @brief Method returns sorted array of contributors if ready otherwise calls the associated sort method
	 * @return DataT array of sorted values returned
	 * @throws InvalidCategoryException
	 */
	public static DataT[] getSortedContributor() {
		try{
			if (sortedByContributor != null){
				return sortedByContributor;
			}
			sortContributor();
			return sortedByContributor;
		}
		catch(InvalidCategoryException e){
			System.err.println("Invalid Category Selection!");
			return null;
		}
		
		
	}
	
	/**
	 * @brief Method returns sorted array of parties if ready otherwise calls the associated sort method
	 * @return DataT array of sorted values returned
	 * @throws InvalidCategoryException
	 */
	public static DataT[] getSortedParty() {
		try{
			if (sortedByParty != null){
				return sortedByParty;
			}
			sortParty();
			return sortedByParty;
		}
		catch(InvalidCategoryException e){
			System.err.println("Invalid Category Selection!");
			return null;
		}
		
		
	}
	
	/**
	 * @brief Method returns sorted array of monetary amounts if ready otherwise calls the associated sort method
	 * @return DataT array of sorted values returned
	 * @throws InvalidCategoryException
	 */
	public static DataT[] getSortedMAmount() {
		try{
			if (sortedByMAmount != null){
				return sortedByMAmount;
			}
			sortMAmount();
			return sortedByMAmount;
		}
		catch(InvalidCategoryException e){
			System.err.println("Invalid Category Selection!");
			return null;
		}
		
		
	}
	
	/**
	 * @brief Method returns sorted array of non monetary amounts if ready otherwise calls the associated sort method
	 * @return DataT array of sorted values returned
	 * @throws InvalidCategoryException
	 */
	public static DataT[] getSortedNMAmount() {
		try{
			if (sortedByNMAmount != null){
				return sortedByNMAmount;
			}
			sortNMAmount();
			return sortedByNMAmount;
		}
		catch(InvalidCategoryException e){
			System.err.println("Invalid Category Selection!");
			return null;
		}
		
		
	}
	
	/**
	 * @brief Method returns sorted array of recipients if ready otherwise calls the associated sort method
	 * @return DataT array of sorted values returned
	 * @throws InvalidCategoryException
	 */
	public static DataT[] getSortedRecipient() {
		try{
			if (sortedByRecipient != null){
				return sortedByRecipient;
			}
			sortRecipient();
			return sortedByRecipient;
		}
		catch(InvalidCategoryException e){
			System.err.println("Invalid Category Selection!");
			return null;
		}
		
		
	}
	
	/**
	 * @brief Method returns sorted array of contributor types if ready otherwise calls the associated sort method
	 * @return DataT array of sorted values returned
	 * @throws InvalidCategoryException
	 */
	public static DataT[] getSortedContributorType() {
		try {
			if (sortedByContributorType != null){
				return sortedByContributorType;
			}
			sortContributorType();
			return sortedByContributorType;	
		}
		catch(InvalidCategoryException e){
			System.err.println("Invalid Category Selection!");
			return null;
		}
			
	}
//
//	public static void main(String[] args){
//		DataT[] searchRecipient = Search.byRecipients("Abbott, Jim");
//		for (DataT i : searchRecipient){
//			System.out.println(i.toString());
//		}
//	}
}
