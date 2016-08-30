# Useragent
This is the user interface for the webservices. It consists of a command line application which allows to create persons, their healthprofiles 
and recipes using the commands listed below. The user then chooses a mealplan, the program prints some advices about it. The mealplan, 
the advices and the selected recipes are saved into a file.

## Compiling and starting the program  
For compiling call the ant target  

     ant compile

Change to the build directory and start the program:  

     java shell.Shell  [id]  

The person id parameter _[id]_ is optional. If ommitted the program will ask for a valid person id or for creating a new person. 
After creating a new person or entering a valid person id the commands listed below are available.

##First steps

###Creating the person
If the person has not been created yet, the first step is creating the person. This can be done by starting the program without any 
commandline parameter or using the command ```person create```. After the creation the id of the new person is printed which must be 
memorized in order to continue the next time.  
If the person has been created before it is sufficient passing the person id as commandline parameter or typing it when asked.
Eventual corrections of the person data can be done using the command ```person update```.

###Creating recipes
Recipes can be created using the command ```recipe create```, corrections of a previously created recipe can be done 
with ```recipe create```.

###Choosing a mealplan a getting the advice
The mealplan can be created with the command ```mealplan```. The user is asked to update the healthprofile, then he composes the mealplan 
for the entire day. It is possible to choose among all recipes, including those of other users. Afterwards the mealplan is evaluated and 
the user can enter a file name for saving the advice and the selected recipes.

## Available commands
NOTE: All commands do not need any parameters, additional informations must be provided when prompted.
* ```person create``` create a new person
* ```person view``` view the person data
* ```person update``` update the person data
* ```healthprofile view``` view the current healthprofile (height, weight, PAL factor)
* ```healthprofile update``` update the healhprofile
* ```healthprofile history``` view the history of a measure
* ```recipe create```  create a new recipe
* ```recipe update``` update a recipe (only recipes created by the user can be updated)
* ```mealplan``` compose the mealplan and get the advice
* ```exit``` terminate the program
