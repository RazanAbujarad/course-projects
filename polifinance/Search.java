package polifinance;

import java.util.Comparator;
import java.util.LinkedList;

/**
 * This class searches the array of donations parsed by the data parser.
 * 
 * @author Sachin Samarasinghe
 * @version V1.0
 * @since 2017-04-03
 *
 */
public class Search {
	/**
	 * Searches the data by the recipient name and returns matches.
	 * 
	 * @param query
	 *            Query to search.
	 * @return Array that contains the matches of the search query.
	 */
	public static DataT[] byRecipients(String query) {
		DataT[] arr = PoliFinance.getSortedRecipient();

		DataT item = new DataT(query, "", "", "", "", 0d, 0d);

		return binarySearch(arr, item, (DataT a, DataT b) -> {
			return a.getRecipient().compareToIgnoreCase(b.getRecipient());
		});
	}

	/**
	 * Searches the data by the recipient party name and returns matches.
	 * 
	 * @param query
	 *            Query to search.
	 * @return Array that contains the matches of the search query.
	 */
	public static DataT[] byParty(String query) {
		DataT[] arr = PoliFinance.getSortedParty();

		DataT item = new DataT("", query, "", "", "", 0d, 0d);

		return binarySearch(arr, item, (DataT a, DataT b) -> {
			return a.getParty().compareToIgnoreCase(b.getParty());
		});
	}

	/**
	 * Searches the data by the electoral district and returns matches.
	 * 
	 * @param query
	 *            Query to search.
	 * @return Array that contains the matches of the search query.
	 */
	public static DataT[] byElectoralDistrict(String query) {
		DataT[] arr = PoliFinance.getSortedElectoralDistrict();

		DataT item = new DataT("", "", query, "", "", 0d, 0d);

		return binarySearch(arr, item, (DataT a, DataT b) -> {
			return a.getElectoralDistrict().compareToIgnoreCase(b.getElectoralDistrict());
		});
	}

	/**
	 * Searches the data by the contributor type and returns matches.
	 * 
	 * @param query
	 *            Query to search.
	 * @return Array that contains the matches of the search query.
	 */
	public static DataT[] byContributorType(String query) {
		DataT[] arr = PoliFinance.getSortedContributorType();

		DataT item = new DataT("", "", "", query, "", 0d, 0d);

		return binarySearch(arr, item, (DataT a, DataT b) -> {
			return a.getContributorType().compareToIgnoreCase(b.getContributorType());
		});
	}

	/**
	 * Searches the data by the contributor name and returns matches.
	 * 
	 * @param query
	 *            Query to search.
	 * @return Array that contains the matches of the search query.
	 */
	public static DataT[] byContributor(String query) {
		DataT[] arr = PoliFinance.getSortedContributor();

		DataT item = new DataT("", "", "", "", query, 0d, 0d);

		return binarySearch(arr, item, (DataT a, DataT b) -> {
			return a.getContributor().compareToIgnoreCase(b.getContributor());
		});
	}

	/**
	 * Searches the data by the non monetary amount and returns matches.
	 * 
	 * @param query
	 *            Query to search.
	 * @return Array that contains the matches of the search query.
	 */
	public static DataT[] by_nm_amount(String query) {
		DataT[] arr = PoliFinance.getSortedNMAmount();
		Double q = Double.parseDouble(query);

		DataT item = new DataT("", "", "", "", "", 0d, q);

		return binarySearch(arr, item, (DataT a, DataT b) -> {
			return a.getAmount().compareTo(b.getAmount());
		});
	}

	/**
	 * Searches the data by the monetary and returns matches.
	 * 
	 * @param query
	 *            Query to search.
	 * @return Array that contains the matches of the search query.
	 */
	public static DataT[] by_m_amount(String query) {
		DataT[] arr = PoliFinance.getSortedMAmount();
		Double q = Double.parseDouble(query);

		DataT item = new DataT("", "", "", "", "", q, 0d);

		return binarySearch(arr, item, (DataT a, DataT b) -> {
			return a.getAmount().compareTo(b.getAmount());
		});
	}

	private static DataT[] binarySearch(DataT[] array, DataT item, Comparator<DataT> comp) {
		int r = rank(array, item, 0, array.length - 1, comp);
		if (r >= array.length)
			r--;

		LinkedList<DataT> list = new LinkedList<DataT>();

		for (int i = r; i >= 0; i--) {
			if (comp.compare(array[i], item) == 0)
				list.add(array[i]);
			else
				break;
		}

		for (int i = r + 1; i < array.length; i++) {
			if (comp.compare(array[i], item) == 0)
				list.add(array[i]);
			else
				break;
		}

		return list.toArray(new DataT[0]);
	}

	// finds the rank of item in the array bounded by the indeces lo and hi
	// (inclusive). The comparator is used for comparing items in the array
	// against the provided item.
	private static int rank(DataT[] array, DataT item, int lo, int hi, Comparator<DataT> comp) {
		if (lo > hi)
			return lo;

		int mid = lo + ((hi - lo) / 2);
		int r = comp.compare(item, array[mid]);

		if (r > 0)
			return rank(array, item, mid + 1, hi, comp);
		else if (r < 0)
			return rank(array, item, lo, mid - 1, comp);
		else
			return mid;
	}
}

