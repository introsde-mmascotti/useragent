package shell;

import healthprofile.storage.service.Person;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import recipestorage.service.Recipe;
import service.Advisor;
import service.AdvisorService;

public class Shell {
	
	/**
	 * The program is started with: <p>
	 * <code>java shell.Shell [id]</code> <p>
	 * If a valid person id is in program arguments, the person is retrieved from the remote database. 
	 * Otherwise the user is asked to created a new person or type a valid id. <p>
	 * Then the user can type the various commands and terminate the program with 'exit'.
	 * @param args the id of the person for which the operations should be done
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		
		BufferedReader shell_reader = new BufferedReader(new InputStreamReader(System.in));
		Person person = null;
		
		AdvisorService advisor = new AdvisorService();
		Advisor service = advisor.getAdvisorPort();

		Integer id;
		if (args.length >= 1) {
			id = new Integer(Integer.parseInt(args[0]));
			person = service.getPerson(id);
			if (person == null)
				System.out.println("No person found with id=" + id);
			else
				HealthprofileOperation.printPerson(person);
		}
		
		while (person == null) {
			id = ShellUtility.readInteger("Type the id of a person: ","Please type a number!", null, null, null);
			person = service.getPerson(id);

			if (person != null){
				HealthprofileOperation.printPerson(person);
				break;
			}

			System.out.println("No person found with id=" + id);

			Character[] yn = { new Character('y'), new Character('n'), new Character('e') };
			char decision = ShellUtility.readChar(
					"Would you like to create a new person?\n\t(y)es\n\t(n)o\n\t(e)xit\n",
					"Type 'y' (yes) , 'n' (no), 'e' (exit)", null, yn);

			if (decision == 'y')
				person = HealthprofileOperation.createPerson();
			else if (decision == 'e')
				System.exit(0);
			else
				continue;
		}
		
		while (true){
			System.out.print("> ");
			
			String input = shell_reader.readLine(); 
			
			if (input.startsWith("person create"))
				person = HealthprofileOperation.createPerson();
			else if (input.startsWith("person view"))
				HealthprofileOperation.printPerson(person);
			else if (input.startsWith("person update"))
				HealthprofileOperation.updatePerson(person);
			
			else if (input.startsWith("healthprofile view"))
				HealthprofileOperation.viewHeathprofile(person);
			else if (input.startsWith("healthprofile update"))
				HealthprofileOperation.updateHeathprofile(person);
			else if (input.startsWith("healthprofile history"))
				HealthprofileOperation.viewHistory(person);
			
			else if (input.startsWith("recipe create"))
				RecipeOperations.readRecipe(null, "" + person.getId());
			else if (input.startsWith("recipe update")){
				Recipe r = RecipeOperations.chooseRecipe("" + person.getId());
				if (r != null)
					RecipeOperations.updateRecipe(r);
			}
			else if (input.startsWith("mealplan"))
				Mealchecker.checkMeal(person);
			else if (input.startsWith("exit"))
				System.exit(0);
			else
				System.out.println("Option not recognized.");
		}
	}
}
