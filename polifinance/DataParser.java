package polifinance;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import java.io.IOException;
import java.io.FileNotFoundException;

/**
 * Parses data from a 15 field per row csv file.
 * 
 * @author Sachin Samarasinghe
 * @version v1.0
 * @since 2017-03-22
 */
public class DataParser {
	// changes 2017-03-22: now parses the non-monetary field as well
	
	/**
	 * Parses a 15 fields per row csv file.
	 * 
	 * @param path
	 *            Path to the csv file.
	 * @return Array that contains the parsed rows from the csv file.
	 * @throws IOException
	 *             Runtime error during reading a line from the file.
	 */
	public static DataT[] parse(String path) {
		BufferedReader r = null;

		try {
			r = new BufferedReader(new FileReader(path));
		} catch (FileNotFoundException e) {
			// file not found
			System.err.println("\"" + path + "\" was not found.");
			e.printStackTrace();
		}

		// check the number of fields per row
		try {
			int f;
			f = r.readLine().split(",").length;
			if (f != 15) {
				throw new RuntimeException(
						"The number of fields per row is not 15. This file has "
								+ f + " fields per row.");
			}
		} catch (IOException e) {
			System.err.println("Error reading next line.");
		}

		// list that stores the data set
		ArrayList<DataT> dataSet = new ArrayList<DataT>(550000);

		// read fields from the file in to ln
		String ln = null;
		try {
			ln = r.readLine();
		} catch (IOException e) {
			System.err.println("Error reading next line.");
		}

		while (ln != null) {

			ln = ln.replaceAll("\"\"", ""); // remove all empty sets of quotes

			String[] row = new String[15]; // array to store final
											// fields in each row

			String[] split = ln.split(",", -1); // read and split
			if (split.length == 0) {
				// empty line
				try {
					ln = r.readLine();
				} catch (IOException e) {
					System.err.println("Error reading next line.");
				}
				continue;
			}

			int indexFinal = 0;

			for (int i = 0; i < split.length; i++) {

				// Special handling for fields with "
				// Certain fields are wrapped inside " and can contain commas
				// inside
				// them. Commas inside " must be ignored
				if (split[i].contains("\"")) {
					int nOfQs = 1; // number of quotes
					int qs = -1;
					String fi = ""; // field without the quotes

					// get text between quotes
					while (nOfQs % 2 == 1) {
						int q = 0;

						while (q < split[i].length()) {
							if (split[i].charAt(q) == '\"')
								qs++;
							else
								fi += split[i].charAt(q);
							q++;
						}

						nOfQs += qs;

						// move to the next line if the quotes don't close
						if (nOfQs % 2 == 1) {
							if (i >= split.length)
								break;
							else
								fi += ",";
							i++;
						}
						qs = 0;
					}

					row[indexFinal] = fi;
				} else {
					// field does not contain
					row[indexFinal] = split[i];
				}
				indexFinal++;
			}

			// check for empty fields in double fields
			if (row[13].equals(""))
				row[13] = "0";

			// check for empty fields in double fields
			if (row[14].equals(""))
				row[14] = "0";

			DataT rowd = new DataT(row[2], row[3], row[4], row[11], row[12],
					Double.parseDouble(row[13]), Double.parseDouble(row[14]));
			dataSet.add(rowd);

			try {
				ln = r.readLine();
			} catch (IOException e) {
				System.err.println("Error reading next line.");
			}
		}

		// close the file reader
		try {
			r.close();
		} catch (IOException e) {
			System.err.println("Error closing opened data file.");
		}

		return dataSet.toArray(new DataT[0]);
	}
}
