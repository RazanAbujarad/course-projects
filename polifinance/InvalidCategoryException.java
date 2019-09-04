package polifinance;

/**
 * 
 * @author Shrey Mittal
 * @since 2017-03-30
 * @version 1
 * @brief This class defines an invalid category to sort a list by. It is used by Sort.java within the polifinance package.
 */

public class InvalidCategoryException extends Exception {
	public InvalidCategoryException(String msg){
		super(msg);
	}
}
