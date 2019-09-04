package polifinance;

/**
 * 
 * @authors Shrey Mittal, Pardeep Sandhar
 * @version 3
 * @since 2017-03-29
 * This method uses Quicksort.
 * Information on how to implement this method was found in Algorithms 4th ed. by Sedgewick & Wayne p.289-291.
 * This module also uses the shuffle method from the StdRandom class that was procured from the Internet, authored by Sedgewick and Wayne.
 */
public class Sort {
	/**
	 * category is a String field variable specifying which parameter of DataT will be compared when sorting
	 */
	private static String category;
	
	/**
	 * 
	 * @param a DataT array
	 * @param cat String category to sort by
	 * @throws InvalidCategoryException
	 */
	public static void sort(DataT[] a, String cat) throws InvalidCategoryException{
		StdRandom.shuffle(a);
		category =  cat;
		sort(a, 0, a.length - 1);
	}
	
	/**
	 * 
	 * @param a DataT array
	 * @param lo minimum index
	 * @param hi maximum index
	 * @throws InvalidCategoryException
	 */
	private static void sort(DataT[] a, int lo, int hi) throws InvalidCategoryException{
		if (hi <= lo) return;
		int j = partition(a, lo, hi);
		sort(a, lo, j-1);
		sort(a, j+1, hi);
	}

	/**
	 * 
	 * @param a DataT array
	 * @param lo minimum index
	 * @param hi maximum index
	 * @return int value of the index at which the sorted element will be transferred to
	 * @throws InvalidCategoryException
	 */
	private static int partition(DataT[] a, int lo, int hi) throws InvalidCategoryException{
		int i = lo, j = hi + 1;
		while(true){
			while (less(a[++i], a[lo], category))
				if (i == hi) break;
			while (less(a[lo], a[--j], category))
				if (j == lo) break;

			if (i>=j) break;
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j;
	}

	/**
	 * @brief Pardeep Sandhar used switch statement within less block. This method determines if an attribute of a DataT object is less than another
	 * @param i DataT object
	 * @param j DataT object
	 * @param cat String category to sort by
	 * @return boolean value of whether the categorical attribute of i is less than j when compared
	 * @throws InvalidCategoryException
	 */
	private static boolean less(DataT i, DataT j, String cat) throws InvalidCategoryException{
		switch(cat){
			case "electoralDistrict": 
				return ((i.getElectoralDistrict()).compareToIgnoreCase(j.getElectoralDistrict()) < 0);
			case "contributor": 
				return ((i.getContributor()).compareToIgnoreCase(j.getContributor()) < 0);
			case "party": 
				return ((i.getParty()).compareToIgnoreCase(j.getParty()) < 0);
			case "m_amount": 
				return ((i.getAmount()).compareTo(j.getAmount()) < 0);
			case "nm_amount": 
				return ((i.getNAmount()).compareTo(j.getNAmount()) < 0);
			case "recipient": 
				return ((i.getRecipient()).compareToIgnoreCase(j.getRecipient()) < 0);
			case "contributorType": 
				return ((i.getContributorType()).compareToIgnoreCase(j.getContributorType()) < 0);
			default: 
				throw new InvalidCategoryException("Invalid category selection!"); 
		}
	}
	
	/**
	 * 
	 * @param a DataT array
	 * @param i int index
	 * @param j int index
	 */
	private static void exch(DataT[] a, int i, int j){
		DataT temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
}
