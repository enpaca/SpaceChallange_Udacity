public interface SpaceShip {
    /**
     * A method that returns either true or false indicating if the launch was successful or if the rocket has crashed.
     *
     * @return
     */
    boolean launch();

    /**
     * A method that also returns either true or false based on the success of the landing.
     *
     * @return
     */
    boolean land();

    /**
     * A method that takes an Item as an argument and returns true if the rocket can carry such item or false
     * if it will exceed the weight limit.
     *
     * @param specifiedItem
     * @return
     */
    boolean canCarry(Item specifiedItem);

    /**
     * A method that also takes an Item object and updates the current weight of the rocket.
     *
     * @param specifiedItem
     */
    void carry(Item specifiedItem);
}
