package shell;

import java.io.IOException;
import java.util.List;

import recipestorage.service.Ingredient;
import recipestorage.service.Recipe;
import service.Advisor;
import service.AdvisorService;

public class RecipeOperations {
	
		private static final int ADD_INGREDIENT_MODE = 0;
		private static final int REMOVE_INGREDIENT_MODE = 1;
		
		private static Advisor service;
		
		static {
			AdvisorService advisor = new AdvisorService();
			service = advisor.getAdvisorPort();
		}
		
		/**
		 * Searches for recipes in the database and lets the user choose one among them.
		 * If the author is 'null' all {@link Recipe}s in the database are considered, if a name is specified only
		 * the {@link Recipe}s of the author are considered.
		 * @param author 
		 * @return the choosen {@link Recipe}
		 * @throws IOException
		 */
		public static Recipe chooseRecipe(String author) throws IOException{
			String search = ShellUtility.readString("Type a recipe name: ", null);
			List<Recipe> list = service.findRecipe(search, author);
			
			if (list.isEmpty()){
				System.out.println("No recipes found.");
				return null;
			}				
			
			System.out.println("The following recipes have been found. Type the code of the product you want to use.\n");
			for (int i = 0; i < list.size(); i++){
				Recipe r = list.get(i);
				String txt = "%d\t%s (%.2f) kcal (1 serving)\n";
				System.out.format(txt,i, r.getName(), r.getKcal()/r.getNumServings());
			}
						
			int ret = ShellUtility.readInteger("Type the recipe code: ", "Invalid code.", null, new Integer(0), new Integer(list.size()-1));
						
			return list.get(ret);
		}

		/**
		 * Creates a new {@link Recipe} or updates the given {@link Recipe} asking the user for input and saves the 
		 * changes or new created recipe in the remote database.
		 * @param recipe the recipe to be updated or 'null' to create a new one
		 * @param author the author name of the recipe
		 * @return the new created / updated {@link Recipe}
		 * @throws IOException
		 */
		public static Recipe readRecipe(Recipe recipe, String author) throws IOException{
			if (recipe == null) {
				recipe = new Recipe();
				recipe.setAuthor(author);
			}
												
			String name = ShellUtility.readString("Name: ", recipe.getName());
			recipe.setName(name);
						
			Integer servings = ShellUtility.readInteger("Number of servings: ", "Please enter a number.", recipe.getNumServings(), new Integer(0), null);
			recipe.setNumServings(servings);			
			
			recipe = service.saveRecipe(recipe);
			
			recipe = readIngredients(recipe, ADD_INGREDIENT_MODE);
			
			String instructions = ShellUtility.readString("Preparation instructions: ", recipe.getPreparationInstructions());
			recipe.setPreparationInstructions(instructions);
			
			recipe = service.saveRecipe(recipe);
			
			return recipe;
		}

		/**
		 * Asks the user for the {@link Ingredient}s to be added or removed to/from the given {@link Recipe}.
		 * Changes are stored in the remote database.
		 * @param recipe
		 * @param mode 
		 * 	{@link #ADD_INGREDIENT_MODE} to add {@link Ingredient}s to the recipe, 
		 * 	{@link #REMOVE_INGREDIENT_MODE} to remove {@link Ingredient}s from the recipe
		 * @return the updated {@link Recipe}
		 * @throws IOException
		 */
		private static Recipe readIngredients(Recipe recipe, int mode) throws IOException {
			Character [] options = {new Character('c'), new Character('f')};
				
			Character input = 'c';
			while (input.equals(new Character('c'))) {
				if (mode == ADD_INGREDIENT_MODE)
					recipe = addIngredient(recipe);
				else if (mode == REMOVE_INGREDIENT_MODE)
					recipe = removeIngredient(recipe);
				
				input = ShellUtility.readChar("Choose option:\n(c)ontinue\n(f)inish\n", "Type 'c' to continue, 'f' to finish.\n", null, options);		
			}			
			return recipe;
		}
		
		/**
		 * Updates the given {@link Recipe} in the remote database.
		 * @param r {@link Recipe} to be updated
		 * @return the updated {@link Recipe}
		 * @throws IOException
		 */
		public static Recipe updateRecipe(Recipe r) throws IOException{
			
			String name = ShellUtility.readString("Name: ", r.getName());
			r.setName(name);
			
			Integer num_service = ShellUtility.readInteger("Servings: ", "Please enter a number!", r.getNumServings(), 0, null);
			r.setNumServings(num_service);
			
			String instructions = ShellUtility.readString("Preparation instructions: ", r.getPreparationInstructions());
			r.setPreparationInstructions(instructions);
			
			r = service.saveRecipe(r);
			
			printIngredients(r.getIngredients());
			String error_message = "To modify ingredients choose among the following options:\n" + 
					"\t(a)dd ingredient\n" +
					"\t(r)emove ingredient\n" +
					"\t(f)inish\n";
			System.out.println(error_message);
			
			Character[] options = {new Character('a'), new Character('r'),new Character('f')};
			Character input = ShellUtility.readChar("Choose option: ", error_message, null, options );
			while (!input.equals(new Character('f'))) {				
				if (input.equals(new Character('a')))
					r = addIngredient(r);
				else if (input.equals(new Character('r')))
					r = removeIngredient(r);
				
				printIngredients(r.getIngredients());
				input = ShellUtility.readChar("Choose option: ", error_message, null, options ); 
			}
			
			return r;
		}
		
		/**
		 * Lets the user selected an {@link Ingredient} and removes it from the given {@link Recipe}.
		 * The changes are stored in the remote database.
		 * @param r
		 * @return the updated recipe
		 * @throws IOException
		 */
		private static Recipe removeIngredient(Recipe r) throws IOException{
			
			List<Ingredient> list = r.getIngredients();

			System.out.println("Type the number of the ingredient you want to remove.");
			printIngredients(list);
			
			int elem = ShellUtility.readInteger("Ingredient to remove: ", "Please type a valid number!", null,
					new Integer(0), new Integer(list.size() - 1)).intValue();
				
			r = service.removeRecipeIngredient(r, list.get(elem));
						
			return r;
		}
		
		/**
		 * Lets the user select an {@link Ingredient} and adds it to the given {@link Recipe}.
		 * The changes are stored in the remote database.
		 * @param r
		 * @return
		 * @throws IOException
		 */
		private static Recipe addIngredient(Recipe r) throws IOException{
			String error_message = "Type the amount!\n"
					+ "For example if the product contains 4 pieces and you need only 2 type 0.5";
			
			String term = ShellUtility.readString("Enter an ingredient name: ", null);
			List<Ingredient> list = service.findIngredient(term);

			printIngredients(list);
			
			int elem = ShellUtility.readInteger("Type the code of an ingredient: ", "Please type a valid number!", null,
					new Integer(0), new Integer(list.size() - 1)).intValue();
			
			double amount = ShellUtility.readDouble("Amount: ", error_message , null, new Double(0), null);
			
			Ingredient to_add = list.get(elem);
			r = service.addRecipeIngredient(r, to_add, amount);
						
			return r;
		}

		/**
		 * Prints the list of {@link Ingredient}s to {@link System#out}.
		 * @param ingredients
		 */
		private static void printIngredients(List<Ingredient> ingredients) {
			for (int i = 0; i < ingredients.size(); i++) {
				Ingredient ingr = ingredients.get(i);
				String txt = String.format("%d\t%s %s (%.2f %s = %.2f kcal)", i, ingr.getBrand(), ingr.getName(), ingr.getServingSizeQuantity(), ingr.getServingSizeUnit(), ingr.getKcal());
				System.out.println(txt);
			}
		}
}
