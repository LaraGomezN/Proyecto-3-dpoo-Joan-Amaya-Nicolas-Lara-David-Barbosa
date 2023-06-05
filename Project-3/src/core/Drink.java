package core;

import utils.TimeRange;

import java.util.ArrayList;
import java.util.Arrays;

public class Drink extends Service {
    public Drink(
            String name,
            double price,
            ArrayList<String> places,
            TimeRange range
    ){
        super(name, price, places, range);
    }
    @Override
    public String toString() {
        return "Drink: " + super.toString();
    }
}
