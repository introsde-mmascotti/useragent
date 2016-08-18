package shell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * This class provides methods for reading various types of the user input from {@link System#in}. <p>
 * Every method prints a message to {@link System#out} asking the user for input. After the user has typed 
 * the input terminated with <code>'\n'</code> the input is read from {@link System#in} and checked.
 * If the input is not conform with the check an error message is printed and the user is asked again for 
 * a correct input. <p>
 * If the user provides an empty input a default value is returned.
 */
public class ShellUtility {
	static BufferedReader shell_reader = new BufferedReader(new InputStreamReader(System.in));
	
	/**
	 * Reads a {@link String} input.
	 * @param message question for the user
	 * @param default_value value to be returned, if the input is empty
	 * @return the user typed input
	 * @throws IOException
	 */
	public static String readString(String message, String default_value) throws IOException{
		String ret = "";
		
		String mess = message;
		if (default_value != null)
			mess += "(" + default_value +")";
		
		while (ret.isEmpty()){
			System.out.println(mess);
			String input = shell_reader.readLine();
			
			if (input.isEmpty() && default_value == null)
				continue;
			else if (input.isEmpty() && default_value != null)
				ret = default_value;
			else
				ret = input;
		}		
		return ret;
	}
	
	/**
	 * Reads a single {@link Character}.
	 * @param message question for the user
	 * @param error_message printed when the input is not correct (is not listed in "possible_values")
	 * @param default_value value to be returned, if the input is empty
	 * @param possible_values admitted {@link Character}s
	 * @return the {@link Character} typed by the user
	 * @throws IOException
	 */
	public static Character readChar(String message, String error_message, Character default_value, Character[] possible_values) throws IOException{
		Character ret = null;
		
		String mess = message;
		if (default_value != null)
			mess += " (" + default_value +")";
		
		while (ret == null){
			System.out.println(mess);
			String input = shell_reader.readLine();
			
			if (input.isEmpty() && default_value == null)
				continue;
			else if (input.isEmpty() && default_value != null)
				ret = default_value;
			else
				ret = new Character(input.charAt(0));
					
			for (int i = 0; i < possible_values.length; i++){
				if (ret.equals(possible_values[i]))
					break;
				
				//if all characters compared and no valid value found
				if (i == possible_values.length - 1){
					System.out.println(error_message);
					ret = null;
				}
			}
		}		
		return ret;
	}
	
	/**
	 * Reads a {@link Double}.
	 * @param message question for the user
	 * @param error_message printed when the input is not a number
	 * @param default_value value to be returned if the input is empty
	 * @param min the least admitted value
	 * @param max the greatest admitted value
	 * @return the user input
	 * @throws IOException
	 */
	public static Double readDouble(String message, String error_message, Number default_value, Double min, Double max) throws IOException {
		return readNumber(message, error_message, "#.##", default_value, min, max).doubleValue();
	}
	
	/**
	 * Reads a {@link Integer}.
	 * @param message question for the user
	 * @param error_message printed when the input is not a number
	 * @param default_value value to be returned if the input is empty
	 * @param min the least admitted value
	 * @param max the greatest admitted value
	 * @return the user input
	 * @throws IOException
	 */
	public static Integer readInteger(String message, String error_message, Number default_value, Integer min, Integer max) throws IOException {
		return readNumber(message, error_message, "#", default_value, min, max).intValue();
	}
	
	/**
	 * Reads a date and returns it as {@link XMLGregorianCalendar}. See {@link #readDate(String, String, Date, Date, Date)}
	 * for details.
	 * @param message
	 * @param error_message
	 * @param default_value
	 * @param min
	 * @param max
	 * @return
	 * @throws IOException
	 */
	public static XMLGregorianCalendar readXMLGregorianCalendar (String message, String error_message, Date default_value, Date min, Date max) throws IOException {
		Date d = readDate(message, error_message, default_value, min, max);
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(d);
		
		XMLGregorianCalendar ret = null;
		try {
			ret = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		
		return ret;
	}
	
	/**
	 * Reads a {@link Date}
	 * @param message asks the user for input
	 * @param error_message printed if the input is not in the form "dd-MM-yyyy" 
	 * @param default_value returned if the input is empty
	 * @param min least admitted date
	 * @param max greatest admitted date
	 * @return the date typed by the user
	 * @throws IOException
	 */
	public static Date readDate(String message, String error_message, Date default_value, Date min, Date max) throws IOException {
		Date ret = null;		
		
		String ask = message;
		String out_of_range = null;
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
										
		if (default_value != null)
			ask += String.format(" [actual value: %s]", sdf.format(default_value));		
		
		if (min != null && max != null) {
			String s  = "Valid range is %s - %s. Please enter a correct value!\n";
			out_of_range = String.format(s, sdf.format(min), sdf.format(max));			
		}
		else if (min != null) {
			String s  = "Please enter a value greater than %s!\n";
			out_of_range = String.format(s, sdf.format(min));
		}
		else if (max != null) {
			String s  = "Please enter a value less than %s!\n";
			out_of_range = String.format(s, sdf.format(max));
		}
		
		String input = "";
		while (ret == null) {
			System.out.print(ask);
			try {
				input = shell_reader.readLine();
				if (input.isEmpty() && default_value == null)
					continue;
				else if (input.isEmpty() && default_value != null)
					ret = default_value;
				else
					ret = sdf.parse(input);
				
				if (!isInRange(ret, min, max)){
					System.out.println(out_of_range);
					ret = null;
					continue;
				}				
			} catch (ParseException e) {
				System.out.println(error_message);
				ret = null;
				continue;
			}
		}
		return ret;
	}
	
	/**
	 * Reads a {@link Number}.
	 * @param message question for the user
	 * @param error_message printed when the input is not a number or in the correct format
	 * @param format the format in which the number is typed. See {@link NumberFormat} for details.
	 * @param default_value value to be returned if the input is empty
	 * @param min the least admitted value
	 * @param max the greatest admitted value
	 * @return the user input
	 * @throws IOException
	 */
	private static Number readNumber(String message, String error_message, String format, Number default_value, Number min, Number max) throws IOException {
		String ask = message;
		String out_of_range = null;
		
		DecimalFormat df = new DecimalFormat(format);
										
		if (default_value != null)
			ask += String.format("[actual value: %s]", df.format(default_value));		
		
		if (min != null && max != null) {
			String s  = "Valid range is %s - %s Please enter a correct value!\n";
			out_of_range = String.format(s, df.format(min), df.format(max));			
		}
		else if (min != null) {
			String s  = "Please enter a value greater than %s!\n";
			out_of_range = String.format(s, df.format(min));
		}
		else if (max != null) {
			String s  = "Please enter a value less than %s!\n";
			out_of_range = String.format(s, df.format(max));
		}
		
		Number value = null;
		while (value  == null){
			try {
				System.out.println(ask);
				String input = shell_reader.readLine();
				
				if (input.isEmpty() && default_value == null)
					continue;
				else if (input.isEmpty() && default_value != null)
					value = default_value;
				else
					value = df.parse(input);
				
				if (!isInRangeNumber(value, min, max)){
					System.out.println(out_of_range);
					value = null;
					continue;
				}
			} catch (NumberFormatException | ParseException e) {		
				System.out.println(error_message);
				value = null;
			}
		}		
		return value;
	}
	
	/**
	 * @param value
	 * @param min
	 * @param max
	 * @return whether <code> min <= value <= max </code> 
	 */
	private static boolean isInRangeNumber(Number value, Number min, Number max){
		Double val, low = null, high = null;
		
		val = value.doubleValue();
		if (min != null)
			low = min.doubleValue();
		if (max != null)
			high = max.doubleValue();
		
		return isInRange(val, low, high);
	}
	
	/**
	 * 
	 * @param value
	 * @param min
	 * @param max
	 * @return whether <code> min <= value <= max </code> 
	 */
	private static <T extends Comparable<T>> boolean isInRange(T value, T min, T max){
		if (min != null && max != null)
			return min.compareTo(value) <= 0 && value.compareTo(max) <= 0;
		else if (min != null)
			return min.compareTo(value) <= 0;
		else if (max != null)
			return value.compareTo(max) <= 0;
		else
			return true;
	}
}
