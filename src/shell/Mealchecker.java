package shell;

import healthprofile.storage.service.Person;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import recipestorage.service.Ingredient;
import recipestorage.service.Recipe;
import service.Advisor;
import service.AdvisorService;

public class Mealchecker {
	
	/**
	 * The user is asked to: <br>
	 * <li> updated the healthprofile
	 * <li> select the meals he/she wants to consume this day
	 * Afterwards the health and meal advices are printed to {@link System#out} and the user is askted for 
	 * a file where the results are stored. 
	 * @param person
	 * @throws Exception
	 */
	public static void checkMeal(Person person) throws Exception{
		
		HealthprofileOperation.updateHeathprofile(person);
		
		List<Recipe> recipes = new ArrayList<Recipe>();
		System.out.println("Choose your meals for today.");
		
		Character[] possible_values = {new Character('y'), new Character('n')}; 
		Character input = new Character('y');
		while (input.equals(new Character('y'))){
			Recipe choosen_recipe = RecipeOperations.chooseRecipe(null);
			if (choosen_recipe != null)
				recipes.add(choosen_recipe);
			
			input = ShellUtility.readChar("Other? y/n", "Would you like to add another meal?\n(y)es\n(n)o\n", null, possible_values);
		}
		
		AdvisorService advisorservice = new AdvisorService();
		Advisor service = advisorservice.getAdvisorPort();
		
		String result = service.getHealthAdvice(person, recipes);
		System.out.println(result);
		
		resultToFile(result, recipes);
	}

	/**
	 * Writes the result and the selected recipes in a file. The user is prompted for the filename.
	 * @param result
	 * @param recipes
	 * @throws IOException
	 */
	private static void resultToFile(String result, List<Recipe> recipes) throws IOException {
		String file_name = null;
		File f = null;
		
		while (file_name == null) {
			file_name = ShellUtility.readString("Filename: ", null);
			f = new File(file_name);
		
			if (f.exists()) {
				System.out.println("The file '" + f.getAbsolutePath() + "' exists! Please choose a different name.");
				file_name = null;
			}
		}
			
		FileOutputStream fos = new FileOutputStream(f);
		PrintStream printto = new PrintStream(fos);
		
		printto.println(result + "\n");
		
		for (int i = 0; i < recipes.size(); i++)
			printRecipe(recipes.get(i), printto);
		
		printto.flush();
		printto.close();
		fos.close();	
	}
	
	/**
	 * Prints the given {@link Recipe} to the specified {@link PrintStream}.
	 * @param r
	 * @param stream
	 */
	private static void printRecipe(Recipe r, PrintStream stream){
		
		stream.printf("%s(%.2fkcal)\n",r.getName(), r.getKcal());
		
		List<Ingredient> l = r.getIngredients();
		for (int i = 0; i < l.size(); i++)
			printIngredient(l.get(i), stream);
		
		stream.println(r.getPreparationInstructions() + "\n");
	}

	/**
	 * Prints the given {@link Ingredient} to the specified {@link PrintStream}.
	 * @param ingredient
	 * @param stream
	 */
	private static void printIngredient(Ingredient ingredient, PrintStream stream) {
		stream.printf("%.2f %s %s ", 
				ingredient.getServingSizeQuantity(), 
				ingredient.getServingSizeUnit(),
				ingredient.getName());
		
		if (ingredient.getBrand() != null)
			stream.printf(" - %s", ingredient.getBrand());
		
		stream.printf("(%.2f kcal)\n", ingredient.getKcal());		
	}
}
