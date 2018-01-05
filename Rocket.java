public class Rocket implements SpaceShip {
    // Fields:
    int rocketCost = 0;                 // Rocket cost.
    int rocketWeight=0;                 // Specific rocket weight (constant).
    int maxRocketWeight = 0;            // Maximum weight of the rocket with cargo (constant).
    int currentWeightOfTheRocket = 0;   // Holds current weight of the rocket with cargo.
    int cargoCarried = 0;               // Holds current weight of cargo only, without weight of a rocket.
    int cargoLimit=0;                   // Holds maximum weight of cargo.

    double chanceOfLaunchExplosion = 0.0;
    double chanceOfLandingCrash = 0.0;

    // Methods:
    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(Item specifiedItem) {
        // Can specifiedItem be carried?
        if ((this.currentWeightOfTheRocket + specifiedItem.getWeight()) <= this.maxRocketWeight) {
            return true;
        }
        return false;
    }

    @Override
    public void carry(Item specifiedItem) {
        // Update the weight of the Rocket
        this.currentWeightOfTheRocket += specifiedItem.getWeight();
        this.cargoCarried=this.currentWeightOfTheRocket-this.rocketWeight;
    }
}
