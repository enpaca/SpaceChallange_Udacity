public class U1 extends Rocket {

    //Constructor:
    public U1() {
        this.rocketCost = 100;      //$100 million.
        this.rocketWeight = 10000;   //10 tonnes.
        this.maxRocketWeight = 18000;     //18 tonnes.
        this.cargoLimit = this.maxRocketWeight - this.rocketWeight; // 8 tonnes.
        this.currentWeightOfTheRocket = this.rocketWeight;
    }

    //Methods:
    @Override
    public boolean launch() {
        //generate a random number using the probability equation
        double randomNumber = Math.random();
        this.chanceOfLaunchExplosion = ((5.0 / 100.0) * (this.cargoCarried / this.cargoLimit))*10.0;
        if (chanceOfLaunchExplosion >= randomNumber) {
            return false;
        }
        return super.launch();
    }

    @Override
    public boolean land() {
        //generate a random number using the probability equation
        double randomNumber = Math.random();
        this.chanceOfLandingCrash = ((1.0 / 100.0) * (this.cargoCarried / this.cargoLimit))*10.0;
        if (chanceOfLandingCrash >= randomNumber) {
            return false;
        }
        return super.land();
    }
}
