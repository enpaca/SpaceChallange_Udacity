import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Simulation simulator = new Simulation();
        //Load a fleet of U1 rockets.
        ArrayList listOfLoadedU1RocketsPhaseOne = simulator.loadU1(1);
        ArrayList listOfLoadedU1RocketsPhaseTwo = simulator.loadU1(2);
        int budgetU1ForPhaseOne = simulator.runSimulation(listOfLoadedU1RocketsPhaseOne);
        int budgetU1ForPhaseTwo = simulator.runSimulation(listOfLoadedU1RocketsPhaseTwo);

        System.out.println("Simulation \"U1 rockets sent to mars\" costs: $" +
                budgetU1ForPhaseOne+" million in phase 1 and $"+budgetU1ForPhaseTwo+
                " million in phase 2. " +
                "Making a total of $" + (budgetU1ForPhaseOne+budgetU1ForPhaseTwo) +" million for the whole mission to complete.");

        //Load a fleet of U2 rockets.
        ArrayList listOfLoadedU2RocketsPhaseOne = simulator.loadU2(1);
        ArrayList listOfLoadedU2RocketsPhaseTwo = simulator.loadU2(2);
        int budgetU2ForPhaseOne = simulator.runSimulation(listOfLoadedU2RocketsPhaseOne);
        int budgetU2ForPhaseTwo = simulator.runSimulation(listOfLoadedU2RocketsPhaseTwo);

        System.out.println("Simulation \"U2 rockets sent to mars\" costs: $" +
                budgetU2ForPhaseOne+" million in phase 1 and $"+budgetU2ForPhaseTwo+
                " million in phase 2. " +
                "Making a total of $" +(budgetU2ForPhaseOne+budgetU2ForPhaseTwo)+" million for the whole mission to complete.");
    }
}
