public class U2 extends Rocket {

    //Constructor:
    public U2() {
        this.rocketCost = 120;      //$120 million.
        this.rocketWeight = 18000;   //18 tonnes.
        this.maxRocketWeight = 29000;     //29 tonnes.
        this.cargoLimit = this.maxRocketWeight - this.rocketWeight; // 11 tonnes.
        this.currentWeightOfTheRocket = this.rocketWeight;
    }

    //Methods:
    @Override
    public boolean launch() {
        //generate a random number using the probability equation
        double randomNumber = Math.random();
        this.chanceOfLaunchExplosion = ((4.0 / 100.0) * (this.cargoCarried / this.cargoLimit))*10.0;
        if (chanceOfLaunchExplosion >= randomNumber) {
            return false;
        }
        return super.launch();
    }

    @Override
    public boolean land() {
        //generate a random number using the probability equation
        double randomNumber = Math.random();
        this.chanceOfLandingCrash = ((8.0 / 100.0) * (this.cargoCarried / this.cargoLimit))*10.0;
        if (chanceOfLandingCrash >= randomNumber) {
            return false;
        }
        return super.land();
    }
}
