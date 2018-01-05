import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;


public class Simulation {
    //Methods:

    /**
     * This method (helper method) loads all items from a text file and returns an ArrayList of Items:
     *
     * @param filePath A string that represents a file path.
     * @return Reads the text file line by line and create an Item object for each and then add it
     * to an ArrayList of Items. The method should then return that ArrayList.
     */
    private ArrayList<Item> loadItem(String filePath) {
        ArrayList<Item> listOfItems = new ArrayList<>();
        //Create a file.
        File file = new File(filePath);
        //Create a file scanner.
        Scanner fileScanner = null;
        try {
            //Open the file.
            fileScanner = new Scanner(file);
        } catch (FileNotFoundException exceptionMessage) {
            //Handle any exception (potential runtime error).
            System.out.println("No file found in the path: " + exceptionMessage.toString());
        }
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();                    //Will hold a line.
            int indexOfEqualsSign = line.indexOf('=');               //Will find where in the string '=' is in a line.
            String name = line.substring(0, indexOfEqualsSign);      //Will hold the name part of a line.
            int weight = Integer.parseInt(line.substring(indexOfEqualsSign + 1)); //Will hold the weight part of a line.
            //Create an Item object.
            Item anItem = new Item(name, weight);
            //Put it in the list.
            listOfItems.add(anItem);
        }
        return listOfItems;
    }

    /**
     * This method takes the ArrayList of Items returned from loadItems and starts creating U1 rockets.
     * It first tries to fill up 1 rocket with as many items as possible before creating a new rocket object
     * and filling that one until all items are loaded.
     *
     * @param phase Enter which phase of the mission. Expects an integer, 1 for the 1st phase and 2 for the 2nd phase.
     * @return The method then returns the ArrayList of those U1 rockets that are fully loaded.
     */
    public ArrayList<U1> loadU1(int phase) {
        String phaseOfTheMission = "phase-1.txt";           //Holds filepath to the specification of items to be sent
        if (phase == 2) {                                   //during phase 1.
            phaseOfTheMission = "phase-2.txt";              //during phase 2.
        }
        ArrayList<U1> listOfU1Rockets = new ArrayList<>();  //Will hold the U1 rockets to be returned.
        ArrayList<Item> itemsToLoad = new ArrayList<>();    //Will hold the list returned from loadItem method.
        itemsToLoad = this.loadItem(phaseOfTheMission); //Will load items from file 'phase-1.txt'.
        U1 newU1Rocket = new U1();                          //Create a rocket object, to fill it.
        //Loop to fill the rocket until there is no element(item) on the array list.
        while (itemsToLoad.size() > 0) {
            //Take the first item
            Item anItem = itemsToLoad.get(0);
            //Analyze if this item can be carried in the U1 rocket
            if (newU1Rocket.canCarry(anItem)) {
                newU1Rocket.carry(anItem);
                //Remove this item from array list.
                itemsToLoad.remove(0);
            } else {
                //Save the rocket to the list of U1 rockets.
                listOfU1Rockets.add(newU1Rocket);
                newU1Rocket = new U1();                   //Initialize (Create) a new U1 rocket (object).
            }
        }
        return listOfU1Rockets;
    }

    /**
     * This method also takes the ArrayList of Items and starts creating U2 rockets and filling them with those
     * items the same way as with U1 until all items are loaded.
     *
     *@param phase Enter which phase of the mission. Expects an integer, 1 for the 1st phase and 2 for the 2nd phase.
     * @return The method then returns the ArrayList of those U2 rockets that are fully loaded.
     */
    public ArrayList<U2> loadU2(int phase) {
        String phaseOfTheMission = "phase-1.txt";           //Holds filepath to the specification of items to be sent
        if (phase == 2) {                                   //during phase 1.
            phaseOfTheMission = "phase-2.txt";              //during phase 2.
        }
        ArrayList<U2> listOfU2Rockets = new ArrayList<>();  //Will hold the U2 rockets to be returned.
        ArrayList<Item> itemsToLoad = new ArrayList<>();    //Will hold the list returned from loadItem method.
        itemsToLoad = this.loadItem(phaseOfTheMission); //Will load items from file 'phase-1.txt'.
        U2 newU2Rocket = new U2();                          //Create a rocket object, to fill it.
        //Loop to fill the rocket until there is no element(item) on the array list.
        while (itemsToLoad.size() > 0) {
            //Take the first item
            Item anItem = itemsToLoad.get(0);
            //Analyze if this item can be carried in the U1 rocket
            if (newU2Rocket.canCarry(anItem)) {
                newU2Rocket.carry(anItem);
                //Remove this item from array list.
                itemsToLoad.remove(0);
            } else {
                //Save the rocket to the list of U1 rockets.
                listOfU2Rockets.add(newU2Rocket);
                newU2Rocket = new U2();                   //Initialize (Create) a new U2 rocket (object).
            }
        }
        return listOfU2Rockets;
    }

    /**
     * This method takes an ArrayList of Rockets and calls launch and land methods for each of the rockets in the ArrayList.
     * Every time a rocket explodes or crashes (i.e if launch or land return false) it will have to send that rocket again.
     * All while keeping track of the total budget required to send each rocket safely to Mars.
     *
     * @return Returns the total budget required to send all rockets (including the crashed ones).
     */
    public int runSimulation(ArrayList<Rocket> listOfRockets) {           // Use of polymorphism.
        int totalBudget = 0;                                              // Holds total budget of all the rockets sent.
        //Launch (and land) all rockets in the array list.
        for (int i = 0; i < listOfRockets.size(); i++) {
            Rocket currentRocket = new Rocket();                          // Create a rocket,
            currentRocket = listOfRockets.get(i);                         // to draw from the list of rockets.

            //Launch rockets.
            boolean lunchResult = currentRocket.launch();
            while (!lunchResult) {
                totalBudget += currentRocket.rocketCost;
                lunchResult = currentRocket.launch();
            }
            totalBudget += currentRocket.rocketCost;
            //land rockets.
            boolean landResult = currentRocket.land();
            while (!landResult) {
                totalBudget += currentRocket.rocketCost;
                landResult = currentRocket.launch();
            }
            totalBudget += currentRocket.rocketCost;
        }
        return totalBudget;
    }

}
