package model;

import exceptions.InvalidDataException;

public class Contribution {
    public static final Integer MAX_SUM = 1000000;
    private Integer sum;

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public Contribution(Integer sum)
            throws InvalidDataException {
        if(sum>MAX_SUM)
            throw new InvalidDataException("Sum value exceed MAX_SUM!");
        this.sum = sum;
    }
}
