package shell;

import healthprofile.storage.service.Measure;
import healthprofile.storage.service.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import service.Advisor;
import service.AdvisorService;

public class HealthprofileOperation {
	private static final double MAX_HEIGHT = 2.2;
	private static final double MIN_HEIGHT = 1.4;
	private static final double MAX_WEIGHT = 300.0;
	private static final double MIN_WEIGHT = 35.0;
	private static final double MAX_PAL_FACTOR = 2.5;
	private static final double MIN_PAL_FACTOR = 0.8;
	
	private static final String HEIGHT = MeasureTypes.HEIGHT.getType();
	private static final String WEIGHT = MeasureTypes.WEIGHT.getType();
	private static final String PAL_FACTOR= MeasureTypes.PAL_FACTOR.getType();
	
	private static Advisor service;
	
	private static Date min_age;
	private static Date max_age;
		
	static {
		AdvisorService advisor = new AdvisorService();
		service = advisor.getAdvisorPort();
		
		Calendar c = Calendar.getInstance();
		max_age = c.getTime();
		c.add(Calendar.YEAR, -120);
		min_age = c.getTime();
	}
	
	/**
	 * Creates a new {@link Person} or updates the {@link Person} instance in the parameter asking the user for 
	 * the persons data.
	 * @param person person to be updated or 'null' if a new person should be created
	 * @return the new or updated person
	 * @throws IOException
	 * @throws DatatypeConfigurationException
	 */
	public static Person readPerson(Person person) throws IOException, DatatypeConfigurationException{
		Character[] sex_values = {new Character('m'), new Character('f')};
				
		Character sex;
		String fname = "", lname = "";
		XMLGregorianCalendar birthdate;
		
		if (person == null)
			person = new Person();
		
		sex = ShellUtility.readChar("Sex f/m", "Choose 'f' (female) or 'm' (male)", (char) person.getSex(), sex_values);
		fname = ShellUtility.readString("Firstname: ", person.getFirstname());
		lname = ShellUtility.readString("Lastname: ", person.getLastname());
		
		XMLGregorianCalendar actual_birthdate = person.getBirthdate();
		Date actual_bd = null;
		if (actual_birthdate != null)
			actual_bd = actual_birthdate.toGregorianCalendar().getTime();
		birthdate = ShellUtility.readXMLGregorianCalendar("Birthdate: ", "Please enter a valid date.", actual_bd, min_age, max_age); 
				
		person.setSex(sex);
		person.setFirstname(fname);
		person.setLastname(lname);
		person.setBirthdate(birthdate);
		
		return person;
	}

	/**
	 * Asks the user for new healthprofile data for the given person and updates them in the remote database.
	 * @param p
	 * @return list of {@link Measure}s: height, weight and PAL factor
	 * @throws IOException
	 */
	private static List<Measure> readHealthprofile(Person p) throws IOException {
		System.out.println("Insert your healhtprofile data: ");
						
		Measure height = service.getMeasure(p.getId(), HEIGHT);
		if (height == null){
			height = new Measure();
			height.setType(HEIGHT);
		}
		height = readMeasure(height, "meters", null, MIN_HEIGHT, MAX_HEIGHT);
		service.saveMeasure(p.getId(), height, false);
		
		Measure weight = service.getMeasure(p.getId(), WEIGHT);
		if (weight == null){
			weight = new Measure();
			weight.setType(WEIGHT);
		}
		weight = readMeasure(weight, "kg", null, MIN_WEIGHT, MAX_WEIGHT);
		service.saveMeasure(p.getId(), weight, false);
		
		Measure pal_factor = service.getMeasure(p.getId(), PAL_FACTOR);
		if (pal_factor == null){
			pal_factor = new Measure();
			pal_factor.setType(PAL_FACTOR);
		}
		pal_factor = readMeasure(pal_factor, null, null, MIN_PAL_FACTOR, MAX_PAL_FACTOR);
		service.saveMeasure(p.getId(), pal_factor, false);		
		
		List<Measure> measures = new ArrayList<Measure>(3);
		measures.add(height);
		measures.add(weight);
		measures.add(pal_factor);	

		return measures;
	}

	/**
	 * Asks the user for the data of a {@link Measure} and returns it.
	 * @param measure the {@link Measure} to be updated
	 * @param unit the measure unit
	 * @param default_value the default value if the user does not provide an input
	 * @param min the least admitted value
	 * @param max the greatest admitted value
	 * @return the updated {@link Measure} instance
	 * @throws IOException
	 */
	private static Measure readMeasure(Measure measure, String unit, Double default_value, Double min, Double max) throws IOException{
		String message;
		
		if (unit != null)
			message = String.format("%s (in %s):", measure.getType(), unit);
		else 
			message = measure.getType();

		String error_message = "Please enter a correct value for " + measure.getType();
		Double value = ShellUtility.readDouble(message , error_message , default_value, min, max);
			
		measure.setValue(value);
		measure.setUnit(unit);
		
		GregorianCalendar c = new GregorianCalendar();		
		measure.setCreated(toXMLGregorianCalendar(c));
		
		return measure;
	}
	
	/**
	 * Updates the healthprofile data (height, weight, PAL factor) of the given {@link Person}. 
	 * The user is asked for new values and the values are stored in the remote database.
	 * @param person
	 * @throws IOException
	 */
	public static void updateHeathprofile(Person person) throws IOException{
		Measure m = null;
		
		m = service.getMeasure(person.getId(), HEIGHT);
		if (m == null) {
			m = new Measure();
			m.setType(HEIGHT);
		}
		m = readMeasure(m, "meters", m.getValue(), new Double(MIN_HEIGHT), new Double(MAX_HEIGHT));
		service.saveMeasure(person.getId(), m, false);
		
		m = service.getMeasure(person.getId(), WEIGHT);
		if (m == null) {
			m = new Measure();
			m.setType(WEIGHT);
		}
		m = readMeasure(m, "kg", m.getValue(), new Double(MIN_WEIGHT), new Double(MAX_WEIGHT));
		service.saveMeasure(person.getId(), m, false);
		
		m = service.getMeasure(person.getId(), PAL_FACTOR);
		if (m == null) {
			m = new Measure();
			m.setType(PAL_FACTOR);
		}
		m = readMeasure(m, null, m.getValue(), new Double(MIN_PAL_FACTOR), new Double(MAX_PAL_FACTOR));
		service.saveMeasure(person.getId(), m, false);
	}
	

	/**
	 * Updates the given person in the remote database.
	 * @param person
	 */
	public static void updatePerson(Person person) {
		Person p;
		try {
			p = readPerson(person);
			p = service.savePerson(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Creates a new {@link Person} in the remote database.
	 * @return the new person
	 */
	public static Person createPerson() {
		Person p = null;
		try {
			p = readPerson(null);
			p = service.savePerson(p);
			readHealthprofile(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Person id is: " + p.getId());
		return p;
	}
	
	/**
	 * Converts the given {@link GregorianCalendar} to an {@link XMLGregorianCalendar}.
	 * @param c
	 * @return
	 */
	private static XMLGregorianCalendar toXMLGregorianCalendar(GregorianCalendar c) {
		try {
			return DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Prints the given {@link Person} to {@link System#out}.
	 * @param person
	 */
	public static void printPerson(Person person) {
		String p = "%s %s, born at %d.%d.%d\n";
		XMLGregorianCalendar bd = person.getBirthdate();
		System.out.printf(p, person.getFirstname(), person.getLastname(), bd.getDay(), bd.getMonth(), bd.getYear());		
	}

	/**
	 * Prints the healthprofile of the given {@link Person} to {@link System#out}.
	 * @param person
	 */
	public static void viewHeathprofile(Person person) {
		List<Measure> hp = service.getHealthprofile(person.getId());
		
		Iterator<Measure> it = hp.iterator();
		while (it.hasNext()){
			Measure m = it.next();
			String m_str = "%s: %.2f (%d.%d.%d)\n";
			XMLGregorianCalendar c = m.getCreated();
			System.out.printf(m_str, m.getType(), m.getValue(), c.getDay(), c.getMonth(), c.getYear());
		}		
	}

	/**
	 * Prints the history of a measure to {@link System#out} for the given {@link Person}.
	 * The type of the measure and the period of time is selected by asking the user. 
	 * @param person
	 * @throws IOException
	 */
	public static void viewHistory(Person person) throws IOException {
		String type = ShellUtility.readString("Measuretype: ", null);
		XMLGregorianCalendar from = ShellUtility.readXMLGregorianCalendar("from: ", "Please enter a date.", null, null, null);
		XMLGregorianCalendar to  = ShellUtility.readXMLGregorianCalendar("to: ", "Please enter a date.", null, from.toGregorianCalendar().getTime() , null);
		
		List<Measure> list = service.getMeasureHistory(person.getId(), type, from, to);
		if (list.isEmpty()) {
			System.out.printf("No measures of type '%s' found.\n", type);
		}
		else {
			System.out.printf("History of '%s':\n", type);
			for (int i = 0; i < list.size(); i++){
				Measure m = list.get(i);
				String txt = String.format("%.2f %s (%s)", m.getValue(), m.getUnit(), printXMLcal(m.getCreated()));
				System.out.println(txt);
			}
		}
	}

	/**
	 * Prints the specified {@link XMLGregorianCalendar} to {@link System#out}.
	 * @param to_print
	 * @return
	 */
	private static String printXMLcal(XMLGregorianCalendar to_print) {
		return String.format("%d.%d.%d", to_print.getDay(), to_print.getMonth(), to_print.getYear());		
	}
}
