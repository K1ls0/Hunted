package main.de.Kilso.hunted.game.field;

import main.de.Kilso.hunted.game.exceptions.NoUsesLeftException;

public class Step {
    private int length, useAmount, id;

    private Step(int length, int useAmount) {
        this.length = length;
        this.useAmount = useAmount;
        id = 1;
    }

    public static Step createByLengthAndAmount(int length, int useAmount) {
        return new Step(length, useAmount);
    }



    public int useStep() throws NoUsesLeftException {
        useAmount--;
        if (useAmount <= 0) {
            return length;
        } else {
            throw new NoUsesLeftException();
        }
    }

    public void setID(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
